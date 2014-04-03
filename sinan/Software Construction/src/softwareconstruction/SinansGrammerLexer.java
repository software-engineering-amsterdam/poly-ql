// Generated from /Users/Sinan/Documents/NetBeansProjects/Software Construction/sinan/Software Construction/src/softwareconstruction/SinansGrammer.g by ANTLR 4.2

    package softwareconstruction;
    import softwareconstruction.*;
    import softwareconstruction.form.*;
    import softwareconstruction.questions.*;
    import softwareconstruction.literals.*;
    import softwareconstruction.operators.*;
    import softwareconstruction.types.*;
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
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, BOOL=12, INT=13, IDENTIFIER=14, STRING=15, LETTER=16, 
		DIGIT=17, OPERATOR=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "'{'", "')'", "'+'", "':'", "'('", "'string'", "'if'", "'int'", 
		"'}'", "'boolean'", "BOOL", "INT", "IDENTIFIER", "STRING", "LETTER", "DIGIT", 
		"OPERATOR", "WS"
	};
	public static final String[] ruleNames = {
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "BOOL", "INT", "IDENTIFIER", "STRING", "LETTER", "DIGIT", 
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
		case 18: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u008f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\rZ\n\r\3\16\6\16]\n\16\r\16\16\16^\3\17\3\17\3\17\7\17d\n"+
		"\17\f\17\16\17g\13\17\3\20\3\20\3\20\3\20\6\20m\n\20\r\20\16\20n\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0087\n\23\3\24\6\24\u008a\n"+
		"\24\r\24\16\24\u008b\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\6\5\2"+
		"AAC\\c|\5\2,-//\61\61\4\2>>@@\4\2\13\f\"\"\u009f\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\3)\3\2\2\2\5.\3\2\2\2\7\60\3\2\2\2\t\62\3\2\2\2\13\64\3\2\2\2\r"+
		"\66\3\2\2\2\178\3\2\2\2\21?\3\2\2\2\23B\3\2\2\2\25F\3\2\2\2\27H\3\2\2"+
		"\2\31Y\3\2\2\2\33\\\3\2\2\2\35`\3\2\2\2\37h\3\2\2\2!r\3\2\2\2#t\3\2\2"+
		"\2%\u0086\3\2\2\2\'\u0089\3\2\2\2)*\7h\2\2*+\7q\2\2+,\7t\2\2,-\7o\2\2"+
		"-\4\3\2\2\2./\7}\2\2/\6\3\2\2\2\60\61\7+\2\2\61\b\3\2\2\2\62\63\7-\2\2"+
		"\63\n\3\2\2\2\64\65\7<\2\2\65\f\3\2\2\2\66\67\7*\2\2\67\16\3\2\2\289\7"+
		"u\2\29:\7v\2\2:;\7t\2\2;<\7k\2\2<=\7p\2\2=>\7i\2\2>\20\3\2\2\2?@\7k\2"+
		"\2@A\7h\2\2A\22\3\2\2\2BC\7k\2\2CD\7p\2\2DE\7v\2\2E\24\3\2\2\2FG\7\177"+
		"\2\2G\26\3\2\2\2HI\7d\2\2IJ\7q\2\2JK\7q\2\2KL\7n\2\2LM\7g\2\2MN\7c\2\2"+
		"NO\7p\2\2O\30\3\2\2\2PQ\7v\2\2QR\7t\2\2RS\7w\2\2SZ\7g\2\2TU\7h\2\2UV\7"+
		"c\2\2VW\7n\2\2WX\7u\2\2XZ\7g\2\2YP\3\2\2\2YT\3\2\2\2Z\32\3\2\2\2[]\4\62"+
		";\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\34\3\2\2\2`e\5!\21\2ad"+
		"\5!\21\2bd\5#\22\2ca\3\2\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f"+
		"\36\3\2\2\2ge\3\2\2\2hl\7$\2\2im\5!\21\2jm\5#\22\2km\7\"\2\2li\3\2\2\2"+
		"lj\3\2\2\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7$\2\2"+
		"q \3\2\2\2rs\t\2\2\2s\"\3\2\2\2tu\4\62;\2u$\3\2\2\2v\u0087\t\3\2\2wx\7"+
		"~\2\2x\u0087\7~\2\2y\u0087\7~\2\2z{\7(\2\2{\u0087\7(\2\2|}\7?\2\2}\u0087"+
		"\7?\2\2~\177\7#\2\2\177\u0087\7?\2\2\u0080\u0087\t\4\2\2\u0081\u0082\7"+
		"@\2\2\u0082\u0087\7?\2\2\u0083\u0084\7>\2\2\u0084\u0087\7?\2\2\u0085\u0087"+
		"\7#\2\2\u0086v\3\2\2\2\u0086w\3\2\2\2\u0086y\3\2\2\2\u0086z\3\2\2\2\u0086"+
		"|\3\2\2\2\u0086~\3\2\2\2\u0086\u0080\3\2\2\2\u0086\u0081\3\2\2\2\u0086"+
		"\u0083\3\2\2\2\u0086\u0085\3\2\2\2\u0087&\3\2\2\2\u0088\u008a\t\5\2\2"+
		"\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\b\24\2\2\u008e(\3\2\2\2\13\2"+
		"Y^celn\u0086\u008b\3\3\24\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}