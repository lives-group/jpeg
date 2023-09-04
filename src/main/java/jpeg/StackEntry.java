/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpeg;

import java.util.ArrayList;
import java.util.List;

public class StackEntry {

    int p;
    int i;
    List<Capture> captureList;

    public StackEntry(int p, int i, List<Capture> c) {
        this.p = p;
        this.i = i;
        this.captureList = c;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getI() {
        return i;
    }

    public List<Capture> getCaptureList() {
        return captureList;
    }
    
    public String toString(){
        return "< "+p+", "+i+"...>";
    }

}
