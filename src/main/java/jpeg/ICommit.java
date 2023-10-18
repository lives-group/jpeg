/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package jpeg;

public class ICommit extends Instruction{
    
    private int l;
    private String end;
    
    public String toString(){
        return "ICommit " + (end == null ? (l + "") : end);
    }
    
    public ICommit(String end){
        this.end = end;
        l = -1;
    }
    
    public ICommit(int l){
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
        s.getE().pop();
    }
    
    
}
