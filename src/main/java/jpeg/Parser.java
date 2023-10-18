package jpeg;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

class Parser {

    private ExpressionScanner scn;
    private Token t;
    private int count;
    private HashMap<String, Integer> lb;
    private ArrayList<Instruction> prog;
    private String grammar;
    private String a;
    private String input;

    public Parser(String grammar) throws FileNotFoundException {
        scn = new ExpressionScanner(new FileReader(grammar));
        count = 0;
        lb = new HashMap<String, Integer>();
        prog = new ArrayList<Instruction>();
        t = null;
        this.grammar = grammar;
        this.input = input;
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
                        prog.add(parseLabel((String)t.getValue()));
                        break;
                }

                t = scn.nextToken();
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        remapLabels();
        return prog;
    }
    
    private void remapLabels(){
        int i = 0;
        while(i < prog.size()){
            if(prog.get(i) instanceof ICall && 
                    ((ICall) prog.get(i)).getLabel() != null){
                ((ICall) prog.get(i)).mapJump(lb.get(((ICall) prog.get(i)).getLabel()) - i - 1);
            } else if(prog.get(i) instanceof IJump &&
                    ((IJump) prog.get(i)).getLabel() != null){
                ((IJump) prog.get(i)).mapJump(lb.get(((IJump) prog.get(i)).getLabel()) - i - 1);
            } else if(prog.get(i) instanceof ICommit &&
                    ((ICommit) prog.get(i)).getLabel() != null){
                ((ICommit) prog.get(i)).mapJump(lb.get(((ICommit) prog.get(i)).getLabel()) - i - 1);
            } else if(prog.get(i) instanceof IChoice &&
                    ((IChoice) prog.get(i)).getLabel() != null){
                ((IChoice) prog.get(i)).mapJump(lb.get(((IChoice) prog.get(i)).getLabel()) - i - 1);
            } else if(prog.get(i) instanceof ILabel){
                prog.remove(i);
            } else {
                i++;
            }
            
        }
    }

    public IChar parseChar() {
        char a;
        nxt();
        if (t.getTer() == Terminals.ASPAS) {
            nxt();
            if (t.getTer() == Terminals.CHARLIT) {
                a = ((String) (t.getValue())).charAt(0);
                nxt();
                if (t.getTer() == Terminals.ASPAS) {
                    count++;
                    return new IChar(a);
                }
            }
        }
        return null;
    }

    public IChars parseChars() {
        char a[] = new char[2];
        nxt();
        if (t.getTer() == Terminals.ASPAS) {
            nxt();
            if (t.getTer() == Terminals.CHARLIT) {
                a[0] = ((String) (t.getValue())).charAt(0);
                nxt();
                if (t.getTer() == Terminals.ASPAS) {
                    nxt();
                    if (t.getTer() == Terminals.ASPAS) {
                        nxt();
                        if (t.getTer() == Terminals.CHARLIT) {
                            a[1] = ((String) (t.getValue())).charAt(0);
                            nxt();
                            if (t.getTer() == Terminals.ASPAS) {
                                count++;
                                return new IChars(a[0], a[1]);
                            }
                        }
                    }
                }
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

    public IHalt parseHalt() {
        count++;
        return new IHalt();
    }

    public ILabel parseLabel(String l) {
        nxt();
        if (t.getTer() == Terminals.COLON) {
            lb.put(l, count + 1);
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

}
