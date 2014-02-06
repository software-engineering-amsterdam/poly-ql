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
		MONEY=9, BOOL=10, INT=11, WS=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "'{'", "'}'", "FULLQUESTION", "NAME", "QUESTION", "ID", "TYPE", 
		"MONEY", "BOOL", "INT", "WS"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "FULLQUESTION", "NAME", "QUESTION", "ID", "TYPE", 
		"MONEY", "BOOL", "INT", "WS"
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
		case 11: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\16O\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\6\6*\n\6\r\6\16\6+\3\7\6\7/\n\7\r\7\16\7\60\3\b\6\b\64\n\b\r\b"+
		"\16\b\65\3\t\3\t\3\t\5\t;\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\6\fE\n"+
		"\f\r\f\16\fF\3\r\6\rJ\n\r\r\r\16\rK\3\r\3\r\2\16\3\3\1\5\4\1\7\5\1\t\6"+
		"\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\2\3\2\6\3\2"+
		"c|\b\2\"\"cdggnnpqwx\3\2\62;\4\2\13\f\"\"U\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5"+
		" \3\2\2\2\7\"\3\2\2\2\t$\3\2\2\2\13)\3\2\2\2\r.\3\2\2\2\17\63\3\2\2\2"+
		"\21:\3\2\2\2\23<\3\2\2\2\25A\3\2\2\2\27D\3\2\2\2\31I\3\2\2\2\33\34\7h"+
		"\2\2\34\35\7q\2\2\35\36\7t\2\2\36\37\7o\2\2\37\4\3\2\2\2 !\7}\2\2!\6\3"+
		"\2\2\2\"#\7\177\2\2#\b\3\2\2\2$%\5\r\7\2%&\5\17\b\2&\'\5\21\t\2\'\n\3"+
		"\2\2\2(*\t\2\2\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\f\3\2\2\2-/"+
		"\t\2\2\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\16\3\2\2\2"+
		"\62\64\t\2\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2"+
		"\66\20\3\2\2\2\67;\5\25\13\28;\5\27\f\29;\5\23\n\2:\67\3\2\2\2:8\3\2\2"+
		"\2:9\3\2\2\2;\22\3\2\2\2<=\5\27\f\2=>\7.\2\2>?\5\27\f\2?@\5\27\f\2@\24"+
		"\3\2\2\2AB\t\3\2\2B\26\3\2\2\2CE\t\4\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2"+
		"FG\3\2\2\2G\30\3\2\2\2HJ\t\5\2\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2"+
		"\2LM\3\2\2\2MN\b\r\2\2N\32\3\2\2\2\t\2+\60\65:FK";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}