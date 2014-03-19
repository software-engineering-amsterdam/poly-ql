// Generated from /Users/Sinan/Documents/NetBeansProjects/Software Construction/sinan/Software Construction/src/softwareconstruction/SinansGrammer.g by ANTLR 4.2

    package softwareconstruction;
    import softwareconstruction.*;
    import softwareconstruction.form.*;
    import softwareconstruction.questions.*;
    import softwareconstruction.literals.*;
    import java.util.ArrayList;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SinansGrammerLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, TYPE=20, IDENTIFIER=21, STRING=22, LETTER=23, 
		DIGIT=24, BOOL=25, OPERATOR=26, WS=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "')'", "'+'", "'-'", "'*'", "'('", "':'", "'if'", "'<'", "'<='", 
		"'&&'", "'||'", "'{'", "'>'", "'/'", "'=='", "'}'", "'>='", "'!'", "TYPE", 
		"IDENTIFIER", "STRING", "LETTER", "DIGIT", "BOOL", "OPERATOR", "WS"
	};
	public static final String[] ruleNames = {
		"T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", 
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "TYPE", "IDENTIFIER", "STRING", "LETTER", "DIGIT", "BOOL", 
		"OPERATOR", "WS"
	};


	public SinansGrammerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SinansGrammer.g"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 26: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u00b0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25u\n\25\3\26\3\26\3\26\7\26z\n\26\f\26\16"+
		"\26}\13\26\3\27\3\27\3\27\3\27\6\27\u0083\n\27\r\27\16\27\u0084\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5"+
		"\32\u0096\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\5\33\u00a8\n\33\3\34\6\34\u00ab\n\34\r\34\16"+
		"\34\u00ac\3\34\3\34\2\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\35\3\2\6\5\2AAC\\c|\5\2,-//\61\61\4\2>>@@\4\2\13\f\"\""+
		"\u00c0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2"+
		"\2\5>\3\2\2\2\7@\3\2\2\2\tB\3\2\2\2\13D\3\2\2\2\rF\3\2\2\2\17H\3\2\2\2"+
		"\21J\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27R\3\2\2\2\31U\3\2\2\2\33X\3\2\2"+
		"\2\35Z\3\2\2\2\37\\\3\2\2\2!^\3\2\2\2#a\3\2\2\2%c\3\2\2\2\'f\3\2\2\2)"+
		"t\3\2\2\2+v\3\2\2\2-~\3\2\2\2/\u0088\3\2\2\2\61\u008a\3\2\2\2\63\u0095"+
		"\3\2\2\2\65\u00a7\3\2\2\2\67\u00aa\3\2\2\29:\7h\2\2:;\7q\2\2;<\7t\2\2"+
		"<=\7o\2\2=\4\3\2\2\2>?\7+\2\2?\6\3\2\2\2@A\7-\2\2A\b\3\2\2\2BC\7/\2\2"+
		"C\n\3\2\2\2DE\7,\2\2E\f\3\2\2\2FG\7*\2\2G\16\3\2\2\2HI\7<\2\2I\20\3\2"+
		"\2\2JK\7k\2\2KL\7h\2\2L\22\3\2\2\2MN\7>\2\2N\24\3\2\2\2OP\7>\2\2PQ\7?"+
		"\2\2Q\26\3\2\2\2RS\7(\2\2ST\7(\2\2T\30\3\2\2\2UV\7~\2\2VW\7~\2\2W\32\3"+
		"\2\2\2XY\7}\2\2Y\34\3\2\2\2Z[\7@\2\2[\36\3\2\2\2\\]\7\61\2\2] \3\2\2\2"+
		"^_\7?\2\2_`\7?\2\2`\"\3\2\2\2ab\7\177\2\2b$\3\2\2\2cd\7@\2\2de\7?\2\2"+
		"e&\3\2\2\2fg\7#\2\2g(\3\2\2\2hi\7d\2\2ij\7q\2\2jk\7q\2\2kl\7n\2\2lm\7"+
		"g\2\2mn\7c\2\2nu\7p\2\2op\7o\2\2pq\7q\2\2qr\7p\2\2rs\7g\2\2su\7{\2\2t"+
		"h\3\2\2\2to\3\2\2\2u*\3\2\2\2v{\5/\30\2wz\5/\30\2xz\5\61\31\2yw\3\2\2"+
		"\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|,\3\2\2\2}{\3\2\2\2~\u0082"+
		"\7$\2\2\177\u0083\5/\30\2\u0080\u0083\5\61\31\2\u0081\u0083\7\"\2\2\u0082"+
		"\177\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2"+
		"\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087"+
		"\7$\2\2\u0087.\3\2\2\2\u0088\u0089\t\2\2\2\u0089\60\3\2\2\2\u008a\u008b"+
		"\4\62;\2\u008b\62\3\2\2\2\u008c\u008d\7v\2\2\u008d\u008e\7t\2\2\u008e"+
		"\u008f\7w\2\2\u008f\u0096\7g\2\2\u0090\u0091\7h\2\2\u0091\u0092\7c\2\2"+
		"\u0092\u0093\7n\2\2\u0093\u0094\7u\2\2\u0094\u0096\7g\2\2\u0095\u008c"+
		"\3\2\2\2\u0095\u0090\3\2\2\2\u0096\64\3\2\2\2\u0097\u00a8\t\3\2\2\u0098"+
		"\u0099\7~\2\2\u0099\u00a8\7~\2\2\u009a\u00a8\7~\2\2\u009b\u009c\7(\2\2"+
		"\u009c\u00a8\7(\2\2\u009d\u009e\7?\2\2\u009e\u00a8\7?\2\2\u009f\u00a0"+
		"\7#\2\2\u00a0\u00a8\7?\2\2\u00a1\u00a8\t\4\2\2\u00a2\u00a3\7@\2\2\u00a3"+
		"\u00a8\7?\2\2\u00a4\u00a5\7>\2\2\u00a5\u00a8\7?\2\2\u00a6\u00a8\7#\2\2"+
		"\u00a7\u0097\3\2\2\2\u00a7\u0098\3\2\2\2\u00a7\u009a\3\2\2\2\u00a7\u009b"+
		"\3\2\2\2\u00a7\u009d\3\2\2\2\u00a7\u009f\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a7"+
		"\u00a2\3\2\2\2\u00a7\u00a4\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\66\3\2\2"+
		"\2\u00a9\u00ab\t\5\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\b\34\2\2"+
		"\u00af8\3\2\2\2\13\2ty{\u0082\u0084\u0095\u00a7\u00ac\3\3\34\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}