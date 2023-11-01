package jpeg;

public class ICall extends Instruction {

    private int lb;
    private String end;
    
    public String toString(){
        return "ICall " + (end == null ? (lb + "") : end);
    }
    
    public ICall(String end){
        this.end = end;
        lb = -1;
    }

    public ICall(int l) {
        this.lb = l;
    }
    
    public void mapJump(int l){
        this.lb = l;
        end = null;
    }
    
    public String getLabel(){
        return end;
    }

    @Override
    public void execute(State s, String input) {
        StackEntry stk = new StackEntry(s.getP() + 1, -1, null);
        s.setP(s.getP() + lb);
        s.getE().push(stk);
    }

}
