// Generated from /Users/Sinan/Documents/NetBeansProjects/Software Construction/sinan/Software Construction/src/softwareconstruction/SinansGrammer.g by ANTLR 4.2

    package softwareconstruction;
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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, TYPE=8, IDENTIFIER=9, 
		STRING=10, LETTER=11, DIGIT=12, WS=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "'{'", "')'", "':'", "'('", "'if'", "'}'", "TYPE", "IDENTIFIER", 
		"STRING", "LETTER", "DIGIT", "WS"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "TYPE", "IDENTIFIER", 
		"STRING", "LETTER", "DIGIT", "WS"
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
		case 12: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17X\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\t<\n\t\3\n\3\n\6\n@\n\n\r\n\16\nA\3\13\3\13\3\13\3\13\6\13"+
		"H\n\13\r\13\16\13I\3\13\3\13\3\f\3\f\3\r\3\r\3\16\6\16S\n\16\r\16\16\16"+
		"T\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\3\2\4\5\2AAC\\c|\4\2\13\f\"\"^\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\3\35\3\2\2\2\5\"\3\2\2\2\7$\3\2\2\2\t&\3\2\2\2\13(\3\2\2\2\r*\3\2\2\2"+
		"\17-\3\2\2\2\21;\3\2\2\2\23?\3\2\2\2\25C\3\2\2\2\27M\3\2\2\2\31O\3\2\2"+
		"\2\33R\3\2\2\2\35\36\7h\2\2\36\37\7q\2\2\37 \7t\2\2 !\7o\2\2!\4\3\2\2"+
		"\2\"#\7}\2\2#\6\3\2\2\2$%\7+\2\2%\b\3\2\2\2&\'\7<\2\2\'\n\3\2\2\2()\7"+
		"*\2\2)\f\3\2\2\2*+\7k\2\2+,\7h\2\2,\16\3\2\2\2-.\7\177\2\2.\20\3\2\2\2"+
		"/\60\7d\2\2\60\61\7q\2\2\61\62\7q\2\2\62\63\7n\2\2\63\64\7g\2\2\64\65"+
		"\7c\2\2\65<\7p\2\2\66\67\7o\2\2\678\7q\2\289\7p\2\29:\7g\2\2:<\7{\2\2"+
		";/\3\2\2\2;\66\3\2\2\2<\22\3\2\2\2=@\5\27\f\2>@\5\31\r\2?=\3\2\2\2?>\3"+
		"\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\24\3\2\2\2CG\7$\2\2DH\5\27\f\2E"+
		"H\5\31\r\2FH\7\"\2\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2"+
		"IJ\3\2\2\2JK\3\2\2\2KL\7$\2\2L\26\3\2\2\2MN\t\2\2\2N\30\3\2\2\2OP\4\62"+
		";\2P\32\3\2\2\2QS\t\3\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3"+
		"\2\2\2VW\b\16\2\2W\34\3\2\2\2\t\2;?AGIT\3\3\16\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}