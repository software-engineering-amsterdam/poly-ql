// Generated from Questionnaire.g4 by ANTLR 4.2
package edu.uva.softwarecons.grammar;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class QuestionnaireLexer
    extends Lexer
{
    protected static final DFA[] _decisionToDFA;

    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();

    public static final int T__5 = 1, T__4 = 2, T__3 = 3, T__2 = 4, T__1 = 5, T__0 = 6, BOOL_TYPE = 7, STRING_TYPE = 8,
        INT_TYPE = 9, DATE_TYPE = 10, DECIMAL_TYPE = 11, MONEY_TYPE = 12, MUL = 13, DIV = 14, ADD = 15, SUB = 16, NOT =
        17, AND = 18, OR = 19, LT = 20, LEq = 21, GT = 22, GEq = 23, Eq = 24, NEq = 25, BOOLEAN = 26, IF = 27, ELSE =
        28, ID = 29, INT = 30, STRING = 31, COMMENT = 32, MULTYLINE_COMMENT = 33, WS = 34;

    public static String[] modeNames = { "DEFAULT_MODE" };

    public static final String[] tokenNames =
        { "<INVALID>", "'form'", "'{'", "')'", "':'", "'('", "'}'", "'boolean'", "'string'", "'integer'", "'date'",
            "'decimal'", "'money'", "'*'", "'/'", "'+'", "'-'", "'!'", "'&&'", "'||'", "'<'", "'<='", "'>'", "'>='",
            "'=='", "'!='", "BOOLEAN", "'if'", "'else'", "ID", "INT", "STRING", "COMMENT", "MULTYLINE_COMMENT", "WS" };

    public static final String[] ruleNames =
        { "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "BOOL_TYPE", "STRING_TYPE", "INT_TYPE", "DATE_TYPE",
            "DECIMAL_TYPE", "MONEY_TYPE", "MUL", "DIV", "ADD", "SUB", "NOT", "AND", "OR", "LT", "LEq", "GT", "GEq",
            "Eq", "NEq", "BOOLEAN", "IF", "ELSE", "ID", "INT", "STRING", "ESC", "UNICODE", "HEX", "COMMENT",
            "MULTYLINE_COMMENT", "WS" };


    public QuestionnaireLexer( CharStream input )
    {
        super( input );
        _interp = new LexerATNSimulator( this, _ATN, _decisionToDFA, _sharedContextCache );
    }

    @Override
    public String getGrammarFileName()
    {
        return "Questionnaire.g4";
    }

    @Override
    public String[] getTokenNames()
    {
        return tokenNames;
    }

    @Override
    public String[] getRuleNames()
    {
        return ruleNames;
    }

    @Override
    public String getSerializedATN()
    {
        return _serializedATN;
    }

    @Override
    public String[] getModeNames()
    {
        return modeNames;
    }

    @Override
    public ATN getATN()
    {
        return _ATN;
    }

    public static final String _serializedATN =
        "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2$\u0101\b\1\4\2\t" +
            "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
            "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
            "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
            "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
            "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3" +
            "\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t" +
            "\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3" +
            "\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16" +
            "\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24" +
            "\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32" +
            "\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00b0\n\33" +
            "\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\7\36\u00bc\n\36\f\36" +
            "\16\36\u00bf\13\36\3\37\6\37\u00c2\n\37\r\37\16\37\u00c3\3 \3 \3 \7 \u00c9" +
            "\n \f \16 \u00cc\13 \3 \3 \3!\3!\3!\5!\u00d3\n!\3\"\3\"\3\"\3\"\3\"\3" +
            "\"\3#\3#\3$\3$\3$\3$\7$\u00e1\n$\f$\16$\u00e4\13$\3$\5$\u00e7\n$\3$\3" +
            "$\3$\3$\3%\3%\3%\3%\7%\u00f1\n%\f%\16%\u00f4\13%\3%\3%\3%\3%\3%\3&\6&" +
            "\u00fc\n&\r&\16&\u00fd\3&\3&\4\u00e2\u00f2\2\'\3\3\5\4\7\5\t\6\13\7\r" +
            "\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25" +
            ")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\2C\2E\2G\"I#K$\3" +
            "\2\t\4\2C\\c|\5\2\62;C\\c|\3\2\62;\4\2$$^^\n\2$$\61\61^^ddhhppttvv\5\2" +
            "\62;CHch\5\2\13\f\17\17\"\"\u0107\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2" +
            "\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3" +
            "\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2" +
            "\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2" +
            "\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2" +
            "\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2G\3\2\2" +
            "\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5R\3\2\2\2\7T\3\2\2\2\tV\3\2\2\2\13" +
            "X\3\2\2\2\rZ\3\2\2\2\17\\\3\2\2\2\21d\3\2\2\2\23k\3\2\2\2\25s\3\2\2\2" +
            "\27x\3\2\2\2\31\u0080\3\2\2\2\33\u0086\3\2\2\2\35\u0088\3\2\2\2\37\u008a" +
            "\3\2\2\2!\u008c\3\2\2\2#\u008e\3\2\2\2%\u0090\3\2\2\2\'\u0093\3\2\2\2" +
            ")\u0096\3\2\2\2+\u0098\3\2\2\2-\u009b\3\2\2\2/\u009d\3\2\2\2\61\u00a0" +
            "\3\2\2\2\63\u00a3\3\2\2\2\65\u00af\3\2\2\2\67\u00b1\3\2\2\29\u00b4\3\2" +
            "\2\2;\u00b9\3\2\2\2=\u00c1\3\2\2\2?\u00c5\3\2\2\2A\u00cf\3\2\2\2C\u00d4" +
            "\3\2\2\2E\u00da\3\2\2\2G\u00dc\3\2\2\2I\u00ec\3\2\2\2K\u00fb\3\2\2\2M" +
            "N\7h\2\2NO\7q\2\2OP\7t\2\2PQ\7o\2\2Q\4\3\2\2\2RS\7}\2\2S\6\3\2\2\2TU\7" +
            "+\2\2U\b\3\2\2\2VW\7<\2\2W\n\3\2\2\2XY\7*\2\2Y\f\3\2\2\2Z[\7\177\2\2[" +
            "\16\3\2\2\2\\]\7d\2\2]^\7q\2\2^_\7q\2\2_`\7n\2\2`a\7g\2\2ab\7c\2\2bc\7" +
            "p\2\2c\20\3\2\2\2de\7u\2\2ef\7v\2\2fg\7t\2\2gh\7k\2\2hi\7p\2\2ij\7i\2" +
            "\2j\22\3\2\2\2kl\7k\2\2lm\7p\2\2mn\7v\2\2no\7g\2\2op\7i\2\2pq\7g\2\2q" +
            "r\7t\2\2r\24\3\2\2\2st\7f\2\2tu\7c\2\2uv\7v\2\2vw\7g\2\2w\26\3\2\2\2x" +
            "y\7f\2\2yz\7g\2\2z{\7e\2\2{|\7k\2\2|}\7o\2\2}~\7c\2\2~\177\7n\2\2\177" +
            "\30\3\2\2\2\u0080\u0081\7o\2\2\u0081\u0082\7q\2\2\u0082\u0083\7p\2\2\u0083" +
            "\u0084\7g\2\2\u0084\u0085\7{\2\2\u0085\32\3\2\2\2\u0086\u0087\7,\2\2\u0087" +
            "\34\3\2\2\2\u0088\u0089\7\61\2\2\u0089\36\3\2\2\2\u008a\u008b\7-\2\2\u008b" +
            " \3\2\2\2\u008c\u008d\7/\2\2\u008d\"\3\2\2\2\u008e\u008f\7#\2\2\u008f" +
            "$\3\2\2\2\u0090\u0091\7(\2\2\u0091\u0092\7(\2\2\u0092&\3\2\2\2\u0093\u0094" +
            "\7~\2\2\u0094\u0095\7~\2\2\u0095(\3\2\2\2\u0096\u0097\7>\2\2\u0097*\3" +
            "\2\2\2\u0098\u0099\7>\2\2\u0099\u009a\7?\2\2\u009a,\3\2\2\2\u009b\u009c" +
            "\7@\2\2\u009c.\3\2\2\2\u009d\u009e\7@\2\2\u009e\u009f\7?\2\2\u009f\60" +
            "\3\2\2\2\u00a0\u00a1\7?\2\2\u00a1\u00a2\7?\2\2\u00a2\62\3\2\2\2\u00a3" +
            "\u00a4\7#\2\2\u00a4\u00a5\7?\2\2\u00a5\64\3\2\2\2\u00a6\u00a7\7v\2\2\u00a7" +
            "\u00a8\7t\2\2\u00a8\u00a9\7w\2\2\u00a9\u00b0\7g\2\2\u00aa\u00ab\7h\2\2" +
            "\u00ab\u00ac\7c\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7u\2\2\u00ae\u00b0" +
            "\7g\2\2\u00af\u00a6\3\2\2\2\u00af\u00aa\3\2\2\2\u00b0\66\3\2\2\2\u00b1" +
            "\u00b2\7k\2\2\u00b2\u00b3\7h\2\2\u00b38\3\2\2\2\u00b4\u00b5\7g\2\2\u00b5" +
            "\u00b6\7n\2\2\u00b6\u00b7\7u\2\2\u00b7\u00b8\7g\2\2\u00b8:\3\2\2\2\u00b9" +
            "\u00bd\t\2\2\2\u00ba\u00bc\t\3\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2" +
            "\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be<\3\2\2\2\u00bf\u00bd" +
            "\3\2\2\2\u00c0\u00c2\t\4\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3" +
            "\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4>\3\2\2\2\u00c5\u00ca\7$\2\2\u00c6" +
            "\u00c9\5A!\2\u00c7\u00c9\n\5\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2" +
            "\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd" +
            "\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7$\2\2\u00ce@\3\2\2\2\u00cf\u00d2" +
            "\7^\2\2\u00d0\u00d3\t\6\2\2\u00d1\u00d3\5C\"\2\u00d2\u00d0\3\2\2\2\u00d2" +
            "\u00d1\3\2\2\2\u00d3B\3\2\2\2\u00d4\u00d5\7w\2\2\u00d5\u00d6\5E#\2\u00d6" +
            "\u00d7\5E#\2\u00d7\u00d8\5E#\2\u00d8\u00d9\5E#\2\u00d9D\3\2\2\2\u00da" +
            "\u00db\t\7\2\2\u00dbF\3\2\2\2\u00dc\u00dd\7\61\2\2\u00dd\u00de\7\61\2" +
            "\2\u00de\u00e2\3\2\2\2\u00df\u00e1\13\2\2\2\u00e0\u00df\3\2\2\2\u00e1" +
            "\u00e4\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e6\3\2" +
            "\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e7\7\17\2\2\u00e6\u00e5\3\2\2\2\u00e6" +
            "\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\7\f\2\2\u00e9\u00ea\3\2" +
            "\2\2\u00ea\u00eb\b$\2\2\u00ebH\3\2\2\2\u00ec\u00ed\7\61\2\2\u00ed\u00ee" +
            "\7,\2\2\u00ee\u00f2\3\2\2\2\u00ef\u00f1\13\2\2\2\u00f0\u00ef\3\2\2\2\u00f1" +
            "\u00f4\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f5\3\2" +
            "\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7,\2\2\u00f6\u00f7\7\61\2\2\u00f7" +
            "\u00f8\3\2\2\2\u00f8\u00f9\b%\2\2\u00f9J\3\2\2\2\u00fa\u00fc\t\b\2\2\u00fb" +
            "\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2" +
            "\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\b&\2\2\u0100L\3\2\2\2\r\2\u00af\u00bd" +
            "\u00c3\u00c8\u00ca\u00d2\u00e2\u00e6\u00f2\u00fd\3\b\2\2";

    public static final ATN _ATN = new ATNDeserializer().deserialize( _serializedATN.toCharArray() );

    static
    {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for ( int i = 0; i < _ATN.getNumberOfDecisions(); i++ )
        {
            _decisionToDFA[i] = new DFA( _ATN.getDecisionState( i ), i );
        }
    }
}