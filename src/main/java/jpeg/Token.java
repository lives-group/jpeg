package jpeg;


import jpeg.Terminals;

class Token { 
    private int l,c, len;
    private short terminal;
    private Object value;
    
    public Token(short ter, int l, int c, int len){
        terminal = ter;
        this.l = l;
        this.c = c;
        this.len = len;
        value = null;
    }
    
    public Token(short ter, int l, int c, int len, Object value){
        this(ter,l,c,len);
        this.value = value;
    }
    
    public boolean isEOF(){ return terminal == Terminals.EOF; }
    
    public String toString(){
       return "[ " + l + " , " + c + " ; " + len + "; " + Terminals. terminalName(terminal) + "] " + 
       (value == null ? "" : value.toString());
     }

    public short getTer(){
        return terminal;
    }

    public Object getValue(){
        return value;
    }
    

}
