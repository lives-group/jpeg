package jpeg;

/**
 * This class lists terminals used by the grammar specified in "expr.grammar".
 */
public class Terminals {

    static public final short EOF = 0;
    static public final short MINUS = 1;
    static public final short ID = 2;
    static public final short LPAREN = 3;
    static public final short NUMBER = 4;
    static public final short CHAR = 5;
    static public final short COMMIT = 6;
    static public final short JUMP = 7;
    static public final short CHOICE = 8;
    static public final short HALT = 9;
    static public final short CHARS = 10;
    static public final short CALL = 11;
    static public final short RETURN = 12;
    static public final short CAPTURE = 13;
    static public final short ANY = 14;
    static public final short COLON = 15;
    static public final short ASPAS = 16;
    static public final short CHARLIT = 17;
    static public final short FAIL = 18;

    static public String terminalName(short n) {
        switch (n) {
            case 0:
                return "EOF";
            case 1:
                return "-";
            case 2:
                return "ID";
            case 3:
                return "(";
            case 4:
                return "NUM";
            case 5:
                return "Char";
            case 6:
                return "Commit";
            case 7:
                return "Jump";
            case 8:
                return "Choice";
            case 9:
                return "Halt";
            case 10:
                return "Chars";
            case 11:
                return "Call";
            case 12:
                return "Return";
            case 13:
                return "Capture";
            case 14:
                return "Any";
            case 15:
                return ":";
            case 16:
                return "'";
            case 17:
                return "Character";
            case 18:
                return "Fail";

        }
        return "I don't Know !";
    }
}
