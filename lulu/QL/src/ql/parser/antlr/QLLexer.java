// Generated from QL.g4 by ANTLR 4.2

package ql.parser.antlr;
import ql.ast.expr.*;
import ql.ast.form.stat.*;
import ql.ast.form.*;
import ql.ast.type.*;
import ql.ast.expr.exprType.*;
import ql.ast.expr.operation.*;
import ql.ast.expr.operation.add.*;
import ql.ast.expr.operation.andor.*;
import ql.ast.expr.operation.mul.*;
import ql.ast.expr.operation.rel.*;
import ql.ast.expr.operation.un.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__23=1, T__22=2, T__21=3, T__20=4, T__19=5, T__18=6, T__17=7, T__16=8, 
		T__15=9, T__14=10, T__13=11, T__12=12, T__11=13, T__10=14, T__9=15, T__8=16, 
		T__7=17, T__6=18, T__5=19, T__4=20, T__3=21, T__2=22, T__1=23, T__0=24, 
		Str=25, WS=26, COMMENT=27, Int=28, Bool=29, Ident=30;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "')'", "'+'", "'-'", "'*'", "'('", "':'", "'if'", "'int'", "'<'", 
		"'!='", "'<='", "'&&'", "'||'", "'{'", "'>'", "'string'", "'else'", "'/'", 
		"'=='", "'boolean'", "'}'", "'>='", "'!'", "Str", "WS", "COMMENT", "Int", 
		"Bool", "Ident"
	};
	public static final String[] ruleNames = {
		"T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", "T__16", 
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Str", 
		"WS", "COMMENT", "Int", "Bool", "Ident"
	};


	public QLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u00c6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\7\32\u008c"+
		"\n\32\f\32\16\32\u008f\13\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3"+
		"\34\3\34\7\34\u009b\n\34\f\34\16\34\u009e\13\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\7\34\u00a6\n\34\f\34\16\34\u00a9\13\34\3\34\5\34\u00ac\n\34\3"+
		"\34\3\34\3\35\6\35\u00b1\n\35\r\35\16\35\u00b2\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u00be\n\36\3\37\3\37\7\37\u00c2\n\37\f\37\16"+
		"\37\u00c5\13\37\5\u008d\u009c\u00a7\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= \3\2\5\5\2\13\f\17\17\"\"\4\2C\\"+
		"c|\6\2\62;C\\aac|\u00cc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5D\3\2\2\2\7F\3\2\2"+
		"\2\tH\3\2\2\2\13J\3\2\2\2\rL\3\2\2\2\17N\3\2\2\2\21P\3\2\2\2\23S\3\2\2"+
		"\2\25W\3\2\2\2\27Y\3\2\2\2\31\\\3\2\2\2\33_\3\2\2\2\35b\3\2\2\2\37e\3"+
		"\2\2\2!g\3\2\2\2#i\3\2\2\2%p\3\2\2\2\'u\3\2\2\2)w\3\2\2\2+z\3\2\2\2-\u0082"+
		"\3\2\2\2/\u0084\3\2\2\2\61\u0087\3\2\2\2\63\u0089\3\2\2\2\65\u0092\3\2"+
		"\2\2\67\u00ab\3\2\2\29\u00b0\3\2\2\2;\u00bd\3\2\2\2=\u00bf\3\2\2\2?@\7"+
		"h\2\2@A\7q\2\2AB\7t\2\2BC\7o\2\2C\4\3\2\2\2DE\7+\2\2E\6\3\2\2\2FG\7-\2"+
		"\2G\b\3\2\2\2HI\7/\2\2I\n\3\2\2\2JK\7,\2\2K\f\3\2\2\2LM\7*\2\2M\16\3\2"+
		"\2\2NO\7<\2\2O\20\3\2\2\2PQ\7k\2\2QR\7h\2\2R\22\3\2\2\2ST\7k\2\2TU\7p"+
		"\2\2UV\7v\2\2V\24\3\2\2\2WX\7>\2\2X\26\3\2\2\2YZ\7#\2\2Z[\7?\2\2[\30\3"+
		"\2\2\2\\]\7>\2\2]^\7?\2\2^\32\3\2\2\2_`\7(\2\2`a\7(\2\2a\34\3\2\2\2bc"+
		"\7~\2\2cd\7~\2\2d\36\3\2\2\2ef\7}\2\2f \3\2\2\2gh\7@\2\2h\"\3\2\2\2ij"+
		"\7u\2\2jk\7v\2\2kl\7t\2\2lm\7k\2\2mn\7p\2\2no\7i\2\2o$\3\2\2\2pq\7g\2"+
		"\2qr\7n\2\2rs\7u\2\2st\7g\2\2t&\3\2\2\2uv\7\61\2\2v(\3\2\2\2wx\7?\2\2"+
		"xy\7?\2\2y*\3\2\2\2z{\7d\2\2{|\7q\2\2|}\7q\2\2}~\7n\2\2~\177\7g\2\2\177"+
		"\u0080\7c\2\2\u0080\u0081\7p\2\2\u0081,\3\2\2\2\u0082\u0083\7\177\2\2"+
		"\u0083.\3\2\2\2\u0084\u0085\7@\2\2\u0085\u0086\7?\2\2\u0086\60\3\2\2\2"+
		"\u0087\u0088\7#\2\2\u0088\62\3\2\2\2\u0089\u008d\7$\2\2\u008a\u008c\13"+
		"\2\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008e\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7$"+
		"\2\2\u0091\64\3\2\2\2\u0092\u0093\t\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095"+
		"\b\33\2\2\u0095\66\3\2\2\2\u0096\u0097\7\61\2\2\u0097\u0098\7,\2\2\u0098"+
		"\u009c\3\2\2\2\u0099\u009b\13\2\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3"+
		"\2\2\2\u009c\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u00a0\7,\2\2\u00a0\u00ac\7\61\2\2\u00a1\u00a2\7\61"+
		"\2\2\u00a2\u00a3\7\61\2\2\u00a3\u00a7\3\2\2\2\u00a4\u00a6\13\2\2\2\u00a5"+
		"\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a7\u00a5\3\2"+
		"\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ac\7\f\2\2\u00ab"+
		"\u0096\3\2\2\2\u00ab\u00a1\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\b\34"+
		"\2\2\u00ae8\3\2\2\2\u00af\u00b1\4\62;\2\u00b0\u00af\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3:\3\2\2\2\u00b4"+
		"\u00b5\7v\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7\7w\2\2\u00b7\u00be\7g\2\2"+
		"\u00b8\u00b9\7h\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc"+
		"\7u\2\2\u00bc\u00be\7g\2\2\u00bd\u00b4\3\2\2\2\u00bd\u00b8\3\2\2\2\u00be"+
		"<\3\2\2\2\u00bf\u00c3\t\3\2\2\u00c0\u00c2\t\4\2\2\u00c1\u00c0\3\2\2\2"+
		"\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4>\3"+
		"\2\2\2\u00c5\u00c3\3\2\2\2\n\2\u008d\u009c\u00a7\u00ab\u00b2\u00bd\u00c3"+
		"\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}