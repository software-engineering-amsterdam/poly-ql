// Generated from Questionnaire.g4 by ANTLR 4.1

    package nl.uva.polyql.antlr4;
    import nl.uva.polyql.ast.*;
    import nl.uva.polyql.ast.expressions.*;
    import nl.uva.polyql.ast.expressions.operations.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuestionnaireLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__21=1, T__20=2, T__19=3, T__18=4, T__17=5, T__16=6, T__15=7, T__14=8, 
		T__13=9, T__12=10, T__11=11, T__10=12, T__9=13, T__8=14, T__7=15, T__6=16, 
		T__5=17, T__4=18, T__3=19, T__2=20, T__1=21, T__0=22, COMMENT=23, TYPE=24, 
		BOOLEAN=25, ID=26, STRING=27, LETTER=28, NUMBER=29, DIGIT=30, WS=31, PUNCTUATION=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "')'", "'+'", "'-'", "'*'", "'('", "':'", "'if'", "'<'", "'!='", 
		"'<='", "'&&'", "'||'", "'{'", "'>'", "'=='", "'else'", "'/'", "'}'", 
		"'>='", "'|'", "'!'", "COMMENT", "TYPE", "BOOLEAN", "ID", "STRING", "LETTER", 
		"NUMBER", "DIGIT", "WS", "PUNCTUATION"
	};
	public static final String[] ruleNames = {
		"T__21", "T__20", "T__19", "T__18", "T__17", "T__16", "T__15", "T__14", 
		"T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", 
		"T__4", "T__3", "T__2", "T__1", "T__0", "COMMENT", "TYPE", "BOOLEAN", 
		"ID", "STRING", "LETTER", "NUMBER", "DIGIT", "WS", "PUNCTUATION"
	};


	public QuestionnaireLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Questionnaire.g4"; }

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
		case 30: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\"\u00d5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\7\30\u0081\n\30\f\30\16\30\u0084\13\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u0099\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00a4\n"+
		"\32\3\33\3\33\3\33\7\33\u00a9\n\33\f\33\16\33\u00ac\13\33\3\34\3\34\3"+
		"\34\3\34\7\34\u00b2\n\34\f\34\16\34\u00b5\13\34\3\34\3\34\3\35\3\35\3"+
		"\36\5\36\u00bc\n\36\3\36\6\36\u00bf\n\36\r\36\16\36\u00c0\3\36\3\36\6"+
		"\36\u00c5\n\36\r\36\16\36\u00c6\5\36\u00c9\n\36\3\37\3\37\3 \6 \u00ce"+
		"\n \r \16 \u00cf\3 \3 \3!\3!\2\"\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1"+
		"\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!"+
		"\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34"+
		"\1\67\35\19\36\1;\37\1= \1?!\2A\"\1\3\2\6\4\2\f\f\17\17\4\2C\\c|\5\2\13"+
		"\f\17\17\"\"\b\2\"#)+..\60\60<=AA\u00e2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\3C\3\2\2\2\5H\3\2\2\2\7J\3\2\2\2\tL\3\2\2\2\13N\3\2\2\2\rP\3"+
		"\2\2\2\17R\3\2\2\2\21T\3\2\2\2\23W\3\2\2\2\25Y\3\2\2\2\27\\\3\2\2\2\31"+
		"_\3\2\2\2\33b\3\2\2\2\35e\3\2\2\2\37g\3\2\2\2!i\3\2\2\2#l\3\2\2\2%q\3"+
		"\2\2\2\'s\3\2\2\2)u\3\2\2\2+x\3\2\2\2-z\3\2\2\2/|\3\2\2\2\61\u0098\3\2"+
		"\2\2\63\u00a3\3\2\2\2\65\u00a5\3\2\2\2\67\u00ad\3\2\2\29\u00b8\3\2\2\2"+
		";\u00bb\3\2\2\2=\u00ca\3\2\2\2?\u00cd\3\2\2\2A\u00d3\3\2\2\2CD\7h\2\2"+
		"DE\7q\2\2EF\7t\2\2FG\7o\2\2G\4\3\2\2\2HI\7+\2\2I\6\3\2\2\2JK\7-\2\2K\b"+
		"\3\2\2\2LM\7/\2\2M\n\3\2\2\2NO\7,\2\2O\f\3\2\2\2PQ\7*\2\2Q\16\3\2\2\2"+
		"RS\7<\2\2S\20\3\2\2\2TU\7k\2\2UV\7h\2\2V\22\3\2\2\2WX\7>\2\2X\24\3\2\2"+
		"\2YZ\7#\2\2Z[\7?\2\2[\26\3\2\2\2\\]\7>\2\2]^\7?\2\2^\30\3\2\2\2_`\7(\2"+
		"\2`a\7(\2\2a\32\3\2\2\2bc\7~\2\2cd\7~\2\2d\34\3\2\2\2ef\7}\2\2f\36\3\2"+
		"\2\2gh\7@\2\2h \3\2\2\2ij\7?\2\2jk\7?\2\2k\"\3\2\2\2lm\7g\2\2mn\7n\2\2"+
		"no\7u\2\2op\7g\2\2p$\3\2\2\2qr\7\61\2\2r&\3\2\2\2st\7\177\2\2t(\3\2\2"+
		"\2uv\7@\2\2vw\7?\2\2w*\3\2\2\2xy\7~\2\2y,\3\2\2\2z{\7#\2\2{.\3\2\2\2|"+
		"}\7\61\2\2}~\7\61\2\2~\u0082\3\2\2\2\177\u0081\n\2\2\2\u0080\177\3\2\2"+
		"\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\60"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7d\2\2\u0086\u0087\7q\2\2\u0087"+
		"\u0088\7q\2\2\u0088\u0089\7n\2\2\u0089\u008a\7g\2\2\u008a\u008b\7c\2\2"+
		"\u008b\u0099\7p\2\2\u008c\u008d\7p\2\2\u008d\u008e\7w\2\2\u008e\u008f"+
		"\7o\2\2\u008f\u0090\7d\2\2\u0090\u0091\7g\2\2\u0091\u0099\7t\2\2\u0092"+
		"\u0093\7u\2\2\u0093\u0094\7v\2\2\u0094\u0095\7t\2\2\u0095\u0096\7k\2\2"+
		"\u0096\u0097\7p\2\2\u0097\u0099\7i\2\2\u0098\u0085\3\2\2\2\u0098\u008c"+
		"\3\2\2\2\u0098\u0092\3\2\2\2\u0099\62\3\2\2\2\u009a\u009b\7v\2\2\u009b"+
		"\u009c\7t\2\2\u009c\u009d\7w\2\2\u009d\u00a4\7g\2\2\u009e\u009f\7h\2\2"+
		"\u009f\u00a0\7c\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a4"+
		"\7g\2\2\u00a3\u009a\3\2\2\2\u00a3\u009e\3\2\2\2\u00a4\64\3\2\2\2\u00a5"+
		"\u00aa\59\35\2\u00a6\u00a9\59\35\2\u00a7\u00a9\5=\37\2\u00a8\u00a6\3\2"+
		"\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\66\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00b3\7$\2\2"+
		"\u00ae\u00b2\59\35\2\u00af\u00b2\5=\37\2\u00b0\u00b2\5A!\2\u00b1\u00ae"+
		"\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b6\u00b7\7$\2\2\u00b78\3\2\2\2\u00b8\u00b9\t\3\2\2\u00b9:\3\2"+
		"\2\2\u00ba\u00bc\7/\2\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00be\3\2\2\2\u00bd\u00bf\5=\37\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c8\3\2\2\2\u00c2"+
		"\u00c4\7\60\2\2\u00c3\u00c5\5=\37\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3"+
		"\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8"+
		"\u00c2\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9<\3\2\2\2\u00ca\u00cb\4\62;\2"+
		"\u00cb>\3\2\2\2\u00cc\u00ce\t\4\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3"+
		"\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d2\b \2\2\u00d2@\3\2\2\2\u00d3\u00d4\t\5\2\2\u00d4B\3\2\2\2\17\2\u0082"+
		"\u0098\u00a3\u00a8\u00aa\u00b1\u00b3\u00bb\u00c0\u00c6\u00c8\u00cf";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}