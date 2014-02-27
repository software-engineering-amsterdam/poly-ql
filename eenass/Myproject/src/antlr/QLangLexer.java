// Generated from QLang.g4 by ANTLR 4.1
package antlr;
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
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, WS=19, COMMENT=20, NewLine=21, Ident=22, Int=23, Str=24, 
		Bool=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "'+'", "'*'", "'-'", "'('", "'<'", "'!='", "'<='", "'&&'", "'||'", 
		"'>'", "'integer'", "'string'", "'=='", "'/'", "'>='", "'boolean'", "'!'", 
		"WS", "COMMENT", "NewLine", "Ident", "Int", "Str", "Bool"
	};
	public static final String[] ruleNames = {
		"T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", 
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "WS", "COMMENT", "NewLine", "Ident", "Int", "Str", "Bool"
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
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 18: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\33\u00bd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\24\6\24r\n\24\r\24\16\24s\3\24\3\24\3\25\3\25\3\25\3\25\7\25|\n\25"+
		"\f\25\16\25\177\13\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0087\n\25\f"+
		"\25\16\25\u008a\13\25\3\25\3\25\3\25\3\25\7\25\u0090\n\25\f\25\16\25\u0093"+
		"\13\25\5\25\u0095\n\25\3\26\5\26\u0098\n\26\3\26\3\26\5\26\u009c\n\26"+
		"\3\27\3\27\7\27\u00a0\n\27\f\27\16\27\u00a3\13\27\3\30\6\30\u00a6\n\30"+
		"\r\30\16\30\u00a7\3\31\3\31\7\31\u00ac\n\31\f\31\16\31\u00af\13\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00bc\n\32\6}"+
		"\u0088\u0091\u00ad\33\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n"+
		"\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%"+
		"\24\1\'\25\2)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\3\2\5\5\2\13\f\17"+
		"\17\"\"\4\2C\\c|\6\2\62;C\\aac|\u00c8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65"+
		"\3\2\2\2\5\67\3\2\2\2\79\3\2\2\2\t;\3\2\2\2\13=\3\2\2\2\r?\3\2\2\2\17"+
		"A\3\2\2\2\21D\3\2\2\2\23G\3\2\2\2\25J\3\2\2\2\27M\3\2\2\2\31O\3\2\2\2"+
		"\33W\3\2\2\2\35^\3\2\2\2\37a\3\2\2\2!c\3\2\2\2#f\3\2\2\2%n\3\2\2\2\'q"+
		"\3\2\2\2)\u0094\3\2\2\2+\u009b\3\2\2\2-\u009d\3\2\2\2/\u00a5\3\2\2\2\61"+
		"\u00a9\3\2\2\2\63\u00bb\3\2\2\2\65\66\7+\2\2\66\4\3\2\2\2\678\7-\2\28"+
		"\6\3\2\2\29:\7,\2\2:\b\3\2\2\2;<\7/\2\2<\n\3\2\2\2=>\7*\2\2>\f\3\2\2\2"+
		"?@\7>\2\2@\16\3\2\2\2AB\7#\2\2BC\7?\2\2C\20\3\2\2\2DE\7>\2\2EF\7?\2\2"+
		"F\22\3\2\2\2GH\7(\2\2HI\7(\2\2I\24\3\2\2\2JK\7~\2\2KL\7~\2\2L\26\3\2\2"+
		"\2MN\7@\2\2N\30\3\2\2\2OP\7k\2\2PQ\7p\2\2QR\7v\2\2RS\7g\2\2ST\7i\2\2T"+
		"U\7g\2\2UV\7t\2\2V\32\3\2\2\2WX\7u\2\2XY\7v\2\2YZ\7t\2\2Z[\7k\2\2[\\\7"+
		"p\2\2\\]\7i\2\2]\34\3\2\2\2^_\7?\2\2_`\7?\2\2`\36\3\2\2\2ab\7\61\2\2b"+
		" \3\2\2\2cd\7@\2\2de\7?\2\2e\"\3\2\2\2fg\7d\2\2gh\7q\2\2hi\7q\2\2ij\7"+
		"n\2\2jk\7g\2\2kl\7c\2\2lm\7p\2\2m$\3\2\2\2no\7#\2\2o&\3\2\2\2pr\t\2\2"+
		"\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\b\24\2\2v(\3\2"+
		"\2\2wx\7\61\2\2xy\7,\2\2y}\3\2\2\2z|\13\2\2\2{z\3\2\2\2|\177\3\2\2\2}"+
		"~\3\2\2\2}{\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7,\2\2\u0081"+
		"\u0095\7\61\2\2\u0082\u0083\7\61\2\2\u0083\u0084\7\61\2\2\u0084\u0088"+
		"\3\2\2\2\u0085\u0087\13\2\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2"+
		"\u0088\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u0095\3\2\2\2\u008a\u0088"+
		"\3\2\2\2\u008b\u008c\7\61\2\2\u008c\u008d\7\61\2\2\u008d\u0091\3\2\2\2"+
		"\u008e\u0090\5+\26\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0094"+
		"w\3\2\2\2\u0094\u0082\3\2\2\2\u0094\u008b\3\2\2\2\u0095*\3\2\2\2\u0096"+
		"\u0098\7\17\2\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3"+
		"\2\2\2\u0099\u009c\7\f\2\2\u009a\u009c\7\f\2\2\u009b\u0097\3\2\2\2\u009b"+
		"\u009a\3\2\2\2\u009c,\3\2\2\2\u009d\u00a1\t\3\2\2\u009e\u00a0\t\4\2\2"+
		"\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2.\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a6\4\62;\2\u00a5"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\60\3\2\2\2\u00a9\u00ad\7$\2\2\u00aa\u00ac\13\2\2\2\u00ab\u00aa"+
		"\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae"+
		"\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7$\2\2\u00b1\62\3\2\2\2"+
		"\u00b2\u00b3\7v\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7w\2\2\u00b5\u00bc"+
		"\7g\2\2\u00b6\u00b7\7h\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9\7n\2\2\u00b9"+
		"\u00ba\7u\2\2\u00ba\u00bc\7g\2\2\u00bb\u00b2\3\2\2\2\u00bb\u00b6\3\2\2"+
		"\2\u00bc\64\3\2\2\2\16\2s}\u0088\u0091\u0094\u0097\u009b\u00a1\u00a7\u00ad"+
		"\u00bb";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}