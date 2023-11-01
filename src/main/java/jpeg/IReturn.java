/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package jpeg;

public class IReturn extends Instruction{
    
    public IReturn() {
    }

    @Override
    public void execute(State s, String input) {
        StackEntry stk = s.e.pop();
        if (stk.getI() == -1) {
           s.p = stk.getP();
        } else {
            throw new RuntimeException("unexpected Stack context");
        }
    }
    
    public String toString(){
        return "IReturn ";
    }

}
