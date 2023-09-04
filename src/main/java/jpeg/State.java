package jpeg;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class State {

    protected Integer p;
    protected int i;
    protected Stack<StackEntry> e;
    protected List<Capture> c;
    protected boolean halt;

    public State(Integer p, int i) {
        this.p = p;
        this.i = i;
        this.e = new Stack<StackEntry>();
        this.c = new ArrayList<Capture>();
        this.halt = false;
    }

    public Integer getP() {
        return p;
    }

    public int getI() {
        return i;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Stack<StackEntry> getE() {
        return e;
    }

    public List<Capture> getC() {
        return c;
    }

    public void setC(List<Capture> c) {
        this.c = c;
    }
    
    

    public void makeBacktrackPoint(int l) {
        StackEntry stk = new StackEntry(getP() + l, getI(), c);
        e.push(stk);
    }

    public void makeReturnPoint(int l) {
        StackEntry stk = new StackEntry(getP() + l, -1, null);
        e.push(stk);
    }

    public void restore() {

        StackEntry stk = e.pop();
        if (stk.getI() >= 0) {
            p = stk.getP();
            i = stk.getI();
            c = stk.getCaptureList();
        } else {
            throw new RuntimeException("unexpected Stack context");
        }
    }
    
    public boolean isHalt(){
        return halt;
    }
    
    public void halt(){
        this.halt = true;
    }

    /*public void rtrn() {
        StackEntry stk = e.pop();
        if (stk.getI() == -1) {
            p = stk.getP();
        } else {
            throw new RuntimeException("unexpected Stack context");
        }
    }*/
    
    @Override
    public String toString(){
        String s = "{" + p +", "+ i +", [";
        for(StackEntry st : e){
            s += st.toString() + " ";
        }
        s += "]}";
       
        return s;
    }
}


