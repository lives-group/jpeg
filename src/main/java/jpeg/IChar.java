
package jpeg;

public class IChar extends Instruction {

    private char c;

    public IChar(char c) {
        this.c = c;
    }
    
    @Override
    public void execute(State s, String input){
        if (s.getI() < input.length() && s.getP() >=0) {
            if (input.charAt(s.getI()) == c) {
                s.setP(s.getP() + 1);
                s.setI(s.getI() + 1);
            }else {
                s.setP(-1);
            }
        } else {
            s.setP(-1);
        }
    }
}
