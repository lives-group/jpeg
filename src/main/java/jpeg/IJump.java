
package jpeg;

public class IJump extends Instruction{

    private int l;
    private String end;
    
    public String toString(){
        return "IJump " + (end == null ? (l + "") : end);
    }
    
    public IJump(String l){
        end = l;
        this.l = -1;
    }

    public IJump(int l) {
        this.l = l;
        end = null;
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
        System.out.println("IJump executed");
    }

}
