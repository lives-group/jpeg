package jpeg;

public class IAny extends Instruction {

    @Override
    public void execute(State s, String input) {
        if (s.getI() < input.length() && s.getP() >= 0) {
            s.setP(s.getP() + 1);
            s.setI(s.getI() + 1);
        } else {
            s.setP(-1);
        }
    }

}
