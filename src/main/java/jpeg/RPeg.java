package jpeg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RPeg {

    protected State s;
    protected static ArrayList<Instruction> prog;
    protected static String input;

    public RPeg(String input, ArrayList<Instruction> p) {
        s = new State(0, 0);
        prog = p;
        this.input = input;
    }

    public void execute() {
        while (s.getP() >= 0 && !s.isHalt() && s.getP() < prog.size()) {
            Instruction instruction = prog.get(s.getP());
            System.out.println("instrução: " + s.getP());
            instruction.execute(s, input);
            System.out.println(s.toString());
            if (s.getP() == -1) {
                while (!s.getE().isEmpty() && s.getE().peek().getI() == -1) {
                    s.getE().pop();
                }
                if (!s.getE().isEmpty()) {
                    s.setP(s.getE().peek().getP());
                    s.setI(s.getE().peek().getI());
                    s.setC(s.getE().peek().getCaptureList());
                    s.getE().pop();
                }
            }
        }
        if (s.getP() == -1) {
            System.out.println("Rejected");
        } else {
            System.out.println("Accepted");
        }
    }

    public static void main(String[] args) {

        if (args.length != 2) {

            System.err.println("Informe o caminho da gramatica e da entrada como argumento");
            return;
        }

        RPegParser.parse(args[0], args[1]);
    }

    public void placaDeCarro(String input) {
        ArrayList<Instruction> prog = new ArrayList<>();
        prog.add(new IChars('a', 'z'));
        prog.add(new IChars('a', 'z'));
        prog.add(new IChars('a', 'z'));
        prog.add(new IChars('0', '9'));
        prog.add(new IChars('0', '9'));
        prog.add(new IChars('0', '9'));
        prog.add(new IChars('0', '9'));
        RPeg rpeg = new RPeg(input, prog);
        rpeg.execute();
    }

    public void aOuB(String input) {
        ArrayList prog = new ArrayList<Instruction>();
        prog.add(new IChoice(2));
        prog.add(new IChar('a'));
        prog.add(new ICommit(2));
        prog.add(new IChar('b'));
        RPeg rpeg = new RPeg(input, prog);
        rpeg.execute();
    }

    public void aB(String input) {
        ArrayList<Instruction> prog = new ArrayList<>();
        prog.add(new ICall(2));
        prog.add(new IJump(8));
        prog.add(new IChoice(3));
        prog.add(new IChar('a'));
        prog.add(new ICall(-2));
        prog.add(new ICommit(3));
        prog.add(new IChar('b'));
        prog.add(new ICommit(2));
        prog.add(new IReturn());
        RPeg rpeg = new RPeg(input, prog);
        rpeg.execute();
    }

}
