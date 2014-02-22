// Generated from grammar/Form2.g4 by ANTLR 4.2

	package Form2;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Form2Lexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, TYPE=20, IF=21, ELSEIF=22, ELSE=23, IDENTIFIER=24, 
		STRING=25, INT=26, WS=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "'+'", "'-'", "'*'", "'('", "':'", "'<'", "'!='", "';'", "'<='", 
		"'&&'", "'||'", "'{'", "'>'", "'/'", "'=='", "'}'", "'>='", "'!'", "TYPE", 
		"'if'", "'elseif'", "'else'", "IDENTIFIER", "STRING", "INT", "WS"
	};
	public static final String[] ruleNames = {
		"T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", 
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "TYPE", "IF", "ELSEIF", "ELSE", "IDENTIFIER", "STRING", 
		"INT", "WS"
	};


	public Form2Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Form2.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u00b9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\5\25\u008d\n\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\7\31\u00a0\n\31\f\31\16\31\u00a3"+
		"\13\31\3\32\3\32\7\32\u00a7\n\32\f\32\16\32\u00aa\13\32\3\32\3\32\3\33"+
		"\6\33\u00af\n\33\r\33\16\33\u00b0\3\34\6\34\u00b4\n\34\r\34\16\34\u00b5"+
		"\3\34\3\34\2\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\35\3\2\5\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\u00c1\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5;\3\2\2\2"+
		"\7=\3\2\2\2\t?\3\2\2\2\13A\3\2\2\2\rC\3\2\2\2\17E\3\2\2\2\21G\3\2\2\2"+
		"\23J\3\2\2\2\25L\3\2\2\2\27O\3\2\2\2\31R\3\2\2\2\33U\3\2\2\2\35W\3\2\2"+
		"\2\37Y\3\2\2\2![\3\2\2\2#^\3\2\2\2%`\3\2\2\2\'c\3\2\2\2)\u008c\3\2\2\2"+
		"+\u008e\3\2\2\2-\u0091\3\2\2\2/\u0098\3\2\2\2\61\u009d\3\2\2\2\63\u00a4"+
		"\3\2\2\2\65\u00ae\3\2\2\2\67\u00b3\3\2\2\29:\7+\2\2:\4\3\2\2\2;<\7-\2"+
		"\2<\6\3\2\2\2=>\7/\2\2>\b\3\2\2\2?@\7,\2\2@\n\3\2\2\2AB\7*\2\2B\f\3\2"+
		"\2\2CD\7<\2\2D\16\3\2\2\2EF\7>\2\2F\20\3\2\2\2GH\7#\2\2HI\7?\2\2I\22\3"+
		"\2\2\2JK\7=\2\2K\24\3\2\2\2LM\7>\2\2MN\7?\2\2N\26\3\2\2\2OP\7(\2\2PQ\7"+
		"(\2\2Q\30\3\2\2\2RS\7~\2\2ST\7~\2\2T\32\3\2\2\2UV\7}\2\2V\34\3\2\2\2W"+
		"X\7@\2\2X\36\3\2\2\2YZ\7\61\2\2Z \3\2\2\2[\\\7?\2\2\\]\7?\2\2]\"\3\2\2"+
		"\2^_\7\177\2\2_$\3\2\2\2`a\7@\2\2ab\7?\2\2b&\3\2\2\2cd\7#\2\2d(\3\2\2"+
		"\2ef\7d\2\2fg\7q\2\2gh\7q\2\2hi\7n\2\2ij\7g\2\2jk\7c\2\2k\u008d\7p\2\2"+
		"lm\7u\2\2mn\7v\2\2no\7t\2\2op\7k\2\2pq\7p\2\2q\u008d\7i\2\2rs\7k\2\2s"+
		"t\7p\2\2tu\7v\2\2uv\7g\2\2vw\7i\2\2wx\7g\2\2x\u008d\7t\2\2yz\7f\2\2z{"+
		"\7c\2\2{|\7v\2\2|\u008d\7g\2\2}~\7f\2\2~\177\7g\2\2\177\u0080\7e\2\2\u0080"+
		"\u0081\7k\2\2\u0081\u0082\7o\2\2\u0082\u0083\7c\2\2\u0083\u008d\7n\2\2"+
		"\u0084\u0085\7e\2\2\u0085\u0086\7w\2\2\u0086\u0087\7t\2\2\u0087\u0088"+
		"\7t\2\2\u0088\u0089\7g\2\2\u0089\u008a\7p\2\2\u008a\u008b\7e\2\2\u008b"+
		"\u008d\7{\2\2\u008ce\3\2\2\2\u008cl\3\2\2\2\u008cr\3\2\2\2\u008cy\3\2"+
		"\2\2\u008c}\3\2\2\2\u008c\u0084\3\2\2\2\u008d*\3\2\2\2\u008e\u008f\7k"+
		"\2\2\u008f\u0090\7h\2\2\u0090,\3\2\2\2\u0091\u0092\7g\2\2\u0092\u0093"+
		"\7n\2\2\u0093\u0094\7u\2\2\u0094\u0095\7g\2\2\u0095\u0096\7k\2\2\u0096"+
		"\u0097\7h\2\2\u0097.\3\2\2\2\u0098\u0099\7g\2\2\u0099\u009a\7n\2\2\u009a"+
		"\u009b\7u\2\2\u009b\u009c\7g\2\2\u009c\60\3\2\2\2\u009d\u00a1\t\2\2\2"+
		"\u009e\u00a0\t\3\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f"+
		"\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\62\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a8\7$\2\2\u00a5\u00a7\4\"\u0080\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00ac\7$\2\2\u00ac\64\3\2\2\2\u00ad\u00af\4\62;\2"+
		"\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\66\3\2\2\2\u00b2\u00b4\t\4\2\2\u00b3\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b8\b\34\2\2\u00b88\3\2\2\2\b\2\u008c\u00a1\u00a8\u00b0\u00b5"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}