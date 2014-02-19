// Generated from Questionnaire.g4 by ANTLR 4.2
package edu.uva.softwarecons.grammar;
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
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, MUL=16, DIV=17, 
		ADD=18, SUB=19, NOT=20, AND=21, OR=22, LT=23, LEq=24, GT=25, GEq=26, Eq=27, 
		NEq=28, ID=29, INT=30, STRING=31, WS=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "':'", "'('", "'if'", "'decimal'", "'{'", "'else'", "'}'", "'boolean'", 
		"'date'", "')'", "'money'", "'currency'", "'integer'", "'string'", "'*'", 
		"'/'", "'+'", "'-'", "'!'", "'&&'", "'||'", "'<'", "'<='", "'>'", "'>='", 
		"'=='", "'!='", "ID", "INT", "STRING", "WS"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "MUL", "DIV", "ADD", "SUB", 
		"NOT", "AND", "OR", "LT", "LEq", "GT", "GEq", "Eq", "NEq", "ID", "INT", 
		"STRING", "ESC", "UNICODE", "HEX", "WS"
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
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u00db\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\36\6\36\u00b5\n\36\r\36\16\36\u00b6\3\37\6\37\u00ba"+
		"\n\37\r\37\16\37\u00bb\3 \3 \3 \7 \u00c1\n \f \16 \u00c4\13 \3 \3 \3!"+
		"\3!\3!\5!\u00cb\n!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3$\6$\u00d6\n$\r$\16"+
		"$\u00d7\3$\3$\2\2%\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\2C\2E\2G\"\3\2\b\5\2\62;C\\c|\3\2\62;\4\2$$"+
		"^^\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\5\2\13\f\17\17\"\"\u00dd\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5N\3\2\2\2\7P\3\2\2\2\tR"+
		"\3\2\2\2\13U\3\2\2\2\r]\3\2\2\2\17_\3\2\2\2\21d\3\2\2\2\23f\3\2\2\2\25"+
		"n\3\2\2\2\27s\3\2\2\2\31u\3\2\2\2\33{\3\2\2\2\35\u0084\3\2\2\2\37\u008c"+
		"\3\2\2\2!\u0093\3\2\2\2#\u0095\3\2\2\2%\u0097\3\2\2\2\'\u0099\3\2\2\2"+
		")\u009b\3\2\2\2+\u009d\3\2\2\2-\u00a0\3\2\2\2/\u00a3\3\2\2\2\61\u00a5"+
		"\3\2\2\2\63\u00a8\3\2\2\2\65\u00aa\3\2\2\2\67\u00ad\3\2\2\29\u00b0\3\2"+
		"\2\2;\u00b4\3\2\2\2=\u00b9\3\2\2\2?\u00bd\3\2\2\2A\u00c7\3\2\2\2C\u00cc"+
		"\3\2\2\2E\u00d2\3\2\2\2G\u00d5\3\2\2\2IJ\7h\2\2JK\7q\2\2KL\7t\2\2LM\7"+
		"o\2\2M\4\3\2\2\2NO\7<\2\2O\6\3\2\2\2PQ\7*\2\2Q\b\3\2\2\2RS\7k\2\2ST\7"+
		"h\2\2T\n\3\2\2\2UV\7f\2\2VW\7g\2\2WX\7e\2\2XY\7k\2\2YZ\7o\2\2Z[\7c\2\2"+
		"[\\\7n\2\2\\\f\3\2\2\2]^\7}\2\2^\16\3\2\2\2_`\7g\2\2`a\7n\2\2ab\7u\2\2"+
		"bc\7g\2\2c\20\3\2\2\2de\7\177\2\2e\22\3\2\2\2fg\7d\2\2gh\7q\2\2hi\7q\2"+
		"\2ij\7n\2\2jk\7g\2\2kl\7c\2\2lm\7p\2\2m\24\3\2\2\2no\7f\2\2op\7c\2\2p"+
		"q\7v\2\2qr\7g\2\2r\26\3\2\2\2st\7+\2\2t\30\3\2\2\2uv\7o\2\2vw\7q\2\2w"+
		"x\7p\2\2xy\7g\2\2yz\7{\2\2z\32\3\2\2\2{|\7e\2\2|}\7w\2\2}~\7t\2\2~\177"+
		"\7t\2\2\177\u0080\7g\2\2\u0080\u0081\7p\2\2\u0081\u0082\7e\2\2\u0082\u0083"+
		"\7{\2\2\u0083\34\3\2\2\2\u0084\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u0087"+
		"\7v\2\2\u0087\u0088\7g\2\2\u0088\u0089\7i\2\2\u0089\u008a\7g\2\2\u008a"+
		"\u008b\7t\2\2\u008b\36\3\2\2\2\u008c\u008d\7u\2\2\u008d\u008e\7v\2\2\u008e"+
		"\u008f\7t\2\2\u008f\u0090\7k\2\2\u0090\u0091\7p\2\2\u0091\u0092\7i\2\2"+
		"\u0092 \3\2\2\2\u0093\u0094\7,\2\2\u0094\"\3\2\2\2\u0095\u0096\7\61\2"+
		"\2\u0096$\3\2\2\2\u0097\u0098\7-\2\2\u0098&\3\2\2\2\u0099\u009a\7/\2\2"+
		"\u009a(\3\2\2\2\u009b\u009c\7#\2\2\u009c*\3\2\2\2\u009d\u009e\7(\2\2\u009e"+
		"\u009f\7(\2\2\u009f,\3\2\2\2\u00a0\u00a1\7~\2\2\u00a1\u00a2\7~\2\2\u00a2"+
		".\3\2\2\2\u00a3\u00a4\7>\2\2\u00a4\60\3\2\2\2\u00a5\u00a6\7>\2\2\u00a6"+
		"\u00a7\7?\2\2\u00a7\62\3\2\2\2\u00a8\u00a9\7@\2\2\u00a9\64\3\2\2\2\u00aa"+
		"\u00ab\7@\2\2\u00ab\u00ac\7?\2\2\u00ac\66\3\2\2\2\u00ad\u00ae\7?\2\2\u00ae"+
		"\u00af\7?\2\2\u00af8\3\2\2\2\u00b0\u00b1\7#\2\2\u00b1\u00b2\7?\2\2\u00b2"+
		":\3\2\2\2\u00b3\u00b5\t\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2"+
		"\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7<\3\2\2\2\u00b8\u00ba\t"+
		"\3\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc>\3\2\2\2\u00bd\u00c2\7$\2\2\u00be\u00c1\5A!\2\u00bf"+
		"\u00c1\n\4\2\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3\2"+
		"\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c5\u00c6\7$\2\2\u00c6@\3\2\2\2\u00c7\u00ca\7^\2\2\u00c8"+
		"\u00cb\t\5\2\2\u00c9\u00cb\5C\"\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2"+
		"\2\2\u00cbB\3\2\2\2\u00cc\u00cd\7w\2\2\u00cd\u00ce\5E#\2\u00ce\u00cf\5"+
		"E#\2\u00cf\u00d0\5E#\2\u00d0\u00d1\5E#\2\u00d1D\3\2\2\2\u00d2\u00d3\t"+
		"\6\2\2\u00d3F\3\2\2\2\u00d4\u00d6\t\7\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00da\b$\2\2\u00daH\3\2\2\2\t\2\u00b6\u00bb\u00c0\u00c2\u00ca\u00d7\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}