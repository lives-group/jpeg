package jpeg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RPeg {

    protected State s;
    protected static ArrayList<Instruction> prog;
    protected static String input;

    public RPeg() {
        s = new State(0, 0);

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
        
        
        RPeg rpeg = new RPeg();
        Parser p;
        input = lerArquivoTexto(args[1]);
       
        try {
            p = new Parser(args[0]);
            //p.testLexer();
            
            prog = p.parse();
            p.printLBTable();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RPeg.class.getName()).log(Level.SEVERE, null, ex);
        }
        rpeg.printProgram();
        rpeg.execute();
       /*input = "8.f";
        aOuB();*/
        /*input = "aab";
        aB();*/
        
    }

    public static void placaDeCarro(String input) {
        prog = new ArrayList<>();
        prog.add(new IChars('0', '9'));
        prog.add(new IChars('a', 'z'));
        prog.add(new IChars('a', 'z'));
        prog.add(new IChars('0', '9'));
        prog.add(new IChars('0', '9'));
        prog.add(new IChars('0', '9'));
        prog.add(new IChars('0', '9'));
        RPeg rpeg = new RPeg();
        rpeg.execute();
    }

    /*public static void aOuB() {
        prog = new ArrayList<>();
        prog.add(new ICall(2));
        prog.add(new IJump(8));
        prog.add(new IChoice(3));
        prog.add(new IChars('0','9'));
        prog.add(new ICall(-2));
        prog.add(new ICommit(6));
        prog.add(new IChoice(7));
        prog.add(new IChar('.'));
            prog.add(new IChoice(3));
            prog.add(new IChars('0','9'));
            prog.add(new ICall(-2));
            prog.add(new ICommit(2));
        prog.add(new ICommit(2));
        prog.add(new IReturn());
        RPeg rpeg = new RPeg();
        rpeg.execute();
    }*/
    
    public static void aOuB() {
        prog = new ArrayList<>();
        prog.add(new ICall(2));
        prog.add(new IJump(8));
        prog.add(new IChoice(3));
        prog.add(new IChars('0','9'));
        prog.add(new ICall(-2));
        prog.add(new ICommit(3));
        prog.add(new IChar('.'));
        prog.add(new ICommit(2));
        prog.add(new IReturn());
        RPeg rpeg = new RPeg();
        rpeg.execute();
    }

    public static void aB() {
        prog = new ArrayList<>();
        prog.add(new ICall(2));
        prog.add(new IJump(8));
        prog.add(new IChoice(3));
        prog.add(new IChar('a'));
        prog.add(new ICall(-2));
        prog.add(new ICommit(3));
        prog.add(new IChar('b'));
        prog.add(new ICommit(2));
        prog.add(new IReturn());
        RPeg rpeg = new RPeg();
        rpeg.execute();
    }
    
    public static String lerArquivoTexto(String nomeArquivo) {
        StringBuilder conteudo = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
            br.close();
            return conteudo.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void printProgram(){
        int j = 0;
        for(Instruction i : prog){
            System.out.println(j++ +" :" + i.toString());
            
        }
    }


}