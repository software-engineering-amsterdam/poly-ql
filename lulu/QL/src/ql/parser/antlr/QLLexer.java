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
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, WS=9, 
		COMMENT=10, Ident=11, Int=12, Bool=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'Int'", "'form'", "'{'", "':'", "'Boolean'", "'}'", "'String'", "'\"'", 
		"WS", "COMMENT", "Ident", "Int", "Bool"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "WS", 
		"COMMENT", "Ident", "Int", "Bool"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17p\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13F\n\13\f\13"+
		"\16\13I\13\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13Q\n\13\f\13\16\13T\13"+
		"\13\5\13V\n\13\3\13\3\13\3\f\3\f\7\f\\\n\f\f\f\16\f_\13\f\3\r\6\rb\n\r"+
		"\r\r\16\rc\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16o\n\16\4G"+
		"R\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\3\2\5\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|u\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\3\35\3\2\2\2\5!\3\2\2\2\7&\3\2\2\2\t(\3\2\2\2\13*\3\2\2\2\r\62\3"+
		"\2\2\2\17\64\3\2\2\2\21;\3\2\2\2\23=\3\2\2\2\25U\3\2\2\2\27Y\3\2\2\2\31"+
		"a\3\2\2\2\33n\3\2\2\2\35\36\7K\2\2\36\37\7p\2\2\37 \7v\2\2 \4\3\2\2\2"+
		"!\"\7h\2\2\"#\7q\2\2#$\7t\2\2$%\7o\2\2%\6\3\2\2\2&\'\7}\2\2\'\b\3\2\2"+
		"\2()\7<\2\2)\n\3\2\2\2*+\7D\2\2+,\7q\2\2,-\7q\2\2-.\7n\2\2./\7g\2\2/\60"+
		"\7c\2\2\60\61\7p\2\2\61\f\3\2\2\2\62\63\7\177\2\2\63\16\3\2\2\2\64\65"+
		"\7U\2\2\65\66\7v\2\2\66\67\7t\2\2\678\7k\2\289\7p\2\29:\7i\2\2:\20\3\2"+
		"\2\2;<\7$\2\2<\22\3\2\2\2=>\t\2\2\2>?\3\2\2\2?@\b\n\2\2@\24\3\2\2\2AB"+
		"\7\61\2\2BC\7,\2\2CG\3\2\2\2DF\13\2\2\2ED\3\2\2\2FI\3\2\2\2GH\3\2\2\2"+
		"GE\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7,\2\2KV\7\61\2\2LM\7\61\2\2MN\7\61\2"+
		"\2NR\3\2\2\2OQ\13\2\2\2PO\3\2\2\2QT\3\2\2\2RS\3\2\2\2RP\3\2\2\2SV\3\2"+
		"\2\2TR\3\2\2\2UA\3\2\2\2UL\3\2\2\2VW\3\2\2\2WX\b\13\2\2X\26\3\2\2\2Y]"+
		"\t\3\2\2Z\\\t\4\2\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\30\3\2\2"+
		"\2_]\3\2\2\2`b\4\62;\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\32\3\2"+
		"\2\2ef\7v\2\2fg\7t\2\2gh\7w\2\2ho\7g\2\2ij\7h\2\2jk\7c\2\2kl\7n\2\2lm"+
		"\7u\2\2mo\7g\2\2ne\3\2\2\2ni\3\2\2\2o\34\3\2\2\2\t\2GRU]cn\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}