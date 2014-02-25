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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, Str=8, NEWLINE=9, 
		WS=10, COMMENT=11, Ident=12, Int=13, Bool=14;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "'{'", "':'", "'string'", "'int'", "'}'", "'boolean'", 
		"Str", "NEWLINE", "WS", "COMMENT", "Ident", "Int", "Bool"
	};
	public static final int
		RULE_form = 0, RULE_formItems = 1, RULE_question = 2, RULE_type = 3;
	public static final String[] ruleNames = {
		"form", "formItems", "question", "type"
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

	public final Form form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8); match(1);
			setState(9); ((FormContext)_localctx).Ident = match(Ident);
			setState(10); ((FormContext)_localctx).f = formItems();
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
		return _localctx.result;
	}

	public static class FormItemsContext extends ParserRuleContext {
		public List<FormItems> result;
		public QuestionContext q;
		public List<TerminalNode> NEWLINE() { return getTokens(QLParser.NEWLINE); }
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public TerminalNode NEWLINE(int i) {
			return getToken(QLParser.NEWLINE, i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
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
			setState(13); match(2);
			setState(14); match(NEWLINE);
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Ident) {
				{
				{
				setState(15); ((FormItemsContext)_localctx).q = question();
				formItems.add(((FormItemsContext)_localctx).q.result);
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(23); match(6);
			setState(24); match(NEWLINE);
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
		public Token Str;
		public TypeContext t;
		public TerminalNode NEWLINE() { return getToken(QLParser.NEWLINE, 0); }
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Str() { return getToken(QLParser.Str, 0); }
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
			setState(27); ((QuestionContext)_localctx).Ident = match(Ident);
			setState(28); match(3);
			setState(29); ((QuestionContext)_localctx).Str = match(Str);
			setState(30); ((QuestionContext)_localctx).t = type();
			setState(31); match(NEWLINE);
			 ((QuestionContext)_localctx).result =  new Question(new Ident((((QuestionContext)_localctx).Ident!=null?((QuestionContext)_localctx).Ident.getText():null)), (((QuestionContext)_localctx).Str!=null?((QuestionContext)_localctx).Str.getText():null), ((QuestionContext)_localctx).t.result); 
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
			setState(40);
			switch (_input.LA(1)) {
			case 7:
				enterOuterAlt(_localctx, 1);
				{
				setState(34); match(7);
				 ((TypeContext)_localctx).result =  new Bool();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(36); match(5);
				 ((TypeContext)_localctx).result =  new Int();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 3);
				{
				setState(38); match(4);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20-\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3\25\n\3"+
		"\f\3\16\3\30\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5+\n\5\3\5\2\2\6\2\4\6\b\2\2+\2\n\3\2\2\2\4\17\3\2"+
		"\2\2\6\35\3\2\2\2\b*\3\2\2\2\n\13\7\3\2\2\13\f\7\16\2\2\f\r\5\4\3\2\r"+
		"\16\b\2\1\2\16\3\3\2\2\2\17\20\7\4\2\2\20\26\7\13\2\2\21\22\5\6\4\2\22"+
		"\23\b\3\1\2\23\25\3\2\2\2\24\21\3\2\2\2\25\30\3\2\2\2\26\24\3\2\2\2\26"+
		"\27\3\2\2\2\27\31\3\2\2\2\30\26\3\2\2\2\31\32\7\b\2\2\32\33\7\13\2\2\33"+
		"\34\b\3\1\2\34\5\3\2\2\2\35\36\7\16\2\2\36\37\7\5\2\2\37 \7\n\2\2 !\5"+
		"\b\5\2!\"\7\13\2\2\"#\b\4\1\2#\7\3\2\2\2$%\7\t\2\2%+\b\5\1\2&\'\7\7\2"+
		"\2\'+\b\5\1\2()\7\6\2\2)+\b\5\1\2*$\3\2\2\2*&\3\2\2\2*(\3\2\2\2+\t\3\2"+
		"\2\2\4\26*";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}