// Generated from /Users/Sinan/Documents/NetBeansProjects/Software Construction/sinan/Software Construction/src/softwareconstruction/SinansGrammer.g by ANTLR 4.2

    package softwareconstruction;

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
		T__3=1, T__2=2, T__1=3, T__0=4, IDENTIFIER=5, STRING=6, LETTER=7, DIGIT=8, 
		WS=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "'{'", "':'", "'}'", "IDENTIFIER", "STRING", "LETTER", "DIGIT", 
		"WS"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "IDENTIFIER", "STRING", "LETTER", "DIGIT", 
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
		case 8: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13<\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\6\6#\n\6\r\6\16\6$\3\7\3"+
		"\7\3\7\3\7\6\7+\n\7\r\7\16\7,\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\6\n\67\n"+
		"\n\r\n\16\n8\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3"+
		"\2\4\4\2C\\c|\4\2\13\f\"\"A\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\3\25\3\2\2\2\5\32\3\2\2\2\7\34\3\2\2\2\t\36\3\2\2\2\13\"\3\2\2\2\r&\3"+
		"\2\2\2\17\61\3\2\2\2\21\63\3\2\2\2\23\66\3\2\2\2\25\26\7h\2\2\26\27\7"+
		"q\2\2\27\30\7t\2\2\30\31\7o\2\2\31\4\3\2\2\2\32\33\7}\2\2\33\6\3\2\2\2"+
		"\34\35\7<\2\2\35\b\3\2\2\2\36\37\7\177\2\2\37\n\3\2\2\2 #\5\17\b\2!#\5"+
		"\21\t\2\" \3\2\2\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\f\3\2\2"+
		"\2&*\7$\2\2\'+\5\17\b\2(+\5\21\t\2)+\7\"\2\2*\'\3\2\2\2*(\3\2\2\2*)\3"+
		"\2\2\2+,\3\2\2\2,*\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\7A\2\2/\60\7$\2\2\60"+
		"\16\3\2\2\2\61\62\t\2\2\2\62\20\3\2\2\2\63\64\4\62;\2\64\22\3\2\2\2\65"+
		"\67\t\3\2\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2"+
		":;\b\n\2\2;\24\3\2\2\2\b\2\"$*,8\3\3\n\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}