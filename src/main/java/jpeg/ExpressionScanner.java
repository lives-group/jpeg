package jpeg;




@SuppressWarnings("fallthrough")
class ExpressionScanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int CHAR = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1, 1
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\1\u0200\1\u0300\1\u0400\1\u0500\1\u0600\1\u0700"+
    "\1\u0800\1\u0900\1\u0a00\1\u0b00\1\u0c00\1\u0d00\1\u0e00\1\u0f00"+
    "\1\u1000\1\u0100\1\u1100\1\u1200\1\u1300\1\u0100\1\u1400\1\u1500"+
    "\1\u1600\1\u1700\1\u1800\1\u1900\1\u1a00\1\u1b00\1\u0100\1\u1c00"+
    "\1\u1d00\1\u1e00\12\u1f00\1\u2000\1\u2100\1\u2200\1\u1f00\1\u2300"+
    "\1\u2400\2\u1f00\31\u0100\1\u2500\121\u0100\1\u2600\4\u0100\1\u2700"+
    "\1\u0100\1\u2800\1\u2900\1\u2a00\1\u2b00\1\u2c00\1\u2d00\53\u0100"+
    "\1\u2e00\41\u1f00\1\u0100\1\u2f00\1\u3000\1\u0100\1\u3100\1\u3200"+
    "\1\u3300\1\u3400\1\u1f00\1\u3500\1\u3600\1\u3700\1\u3800\1\u0100"+
    "\1\u3900\1\u3a00\1\u3b00\1\u3c00\1\u3d00\1\u3e00\1\u3f00\1\u1f00"+
    "\1\u4000\1\u4100\1\u4200\1\u4300\1\u4400\1\u4500\1\u4600\1\u4700"+
    "\1\u4800\1\u4900\1\u4a00\1\u4b00\1\u1f00\1\u4c00\1\u4d00\1\u4e00"+
    "\1\u1f00\3\u0100\1\u4f00\1\u5000\1\u5100\12\u1f00\4\u0100\1\u5200"+
    "\17\u1f00\2\u0100\1\u5300\41\u1f00\2\u0100\1\u5400\1\u5500\2\u1f00"+
    "\1\u5600\1\u5700\27\u0100\1\u5800\2\u0100\1\u5900\45\u1f00\1\u0100"+
    "\1\u5a00\1\u5b00\11\u1f00\1\u5c00\27\u1f00\1\u5d00\1\u5e00\1\u5f00"+
    "\1\u6000\11\u1f00\1\u6100\1\u6200\5\u1f00\1\u6300\1\u6400\4\u1f00"+
    "\1\u6500\21\u1f00\246\u0100\1\u6600\20\u0100\1\u6700\1\u6800\25\u0100"+
    "\1\u6900\34\u0100\1\u6a00\14\u1f00\2\u0100\1\u6b00\u0e05\u1f00";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\2\1\1\0\1\2\1\1\22\0\1\2\1\0"+
    "\1\3\4\0\1\4\10\0\12\5\1\6\6\0\1\7"+
    "\1\10\1\11\2\10\1\12\1\10\1\13\1\10\1\14"+
    "\7\10\1\15\10\10\1\0\1\16\4\0\1\17\1\20"+
    "\1\21\1\10\1\22\2\10\1\23\1\24\2\10\1\25"+
    "\1\26\1\27\1\30\1\31\1\10\1\32\1\33\1\34"+
    "\1\35\3\10\1\36\1\10\57\0\1\37\12\0\1\37"+
    "\4\0\1\37\5\0\27\37\1\0\37\37\1\0\u01ca\37"+
    "\4\0\14\37\16\0\5\37\7\0\1\37\1\0\1\37"+
    "\201\0\5\37\1\0\2\37\2\0\4\37\1\0\1\37"+
    "\6\0\1\37\1\0\3\37\1\0\1\37\1\0\24\37"+
    "\1\0\123\37\1\0\213\37\10\0\246\37\1\0\46\37"+
    "\2\0\1\37\6\0\51\37\107\0\33\37\4\0\4\37"+
    "\55\0\53\37\25\0\12\5\4\0\2\37\1\0\143\37"+
    "\1\0\1\37\17\0\2\37\7\0\2\37\12\5\3\37"+
    "\2\0\1\37\20\0\1\37\1\0\36\37\35\0\131\37"+
    "\13\0\1\37\16\0\12\5\41\37\11\0\2\37\4\0"+
    "\1\37\5\0\26\37\4\0\1\37\11\0\1\37\3\0"+
    "\1\37\27\0\31\37\7\0\13\37\65\0\25\37\1\0"+
    "\10\37\106\0\66\37\3\0\1\37\22\0\1\37\7\0"+
    "\12\37\4\0\12\5\1\0\20\37\4\0\10\37\2\0"+
    "\2\37\2\0\26\37\1\0\7\37\1\0\1\37\3\0"+
    "\4\37\3\0\1\37\20\0\1\37\15\0\2\37\1\0"+
    "\3\37\4\0\12\5\2\37\12\0\1\37\10\0\6\37"+
    "\4\0\2\37\2\0\26\37\1\0\7\37\1\0\2\37"+
    "\1\0\2\37\1\0\2\37\37\0\4\37\1\0\1\37"+
    "\7\0\12\5\2\0\3\37\20\0\11\37\1\0\3\37"+
    "\1\0\26\37\1\0\7\37\1\0\2\37\1\0\5\37"+
    "\3\0\1\37\22\0\1\37\17\0\2\37\4\0\12\5"+
    "\11\0\1\37\13\0\10\37\2\0\2\37\2\0\26\37"+
    "\1\0\7\37\1\0\2\37\1\0\5\37\3\0\1\37"+
    "\36\0\2\37\1\0\3\37\4\0\12\5\1\0\1\37"+
    "\21\0\1\37\1\0\6\37\3\0\3\37\1\0\4\37"+
    "\3\0\2\37\1\0\1\37\1\0\2\37\3\0\2\37"+
    "\3\0\3\37\3\0\14\37\26\0\1\37\25\0\12\5"+
    "\25\0\10\37\1\0\3\37\1\0\27\37\1\0\20\37"+
    "\3\0\1\37\32\0\3\37\5\0\2\37\4\0\12\5"+
    "\20\0\1\37\4\0\10\37\1\0\3\37\1\0\27\37"+
    "\1\0\12\37\1\0\5\37\3\0\1\37\40\0\1\37"+
    "\1\0\2\37\4\0\12\5\1\0\2\37\22\0\10\37"+
    "\1\0\3\37\1\0\51\37\2\0\1\37\20\0\1\37"+
    "\5\0\3\37\10\0\3\37\4\0\12\5\12\0\6\37"+
    "\5\0\22\37\3\0\30\37\1\0\11\37\1\0\1\37"+
    "\2\0\7\37\37\0\12\5\21\0\60\37\1\0\2\37"+
    "\14\0\7\37\11\0\12\5\47\0\2\37\1\0\1\37"+
    "\1\0\5\37\1\0\30\37\1\0\1\37\1\0\12\37"+
    "\1\0\2\37\11\0\1\37\2\0\5\37\1\0\1\37"+
    "\11\0\12\5\2\0\4\37\40\0\1\37\37\0\12\5"+
    "\26\0\10\37\1\0\44\37\33\0\5\37\163\0\53\37"+
    "\24\0\1\37\12\5\6\0\6\37\4\0\4\37\3\0"+
    "\1\37\3\0\2\37\7\0\3\37\4\0\15\37\14\0"+
    "\1\37\1\0\12\5\6\0\46\37\1\0\1\37\5\0"+
    "\1\37\2\0\53\37\1\0\115\37\1\0\4\37\2\0"+
    "\7\37\1\0\1\37\1\0\4\37\2\0\51\37\1\0"+
    "\4\37\2\0\41\37\1\0\4\37\2\0\7\37\1\0"+
    "\1\37\1\0\4\37\2\0\17\37\1\0\71\37\1\0"+
    "\4\37\2\0\103\37\45\0\20\37\20\0\126\37\2\0"+
    "\6\37\3\0\u016c\37\2\0\21\37\1\0\32\37\5\0"+
    "\113\37\6\0\10\37\7\0\15\37\1\0\4\37\16\0"+
    "\22\37\16\0\22\37\16\0\15\37\1\0\3\37\17\0"+
    "\64\37\43\0\1\37\4\0\1\37\3\0\12\5\46\0"+
    "\12\5\6\0\131\37\7\0\5\37\2\0\42\37\1\0"+
    "\1\37\5\0\106\37\12\0\37\37\47\0\12\5\36\37"+
    "\2\0\5\37\13\0\54\37\4\0\32\37\6\0\12\5"+
    "\46\0\27\37\11\0\65\37\53\0\12\5\6\0\12\5"+
    "\15\0\1\37\135\0\57\37\21\0\7\37\4\0\12\5"+
    "\51\0\36\37\15\0\2\37\12\5\54\37\32\0\44\37"+
    "\34\0\12\5\3\0\3\37\12\5\44\37\2\0\11\37"+
    "\7\0\53\37\2\0\3\37\51\0\4\37\1\0\6\37"+
    "\1\0\2\37\3\0\1\37\5\0\300\37\100\0\26\37"+
    "\2\0\6\37\2\0\46\37\2\0\6\37\2\0\10\37"+
    "\1\0\1\37\1\0\1\37\1\0\1\37\1\0\37\37"+
    "\2\0\65\37\1\0\7\37\1\0\1\37\3\0\3\37"+
    "\1\0\7\37\3\0\4\37\2\0\6\37\4\0\15\37"+
    "\5\0\3\37\1\0\7\37\164\0\1\37\15\0\1\37"+
    "\20\0\15\37\145\0\1\37\4\0\1\37\2\0\12\37"+
    "\1\0\1\37\3\0\5\37\6\0\1\37\1\0\1\37"+
    "\1\0\1\37\1\0\4\37\1\0\13\37\2\0\4\37"+
    "\5\0\5\37\4\0\1\37\64\0\2\37\u017b\0\57\37"+
    "\1\0\57\37\1\0\205\37\6\0\4\37\3\0\2\37"+
    "\14\0\46\37\1\0\1\37\5\0\1\37\2\0\70\37"+
    "\7\0\1\37\20\0\27\37\11\0\7\37\1\0\7\37"+
    "\1\0\7\37\1\0\7\37\1\0\7\37\1\0\7\37"+
    "\1\0\7\37\1\0\7\37\120\0\1\37\325\0\2\37"+
    "\52\0\5\37\5\0\2\37\4\0\126\37\6\0\3\37"+
    "\1\0\132\37\1\0\4\37\5\0\53\37\1\0\136\37"+
    "\21\0\33\37\65\0\306\37\112\0\360\37\20\0\215\37"+
    "\103\0\56\37\2\0\15\37\3\0\20\37\12\5\2\37"+
    "\24\0\57\37\20\0\37\37\2\0\106\37\61\0\11\37"+
    "\2\0\147\37\2\0\65\37\2\0\5\37\60\0\13\37"+
    "\1\0\3\37\1\0\4\37\1\0\27\37\35\0\64\37"+
    "\16\0\62\37\34\0\12\5\30\0\6\37\3\0\1\37"+
    "\1\0\2\37\1\0\12\5\34\37\12\0\27\37\31\0"+
    "\35\37\7\0\57\37\34\0\1\37\12\5\6\0\5\37"+
    "\1\0\12\37\12\5\5\37\1\0\51\37\27\0\3\37"+
    "\1\0\10\37\4\0\12\5\6\0\27\37\3\0\1\37"+
    "\3\0\62\37\1\0\1\37\3\0\2\37\2\0\5\37"+
    "\2\0\1\37\1\0\1\37\30\0\3\37\2\0\13\37"+
    "\7\0\3\37\14\0\6\37\2\0\6\37\2\0\6\37"+
    "\11\0\7\37\1\0\7\37\1\0\53\37\1\0\14\37"+
    "\10\0\163\37\15\0\12\5\6\0\244\37\14\0\27\37"+
    "\4\0\61\37\4\0\156\37\2\0\152\37\46\0\7\37"+
    "\14\0\5\37\5\0\1\37\1\0\12\37\1\0\15\37"+
    "\1\0\5\37\1\0\1\37\1\0\2\37\1\0\2\37"+
    "\1\0\154\37\41\0\153\37\22\0\100\37\2\0\66\37"+
    "\50\0\14\37\164\0\5\37\1\0\207\37\23\0\12\5"+
    "\7\0\32\37\6\0\32\37\13\0\131\37\3\0\6\37"+
    "\2\0\6\37\2\0\6\37\2\0\3\37\43\0\14\37"+
    "\1\0\32\37\1\0\23\37\1\0\2\37\1\0\17\37"+
    "\2\0\16\37\42\0\173\37\205\0\35\37\3\0\61\37"+
    "\57\0\40\37\15\0\24\37\1\0\10\37\6\0\46\37"+
    "\12\0\36\37\2\0\44\37\4\0\10\37\60\0\236\37"+
    "\2\0\12\5\6\0\44\37\4\0\44\37\4\0\50\37"+
    "\10\0\64\37\234\0\67\37\11\0\26\37\12\0\10\37"+
    "\230\0\6\37\2\0\1\37\1\0\54\37\1\0\2\37"+
    "\3\0\1\37\2\0\27\37\12\0\27\37\11\0\37\37"+
    "\101\0\23\37\1\0\2\37\12\0\26\37\12\0\32\37"+
    "\106\0\70\37\6\0\2\37\100\0\1\37\17\0\4\37"+
    "\1\0\3\37\1\0\35\37\52\0\35\37\3\0\35\37"+
    "\43\0\10\37\1\0\34\37\33\0\66\37\12\0\26\37"+
    "\12\0\23\37\15\0\22\37\156\0\111\37\67\0\63\37"+
    "\15\0\63\37\15\0\44\37\14\0\12\5\306\0\35\37"+
    "\12\0\1\37\10\0\26\37\232\0\27\37\14\0\65\37"+
    "\56\0\12\5\23\0\55\37\40\0\31\37\7\0\12\5"+
    "\11\0\44\37\17\0\12\5\4\0\1\37\13\0\43\37"+
    "\3\0\1\37\14\0\60\37\16\0\4\37\13\0\12\5"+
    "\1\37\1\0\1\37\43\0\22\37\1\0\31\37\124\0"+
    "\7\37\1\0\1\37\1\0\4\37\1\0\17\37\1\0"+
    "\12\37\7\0\57\37\21\0\12\5\13\0\10\37\2\0"+
    "\2\37\2\0\26\37\1\0\7\37\1\0\2\37\1\0"+
    "\5\37\3\0\1\37\22\0\1\37\14\0\5\37\236\0"+
    "\65\37\22\0\4\37\5\0\12\5\5\0\1\37\40\0"+
    "\60\37\24\0\2\37\1\0\1\37\10\0\12\5\246\0"+
    "\57\37\51\0\4\37\44\0\60\37\24\0\1\37\13\0"+
    "\12\5\46\0\53\37\15\0\1\37\7\0\12\5\66\0"+
    "\33\37\25\0\12\5\306\0\54\37\164\0\100\37\12\5"+
    "\25\0\1\37\240\0\10\37\2\0\47\37\20\0\1\37"+
    "\1\0\1\37\34\0\1\37\12\0\50\37\7\0\1\37"+
    "\25\0\1\37\13\0\56\37\23\0\1\37\42\0\71\37"+
    "\7\0\11\37\1\0\45\37\21\0\1\37\17\0\12\5"+
    "\30\0\36\37\160\0\7\37\1\0\2\37\1\0\46\37"+
    "\25\0\1\37\11\0\12\5\6\0\6\37\1\0\2\37"+
    "\1\0\40\37\16\0\1\37\7\0\12\5\u0136\0\23\37"+
    "\15\0\232\37\346\0\304\37\274\0\57\37\321\0\107\37"+
    "\271\0\71\37\7\0\37\37\1\0\12\5\146\0\36\37"+
    "\22\0\60\37\20\0\4\37\14\0\12\5\11\0\25\37"+
    "\5\0\23\37\260\0\100\37\200\0\113\37\5\0\1\37"+
    "\102\0\15\37\100\0\2\37\1\0\1\37\34\0\370\37"+
    "\10\0\363\37\15\0\37\37\61\0\3\37\21\0\4\37"+
    "\10\0\u018c\37\4\0\153\37\5\0\15\37\3\0\11\37"+
    "\7\0\12\37\146\0\125\37\1\0\107\37\1\0\2\37"+
    "\2\0\1\37\2\0\2\37\2\0\4\37\1\0\14\37"+
    "\1\0\1\37\1\0\7\37\1\0\101\37\1\0\4\37"+
    "\2\0\10\37\1\0\7\37\1\0\34\37\1\0\4\37"+
    "\1\0\5\37\1\0\1\37\3\0\7\37\1\0\u0154\37"+
    "\2\0\31\37\1\0\31\37\1\0\37\37\1\0\31\37"+
    "\1\0\37\37\1\0\31\37\1\0\37\37\1\0\31\37"+
    "\1\0\37\37\1\0\31\37\1\0\10\37\2\0\62\5"+
    "\55\37\12\0\7\37\2\0\12\5\4\0\1\37\u0171\0"+
    "\54\37\4\0\12\5\6\0\305\37\73\0\104\37\7\0"+
    "\1\37\4\0\12\5\246\0\4\37\1\0\33\37\1\0"+
    "\2\37\1\0\1\37\2\0\1\37\1\0\12\37\1\0"+
    "\4\37\1\0\1\37\1\0\1\37\6\0\1\37\4\0"+
    "\1\37\1\0\1\37\1\0\1\37\1\0\3\37\1\0"+
    "\2\37\1\0\1\37\2\0\1\37\1\0\1\37\1\0"+
    "\1\37\1\0\1\37\1\0\1\37\1\0\2\37\1\0"+
    "\1\37\2\0\4\37\1\0\7\37\1\0\4\37\1\0"+
    "\4\37\1\0\1\37\1\0\12\37\1\0\21\37\5\0"+
    "\3\37\1\0\5\37\1\0\21\37\104\0\327\37\51\0"+
    "\65\37\13\0\336\37\2\0\u0182\37\16\0\u0131\37\37\0"+
    "\36\37\342\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[27648];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\5\7\6\1\7"+
    "\1\10\1\11\10\6\1\12\1\13\1\14\1\15\1\16"+
    "\11\6\1\17\1\6\1\20\2\6\1\21\1\22\1\23"+
    "\2\6\1\24\4\6\1\25\1\26\1\27\1\30";

  private static int [] zzUnpackAction() {
    int [] result = new int[58];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\40\0\100\0\140\0\100\0\200\0\100\0\240"+
    "\0\300\0\340\0\u0100\0\u0120\0\u0140\0\u0160\0\100\0\100"+
    "\0\u0180\0\u01a0\0\u01c0\0\u01e0\0\u0200\0\u0220\0\u0240\0\u0260"+
    "\0\u0280\0\100\0\100\0\100\0\100\0\300\0\u02a0\0\u02c0"+
    "\0\u02e0\0\u0300\0\u0320\0\u0340\0\u0360\0\u0380\0\u03a0\0\300"+
    "\0\u03c0\0\u03e0\0\u0400\0\u0420\0\300\0\300\0\300\0\u0440"+
    "\0\u0460\0\300\0\u0480\0\u04a0\0\u04c0\0\u04e0\0\300\0\300"+
    "\0\300\0\300";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[58];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\2\4\1\3\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\3\20\11\1\3"+
    "\1\17\1\3\1\17\1\3\1\20\11\17\1\21\21\17"+
    "\41\0\2\4\42\0\1\6\37\0\1\11\1\0\7\11"+
    "\1\0\10\11\1\22\10\11\5\0\1\11\1\0\7\11"+
    "\1\0\21\11\5\0\1\11\1\0\7\11\1\0\1\23"+
    "\3\11\1\24\4\11\1\25\7\11\5\0\1\11\1\0"+
    "\7\11\1\0\1\26\20\11\5\0\1\11\1\0\7\11"+
    "\1\0\1\27\20\11\5\0\1\11\1\0\7\11\1\0"+
    "\16\11\1\30\2\11\5\0\1\11\1\0\7\11\1\0"+
    "\3\11\1\31\15\11\20\0\1\32\6\0\1\33\2\0"+
    "\1\34\1\0\1\35\10\0\1\11\1\0\7\11\1\0"+
    "\17\11\1\36\1\11\5\0\1\11\1\0\7\11\1\0"+
    "\6\11\1\37\3\11\1\40\6\11\5\0\1\11\1\0"+
    "\7\11\1\0\1\41\10\11\1\42\7\11\5\0\1\11"+
    "\1\0\7\11\1\0\7\11\1\43\11\11\5\0\1\11"+
    "\1\0\7\11\1\0\5\11\1\44\13\11\5\0\1\11"+
    "\1\0\7\11\1\0\6\11\1\45\12\11\5\0\1\11"+
    "\1\0\7\11\1\0\7\11\1\46\11\11\5\0\1\11"+
    "\1\0\7\11\1\0\15\11\1\47\3\11\5\0\1\11"+
    "\1\0\7\11\1\0\6\11\1\50\12\11\5\0\1\11"+
    "\1\0\7\11\1\0\15\11\1\51\3\11\5\0\1\11"+
    "\1\0\7\11\1\0\13\11\1\52\5\11\5\0\1\11"+
    "\1\0\7\11\1\0\5\11\1\53\13\11\5\0\1\11"+
    "\1\0\7\11\1\0\7\11\1\54\11\11\5\0\1\11"+
    "\1\0\7\11\1\0\6\11\1\55\12\11\5\0\1\11"+
    "\1\0\7\11\1\0\15\11\1\56\3\11\5\0\1\11"+
    "\1\0\7\11\1\0\12\11\1\57\6\11\5\0\1\11"+
    "\1\0\7\11\1\0\16\11\1\60\2\11\5\0\1\11"+
    "\1\0\7\11\1\0\16\11\1\61\2\11\5\0\1\11"+
    "\1\0\7\11\1\0\14\11\1\62\4\11\5\0\1\11"+
    "\1\0\7\11\1\0\2\11\1\63\16\11\5\0\1\11"+
    "\1\0\7\11\1\0\5\11\1\64\13\11\5\0\1\11"+
    "\1\0\7\11\1\0\13\11\1\65\5\11\5\0\1\11"+
    "\1\0\7\11\1\0\13\11\1\66\5\11\5\0\1\11"+
    "\1\0\7\11\1\0\3\11\1\67\15\11\5\0\1\11"+
    "\1\0\7\11\1\0\15\11\1\70\3\11\5\0\1\11"+
    "\1\0\7\11\1\0\10\11\1\71\10\11\5\0\1\11"+
    "\1\0\7\11\1\0\3\11\1\72\15\11";

  private static int [] zzUnpacktrans() {
    int [] result = new int[1280];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\1\1\1\11\1\1\1\11\7\1\2\11"+
    "\11\1\4\11\35\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[58];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
	private char c;  
        private int cCount = 0;
	private Token newToken(short id)
	{
		return new Token(id, yyline + 1, yycolumn + 1, yylength());
	}

	private Token newToken(short id, Object value)
	{
		return new Token(id, yyline + 1, yycolumn + 1, yylength(), value);
	}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  ExpressionScanner(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Token nextToken() throws java.io.IOException
    , Exception
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
          { 	return newToken(Terminals.EOF, "end-of-file");
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { throw new Exception("unexpected character '" + yytext() + "'");
            }
          // fall through
          case 25: break;
          case 2:
            { /* ignore */
            }
          // fall through
          case 26: break;
          case 3:
            { c = '\0'; yybegin(CHAR);
            }
          // fall through
          case 27: break;
          case 4:
            { return newToken(Terminals.NUMBER, Double.parseDouble(yytext()) );
            }
          // fall through
          case 28: break;
          case 5:
            { return newToken(Terminals.COLON);
            }
          // fall through
          case 29: break;
          case 6:
            { return newToken(Terminals.ID, yytext());
            }
          // fall through
          case 30: break;
          case 7:
            { c = yytext().charAt(0);
            }
          // fall through
          case 31: break;
          case 8:
            { yybegin(YYINITIAL); return newToken(Terminals.CHARLIT, c);
            }
          // fall through
          case 32: break;
          case 9:
            { c = '\\';
            }
          // fall through
          case 33: break;
          case 10:
            { c = '\b';
            }
          // fall through
          case 34: break;
          case 11:
            { c = '\n';
            }
          // fall through
          case 35: break;
          case 12:
            { c = '\r';
            }
          // fall through
          case 36: break;
          case 13:
            { c = '\t';
            }
          // fall through
          case 37: break;
          case 14:
            { return newToken(Terminals.ANY);
            }
          // fall through
          case 38: break;
          case 15:
            { return newToken(Terminals.CALL);
            }
          // fall through
          case 39: break;
          case 16:
            { return newToken(Terminals.CHAR);
            }
          // fall through
          case 40: break;
          case 17:
            { return newToken(Terminals.FAIL);
            }
          // fall through
          case 41: break;
          case 18:
            { return newToken(Terminals.HALT);
            }
          // fall through
          case 42: break;
          case 19:
            { return newToken(Terminals.JUMP);
            }
          // fall through
          case 43: break;
          case 20:
            { return newToken(Terminals.CHARS);
            }
          // fall through
          case 44: break;
          case 21:
            { return newToken(Terminals.CHOICE);
            }
          // fall through
          case 45: break;
          case 22:
            { return newToken(Terminals.COMMIT);
            }
          // fall through
          case 46: break;
          case 23:
            { return newToken(Terminals.RETURN);
            }
          // fall through
          case 47: break;
          case 24:
            { return newToken(Terminals.CAPTURE);
            }
          // fall through
          case 48: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
