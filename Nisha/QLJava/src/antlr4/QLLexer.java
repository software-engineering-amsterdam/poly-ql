// Generated from QL.g4 by ANTLR 4.1

	package antlr4;
	import ast.form.*;
	import ast.type.*;
	import ast.literals.*;
	import expr.conditional.*;
	import expr.operation.*;
	import expr.relational.*;
	import expr.unary.*;
	import expr.Expr;
	import expr.Ident;
	
	

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
		WS=25, COMMENT=26, Bool=27, Ident=28, Int=29, Str=30, NEWLINE=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "')'", "'+'", "'*'", "'-'", "'('", "':'", "'if'", "'<'", "'!='", 
		"'<='", "'&&'", "'||'", "'{'", "'>'", "'integer'", "'string'", "'else'", 
		"'/'", "'=='", "'}'", "'>='", "'boolean'", "'!'", "WS", "COMMENT", "Bool", 
		"Ident", "Int", "Str", "NEWLINE"
	};
	public static final String[] ruleNames = {
		"T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", "T__16", 
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "WS", 
		"COMMENT", "Bool", "Ident", "Int", "Str", "NEWLINE"
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
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 24: WS_action((RuleContext)_localctx, actionIndex); break;

		case 25: COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _channel = HIDDEN;  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2!\u00d2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u0098\n\33\f\33"+
		"\16\33\u009b\13\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u00a3\n\33\f\33"+
		"\16\33\u00a6\13\33\3\33\3\33\5\33\u00aa\n\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00b7\n\34\3\35\3\35\7\35\u00bb\n"+
		"\35\f\35\16\35\u00be\13\35\3\36\6\36\u00c1\n\36\r\36\16\36\u00c2\3\37"+
		"\3\37\7\37\u00c7\n\37\f\37\16\37\u00ca\13\37\3\37\3\37\3 \5 \u00cf\n "+
		"\3 \3 \5\u0099\u00a4\u00c8!\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t"+
		"\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1"+
		"#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\2\65\34\3\67"+
		"\35\19\36\1;\37\1= \1?!\1\3\2\5\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\"+
		"aac|\u00d9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5F\3\2\2\2\7H\3\2\2\2"+
		"\tJ\3\2\2\2\13L\3\2\2\2\rN\3\2\2\2\17P\3\2\2\2\21R\3\2\2\2\23U\3\2\2\2"+
		"\25W\3\2\2\2\27Z\3\2\2\2\31]\3\2\2\2\33`\3\2\2\2\35c\3\2\2\2\37e\3\2\2"+
		"\2!g\3\2\2\2#o\3\2\2\2%v\3\2\2\2\'{\3\2\2\2)}\3\2\2\2+\u0080\3\2\2\2-"+
		"\u0082\3\2\2\2/\u0085\3\2\2\2\61\u008d\3\2\2\2\63\u008f\3\2\2\2\65\u00a9"+
		"\3\2\2\2\67\u00b6\3\2\2\29\u00b8\3\2\2\2;\u00c0\3\2\2\2=\u00c4\3\2\2\2"+
		"?\u00ce\3\2\2\2AB\7h\2\2BC\7q\2\2CD\7t\2\2DE\7o\2\2E\4\3\2\2\2FG\7+\2"+
		"\2G\6\3\2\2\2HI\7-\2\2I\b\3\2\2\2JK\7,\2\2K\n\3\2\2\2LM\7/\2\2M\f\3\2"+
		"\2\2NO\7*\2\2O\16\3\2\2\2PQ\7<\2\2Q\20\3\2\2\2RS\7k\2\2ST\7h\2\2T\22\3"+
		"\2\2\2UV\7>\2\2V\24\3\2\2\2WX\7#\2\2XY\7?\2\2Y\26\3\2\2\2Z[\7>\2\2[\\"+
		"\7?\2\2\\\30\3\2\2\2]^\7(\2\2^_\7(\2\2_\32\3\2\2\2`a\7~\2\2ab\7~\2\2b"+
		"\34\3\2\2\2cd\7}\2\2d\36\3\2\2\2ef\7@\2\2f \3\2\2\2gh\7k\2\2hi\7p\2\2"+
		"ij\7v\2\2jk\7g\2\2kl\7i\2\2lm\7g\2\2mn\7t\2\2n\"\3\2\2\2op\7u\2\2pq\7"+
		"v\2\2qr\7t\2\2rs\7k\2\2st\7p\2\2tu\7i\2\2u$\3\2\2\2vw\7g\2\2wx\7n\2\2"+
		"xy\7u\2\2yz\7g\2\2z&\3\2\2\2{|\7\61\2\2|(\3\2\2\2}~\7?\2\2~\177\7?\2\2"+
		"\177*\3\2\2\2\u0080\u0081\7\177\2\2\u0081,\3\2\2\2\u0082\u0083\7@\2\2"+
		"\u0083\u0084\7?\2\2\u0084.\3\2\2\2\u0085\u0086\7d\2\2\u0086\u0087\7q\2"+
		"\2\u0087\u0088\7q\2\2\u0088\u0089\7n\2\2\u0089\u008a\7g\2\2\u008a\u008b"+
		"\7c\2\2\u008b\u008c\7p\2\2\u008c\60\3\2\2\2\u008d\u008e\7#\2\2\u008e\62"+
		"\3\2\2\2\u008f\u0090\t\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\b\32\2\2"+
		"\u0092\64\3\2\2\2\u0093\u0094\7\61\2\2\u0094\u0095\7,\2\2\u0095\u0099"+
		"\3\2\2\2\u0096\u0098\13\2\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009c\u009d\7,\2\2\u009d\u00aa\7\61\2\2\u009e\u009f\7\61\2\2"+
		"\u009f\u00a0\7\61\2\2\u00a0\u00a4\3\2\2\2\u00a1\u00a3\13\2\2\2\u00a2\u00a1"+
		"\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5"+
		"\u00a7\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7\61\2\2\u00a8\u00aa\7"+
		"\61\2\2\u00a9\u0093\3\2\2\2\u00a9\u009e\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00ac\b\33\3\2\u00ac\66\3\2\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7t\2\2"+
		"\u00af\u00b0\7w\2\2\u00b0\u00b7\7g\2\2\u00b1\u00b2\7h\2\2\u00b2\u00b3"+
		"\7c\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7u\2\2\u00b5\u00b7\7g\2\2\u00b6"+
		"\u00ad\3\2\2\2\u00b6\u00b1\3\2\2\2\u00b78\3\2\2\2\u00b8\u00bc\t\3\2\2"+
		"\u00b9\u00bb\t\4\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd:\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c1\4\62;\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3<\3\2\2\2\u00c4\u00c8\7$\2\2\u00c5\u00c7"+
		"\13\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c9\3\2\2\2"+
		"\u00c8\u00c6\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc"+
		"\7$\2\2\u00cc>\3\2\2\2\u00cd\u00cf\7\17\2\2\u00ce\u00cd\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\7\f\2\2\u00d1@\3\2\2\2"+
		"\13\2\u0099\u00a4\u00a9\u00b6\u00bc\u00c2\u00c8\u00ce";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}