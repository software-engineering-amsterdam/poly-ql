// Generated from QL.g4 by ANTLR 4.2

package ql.parser.antlr;
import ql.ast.expr.*;
import ql.ast.stat.*;
import ql.ast.form.*;
import ql.ast.form.questionType.*;
import ql.ast.expr.exprType.*;
import ql.ast.expr.operation.*;
import ql.ast.expr.operation.add.*;
import ql.ast.expr.operation.andor.*;
import ql.ast.expr.operation.mul.*;
import ql.ast.expr.operation.rel.*;
import ql.ast.expr.operation.un.*;

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
		T__21=1, T__20=2, T__19=3, T__18=4, T__17=5, T__16=6, T__15=7, T__14=8, 
		T__13=9, T__12=10, T__11=11, T__10=12, T__9=13, T__8=14, T__7=15, T__6=16, 
		T__5=17, T__4=18, T__3=19, T__2=20, T__1=21, T__0=22, Str=23, NEWLINE=24, 
		WS=25, COMMENT=26, Ident=27, Int=28, Bool=29;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "')'", "'+'", "'-'", "'*'", "'('", "':'", "'int'", 
		"'<'", "'!='", "'<='", "'&&'", "'||'", "'{'", "'>'", "'string'", "'/'", 
		"'=='", "'boolean'", "'}'", "'>='", "'!'", "Str", "NEWLINE", "WS", "COMMENT", 
		"Ident", "Int", "Bool"
	};
	public static final int
		RULE_form = 0, RULE_formItems = 1, RULE_question = 2, RULE_type = 3, RULE_unExpr = 4, 
		RULE_expr = 5, RULE_mulExpr = 6, RULE_addExpr = 7, RULE_relExpr = 8, RULE_andExpr = 9, 
		RULE_orExpr = 10;
	public static final String[] ruleNames = {
		"form", "formItems", "question", "type", "unExpr", "expr", "mulExpr", 
		"addExpr", "relExpr", "andExpr", "orExpr"
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
			setState(22); match(1);
			setState(23); ((FormContext)_localctx).Ident = match(Ident);
			setState(24); ((FormContext)_localctx).f = formItems();
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
			setState(27); match(14);
			setState(28); match(NEWLINE);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Ident) {
				{
				{
				setState(29); ((FormItemsContext)_localctx).q = question();
				formItems.add(((FormItemsContext)_localctx).q.result);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37); match(20);
			setState(38); match(NEWLINE);
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
		public OrExprContext x;
		public TerminalNode NEWLINE() { return getToken(QLParser.NEWLINE, 0); }
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public List<TerminalNode> WS() { return getTokens(QLParser.WS); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(QLParser.COMMENT, 0); }
		public TerminalNode WS(int i) {
			return getToken(QLParser.WS, i);
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
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41); ((QuestionContext)_localctx).Ident = match(Ident);
				setState(42); match(7);
				setState(43); ((QuestionContext)_localctx).Str = match(Str);
				setState(44); ((QuestionContext)_localctx).t = type();
				setState(45); match(NEWLINE);
				 ((QuestionContext)_localctx).result =  new Question(new Ident((((QuestionContext)_localctx).Ident!=null?((QuestionContext)_localctx).Ident.getText():null)), (((QuestionContext)_localctx).Str!=null?((QuestionContext)_localctx).Str.getText():null), ((QuestionContext)_localctx).t.result); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48); ((QuestionContext)_localctx).Ident = match(Ident);
				setState(49); match(7);
				setState(50); ((QuestionContext)_localctx).Str = match(Str);
				setState(51); ((QuestionContext)_localctx).t = type();
				setState(52); match(6);
				setState(53); ((QuestionContext)_localctx).x = orExpr();
				setState(54); match(2);
				setState(59);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(55); match(WS);
					}
					break;

				case 2:
					{
					setState(56); match(WS);
					setState(57); match(COMMENT);
					setState(58); match(WS);
					}
					break;
				}
				 ((QuestionContext)_localctx).result =  new Question(new Ident((((QuestionContext)_localctx).Ident!=null?((QuestionContext)_localctx).Ident.getText():null)), (((QuestionContext)_localctx).Str!=null?((QuestionContext)_localctx).Str.getText():null), ((QuestionContext)_localctx).t.result, ((QuestionContext)_localctx).x.result); 
				}
				break;
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
			setState(71);
			switch (_input.LA(1)) {
			case 19:
				enterOuterAlt(_localctx, 1);
				{
				setState(65); match(19);
				 ((TypeContext)_localctx).result =  new Bool();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 2);
				{
				setState(67); match(8);
				 ((TypeContext)_localctx).result =  new Int();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 3);
				{
				setState(69); match(16);
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

	public static class UnExprContext extends ParserRuleContext {
		public Expr result;
		public UnExprContext x;
		public ExprContext r;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnExprContext unExpr() {
			return getRuleContext(UnExprContext.class,0);
		}
		public UnExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterUnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitUnExpr(this);
		}
	}

	public final UnExprContext unExpr() throws RecognitionException {
		UnExprContext _localctx = new UnExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unExpr);
		try {
			setState(88);
			switch (_input.LA(1)) {
			case 3:
				enterOuterAlt(_localctx, 1);
				{
				setState(73); match(3);
				setState(74); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Pos(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 2);
				{
				setState(77); match(4);
				setState(78); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Neg(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 3);
				{
				setState(81); match(22);
				setState(82); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Not(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 6:
			case Str:
			case Ident:
			case Int:
			case Bool:
				enterOuterAlt(_localctx, 4);
				{
				setState(85); ((UnExprContext)_localctx).r = expr();
				 ((UnExprContext)_localctx).result =  ((UnExprContext)_localctx).r.result; 
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

	public static class ExprContext extends ParserRuleContext {
		public Expr result;
		public Token Int;
		public Token Bool;
		public Token Str;
		public Token Ident;
		public OrExprContext x;
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public TerminalNode Bool() { return getToken(QLParser.Bool, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode Str() { return getToken(QLParser.Str, 0); }
		public TerminalNode Int() { return getToken(QLParser.Int, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		try {
			setState(103);
			switch (_input.LA(1)) {
			case Int:
				enterOuterAlt(_localctx, 1);
				{
				setState(90); ((ExprContext)_localctx).Int = match(Int);
				 ((ExprContext)_localctx).result =  new IntExpr(Integer.parseInt((((ExprContext)_localctx).Int!=null?((ExprContext)_localctx).Int.getText():null)));
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 2);
				{
				setState(92); ((ExprContext)_localctx).Bool = match(Bool);
				 ((ExprContext)_localctx).result =  new BoolExpr(Boolean.parseBoolean((((ExprContext)_localctx).Bool!=null?((ExprContext)_localctx).Bool.getText():null)));
				}
				break;
			case Str:
				enterOuterAlt(_localctx, 3);
				{
				setState(94); ((ExprContext)_localctx).Str = match(Str);
				 ((ExprContext)_localctx).result =  new StrExpr((((ExprContext)_localctx).Str!=null?((ExprContext)_localctx).Str.getText():null)); 
				}
				break;
			case Ident:
				enterOuterAlt(_localctx, 4);
				{
				setState(96); ((ExprContext)_localctx).Ident = match(Ident);
				 ((ExprContext)_localctx).result =  new Ident((((ExprContext)_localctx).Ident!=null?((ExprContext)_localctx).Ident.getText():null)); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 5);
				{
				setState(98); match(6);
				setState(99); ((ExprContext)_localctx).x = orExpr();
				setState(100); match(2);
				 ((ExprContext)_localctx).result =  ((ExprContext)_localctx).x.result;
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

	public static class MulExprContext extends ParserRuleContext {
		public Expr result;
		public UnExprContext lhs;
		public Token op;
		public UnExprContext rhs;
		public UnExprContext unExpr(int i) {
			return getRuleContext(UnExprContext.class,i);
		}
		public List<UnExprContext> unExpr() {
			return getRuleContexts(UnExprContext.class);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitMulExpr(this);
		}
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); ((MulExprContext)_localctx).lhs = unExpr();
			 ((MulExprContext)_localctx).result = ((MulExprContext)_localctx).lhs.result; 
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5 || _la==17) {
				{
				{
				setState(107);
				((MulExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==5 || _la==17) ) {
					((MulExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(108); ((MulExprContext)_localctx).rhs = unExpr();
				 
				      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("*")) {
				        ((MulExprContext)_localctx).result =  new Mul(_localctx.result, ((MulExprContext)_localctx).rhs.result);
				      }
				      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("<=")) {
				        ((MulExprContext)_localctx).result =  new Div(_localctx.result, ((MulExprContext)_localctx).rhs.result);      
				      }
				    
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class AddExprContext extends ParserRuleContext {
		public Expr result;
		public MulExprContext lhs;
		public Token op;
		public MulExprContext rhs;
		public List<MulExprContext> mulExpr() {
			return getRuleContexts(MulExprContext.class);
		}
		public MulExprContext mulExpr(int i) {
			return getRuleContext(MulExprContext.class,i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitAddExpr(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); ((AddExprContext)_localctx).lhs = mulExpr();
			 ((AddExprContext)_localctx).result = ((AddExprContext)_localctx).lhs.result; 
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==4) {
				{
				{
				setState(118);
				((AddExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==3 || _la==4) ) {
					((AddExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(119); ((AddExprContext)_localctx).rhs = mulExpr();
				 
				      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("+")) {
				        ((AddExprContext)_localctx).result =  new Add(_localctx.result, ((AddExprContext)_localctx).rhs.result);
				      }
				      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("-")) {
				        ((AddExprContext)_localctx).result =  new Sub(_localctx.result, ((AddExprContext)_localctx).rhs.result);      
				      }
				    
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class RelExprContext extends ParserRuleContext {
		public Expr result;
		public AddExprContext lhs;
		public Token op;
		public AddExprContext rhs;
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public RelExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitRelExpr(this);
		}
	}

	public final RelExprContext relExpr() throws RecognitionException {
		RelExprContext _localctx = new RelExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_relExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); ((RelExprContext)_localctx).lhs = addExpr();
			 ((RelExprContext)_localctx).result = ((RelExprContext)_localctx).lhs.result; 
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 10) | (1L << 11) | (1L << 15) | (1L << 18) | (1L << 21))) != 0)) {
				{
				{
				setState(129);
				((RelExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 10) | (1L << 11) | (1L << 15) | (1L << 18) | (1L << 21))) != 0)) ) {
					((RelExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(130); ((RelExprContext)_localctx).rhs = addExpr();
				 
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("<")) {
				        ((RelExprContext)_localctx).result =  new LT(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("<=")) {
				        ((RelExprContext)_localctx).result =  new LEq(_localctx.result, ((RelExprContext)_localctx).rhs.result);      
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals(">")) {
				        ((RelExprContext)_localctx).result =  new GT(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals(">=")) {
				        ((RelExprContext)_localctx).result =  new GEq(_localctx.result, ((RelExprContext)_localctx).rhs.result);      
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("==")) {
				        ((RelExprContext)_localctx).result =  new Eq(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("!=")) {
				        ((RelExprContext)_localctx).result =  new NEq(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				    
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class AndExprContext extends ParserRuleContext {
		public Expr result;
		public RelExprContext lhs;
		public RelExprContext rhs;
		public List<RelExprContext> relExpr() {
			return getRuleContexts(RelExprContext.class);
		}
		public RelExprContext relExpr(int i) {
			return getRuleContext(RelExprContext.class,i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitAndExpr(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); ((AndExprContext)_localctx).lhs = relExpr();
			 ((AndExprContext)_localctx).result = ((AndExprContext)_localctx).lhs.result; 
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==12) {
				{
				{
				setState(140); match(12);
				setState(141); ((AndExprContext)_localctx).rhs = relExpr();
				 ((AndExprContext)_localctx).result =  new And(_localctx.result, ((AndExprContext)_localctx).rhs.result); 
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class OrExprContext extends ParserRuleContext {
		public Expr result;
		public AndExprContext lhs;
		public AndExprContext rhs;
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitOrExpr(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149); ((OrExprContext)_localctx).lhs = andExpr();
			 ((OrExprContext)_localctx).result =  ((OrExprContext)_localctx).lhs.result; 
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==13) {
				{
				{
				setState(151); match(13);
				setState(152); ((OrExprContext)_localctx).rhs = andExpr();
				 ((OrExprContext)_localctx).result =  new Or(_localctx.result, ((OrExprContext)_localctx).rhs.result); 
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u00a3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3#\n\3\f\3\16"+
		"\3&\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4>\n\4\3\4\3\4\5\4B\n\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6[\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5"+
		"\7j\n\7\3\b\3\b\3\b\3\b\3\b\3\b\7\br\n\b\f\b\16\bu\13\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\7\t}\n\t\f\t\16\t\u0080\13\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0088"+
		"\n\n\f\n\16\n\u008b\13\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0093\n\13"+
		"\f\13\16\13\u0096\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u009e\n\f\f\f\16\f"+
		"\u00a1\13\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\5\4\2\7\7\23\23\3\2"+
		"\5\6\6\2\13\r\21\21\24\24\27\27\u00a8\2\30\3\2\2\2\4\35\3\2\2\2\6A\3\2"+
		"\2\2\bI\3\2\2\2\nZ\3\2\2\2\fi\3\2\2\2\16k\3\2\2\2\20v\3\2\2\2\22\u0081"+
		"\3\2\2\2\24\u008c\3\2\2\2\26\u0097\3\2\2\2\30\31\7\3\2\2\31\32\7\35\2"+
		"\2\32\33\5\4\3\2\33\34\b\2\1\2\34\3\3\2\2\2\35\36\7\20\2\2\36$\7\32\2"+
		"\2\37 \5\6\4\2 !\b\3\1\2!#\3\2\2\2\"\37\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$"+
		"%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'(\7\26\2\2()\7\32\2\2)*\b\3\1\2*\5\3\2"+
		"\2\2+,\7\35\2\2,-\7\t\2\2-.\7\31\2\2./\5\b\5\2/\60\7\32\2\2\60\61\b\4"+
		"\1\2\61B\3\2\2\2\62\63\7\35\2\2\63\64\7\t\2\2\64\65\7\31\2\2\65\66\5\b"+
		"\5\2\66\67\7\b\2\2\678\5\26\f\28=\7\4\2\29>\7\33\2\2:;\7\33\2\2;<\7\34"+
		"\2\2<>\7\33\2\2=9\3\2\2\2=:\3\2\2\2>?\3\2\2\2?@\b\4\1\2@B\3\2\2\2A+\3"+
		"\2\2\2A\62\3\2\2\2B\7\3\2\2\2CD\7\25\2\2DJ\b\5\1\2EF\7\n\2\2FJ\b\5\1\2"+
		"GH\7\22\2\2HJ\b\5\1\2IC\3\2\2\2IE\3\2\2\2IG\3\2\2\2J\t\3\2\2\2KL\7\5\2"+
		"\2LM\5\n\6\2MN\b\6\1\2N[\3\2\2\2OP\7\6\2\2PQ\5\n\6\2QR\b\6\1\2R[\3\2\2"+
		"\2ST\7\30\2\2TU\5\n\6\2UV\b\6\1\2V[\3\2\2\2WX\5\f\7\2XY\b\6\1\2Y[\3\2"+
		"\2\2ZK\3\2\2\2ZO\3\2\2\2ZS\3\2\2\2ZW\3\2\2\2[\13\3\2\2\2\\]\7\36\2\2]"+
		"j\b\7\1\2^_\7\37\2\2_j\b\7\1\2`a\7\31\2\2aj\b\7\1\2bc\7\35\2\2cj\b\7\1"+
		"\2de\7\b\2\2ef\5\26\f\2fg\7\4\2\2gh\b\7\1\2hj\3\2\2\2i\\\3\2\2\2i^\3\2"+
		"\2\2i`\3\2\2\2ib\3\2\2\2id\3\2\2\2j\r\3\2\2\2kl\5\n\6\2ls\b\b\1\2mn\t"+
		"\2\2\2no\5\n\6\2op\b\b\1\2pr\3\2\2\2qm\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3"+
		"\2\2\2t\17\3\2\2\2us\3\2\2\2vw\5\16\b\2w~\b\t\1\2xy\t\3\2\2yz\5\16\b\2"+
		"z{\b\t\1\2{}\3\2\2\2|x\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177"+
		"\21\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\5\20\t\2\u0082\u0089\b\n\1\2\u0083"+
		"\u0084\t\4\2\2\u0084\u0085\5\20\t\2\u0085\u0086\b\n\1\2\u0086\u0088\3"+
		"\2\2\2\u0087\u0083\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\23\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\5\22\n"+
		"\2\u008d\u0094\b\13\1\2\u008e\u008f\7\16\2\2\u008f\u0090\5\22\n\2\u0090"+
		"\u0091\b\13\1\2\u0091\u0093\3\2\2\2\u0092\u008e\3\2\2\2\u0093\u0096\3"+
		"\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\25\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0097\u0098\5\24\13\2\u0098\u009f\b\f\1\2\u0099\u009a\7"+
		"\17\2\2\u009a\u009b\5\24\13\2\u009b\u009c\b\f\1\2\u009c\u009e\3\2\2\2"+
		"\u009d\u0099\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\27\3\2\2\2\u00a1\u009f\3\2\2\2\r$=AIZis~\u0089\u0094\u009f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}