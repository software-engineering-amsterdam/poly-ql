// Generated from QLang.g4 by ANTLR 4.1
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
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, WS=16, COMMENT=17, 
		NewLine=18, Ident=19, Int=20, Str=21, Bool=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'||'", "'>'", "')'", "'+'", "'-'", "'*'", "'('", "'/'", "'<'", "'=='", 
		"'>='", "'!='", "'!'", "'<='", "'&&'", "WS", "COMMENT", "NewLine", "Ident", 
		"Int", "Str", "Bool"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "WS", "COMMENT", "NewLine", 
		"Ident", "Int", "Str", "Bool"
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\30\u0099\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\22\3\22\7\22Z\n\22\f\22\16\22]\13\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\7\22e\n\22\f\22\16\22h\13\22\3\22\3\22\3\22\3"+
		"\22\7\22n\n\22\f\22\16\22q\13\22\5\22s\n\22\3\23\3\23\3\23\5\23x\n\23"+
		"\3\24\3\24\7\24|\n\24\f\24\16\24\177\13\24\3\25\6\25\u0082\n\25\r\25\16"+
		"\25\u0083\3\26\3\26\7\26\u0088\n\26\f\26\16\26\u008b\13\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0098\n\27\6[fo\u0089"+
		"\30\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1"+
		"\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1"+
		"+\27\1-\30\1\3\2\5\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\u00a2\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2"+
		"\5\62\3\2\2\2\7\64\3\2\2\2\t\66\3\2\2\2\138\3\2\2\2\r:\3\2\2\2\17<\3\2"+
		"\2\2\21>\3\2\2\2\23@\3\2\2\2\25B\3\2\2\2\27E\3\2\2\2\31H\3\2\2\2\33K\3"+
		"\2\2\2\35M\3\2\2\2\37P\3\2\2\2!S\3\2\2\2#r\3\2\2\2%w\3\2\2\2\'y\3\2\2"+
		"\2)\u0081\3\2\2\2+\u0085\3\2\2\2-\u0097\3\2\2\2/\60\7~\2\2\60\61\7~\2"+
		"\2\61\4\3\2\2\2\62\63\7@\2\2\63\6\3\2\2\2\64\65\7+\2\2\65\b\3\2\2\2\66"+
		"\67\7-\2\2\67\n\3\2\2\289\7/\2\29\f\3\2\2\2:;\7,\2\2;\16\3\2\2\2<=\7*"+
		"\2\2=\20\3\2\2\2>?\7\61\2\2?\22\3\2\2\2@A\7>\2\2A\24\3\2\2\2BC\7?\2\2"+
		"CD\7?\2\2D\26\3\2\2\2EF\7@\2\2FG\7?\2\2G\30\3\2\2\2HI\7#\2\2IJ\7?\2\2"+
		"J\32\3\2\2\2KL\7#\2\2L\34\3\2\2\2MN\7>\2\2NO\7?\2\2O\36\3\2\2\2PQ\7(\2"+
		"\2QR\7(\2\2R \3\2\2\2ST\t\2\2\2T\"\3\2\2\2UV\7\61\2\2VW\7,\2\2W[\3\2\2"+
		"\2XZ\13\2\2\2YX\3\2\2\2Z]\3\2\2\2[\\\3\2\2\2[Y\3\2\2\2\\^\3\2\2\2][\3"+
		"\2\2\2^_\7,\2\2_s\7\61\2\2`a\7\61\2\2ab\7\61\2\2bf\3\2\2\2ce\13\2\2\2"+
		"dc\3\2\2\2eh\3\2\2\2fg\3\2\2\2fd\3\2\2\2gs\3\2\2\2hf\3\2\2\2ij\7\61\2"+
		"\2jk\7\61\2\2ko\3\2\2\2ln\5%\23\2ml\3\2\2\2nq\3\2\2\2op\3\2\2\2om\3\2"+
		"\2\2ps\3\2\2\2qo\3\2\2\2rU\3\2\2\2r`\3\2\2\2ri\3\2\2\2s$\3\2\2\2tx\7\f"+
		"\2\2uv\7\17\2\2vx\7\f\2\2wt\3\2\2\2wu\3\2\2\2x&\3\2\2\2y}\t\3\2\2z|\t"+
		"\4\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~(\3\2\2\2\177}\3\2\2"+
		"\2\u0080\u0082\4\62;\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084*\3\2\2\2\u0085\u0089\7$\2\2\u0086\u0088"+
		"\13\2\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u008a\3\2\2\2"+
		"\u0089\u0087\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d"+
		"\7$\2\2\u008d,\3\2\2\2\u008e\u008f\7v\2\2\u008f\u0090\7t\2\2\u0090\u0091"+
		"\7w\2\2\u0091\u0098\7g\2\2\u0092\u0093\7h\2\2\u0093\u0094\7c\2\2\u0094"+
		"\u0095\7n\2\2\u0095\u0096\7u\2\2\u0096\u0098\7g\2\2\u0097\u008e\3\2\2"+
		"\2\u0097\u0092\3\2\2\2\u0098.\3\2\2\2\f\2[forw}\u0083\u0089\u0097";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}