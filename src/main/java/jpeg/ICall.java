package jpeg;

public class ICall extends Instruction {

    private int l;

    public ICall(int l) {
        this.l = l;
    }

    @Override
    public void execute(State s, String input) {
        s.setP(s.getP() + l);
        StackEntry stk = new StackEntry(s.getP() + 1, -1, null);
        s.getE().push(stk);
    }

}
