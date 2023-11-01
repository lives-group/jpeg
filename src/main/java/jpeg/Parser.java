package jpeg;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

class Parser {

    private ExpressionScanner scn;
    private Token t;
    private int count;
    private HashMap<String, Integer> lb;
    private ArrayList<Instruction> prog;
    private String grammar;
    private String a;

    public Parser(String grammar) throws FileNotFoundException {
        scn = new ExpressionScanner(new FileReader(grammar));
        count = 0;
        lb = new HashMap<String, Integer>();
        prog = new ArrayList<Instruction>();
        t = null;
        this.grammar = grammar;
    }

    public void testLexer() {
        try {
            nxt();
            while (!t.isEOF()) {
                System.out.println(t.toString());
                nxt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Instruction> parse() {
        try {
            t = scn.nextToken();

            while (!t.isEOF()) {
                switch (t.getTer()) {
                    case Terminals.CHAR:
                        prog.add(parseChar());
                        break;
                    case Terminals.CHARS:
                        prog.add(parseChars());
                        break;
                    case Terminals.CALL:
                        prog.add(parseCall());
                        break;
                    case Terminals.CHOICE:
                        prog.add(parseChoice());
                        break;
                    case Terminals.JUMP:
                        prog.add(parseJump());
                        break;
                    case Terminals.COMMIT:
                        prog.add(parseCommit());
                        break;
                    case Terminals.RETURN:
                        prog.add(parseReturn());
                        break;
                    case Terminals.HALT:
                        prog.add(parseHalt());
                        break;
                    case Terminals.ID:
                        
                        prog.add(parseLabel((String) t.getValue()));
                        
                        break;
                    case Terminals.FAIL:
                        prog.add(parseFail());
                        break;
                }

                t = scn.nextToken();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        printLBTable();
        remapLabels();
        return prog;
    }

    private void remapLabels() {
        int i = 0;
        while (i < prog.size()) {
            if (prog.get(i) instanceof ICall
                    && ((ICall) prog.get(i)).getLabel() != null) {
                ((ICall) prog.get(i)).mapJump(lb.get(((ICall) prog.get(i)).getLabel()) - i);
            } else if (prog.get(i) instanceof IJump
                    && ((IJump) prog.get(i)).getLabel() != null) {
                ((IJump) prog.get(i)).mapJump(lb.get(((IJump) prog.get(i)).getLabel()) - i);
            } else if (prog.get(i) instanceof ICommit
                    && ((ICommit) prog.get(i)).getLabel() != null) {
                ((ICommit) prog.get(i)).mapJump(lb.get(((ICommit) prog.get(i)).getLabel()) - i);
            } else if (prog.get(i) instanceof IChoice
                    && ((IChoice) prog.get(i)).getLabel() != null) {
                
                ((IChoice) prog.get(i)).mapJump(lb.get(((IChoice) prog.get(i)).getLabel()) - i);
                
            } else if (prog.get(i) instanceof ILabel) {
                prog.remove(i);
            } else {
                i++;
            }

        }
    }

    private boolean chr() {
        return t.getTer() == Terminals.CHARLIT;
    }

    private IChar parseChar() {
        char a;
        nxt();
        if (chr()) {
            a = ((Character) (t.getValue()));
            count++;
            return new IChar(a);
        }
        return null;
    }

    public IChars parseChars() {
        char a[] = new char[2];
        nxt();
        if (chr()) {
            a[0] = ((Character) (t.getValue()));
            nxt();
            if (chr()) {
                a[1] = ((Character) (t.getValue()));
                count++;
                return new IChars(a[0], a[1]);
            }
        }
        return null;
    }

    public ICall parseCall() {
        nxt();
        if (t.getTer() == Terminals.ID) {
            a = (String) t.getValue();
            count++;
            return new ICall(a);
        }
        return null;
    }

    public IChoice parseChoice() {
        nxt();
        if (t.getTer() == Terminals.ID) {
            a = (String) t.getValue();
            count++;
            return new IChoice(a);
        }
        return null;
    }

    public IJump parseJump() {
        nxt();
        if (t.getTer() == Terminals.ID) {
            a = (String) t.getValue();
            count++;
            return new IJump(a);
        }

        return null;

    }

    public ICommit parseCommit() {
        nxt();
        if (t.getTer() == Terminals.ID) {
            a = (String) t.getValue();
            count++;
            return new ICommit(a);

        }
        return null;

    }

    public IReturn parseReturn() {
        count++;
        return new IReturn();
    }
    
    public IFail parseFail(){
        count++;
        return new IFail();
    }

    public IHalt parseHalt() {
        count++;
        return new IHalt();
    }

    public ILabel parseLabel(String l) {
        nxt();
        if (t.getTer() == Terminals.COLON) {
            lb.put(l, count);
            return new ILabel(l);
        }
        return null;
    }

    private void nxt() {
        try {
            t = scn.nextToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printLBTable() {
        String s =  "----Labels ----- \n";
        for (Entry<String, Integer> e : lb.entrySet()) {
            s +=  " " + e.getKey() + " |-> " + e.getValue().toString() + "\n";
        }
        System.out.println(s);
        
    }

}
