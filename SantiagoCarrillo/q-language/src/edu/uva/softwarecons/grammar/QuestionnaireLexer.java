// Generated from Questionnaire.g4 by ANTLR 4.2
package edu.uva.softwarecons.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuestionnaireLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, BOOL_TYPE=7, STRING_TYPE=8, 
		INT_TYPE=9, DATE_TYPE=10, DECIMAL_TYPE=11, MONEY_TYPE=12, MUL=13, DIV=14, 
		ADD=15, SUB=16, NOT=17, AND=18, OR=19, LT=20, LEq=21, GT=22, GEq=23, Eq=24, 
		NEq=25, IF=26, ELSE=27, ID=28, INT=29, STRING=30, WS=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "'{'", "')'", "':'", "'('", "'}'", "'boolean'", "'string'", 
		"'integer'", "'date'", "'decimal'", "'money'", "'*'", "'/'", "'+'", "'-'", 
		"'!'", "'&&'", "'||'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'if'", 
		"'else'", "ID", "INT", "STRING", "WS"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "BOOL_TYPE", "STRING_TYPE", 
		"INT_TYPE", "DATE_TYPE", "DECIMAL_TYPE", "MONEY_TYPE", "MUL", "DIV", "ADD", 
		"SUB", "NOT", "AND", "OR", "LT", "LEq", "GT", "GEq", "Eq", "NEq", "IF", 
		"ELSE", "ID", "INT", "STRING", "ESC", "UNICODE", "HEX", "WS"
	};


	public QuestionnaireLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Questionnaire.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u00d2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\7\35\u00ab\n\35\f\35\16\35"+
		"\u00ae\13\35\3\36\6\36\u00b1\n\36\r\36\16\36\u00b2\3\37\3\37\3\37\7\37"+
		"\u00b8\n\37\f\37\16\37\u00bb\13\37\3\37\3\37\3 \3 \3 \5 \u00c2\n \3!\3"+
		"!\3!\3!\3!\3!\3\"\3\"\3#\6#\u00cd\n#\r#\16#\u00ce\3#\3#\2\2$\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?\2A\2"+
		"C\2E!\3\2\t\4\2C\\c|\5\2\62;C\\c|\3\2\62;\4\2$$^^\n\2$$\61\61^^ddhhpp"+
		"ttvv\5\2\62;CHch\5\2\13\f\17\17\"\"\u00d4\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2E\3\2\2\2"+
		"\3G\3\2\2\2\5L\3\2\2\2\7N\3\2\2\2\tP\3\2\2\2\13R\3\2\2\2\rT\3\2\2\2\17"+
		"V\3\2\2\2\21^\3\2\2\2\23e\3\2\2\2\25m\3\2\2\2\27r\3\2\2\2\31z\3\2\2\2"+
		"\33\u0080\3\2\2\2\35\u0082\3\2\2\2\37\u0084\3\2\2\2!\u0086\3\2\2\2#\u0088"+
		"\3\2\2\2%\u008a\3\2\2\2\'\u008d\3\2\2\2)\u0090\3\2\2\2+\u0092\3\2\2\2"+
		"-\u0095\3\2\2\2/\u0097\3\2\2\2\61\u009a\3\2\2\2\63\u009d\3\2\2\2\65\u00a0"+
		"\3\2\2\2\67\u00a3\3\2\2\29\u00a8\3\2\2\2;\u00b0\3\2\2\2=\u00b4\3\2\2\2"+
		"?\u00be\3\2\2\2A\u00c3\3\2\2\2C\u00c9\3\2\2\2E\u00cc\3\2\2\2GH\7h\2\2"+
		"HI\7q\2\2IJ\7t\2\2JK\7o\2\2K\4\3\2\2\2LM\7}\2\2M\6\3\2\2\2NO\7+\2\2O\b"+
		"\3\2\2\2PQ\7<\2\2Q\n\3\2\2\2RS\7*\2\2S\f\3\2\2\2TU\7\177\2\2U\16\3\2\2"+
		"\2VW\7d\2\2WX\7q\2\2XY\7q\2\2YZ\7n\2\2Z[\7g\2\2[\\\7c\2\2\\]\7p\2\2]\20"+
		"\3\2\2\2^_\7u\2\2_`\7v\2\2`a\7t\2\2ab\7k\2\2bc\7p\2\2cd\7i\2\2d\22\3\2"+
		"\2\2ef\7k\2\2fg\7p\2\2gh\7v\2\2hi\7g\2\2ij\7i\2\2jk\7g\2\2kl\7t\2\2l\24"+
		"\3\2\2\2mn\7f\2\2no\7c\2\2op\7v\2\2pq\7g\2\2q\26\3\2\2\2rs\7f\2\2st\7"+
		"g\2\2tu\7e\2\2uv\7k\2\2vw\7o\2\2wx\7c\2\2xy\7n\2\2y\30\3\2\2\2z{\7o\2"+
		"\2{|\7q\2\2|}\7p\2\2}~\7g\2\2~\177\7{\2\2\177\32\3\2\2\2\u0080\u0081\7"+
		",\2\2\u0081\34\3\2\2\2\u0082\u0083\7\61\2\2\u0083\36\3\2\2\2\u0084\u0085"+
		"\7-\2\2\u0085 \3\2\2\2\u0086\u0087\7/\2\2\u0087\"\3\2\2\2\u0088\u0089"+
		"\7#\2\2\u0089$\3\2\2\2\u008a\u008b\7(\2\2\u008b\u008c\7(\2\2\u008c&\3"+
		"\2\2\2\u008d\u008e\7~\2\2\u008e\u008f\7~\2\2\u008f(\3\2\2\2\u0090\u0091"+
		"\7>\2\2\u0091*\3\2\2\2\u0092\u0093\7>\2\2\u0093\u0094\7?\2\2\u0094,\3"+
		"\2\2\2\u0095\u0096\7@\2\2\u0096.\3\2\2\2\u0097\u0098\7@\2\2\u0098\u0099"+
		"\7?\2\2\u0099\60\3\2\2\2\u009a\u009b\7?\2\2\u009b\u009c\7?\2\2\u009c\62"+
		"\3\2\2\2\u009d\u009e\7#\2\2\u009e\u009f\7?\2\2\u009f\64\3\2\2\2\u00a0"+
		"\u00a1\7k\2\2\u00a1\u00a2\7h\2\2\u00a2\66\3\2\2\2\u00a3\u00a4\7g\2\2\u00a4"+
		"\u00a5\7n\2\2\u00a5\u00a6\7u\2\2\u00a6\u00a7\7g\2\2\u00a78\3\2\2\2\u00a8"+
		"\u00ac\t\2\2\2\u00a9\u00ab\t\3\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2"+
		"\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad:\3\2\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00af\u00b1\t\4\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3<\3\2\2\2\u00b4\u00b9\7$\2\2\u00b5"+
		"\u00b8\5? \2\u00b6\u00b8\n\5\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2"+
		"\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7$\2\2\u00bd>\3\2\2\2\u00be\u00c1"+
		"\7^\2\2\u00bf\u00c2\t\6\2\2\u00c0\u00c2\5A!\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c0\3\2\2\2\u00c2@\3\2\2\2\u00c3\u00c4\7w\2\2\u00c4\u00c5\5C\"\2\u00c5"+
		"\u00c6\5C\"\2\u00c6\u00c7\5C\"\2\u00c7\u00c8\5C\"\2\u00c8B\3\2\2\2\u00c9"+
		"\u00ca\t\7\2\2\u00caD\3\2\2\2\u00cb\u00cd\t\b\2\2\u00cc\u00cb\3\2\2\2"+
		"\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0"+
		"\3\2\2\2\u00d0\u00d1\b#\2\2\u00d1F\3\2\2\2\t\2\u00ac\u00b2\u00b7\u00b9"+
		"\u00c1\u00ce\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}