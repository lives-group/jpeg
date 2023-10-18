package jpeg;

public class IChoice extends Instruction {

    private int l;
    private String end;
    
    public String toString(){
        return "IChoice " + (end == null ? (l + "") : end);
    }
    
    public IChoice(String end){
        this.end = end;
        this.l = -1;
    }

    public IChoice(int l) {
        this.l = l;
        this.end = null;
    }
    
    public void mapJump(int l){
        this.l = l;
        end = null;
    }
    
    public String getLabel(){
        return end;
    }

    @Override
    public void execute(State s, String input) {
        s.setP(s.getP() + 1);
        StackEntry stk = new StackEntry(s.getP() + l, s.getI(), s.c);
        s.getE().push(stk);
    }
}
