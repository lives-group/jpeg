/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package jpeg;



public class ILabel extends Instruction{

   public String lb;
   
   public ILabel(String lb){
       this.lb = lb;
   }
 
   public String getLb(){
       return lb;
   }
   
   @Override
   public String toString(){
       return lb + ":";
   }

    public void execute(State s, String input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
