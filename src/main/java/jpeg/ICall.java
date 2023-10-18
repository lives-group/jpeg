package jpeg;

public class ICall extends Instruction {

    private int l;
    private String end;
    
    public String toString(){
        return "ICall " + (end == null ? (l + "") : end);
    }
    
    public ICall(String end){
        this.end = end;
        l = -1;
    }

    public ICall(int l) {
        this.l = l;
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
        s.setP(s.getP() + l);
        StackEntry stk = new StackEntry(s.getP() + 1, -1, null);
        s.getE().push(stk);
    }

}
