// Generated from QLang.g4 by ANTLR 4.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLangLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__12=1, T__11=2, T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, 
		T__3=10, T__2=11, T__1=12, T__0=13, WS=14, COMMENT=15, NewLine=16, Ident=17, 
		Int=18, Money=19, Str=20, Bool=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'||'", "'>'", "'+'", "'-'", "'*'", "'/'", "'<'", "'=='", "'>='", "'!='", 
		"'!'", "'<='", "'&&'", "WS", "COMMENT", "NewLine", "Ident", "Int", "Money", 
		"Str", "Bool"
	};
	public static final String[] ruleNames = {
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "WS", "COMMENT", "NewLine", "Ident", "Int", 
		"Money", "Str", "Bool"
	};


	public QLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QLang.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\27\u0097\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\7\20T\n\20\f\20\16\20W\13\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20_\n\20"+
		"\f\20\16\20b\13\20\3\20\3\20\3\20\3\20\7\20h\n\20\f\20\16\20k\13\20\5"+
		"\20m\n\20\3\21\3\21\3\21\5\21r\n\21\3\22\3\22\7\22v\n\22\f\22\16\22y\13"+
		"\22\3\23\6\23|\n\23\r\23\16\23}\3\24\3\24\3\24\3\24\3\25\3\25\7\25\u0086"+
		"\n\25\f\25\16\25\u0089\13\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\5\26\u0096\n\26\6U`i\u0087\2\27\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27\3\2\5\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\u00a0\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\60\3\2\2\2\7\62\3"+
		"\2\2\2\t\64\3\2\2\2\13\66\3\2\2\2\r8\3\2\2\2\17:\3\2\2\2\21<\3\2\2\2\23"+
		"?\3\2\2\2\25B\3\2\2\2\27E\3\2\2\2\31G\3\2\2\2\33J\3\2\2\2\35M\3\2\2\2"+
		"\37l\3\2\2\2!q\3\2\2\2#s\3\2\2\2%{\3\2\2\2\'\177\3\2\2\2)\u0083\3\2\2"+
		"\2+\u0095\3\2\2\2-.\7~\2\2./\7~\2\2/\4\3\2\2\2\60\61\7@\2\2\61\6\3\2\2"+
		"\2\62\63\7-\2\2\63\b\3\2\2\2\64\65\7/\2\2\65\n\3\2\2\2\66\67\7,\2\2\67"+
		"\f\3\2\2\289\7\61\2\29\16\3\2\2\2:;\7>\2\2;\20\3\2\2\2<=\7?\2\2=>\7?\2"+
		"\2>\22\3\2\2\2?@\7@\2\2@A\7?\2\2A\24\3\2\2\2BC\7#\2\2CD\7?\2\2D\26\3\2"+
		"\2\2EF\7#\2\2F\30\3\2\2\2GH\7>\2\2HI\7?\2\2I\32\3\2\2\2JK\7(\2\2KL\7("+
		"\2\2L\34\3\2\2\2MN\t\2\2\2N\36\3\2\2\2OP\7\61\2\2PQ\7,\2\2QU\3\2\2\2R"+
		"T\13\2\2\2SR\3\2\2\2TW\3\2\2\2UV\3\2\2\2US\3\2\2\2VX\3\2\2\2WU\3\2\2\2"+
		"XY\7,\2\2Ym\7\61\2\2Z[\7\61\2\2[\\\7\61\2\2\\`\3\2\2\2]_\13\2\2\2^]\3"+
		"\2\2\2_b\3\2\2\2`a\3\2\2\2`^\3\2\2\2am\3\2\2\2b`\3\2\2\2cd\7\61\2\2de"+
		"\7\61\2\2ei\3\2\2\2fh\5!\21\2gf\3\2\2\2hk\3\2\2\2ij\3\2\2\2ig\3\2\2\2"+
		"jm\3\2\2\2ki\3\2\2\2lO\3\2\2\2lZ\3\2\2\2lc\3\2\2\2m \3\2\2\2nr\7\f\2\2"+
		"op\7\17\2\2pr\7\f\2\2qn\3\2\2\2qo\3\2\2\2r\"\3\2\2\2sw\t\3\2\2tv\t\4\2"+
		"\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x$\3\2\2\2yw\3\2\2\2z|\4\62"+
		";\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~&\3\2\2\2\177\u0080\5%\23"+
		"\2\u0080\u0081\7\60\2\2\u0081\u0082\5%\23\2\u0082(\3\2\2\2\u0083\u0087"+
		"\7$\2\2\u0084\u0086\13\2\2\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2"+
		"\2\2\u008a\u008b\7$\2\2\u008b*\3\2\2\2\u008c\u008d\7v\2\2\u008d\u008e"+
		"\7t\2\2\u008e\u008f\7w\2\2\u008f\u0096\7g\2\2\u0090\u0091\7h\2\2\u0091"+
		"\u0092\7c\2\2\u0092\u0093\7n\2\2\u0093\u0094\7u\2\2\u0094\u0096\7g\2\2"+
		"\u0095\u008c\3\2\2\2\u0095\u0090\3\2\2\2\u0096,\3\2\2\2\f\2U`ilqw}\u0087"+
		"\u0095\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}