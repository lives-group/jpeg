
package jpeg;

public class IJump extends Instruction{

    private int l;

    public IJump(int l) {
        this.l = l;
    }

    @Override
    public void execute(State s, String input) {
        s.setP(s.getP() + l);
        System.out.println("IJump executed");
    }

}
