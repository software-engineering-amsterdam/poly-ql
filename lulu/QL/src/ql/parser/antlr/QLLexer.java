// Generated from QL.g4 by ANTLR 4.2

package ql.parser.antlr;
import ql.ast.expr.*;
import ql.ast.stat.*;
import ql.ast.form.*;
import ql.ast.form.QuestionType.*;
import ql.ast.expr.ExprType.*;

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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, Str=8, NEWLINE=9, 
		WS=10, COMMENT=11, Ident=12, Int=13, Bool=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'form'", "'{'", "':'", "'string'", "'int'", "'}'", "'boolean'", "Str", 
		"NEWLINE", "WS", "COMMENT", "Ident", "Int", "Bool"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Str", "NEWLINE", 
		"WS", "COMMENT", "Ident", "Int", "Bool"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\20|\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\7\t@\n\t\f\t\16\tC\13\t\3\t\3\t\3\n\5\nH"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\fT\n\f\f\f\16\fW\13"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f_\n\f\f\f\16\fb\13\f\5\fd\n\f\3\f\3\f\3"+
		"\r\6\ri\n\r\r\r\16\rj\3\16\6\16n\n\16\r\16\16\16o\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17{\n\17\4A`\2\20\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2\4\5\2\13\f\17\17\"\""+
		"\5\2\62;C\\c|\u0083\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2"+
		"\2\5$\3\2\2\2\7&\3\2\2\2\t(\3\2\2\2\13/\3\2\2\2\r\63\3\2\2\2\17\65\3\2"+
		"\2\2\21=\3\2\2\2\23G\3\2\2\2\25K\3\2\2\2\27c\3\2\2\2\31h\3\2\2\2\33m\3"+
		"\2\2\2\35z\3\2\2\2\37 \7h\2\2 !\7q\2\2!\"\7t\2\2\"#\7o\2\2#\4\3\2\2\2"+
		"$%\7}\2\2%\6\3\2\2\2&\'\7<\2\2\'\b\3\2\2\2()\7u\2\2)*\7v\2\2*+\7t\2\2"+
		"+,\7k\2\2,-\7p\2\2-.\7i\2\2.\n\3\2\2\2/\60\7k\2\2\60\61\7p\2\2\61\62\7"+
		"v\2\2\62\f\3\2\2\2\63\64\7\177\2\2\64\16\3\2\2\2\65\66\7d\2\2\66\67\7"+
		"q\2\2\678\7q\2\289\7n\2\29:\7g\2\2:;\7c\2\2;<\7p\2\2<\20\3\2\2\2=A\7$"+
		"\2\2>@\13\2\2\2?>\3\2\2\2@C\3\2\2\2AB\3\2\2\2A?\3\2\2\2BD\3\2\2\2CA\3"+
		"\2\2\2DE\7$\2\2E\22\3\2\2\2FH\7\17\2\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2I"+
		"J\7\f\2\2J\24\3\2\2\2KL\t\2\2\2LM\3\2\2\2MN\b\13\2\2N\26\3\2\2\2OP\7\61"+
		"\2\2PQ\7,\2\2QU\3\2\2\2RT\13\2\2\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2"+
		"\2\2VX\3\2\2\2WU\3\2\2\2XY\7,\2\2Yd\7\61\2\2Z[\7\61\2\2[\\\7\61\2\2\\"+
		"`\3\2\2\2]_\13\2\2\2^]\3\2\2\2_b\3\2\2\2`a\3\2\2\2`^\3\2\2\2ad\3\2\2\2"+
		"b`\3\2\2\2cO\3\2\2\2cZ\3\2\2\2de\3\2\2\2ef\b\f\2\2f\30\3\2\2\2gi\t\3\2"+
		"\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\32\3\2\2\2ln\4\62;\2ml\3\2"+
		"\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2p\34\3\2\2\2qr\7v\2\2rs\7t\2\2st\7w"+
		"\2\2t{\7g\2\2uv\7h\2\2vw\7c\2\2wx\7n\2\2xy\7u\2\2y{\7g\2\2zq\3\2\2\2z"+
		"u\3\2\2\2{\36\3\2\2\2\13\2AGU`cjoz\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}