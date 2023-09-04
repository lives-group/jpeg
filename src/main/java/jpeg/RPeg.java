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

        String grammar = args[0];
        String input = args[1];
        //System.out.println(grammar);
        //System.out.println(input);

        if (args.length != 2) {

            System.err.println("Informe o caminho da gramatica e da entrada como argumento");
            return;
        }

        ArrayList prog = new ArrayList<Instruction>();
        try {

            FileReader fileReader = new FileReader(grammar, StandardCharsets.UTF_8);
            FileReader fileReader2 = new FileReader(grammar, StandardCharsets.UTF_8);
            FileReader fileReader3 = new FileReader(input, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);

            String linha;
            String linha2;
            String entrada;
            //String entrada2;

            boolean primeiraLinhaLida = false;
            Map<String, Integer> labelMap = new HashMap<>();
            int position = 0;

            while ((linha = bufferedReader.readLine()) != null) {
                if (primeiraLinhaLida) {
                    String[] parts = linha.split(" ");
                    if (parts[0].endsWith(":")) {
                        labelMap.put(parts[0].substring(0, parts[0].length() - 1), position);
                    }
                } else {
                    primeiraLinhaLida = true;
                }
                position++;
            }
            primeiraLinhaLida = false;
            /*for (Map.Entry<String, Integer> entry : labelMap.entrySet()) {
                String label = entry.getKey();
                int position2 = entry.getValue();
                System.out.println("Label: " + label + ", Position: " + position2);
            }*/

            while ((linha2 = bufferedReader2.readLine()) != null) {
                if (primeiraLinhaLida) {
                    String[] parts2 = linha2.split(" ");
                    if ((parts2[0].endsWith(":"))) {
                        switch (parts2[1]) {
                            case "Choice":
                                if (parts2.length == 3) {
                                    prog.add(new IChoice(labelMap.get(parts2[2])));
                                }
                                break;
                            case "Char":
                                if (parts2.length == 3) {
                                    prog.add(new IChar(parts2[2].charAt(0)));
                                }
                                break;
                            case "Chars":
                                if (parts2.length == 4) {
                                    prog.add(new IChars(parts2[2].charAt(0), parts2[3].charAt(0)));
                                }
                                break;
                            case "Halt":
                                if (parts2.length == 2) {
                                    prog.add(new IHalt());
                                }
                                break;
                            case "Commit":
                                if (parts2.length == 3) {
                                    prog.add(new ICommit(labelMap.get(parts2[2])));
                                }
                                break;
                            case "Call":
                                if (parts2.length == 3) {
                                    prog.add(new ICall(labelMap.get(parts2[2])));
                                }
                                break;
                            case "Return":
                                if (parts2.length == 2) {
                                    prog.add(new IReturn());
                                }
                                break;
                            case "Jump":
                                if (parts2.length == 3) {
                                    prog.add(new IJump(labelMap.get(parts2[2])));
                                }
                                break;
                            case "Capture":
                                if (parts2.length == 2) {
                                    prog.add(new ICapture());
                                }
                                break;
                            case "Any":
                                if (parts2.length == 2) {
                                    prog.add(new IAny());
                                }
                                break;
                        }
                    } else {
                        switch (parts2[0]) {
                            case "Choice":
                                if (parts2.length == 2) {
                                    prog.add(new IChoice(labelMap.get(parts2[1])));
                                }
                                break;
                            case "Char":
                                if (parts2.length == 2) {
                                    prog.add(new IChar(parts2[1].charAt(0)));
                                }
                                break;
                            case "Chars":
                                if (parts2.length == 3) {
                                    prog.add(new IChars(parts2[1].charAt(0), parts2[2].charAt(0)));
                                }
                                break;
                            case "Halt":
                                if (parts2.length == 1) {
                                    prog.add(new IHalt());
                                }
                                break;
                            case "Commit":
                                if (parts2.length == 2) {
                                    prog.add(new ICommit(labelMap.get(parts2[1])));
                                }
                                break;
                            case "Call":
                                if (parts2.length == 2) {
                                    prog.add(new ICall(labelMap.get(parts2[1])));
                                }
                                break;
                            case "Return":
                                if (parts2.length == 1) {
                                    prog.add(new IReturn());
                                }
                                break;
                            case "Jump":
                                if (parts2.length == 2) {
                                    prog.add(new IJump(labelMap.get(parts2[1])));
                                }
                                break;
                            case "Capture":
                                if (parts2.length == 1) {
                                    prog.add(new ICapture());
                                }
                                break;
                            case "Any":
                                if (parts2.length == 1) {
                                    prog.add(new IAny());
                                }
                                break;
                        }
                    }
                } else {
                    primeiraLinhaLida = true;
                }
            }
            entrada = bufferedReader3.readLine();
            entrada = entrada.substring(1);
            System.out.println(entrada);

            bufferedReader.close();

            RPeg rpeg = new RPeg(entrada, prog);
            rpeg.execute();

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

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
