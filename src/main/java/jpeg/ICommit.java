/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package jpeg;

public class ICommit extends Instruction{
    
    private int l;
    
    public ICommit(int l){
        this.l = l;
    }

    @Override
    public void execute(State s, String input) {
        s.setP(s.getP() + l);
        s.getE().pop();
    }
    
    
}
