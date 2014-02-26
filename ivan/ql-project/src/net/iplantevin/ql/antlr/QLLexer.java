// Generated from QL.g4 by ANTLR 4.2
package net.iplantevin.ql.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLLexer extends Lexer {
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__7 = 1, T__6 = 2, T__5 = 3, T__4 = 4, T__3 = 5, T__2 = 6, T__1 = 7, T__0 = 8, NOT = 9,
            ADD = 10, SUB = 11, MUL = 12, DIV = 13, LT = 14, GT = 15, LEQ = 16, GEQ = 17, EQ = 18, NEQ = 19,
            AND = 20, OR = 21, BOOLEAN = 22, INTEGER = 23, STRING = 24, TRUE = 25, FALSE = 26, ID = 27,
            INT = 28, COMMENT = 29, COMMENT2 = 30, WS = 31, STR = 32;
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    public static final String[] tokenNames = {
            "<INVALID>",
            "'form'", "'{'", "')'", "'('", "':'", "'if'", "'else'", "'}'", "'!'",
            "'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='",
            "'&&'", "'||'", "'boolean'", "'integer'", "'string'", "'true'", "'false'",
            "ID", "INT", "COMMENT", "COMMENT2", "WS", "STR"
    };
    public static final String[] ruleNames = {
            "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "NOT",
            "ADD", "SUB", "MUL", "DIV", "LT", "GT", "LEQ", "GEQ", "EQ", "NEQ", "AND",
            "OR", "BOOLEAN", "INTEGER", "STRING", "TRUE", "FALSE", "ID", "INT", "COMMENT",
            "COMMENT2", "WS", "STR", "ESC"
    };


    public QLLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "QL.g4";
    }

    @Override
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u00df\b\1\4\2\t" +
                    "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3" +
                    "\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3" +
                    "\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3" +
                    "\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3" +
                    "\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3" +
                    "\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3" +
                    "\33\3\33\3\34\3\34\7\34\u00a1\n\34\f\34\16\34\u00a4\13\34\3\35\6\35\u00a7" +
                    "\n\35\r\35\16\35\u00a8\3\36\3\36\3\36\3\36\7\36\u00af\n\36\f\36\16\36" +
                    "\u00b2\13\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u00bd\n" +
                    "\37\f\37\16\37\u00c0\13\37\3\37\5\37\u00c3\n\37\3\37\3\37\3\37\3\37\3" +
                    " \6 \u00ca\n \r \16 \u00cb\3 \3 \3!\3!\3!\7!\u00d3\n!\f!\16!\u00d6\13" +
                    "!\3!\3!\3\"\3\"\3\"\3\"\5\"\u00de\n\"\5\u00b0\u00be\u00d4\2#\3\3\5\4\7" +
                    "\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22" +
                    "#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C" +
                    "\2\3\2\6\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\u00e6\2\3" +
                    "\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2" +
                    "\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31" +
                    "\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2" +
                    "\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2" +
                    "\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2" +
                    "\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3E\3\2\2\2\5J\3\2\2\2\7L\3\2\2\2\t" +
                    "N\3\2\2\2\13P\3\2\2\2\rR\3\2\2\2\17U\3\2\2\2\21Z\3\2\2\2\23\\\3\2\2\2" +
                    "\25^\3\2\2\2\27`\3\2\2\2\31b\3\2\2\2\33d\3\2\2\2\35f\3\2\2\2\37h\3\2\2" +
                    "\2!j\3\2\2\2#m\3\2\2\2%p\3\2\2\2\'s\3\2\2\2)v\3\2\2\2+y\3\2\2\2-|\3\2" +
                    "\2\2/\u0084\3\2\2\2\61\u008c\3\2\2\2\63\u0093\3\2\2\2\65\u0098\3\2\2\2" +
                    "\67\u009e\3\2\2\29\u00a6\3\2\2\2;\u00aa\3\2\2\2=\u00b8\3\2\2\2?\u00c9" +
                    "\3\2\2\2A\u00cf\3\2\2\2C\u00dd\3\2\2\2EF\7h\2\2FG\7q\2\2GH\7t\2\2HI\7" +
                    "o\2\2I\4\3\2\2\2JK\7}\2\2K\6\3\2\2\2LM\7+\2\2M\b\3\2\2\2NO\7*\2\2O\n\3" +
                    "\2\2\2PQ\7<\2\2Q\f\3\2\2\2RS\7k\2\2ST\7h\2\2T\16\3\2\2\2UV\7g\2\2VW\7" +
                    "n\2\2WX\7u\2\2XY\7g\2\2Y\20\3\2\2\2Z[\7\177\2\2[\22\3\2\2\2\\]\7#\2\2" +
                    "]\24\3\2\2\2^_\7-\2\2_\26\3\2\2\2`a\7/\2\2a\30\3\2\2\2bc\7,\2\2c\32\3" +
                    "\2\2\2de\7\61\2\2e\34\3\2\2\2fg\7>\2\2g\36\3\2\2\2hi\7@\2\2i \3\2\2\2" +
                    "jk\7>\2\2kl\7?\2\2l\"\3\2\2\2mn\7@\2\2no\7?\2\2o$\3\2\2\2pq\7?\2\2qr\7" +
                    "?\2\2r&\3\2\2\2st\7#\2\2tu\7?\2\2u(\3\2\2\2vw\7(\2\2wx\7(\2\2x*\3\2\2" +
                    "\2yz\7~\2\2z{\7~\2\2{,\3\2\2\2|}\7d\2\2}~\7q\2\2~\177\7q\2\2\177\u0080" +
                    "\7n\2\2\u0080\u0081\7g\2\2\u0081\u0082\7c\2\2\u0082\u0083\7p\2\2\u0083" +
                    ".\3\2\2\2\u0084\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u0087\7v\2\2\u0087" +
                    "\u0088\7g\2\2\u0088\u0089\7i\2\2\u0089\u008a\7g\2\2\u008a\u008b\7t\2\2" +
                    "\u008b\60\3\2\2\2\u008c\u008d\7u\2\2\u008d\u008e\7v\2\2\u008e\u008f\7" +
                    "t\2\2\u008f\u0090\7k\2\2\u0090\u0091\7p\2\2\u0091\u0092\7i\2\2\u0092\62" +
                    "\3\2\2\2\u0093\u0094\7v\2\2\u0094\u0095\7t\2\2\u0095\u0096\7w\2\2\u0096" +
                    "\u0097\7g\2\2\u0097\64\3\2\2\2\u0098\u0099\7h\2\2\u0099\u009a\7c\2\2\u009a" +
                    "\u009b\7n\2\2\u009b\u009c\7u\2\2\u009c\u009d\7g\2\2\u009d\66\3\2\2\2\u009e" +
                    "\u00a2\t\2\2\2\u009f\u00a1\t\3\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2" +
                    "\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a38\3\2\2\2\u00a4\u00a2" +
                    "\3\2\2\2\u00a5\u00a7\t\4\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8" +
                    "\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9:\3\2\2\2\u00aa\u00ab\7\61\2\2" +
                    "\u00ab\u00ac\7,\2\2\u00ac\u00b0\3\2\2\2\u00ad\u00af\13\2\2\2\u00ae\u00ad" +
                    "\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1" +
                    "\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\7,\2\2\u00b4\u00b5\7\61" +
                    "\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\36\2\2\u00b7<\3\2\2\2\u00b8\u00b9" +
                    "\7\61\2\2\u00b9\u00ba\7\61\2\2\u00ba\u00be\3\2\2\2\u00bb\u00bd\13\2\2" +
                    "\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bf\3\2\2\2\u00be\u00bc" +
                    "\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c3\7\17\2\2" +
                    "\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5" +
                    "\7\f\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\b\37\2\2\u00c7>\3\2\2\2\u00c8" +
                    "\u00ca\t\5\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2" +
                    "\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\b \2\2\u00ce" +
                    "@\3\2\2\2\u00cf\u00d4\7$\2\2\u00d0\u00d3\5C\"\2\u00d1\u00d3\13\2\2\2\u00d2" +
                    "\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d5\3\2" +
                    "\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7" +
                    "\u00d8\7$\2\2\u00d8B\3\2\2\2\u00d9\u00da\7^\2\2\u00da\u00de\7$\2\2\u00db" +
                    "\u00dc\7^\2\2\u00dc\u00de\7^\2\2\u00dd\u00d9\3\2\2\2\u00dd\u00db\3\2\2" +
                    "\2\u00deD\3\2\2\2\f\2\u00a2\u00a8\u00b0\u00be\u00c2\u00cb\u00d2\u00d4" +
                    "\u00dd\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}