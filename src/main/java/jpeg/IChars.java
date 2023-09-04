

package jpeg;

public class IChars extends Instruction {

    private char start;
    private char end;

    public IChars(char c) {
        this.start = c;
        this.end = c;
    }

    public IChars(char start, char end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute(State s, String input) {
        if (s.getI() < input.length() && s.getP() >= 0) {
            char currentChar = Character.toLowerCase(input.charAt(s.getI()));
            char startChar = Character.toLowerCase(start);
            char endChar = Character.toLowerCase(end);
            
            if (currentChar >= startChar && currentChar <= endChar) {
                s.setP(s.getP() + 1);
                s.setI(s.getI() + 1);
            } else {
                s.setP(-1);
            }
        } else {
            s.setP(-1);
        }
    }
}

