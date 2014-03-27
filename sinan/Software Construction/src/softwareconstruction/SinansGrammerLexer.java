// Generated from /Users/Sinan/Documents/NetBeansProjects/Software Construction/sinan/Software Construction/src/softwareconstruction/SinansGrammer.g by ANTLR 4.2

    package softwareconstruction;
    import softwareconstruction.*;
    import softwareconstruction.form.*;
    import softwareconstruction.questions.*;
    import softwareconstruction.literals.*;
    import softwareconstruction.operators.*;
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
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		BOOL=10, TYPE=11, INT=12, IDENTIFIER=13, STRING=14, LETTER=15, DIGIT=16, 
		OPERATOR=17, WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "'{'", "')'", "'+'", "':'", "'('", "'if'", "'}'", "'!'", "BOOL", 
		"TYPE", "INT", "IDENTIFIER", "STRING", "LETTER", "DIGIT", "OPERATOR", 
		"WS"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"BOOL", "TYPE", "INT", "IDENTIFIER", "STRING", "LETTER", "DIGIT", "OPERATOR", 
		"WS"
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
		case 17: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u008a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13G\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\fU\n\f\3\r\6\rX\n\r\r\r\16\rY\3\16\3\16\3\16\7\16_\n\16\f\16\16\16"+
		"b\13\16\3\17\3\17\3\17\3\17\6\17h\n\17\r\17\16\17i\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u0082\n\22\3\23\6\23\u0085\n\23\r\23\16\23\u0086"+
		"\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\3\2\6\5\2AAC\\c|\5\2,-//\61\61\4\2>"+
		">@@\4\2\13\f\"\"\u009b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5,\3\2\2\2\7.\3\2\2"+
		"\2\t\60\3\2\2\2\13\62\3\2\2\2\r\64\3\2\2\2\17\66\3\2\2\2\219\3\2\2\2\23"+
		";\3\2\2\2\25F\3\2\2\2\27T\3\2\2\2\31W\3\2\2\2\33[\3\2\2\2\35c\3\2\2\2"+
		"\37m\3\2\2\2!o\3\2\2\2#\u0081\3\2\2\2%\u0084\3\2\2\2\'(\7h\2\2()\7q\2"+
		"\2)*\7t\2\2*+\7o\2\2+\4\3\2\2\2,-\7}\2\2-\6\3\2\2\2./\7+\2\2/\b\3\2\2"+
		"\2\60\61\7-\2\2\61\n\3\2\2\2\62\63\7<\2\2\63\f\3\2\2\2\64\65\7*\2\2\65"+
		"\16\3\2\2\2\66\67\7k\2\2\678\7h\2\28\20\3\2\2\29:\7\177\2\2:\22\3\2\2"+
		"\2;<\7#\2\2<\24\3\2\2\2=>\7v\2\2>?\7t\2\2?@\7w\2\2@G\7g\2\2AB\7h\2\2B"+
		"C\7c\2\2CD\7n\2\2DE\7u\2\2EG\7g\2\2F=\3\2\2\2FA\3\2\2\2G\26\3\2\2\2HI"+
		"\7d\2\2IJ\7q\2\2JK\7q\2\2KL\7n\2\2LM\7g\2\2MN\7c\2\2NU\7p\2\2OP\7o\2\2"+
		"PQ\7q\2\2QR\7p\2\2RS\7g\2\2SU\7{\2\2TH\3\2\2\2TO\3\2\2\2U\30\3\2\2\2V"+
		"X\4\62;\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\32\3\2\2\2[`\5\37\20"+
		"\2\\_\5\37\20\2]_\5!\21\2^\\\3\2\2\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3"+
		"\2\2\2a\34\3\2\2\2b`\3\2\2\2cg\7$\2\2dh\5\37\20\2eh\5!\21\2fh\7\"\2\2"+
		"gd\3\2\2\2ge\3\2\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jk\3\2\2\2"+
		"kl\7$\2\2l\36\3\2\2\2mn\t\2\2\2n \3\2\2\2op\4\62;\2p\"\3\2\2\2q\u0082"+
		"\t\3\2\2rs\7~\2\2s\u0082\7~\2\2t\u0082\7~\2\2uv\7(\2\2v\u0082\7(\2\2w"+
		"x\7?\2\2x\u0082\7?\2\2yz\7#\2\2z\u0082\7?\2\2{\u0082\t\4\2\2|}\7@\2\2"+
		"}\u0082\7?\2\2~\177\7>\2\2\177\u0082\7?\2\2\u0080\u0082\7#\2\2\u0081q"+
		"\3\2\2\2\u0081r\3\2\2\2\u0081t\3\2\2\2\u0081u\3\2\2\2\u0081w\3\2\2\2\u0081"+
		"y\3\2\2\2\u0081{\3\2\2\2\u0081|\3\2\2\2\u0081~\3\2\2\2\u0081\u0080\3\2"+
		"\2\2\u0082$\3\2\2\2\u0083\u0085\t\5\2\2\u0084\u0083\3\2\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0089\b\23\2\2\u0089&\3\2\2\2\f\2FTY^`gi\u0081\u0086\3\3\23\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}