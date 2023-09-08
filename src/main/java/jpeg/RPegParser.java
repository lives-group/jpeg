package jpeg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RPegParser {

    public static void parse(String grammarFile, String inputFile) {
        ArrayList<Instruction> prog = new ArrayList<>();
        try {

            FileReader fileReader = new FileReader(grammarFile, StandardCharsets.UTF_8);
            FileReader fileReader2 = new FileReader(grammarFile, StandardCharsets.UTF_8);
            FileReader fileReader3 = new FileReader(inputFile, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);

            String linha;
            String linha2;
            String entrada;

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
                    } else if (parts2.length >= 2) {

                        if (linha2.matches("^(Char|Chars)\\s+'.'(\\s+'.'\\s*)*$")) {

                            String charArguments = linha2.substring(parts2[0].length()).trim();

                            if (charArguments.startsWith("'") && charArguments.endsWith("'")) {
                                charArguments = charArguments.substring(1, charArguments.length() - 1);
                                char[] chars = charArguments.toCharArray();

                                switch (parts2[0]) {
                                    case "Char":
                                        if (chars.length == 1) {
                                            prog.add(new IChar(chars[0]));
                                        }
                                        break;
                                    case "Chars":
                                        if (chars.length >= 2) {
                                            prog.add(new IChars(chars[0], chars[1]));
                                        }
                                        break;
                                }
                            }
                        }

                        switch (parts2[0]) {
                            case "Choice":
                                if (parts2.length == 2) {
                                    prog.add(new IChoice(labelMap.get(parts2[1])));
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
}