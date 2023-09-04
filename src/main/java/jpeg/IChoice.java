package jpeg;

public class IChoice extends Instruction {

    private int l;

    public IChoice(int l) {
        this.l = l;
    }

    @Override
    public void execute(State s, String input) {
        s.setP(s.getP() + 1);
        StackEntry stk = new StackEntry(s.getP() + l, s.getI(), s.c);
        s.getE().push(stk);
    }
}
