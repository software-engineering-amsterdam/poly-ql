// Generated from QL.g4 by ANTLR 4.2

package ql.parser.antlr;
import ql.ast.expr.*;
import ql.ast.stat.*;
import ql.ast.form.*;
import ql.ast.form.QuestionType.*;
import ql.ast.expr.ExprType.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, WS=9, 
		COMMENT=10, Ident=11, Int=12, Bool=13;
	public static final String[] tokenNames = {
		"<INVALID>", "'Int'", "'form'", "'{'", "':'", "'Boolean'", "'}'", "'String'", 
		"'\"'", "WS", "COMMENT", "Ident", "Int", "Bool"
	};
	public static final int
		RULE_form = 0, RULE_formItems = 1, RULE_question = 2, RULE_type = 3, RULE_str = 4;
	public static final String[] ruleNames = {
		"form", "formItems", "question", "type", "str"
	};

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public Form result;
		public Token Ident;
		public FormItemsContext f;
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public FormItemsContext formItems() {
			return getRuleContext(FormItemsContext.class,0);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitForm(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); match(2);
			setState(11); ((FormContext)_localctx).Ident = match(Ident);
			setState(12); ((FormContext)_localctx).f = formItems();
			 ((FormContext)_localctx).result =  new Form(new Ident((((FormContext)_localctx).Ident!=null?((FormContext)_localctx).Ident.getText():null)), ((FormContext)_localctx).f.result); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormItemsContext extends ParserRuleContext {
		public List<FormItems> result;
		public QuestionContext q;
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(QLParser.WS); }
		public TerminalNode COMMENT(int i) {
			return getToken(QLParser.COMMENT, i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public List<TerminalNode> COMMENT() { return getTokens(QLParser.COMMENT); }
		public TerminalNode WS(int i) {
			return getToken(QLParser.WS, i);
		}
		public FormItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formItems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterFormItems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitFormItems(this);
		}
	}

	public final FormItemsContext formItems() throws RecognitionException {
		FormItemsContext _localctx = new FormItemsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_formItems);
		 List<FormItems> formItems = new ArrayList(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); match(3);
			setState(20);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(16); match(WS);
				}
				break;

			case 2:
				{
				setState(17); match(WS);
				setState(18); match(COMMENT);
				setState(19); match(WS);
				}
				break;
			}
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Ident) {
				{
				{
				setState(22); ((FormItemsContext)_localctx).q = question();
				formItems.add(((FormItemsContext)_localctx).q.result);
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30); match(6);
			setState(35);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(31); match(WS);
				}
				break;

			case 2:
				{
				setState(32); match(WS);
				setState(33); match(COMMENT);
				setState(34); match(WS);
				}
				break;
			}
			 ((FormItemsContext)_localctx).result =  formItems; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionContext extends ParserRuleContext {
		public Question result;
		public Token Ident;
		public StrContext s;
		public TypeContext t;
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public List<TerminalNode> WS() { return getTokens(QLParser.WS); }
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(QLParser.COMMENT, 0); }
		public TerminalNode WS(int i) {
			return getToken(QLParser.WS, i);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); ((QuestionContext)_localctx).Ident = match(Ident);
			setState(40); match(4);
			setState(41); ((QuestionContext)_localctx).s = str();
			setState(42); ((QuestionContext)_localctx).t = type();
			setState(47);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(43); match(WS);
				}
				break;

			case 2:
				{
				setState(44); match(WS);
				setState(45); match(COMMENT);
				setState(46); match(WS);
				}
				break;
			}
			 ((QuestionContext)_localctx).result =  new Question(new Ident((((QuestionContext)_localctx).Ident!=null?((QuestionContext)_localctx).Ident.getText():null)), (((QuestionContext)_localctx).s!=null?_input.getText(((QuestionContext)_localctx).s.start,((QuestionContext)_localctx).s.stop):null), ((QuestionContext)_localctx).t.result); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type result;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(57);
			switch (_input.LA(1)) {
			case 5:
				enterOuterAlt(_localctx, 1);
				{
				setState(51); match(5);
				 ((TypeContext)_localctx).result =  new Bool();
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 2);
				{
				setState(53); match(1);
				 ((TypeContext)_localctx).result =  new Int();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 3);
				{
				setState(55); match(7);
				 ((TypeContext)_localctx).result =  new Str();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrContext extends ParserRuleContext {
		public StrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitStr(this);
		}
	}

	public final StrContext str() throws RecognitionException {
		StrContext _localctx = new StrContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_str);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59); match(8);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(60);
					matchWildcard();
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(66); match(8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17G\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3"+
		"\27\n\3\3\3\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3&\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\62\n\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5<\n\5\3\6\3\6\7\6@\n\6\f\6\16\6C\13\6\3\6\3\6"+
		"\3\6\3A\2\7\2\4\6\b\n\2\2H\2\f\3\2\2\2\4\21\3\2\2\2\6)\3\2\2\2\b;\3\2"+
		"\2\2\n=\3\2\2\2\f\r\7\4\2\2\r\16\7\r\2\2\16\17\5\4\3\2\17\20\b\2\1\2\20"+
		"\3\3\2\2\2\21\26\7\5\2\2\22\27\7\13\2\2\23\24\7\13\2\2\24\25\7\f\2\2\25"+
		"\27\7\13\2\2\26\22\3\2\2\2\26\23\3\2\2\2\27\35\3\2\2\2\30\31\5\6\4\2\31"+
		"\32\b\3\1\2\32\34\3\2\2\2\33\30\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35"+
		"\36\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 %\7\b\2\2!&\7\13\2\2\"#\7\13\2\2"+
		"#$\7\f\2\2$&\7\13\2\2%!\3\2\2\2%\"\3\2\2\2&\'\3\2\2\2\'(\b\3\1\2(\5\3"+
		"\2\2\2)*\7\r\2\2*+\7\6\2\2+,\5\n\6\2,\61\5\b\5\2-\62\7\13\2\2./\7\13\2"+
		"\2/\60\7\f\2\2\60\62\7\13\2\2\61-\3\2\2\2\61.\3\2\2\2\62\63\3\2\2\2\63"+
		"\64\b\4\1\2\64\7\3\2\2\2\65\66\7\7\2\2\66<\b\5\1\2\678\7\3\2\28<\b\5\1"+
		"\29:\7\t\2\2:<\b\5\1\2;\65\3\2\2\2;\67\3\2\2\2;9\3\2\2\2<\t\3\2\2\2=A"+
		"\7\n\2\2>@\13\2\2\2?>\3\2\2\2@C\3\2\2\2AB\3\2\2\2A?\3\2\2\2BD\3\2\2\2"+
		"CA\3\2\2\2DE\7\n\2\2E\13\3\2\2\2\b\26\35%\61;A";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}