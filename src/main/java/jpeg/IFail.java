/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package jpeg;

public class IFail extends Instruction{

    @Override
    public void execute(State s, String input) {
        s.setP(-1);
    }

}
