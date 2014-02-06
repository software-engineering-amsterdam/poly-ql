// Generated from Newql.g4 by ANTLR 4.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NewqlLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, FULLQUESTION=4, NAME=5, QUESTION=6, ID=7, TYPE=8, 
		MONEY=9, BOOL=10, INT=11, STRING=12, WS=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'{'", "'form '", "'}'", "FULLQUESTION", "NAME", "QUESTION", "ID", "TYPE", 
		"MONEY", "BOOL", "INT", "STRING", "WS"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "FULLQUESTION", "NAME", "QUESTION", "ID", "TYPE", 
		"MONEY", "BOOL", "INT", "STRING", "WS"
	};


	public NewqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Newql.g4"; }

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
		case 12: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\17y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\6\6\6-\n\6\r\6\16\6.\3\6\6\6\62\n\6\r\6\16\6\63\3\7"+
		"\6\7\67\n\7\r\7\16\78\3\b\6\b<\n\b\r\b\16\b=\3\b\7\bA\n\b\f\b\16\bD\13"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\tZ\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13j\n\13\3\f\6\fm\n\f\r\f\16\fn\3\r\3\r\3\16\6\16t\n"+
		"\16\r\16\16\16u\3\16\3\16\2\17\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17"+
		"\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\2\3\2\b\3\2C\\\4\2C\\"+
		"c|\3\2c|\3\2\62;\13\2\"#*+..\60\60\62=AAC\\^^c|\5\2\13\f\17\17\"\"\u0082"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7%\3\2\2\2\t\'\3"+
		"\2\2\2\13,\3\2\2\2\r\66\3\2\2\2\17;\3\2\2\2\21Y\3\2\2\2\23[\3\2\2\2\25"+
		"i\3\2\2\2\27l\3\2\2\2\31p\3\2\2\2\33s\3\2\2\2\35\36\7}\2\2\36\4\3\2\2"+
		"\2\37 \7h\2\2 !\7q\2\2!\"\7t\2\2\"#\7o\2\2#$\7\"\2\2$\6\3\2\2\2%&\7\177"+
		"\2\2&\b\3\2\2\2\'(\5\r\7\2()\5\17\b\2)*\5\21\t\2*\n\3\2\2\2+-\t\2\2\2"+
		",+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60\62\t\3\2\2\61"+
		"\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\f\3\2\2\2\65"+
		"\67\5\31\r\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29\16\3\2\2"+
		"\2:<\t\4\2\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>B\3\2\2\2?A\t\3\2"+
		"\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\7<\2"+
		"\2F\20\3\2\2\2GH\7d\2\2HI\7q\2\2IJ\7q\2\2JK\7n\2\2KL\7g\2\2LM\7c\2\2M"+
		"Z\7p\2\2NO\7o\2\2OP\7q\2\2PQ\7p\2\2QR\7g\2\2RZ\7{\2\2ST\7u\2\2TU\7v\2"+
		"\2UV\7t\2\2VW\7k\2\2WX\7p\2\2XZ\7i\2\2YG\3\2\2\2YN\3\2\2\2YS\3\2\2\2Z"+
		"\22\3\2\2\2[\\\5\27\f\2\\]\7.\2\2]^\5\27\f\2^_\5\27\f\2_\24\3\2\2\2`a"+
		"\7v\2\2ab\7t\2\2bc\7w\2\2cj\7g\2\2de\7h\2\2ef\7c\2\2fg\7n\2\2gh\7u\2\2"+
		"hj\7g\2\2i`\3\2\2\2id\3\2\2\2j\26\3\2\2\2km\t\5\2\2lk\3\2\2\2mn\3\2\2"+
		"\2nl\3\2\2\2no\3\2\2\2o\30\3\2\2\2pq\t\6\2\2q\32\3\2\2\2rt\t\7\2\2sr\3"+
		"\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\b\16\2\2x\34\3\2\2\2"+
		"\f\2.\638=BYinu";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}