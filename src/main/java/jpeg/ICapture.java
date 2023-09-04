/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package jpeg;

public class ICapture extends Instruction{


    @Override
    public void execute(State s, String input) {
        Capture c = new Capture(s.getI(),s.getP());
        s.getC().add(c);
        s.setP(s.getP() + 1);
    }

}
