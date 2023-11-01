package jpeg;

public class IChoice extends Instruction {

    private int lb;
    private String end;
    
    public String toString(){
        return "IChoice " + (end == null ? (lb + "") : end);
    }
    
    public IChoice(String end){
        this.end = end;
        this.lb = -1;
    }

    public IChoice(int l) {
        this.lb = l;
        this.end = null;
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
        StackEntry stk = new StackEntry(s.getP() + lb, s.getI(), s.c);
        s.setP(s.getP() + 1);

        s.getE().push(stk);
    }
}
