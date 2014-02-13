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
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, IDENTIFIER=7, LETTER=8, 
		DIGIT=9, WS=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "'{'", "':'", "'}'", "'\"'", "'?'", "IDENTIFIER", "LETTER", 
		"DIGIT", "WS"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "IDENTIFIER", "LETTER", 
		"DIGIT", "WS"
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
		case 9: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\f\67\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\6\b)\n\b\r\b\16\b*\3\t\3\t\3\n\3\n\3\13\6\13\62\n\13\r\13\16\13\63"+
		"\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\3\2\4\4"+
		"\2C\\c|\4\2\13\f\"\"9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\3\27\3\2\2\2\5\34\3\2\2\2\7\36\3\2\2\2\t \3\2\2\2\13\"\3\2\2"+
		"\2\r$\3\2\2\2\17(\3\2\2\2\21,\3\2\2\2\23.\3\2\2\2\25\61\3\2\2\2\27\30"+
		"\7h\2\2\30\31\7q\2\2\31\32\7t\2\2\32\33\7o\2\2\33\4\3\2\2\2\34\35\7}\2"+
		"\2\35\6\3\2\2\2\36\37\7<\2\2\37\b\3\2\2\2 !\7\177\2\2!\n\3\2\2\2\"#\7"+
		"$\2\2#\f\3\2\2\2$%\7A\2\2%\16\3\2\2\2&)\5\21\t\2\')\5\23\n\2(&\3\2\2\2"+
		"(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\20\3\2\2\2,-\t\2\2\2-\22\3"+
		"\2\2\2./\4\62;\2/\24\3\2\2\2\60\62\t\3\2\2\61\60\3\2\2\2\62\63\3\2\2\2"+
		"\63\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\b\13\2\2\66\26\3\2\2"+
		"\2\6\2(*\63\3\3\13\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}