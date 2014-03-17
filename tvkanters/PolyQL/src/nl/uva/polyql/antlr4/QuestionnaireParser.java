// Generated from Questionnaire.g4 by ANTLR 4.1

    package nl.uva.polyql.antlr4;
    import nl.uva.polyql.ast.*;
    import nl.uva.polyql.ast.expressions.*;
    import nl.uva.polyql.ast.expressions.operations.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuestionnaireParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__21=1, T__20=2, T__19=3, T__18=4, T__17=5, T__16=6, T__15=7, T__14=8, 
		T__13=9, T__12=10, T__11=11, T__10=12, T__9=13, T__8=14, T__7=15, T__6=16, 
		T__5=17, T__4=18, T__3=19, T__2=20, T__1=21, T__0=22, COMMENT=23, TYPE=24, 
		BOOLEAN=25, ID=26, STRING=27, LETTER=28, NUMBER=29, DIGIT=30, WS=31, PUNCTUATION=32;
	public static final String[] tokenNames = {
		"<INVALID>", "'form'", "')'", "'+'", "'-'", "'*'", "'('", "':'", "'if'", 
		"'<'", "'!='", "'<='", "'&&'", "'||'", "'{'", "'>'", "'=='", "'else'", 
		"'/'", "'}'", "'>='", "'|'", "'!'", "COMMENT", "TYPE", "BOOLEAN", "ID", 
		"STRING", "LETTER", "NUMBER", "DIGIT", "WS", "PUNCTUATION"
	};
	public static final int
		RULE_form = 0, RULE_formrule = 1, RULE_calcquestion = 2, RULE_question = 3, 
		RULE_ifstatement = 4, RULE_expr_main = 5, RULE_expr_or = 6, RULE_expr_and = 7, 
		RULE_expr_eq = 8, RULE_expr_num = 9, RULE_expr_sum = 10, RULE_expr_prod = 11, 
		RULE_expr_unary = 12, RULE_expr_atom = 13, RULE_op_or = 14, RULE_op_and = 15, 
		RULE_op_eq = 16, RULE_op_num = 17, RULE_op_sum = 18, RULE_op_prod = 19, 
		RULE_op_unary = 20;
	public static final String[] ruleNames = {
		"form", "formrule", "calcquestion", "question", "ifstatement", "expr_main", 
		"expr_or", "expr_and", "expr_eq", "expr_num", "expr_sum", "expr_prod", 
		"expr_unary", "expr_atom", "op_or", "op_and", "op_eq", "op_num", "op_sum", 
		"op_prod", "op_unary"
	};

	@Override
	public String getGrammarFileName() { return "Questionnaire.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuestionnaireParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public Form f;
		public Token ID;
		public FormruleContext r;
		public List<FormruleContext> formrule() {
			return getRuleContexts(FormruleContext.class);
		}
		public TerminalNode ID() { return getToken(QuestionnaireParser.ID, 0); }
		public FormruleContext formrule(int i) {
			return getRuleContext(FormruleContext.class,i);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitForm(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); match(1);
			setState(43); ((FormContext)_localctx).ID = match(ID);
			 ((FormContext)_localctx).f =  new Form((((FormContext)_localctx).ID!=null?((FormContext)_localctx).ID.getText():null)); 
			setState(45); match(14);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 8) | (1L << COMMENT) | (1L << ID))) != 0)) {
				{
				{
				setState(46); ((FormContext)_localctx).r = formrule(_localctx.f);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52); match(19);
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

	public static class FormruleContext extends ParserRuleContext {
		public RuleContainer rc;
		public IfstatementContext ifstatement() {
			return getRuleContext(IfstatementContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public CalcquestionContext calcquestion() {
			return getRuleContext(CalcquestionContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(QuestionnaireParser.COMMENT, 0); }
		public FormruleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FormruleContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_formrule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterFormrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitFormrule(this);
		}
	}

	public final FormruleContext formrule(RuleContainer rc) throws RecognitionException {
		FormruleContext _localctx = new FormruleContext(_ctx, getState(), rc);
		enterRule(_localctx, 2, RULE_formrule);
		try {
			setState(60);
			switch (_input.LA(1)) {
			case COMMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(54); match(COMMENT);
				}
				break;
			case 8:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(55); calcquestion(_localctx.rc);
					}
					break;

				case 2:
					{
					setState(56); question(_localctx.rc);
					}
					break;

				case 3:
					{
					setState(57); ifstatement(_localctx.rc);
					}
					break;
				}
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

	public static class CalcquestionContext extends ParserRuleContext {
		public RuleContainer rc;
		public CalculatedQuestion cq;
		public Token id;
		public Token label;
		public Token type;
		public Expr_mainContext e;
		public Expr_mainContext expr_main() {
			return getRuleContext(Expr_mainContext.class,0);
		}
		public TerminalNode ID() { return getToken(QuestionnaireParser.ID, 0); }
		public TerminalNode STRING() { return getToken(QuestionnaireParser.STRING, 0); }
		public TerminalNode TYPE() { return getToken(QuestionnaireParser.TYPE, 0); }
		public CalcquestionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public CalcquestionContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_calcquestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterCalcquestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitCalcquestion(this);
		}
	}

	public final CalcquestionContext calcquestion(RuleContainer rc) throws RecognitionException {
		CalcquestionContext _localctx = new CalcquestionContext(_ctx, getState(), rc);
		enterRule(_localctx, 4, RULE_calcquestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); ((CalcquestionContext)_localctx).id = match(ID);
			setState(63); match(7);
			setState(64); ((CalcquestionContext)_localctx).label = match(STRING);
			setState(65); ((CalcquestionContext)_localctx).type = match(TYPE);
			setState(66); match(6);
			setState(67); ((CalcquestionContext)_localctx).e = expr_main(_localctx.rc);
			setState(68); match(2);
			 ((CalcquestionContext)_localctx).cq =  _localctx.rc.addCalculatedQuestion((((CalcquestionContext)_localctx).id!=null?((CalcquestionContext)_localctx).id.getText():null), (((CalcquestionContext)_localctx).label!=null?((CalcquestionContext)_localctx).label.getText():null), (((CalcquestionContext)_localctx).type!=null?((CalcquestionContext)_localctx).type.getText():null), ((CalcquestionContext)_localctx).e.e); 
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
		public RuleContainer rc;
		public Question q;
		public Token id;
		public Token label;
		public Token type;
		public TerminalNode ID() { return getToken(QuestionnaireParser.ID, 0); }
		public TerminalNode STRING() { return getToken(QuestionnaireParser.STRING, 0); }
		public TerminalNode TYPE() { return getToken(QuestionnaireParser.TYPE, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public QuestionContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question(RuleContainer rc) throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState(), rc);
		enterRule(_localctx, 6, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); ((QuestionContext)_localctx).id = match(ID);
			setState(72); match(7);
			setState(73); ((QuestionContext)_localctx).label = match(STRING);
			setState(74); ((QuestionContext)_localctx).type = match(TYPE);
			 ((QuestionContext)_localctx).q =  _localctx.rc.addQuestion((((QuestionContext)_localctx).id!=null?((QuestionContext)_localctx).id.getText():null), (((QuestionContext)_localctx).label!=null?((QuestionContext)_localctx).label.getText():null), (((QuestionContext)_localctx).type!=null?((QuestionContext)_localctx).type.getText():null)); 
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

	public static class IfstatementContext extends ParserRuleContext {
		public RuleContainer rc;
		public IfStatement is;
		public ElseStatement es;
		public Expr_mainContext e;
		public List<FormruleContext> formrule() {
			return getRuleContexts(FormruleContext.class);
		}
		public Expr_mainContext expr_main() {
			return getRuleContext(Expr_mainContext.class,0);
		}
		public FormruleContext formrule(int i) {
			return getRuleContext(FormruleContext.class,i);
		}
		public IfstatementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public IfstatementContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_ifstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterIfstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitIfstatement(this);
		}
	}

	public final IfstatementContext ifstatement(RuleContainer rc) throws RecognitionException {
		IfstatementContext _localctx = new IfstatementContext(_ctx, getState(), rc);
		enterRule(_localctx, 8, RULE_ifstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); match(8);
			setState(78); match(6);
			setState(79); ((IfstatementContext)_localctx).e = expr_main(_localctx.rc);
			 ((IfstatementContext)_localctx).is =  _localctx.rc.addIfStatement(((IfstatementContext)_localctx).e.e); 
			setState(81); match(2);
			setState(82); match(14);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 8) | (1L << COMMENT) | (1L << ID))) != 0)) {
				{
				{
				setState(83); formrule(_localctx.is);
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89); match(19);
			setState(100);
			_la = _input.LA(1);
			if (_la==17) {
				{
				setState(90); match(17);
				 ((IfstatementContext)_localctx).es =  _localctx.rc.addElseStatement(((IfstatementContext)_localctx).e.e); 
				setState(92); match(14);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 8) | (1L << COMMENT) | (1L << ID))) != 0)) {
					{
					{
					setState(93); formrule(_localctx.es);
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(99); match(19);
				}
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

	public static class Expr_mainContext extends ParserRuleContext {
		public RuleContainer rc;
		public Expression e;
		public Expr_orContext expr;
		public Expr_orContext expr_or() {
			return getRuleContext(Expr_orContext.class,0);
		}
		public Expr_mainContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expr_mainContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_expr_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterExpr_main(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitExpr_main(this);
		}
	}

	public final Expr_mainContext expr_main(RuleContainer rc) throws RecognitionException {
		Expr_mainContext _localctx = new Expr_mainContext(_ctx, getState(), rc);
		enterRule(_localctx, 10, RULE_expr_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); ((Expr_mainContext)_localctx).expr = expr_or(_localctx.rc);
			 ((Expr_mainContext)_localctx).e =  ((Expr_mainContext)_localctx).expr.e; 
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

	public static class Expr_orContext extends ParserRuleContext {
		public RuleContainer rc;
		public Expression e;
		public Expr_andContext left;
		public Op_orContext op;
		public Expr_andContext right;
		public List<Op_orContext> op_or() {
			return getRuleContexts(Op_orContext.class);
		}
		public Expr_andContext expr_and(int i) {
			return getRuleContext(Expr_andContext.class,i);
		}
		public List<Expr_andContext> expr_and() {
			return getRuleContexts(Expr_andContext.class);
		}
		public Op_orContext op_or(int i) {
			return getRuleContext(Op_orContext.class,i);
		}
		public Expr_orContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expr_orContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_expr_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterExpr_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitExpr_or(this);
		}
	}

	public final Expr_orContext expr_or(RuleContainer rc) throws RecognitionException {
		Expr_orContext _localctx = new Expr_orContext(_ctx, getState(), rc);
		enterRule(_localctx, 12, RULE_expr_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); ((Expr_orContext)_localctx).left = expr_and(_localctx.rc);
			 ((Expr_orContext)_localctx).e =  ((Expr_orContext)_localctx).left.e; 
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==13 || _la==21) {
				{
				{
				setState(107); ((Expr_orContext)_localctx).op = op_or();
				setState(108); ((Expr_orContext)_localctx).right = expr_and(_localctx.rc);
				 ((Expr_orContext)_localctx).e =  new BinaryOperation(_localctx.e, (((Expr_orContext)_localctx).op!=null?_input.getText(((Expr_orContext)_localctx).op.start,((Expr_orContext)_localctx).op.stop):null), ((Expr_orContext)_localctx).right.e); 
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

	public static class Expr_andContext extends ParserRuleContext {
		public RuleContainer rc;
		public Expression e;
		public Expr_eqContext left;
		public Op_andContext op;
		public Expr_eqContext right;
		public List<Op_andContext> op_and() {
			return getRuleContexts(Op_andContext.class);
		}
		public List<Expr_eqContext> expr_eq() {
			return getRuleContexts(Expr_eqContext.class);
		}
		public Op_andContext op_and(int i) {
			return getRuleContext(Op_andContext.class,i);
		}
		public Expr_eqContext expr_eq(int i) {
			return getRuleContext(Expr_eqContext.class,i);
		}
		public Expr_andContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expr_andContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_expr_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterExpr_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitExpr_and(this);
		}
	}

	public final Expr_andContext expr_and(RuleContainer rc) throws RecognitionException {
		Expr_andContext _localctx = new Expr_andContext(_ctx, getState(), rc);
		enterRule(_localctx, 14, RULE_expr_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); ((Expr_andContext)_localctx).left = expr_eq(_localctx.rc);
			 ((Expr_andContext)_localctx).e =  ((Expr_andContext)_localctx).left.e; 
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==12) {
				{
				{
				setState(118); ((Expr_andContext)_localctx).op = op_and();
				setState(119); ((Expr_andContext)_localctx).right = expr_eq(_localctx.rc);
				 ((Expr_andContext)_localctx).e =  new BinaryOperation(_localctx.e, (((Expr_andContext)_localctx).op!=null?_input.getText(((Expr_andContext)_localctx).op.start,((Expr_andContext)_localctx).op.stop):null), ((Expr_andContext)_localctx).right.e); 
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

	public static class Expr_eqContext extends ParserRuleContext {
		public RuleContainer rc;
		public Expression e;
		public Expr_numContext left;
		public Op_eqContext op;
		public Expr_numContext right;
		public List<Op_eqContext> op_eq() {
			return getRuleContexts(Op_eqContext.class);
		}
		public Expr_numContext expr_num(int i) {
			return getRuleContext(Expr_numContext.class,i);
		}
		public List<Expr_numContext> expr_num() {
			return getRuleContexts(Expr_numContext.class);
		}
		public Op_eqContext op_eq(int i) {
			return getRuleContext(Op_eqContext.class,i);
		}
		public Expr_eqContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expr_eqContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_expr_eq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterExpr_eq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitExpr_eq(this);
		}
	}

	public final Expr_eqContext expr_eq(RuleContainer rc) throws RecognitionException {
		Expr_eqContext _localctx = new Expr_eqContext(_ctx, getState(), rc);
		enterRule(_localctx, 16, RULE_expr_eq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); ((Expr_eqContext)_localctx).left = expr_num(_localctx.rc);
			 ((Expr_eqContext)_localctx).e =  ((Expr_eqContext)_localctx).left.e; 
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==10 || _la==16) {
				{
				{
				setState(129); ((Expr_eqContext)_localctx).op = op_eq();
				setState(130); ((Expr_eqContext)_localctx).right = expr_num(_localctx.rc);
				 ((Expr_eqContext)_localctx).e =  new BinaryOperation(_localctx.e, (((Expr_eqContext)_localctx).op!=null?_input.getText(((Expr_eqContext)_localctx).op.start,((Expr_eqContext)_localctx).op.stop):null), ((Expr_eqContext)_localctx).right.e); 
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

	public static class Expr_numContext extends ParserRuleContext {
		public RuleContainer rc;
		public Expression e;
		public Expr_sumContext left;
		public Op_numContext op;
		public Expr_sumContext right;
		public Expr_sumContext expr_sum(int i) {
			return getRuleContext(Expr_sumContext.class,i);
		}
		public List<Op_numContext> op_num() {
			return getRuleContexts(Op_numContext.class);
		}
		public Op_numContext op_num(int i) {
			return getRuleContext(Op_numContext.class,i);
		}
		public List<Expr_sumContext> expr_sum() {
			return getRuleContexts(Expr_sumContext.class);
		}
		public Expr_numContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expr_numContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_expr_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterExpr_num(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitExpr_num(this);
		}
	}

	public final Expr_numContext expr_num(RuleContainer rc) throws RecognitionException {
		Expr_numContext _localctx = new Expr_numContext(_ctx, getState(), rc);
		enterRule(_localctx, 18, RULE_expr_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); ((Expr_numContext)_localctx).left = expr_sum(_localctx.rc);
			 ((Expr_numContext)_localctx).e =  ((Expr_numContext)_localctx).left.e; 
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 11) | (1L << 15) | (1L << 20))) != 0)) {
				{
				{
				setState(140); ((Expr_numContext)_localctx).op = op_num();
				setState(141); ((Expr_numContext)_localctx).right = expr_sum(_localctx.rc);
				 ((Expr_numContext)_localctx).e =  new BinaryOperation(_localctx.e, (((Expr_numContext)_localctx).op!=null?_input.getText(((Expr_numContext)_localctx).op.start,((Expr_numContext)_localctx).op.stop):null), ((Expr_numContext)_localctx).right.e); 
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

	public static class Expr_sumContext extends ParserRuleContext {
		public RuleContainer rc;
		public Expression e;
		public Expr_prodContext left;
		public Op_sumContext op;
		public Expr_prodContext right;
		public List<Op_sumContext> op_sum() {
			return getRuleContexts(Op_sumContext.class);
		}
		public List<Expr_prodContext> expr_prod() {
			return getRuleContexts(Expr_prodContext.class);
		}
		public Expr_prodContext expr_prod(int i) {
			return getRuleContext(Expr_prodContext.class,i);
		}
		public Op_sumContext op_sum(int i) {
			return getRuleContext(Op_sumContext.class,i);
		}
		public Expr_sumContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expr_sumContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_expr_sum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterExpr_sum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitExpr_sum(this);
		}
	}

	public final Expr_sumContext expr_sum(RuleContainer rc) throws RecognitionException {
		Expr_sumContext _localctx = new Expr_sumContext(_ctx, getState(), rc);
		enterRule(_localctx, 20, RULE_expr_sum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149); ((Expr_sumContext)_localctx).left = expr_prod(_localctx.rc);
			 ((Expr_sumContext)_localctx).e =  ((Expr_sumContext)_localctx).left.e; 
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==4) {
				{
				{
				setState(151); ((Expr_sumContext)_localctx).op = op_sum();
				setState(152); ((Expr_sumContext)_localctx).right = expr_prod(_localctx.rc);
				 ((Expr_sumContext)_localctx).e =  new BinaryOperation(_localctx.e, (((Expr_sumContext)_localctx).op!=null?_input.getText(((Expr_sumContext)_localctx).op.start,((Expr_sumContext)_localctx).op.stop):null), ((Expr_sumContext)_localctx).right.e); 
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

	public static class Expr_prodContext extends ParserRuleContext {
		public RuleContainer rc;
		public Expression e;
		public Expr_unaryContext left;
		public Op_prodContext op;
		public Expr_unaryContext right;
		public List<Expr_unaryContext> expr_unary() {
			return getRuleContexts(Expr_unaryContext.class);
		}
		public Expr_unaryContext expr_unary(int i) {
			return getRuleContext(Expr_unaryContext.class,i);
		}
		public List<Op_prodContext> op_prod() {
			return getRuleContexts(Op_prodContext.class);
		}
		public Op_prodContext op_prod(int i) {
			return getRuleContext(Op_prodContext.class,i);
		}
		public Expr_prodContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expr_prodContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_expr_prod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterExpr_prod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitExpr_prod(this);
		}
	}

	public final Expr_prodContext expr_prod(RuleContainer rc) throws RecognitionException {
		Expr_prodContext _localctx = new Expr_prodContext(_ctx, getState(), rc);
		enterRule(_localctx, 22, RULE_expr_prod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); ((Expr_prodContext)_localctx).left = expr_unary(_localctx.rc);
			 ((Expr_prodContext)_localctx).e =  ((Expr_prodContext)_localctx).left.e; 
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5 || _la==18) {
				{
				{
				setState(162); ((Expr_prodContext)_localctx).op = op_prod();
				setState(163); ((Expr_prodContext)_localctx).right = expr_unary(_localctx.rc);
				 ((Expr_prodContext)_localctx).e =  new BinaryOperation(_localctx.e, (((Expr_prodContext)_localctx).op!=null?_input.getText(((Expr_prodContext)_localctx).op.start,((Expr_prodContext)_localctx).op.stop):null), ((Expr_prodContext)_localctx).right.e); 
				}
				}
				setState(170);
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

	public static class Expr_unaryContext extends ParserRuleContext {
		public RuleContainer rc;
		public Expression e;
		public Op_unaryContext op;
		public Expr_unaryContext unary;
		public Expr_atomContext expr;
		public Expr_unaryContext expr_unary() {
			return getRuleContext(Expr_unaryContext.class,0);
		}
		public Expr_atomContext expr_atom() {
			return getRuleContext(Expr_atomContext.class,0);
		}
		public Op_unaryContext op_unary() {
			return getRuleContext(Op_unaryContext.class,0);
		}
		public Expr_unaryContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expr_unaryContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_expr_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterExpr_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitExpr_unary(this);
		}
	}

	public final Expr_unaryContext expr_unary(RuleContainer rc) throws RecognitionException {
		Expr_unaryContext _localctx = new Expr_unaryContext(_ctx, getState(), rc);
		enterRule(_localctx, 24, RULE_expr_unary);
		try {
			setState(178);
			switch (_input.LA(1)) {
			case 4:
			case 22:
				enterOuterAlt(_localctx, 1);
				{
				setState(171); ((Expr_unaryContext)_localctx).op = op_unary();
				setState(172); ((Expr_unaryContext)_localctx).unary = expr_unary(_localctx.rc);
				 ((Expr_unaryContext)_localctx).e =  new UnaryOperation((((Expr_unaryContext)_localctx).op!=null?_input.getText(((Expr_unaryContext)_localctx).op.start,((Expr_unaryContext)_localctx).op.stop):null), ((Expr_unaryContext)_localctx).unary.e); 
				}
				break;
			case 6:
			case BOOLEAN:
			case ID:
			case STRING:
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(175); ((Expr_unaryContext)_localctx).expr = expr_atom(_localctx.rc);
				 ((Expr_unaryContext)_localctx).e =  ((Expr_unaryContext)_localctx).expr.e; 
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

	public static class Expr_atomContext extends ParserRuleContext {
		public RuleContainer rc;
		public Expression e;
		public Token ID;
		public Token NUMBER;
		public Token STRING;
		public Token BOOLEAN;
		public Expr_mainContext expr;
		public TerminalNode BOOLEAN() { return getToken(QuestionnaireParser.BOOLEAN, 0); }
		public Expr_mainContext expr_main() {
			return getRuleContext(Expr_mainContext.class,0);
		}
		public TerminalNode ID() { return getToken(QuestionnaireParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(QuestionnaireParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(QuestionnaireParser.STRING, 0); }
		public Expr_atomContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expr_atomContext(ParserRuleContext parent, int invokingState, RuleContainer rc) {
			super(parent, invokingState);
			this.rc = rc;
		}
		@Override public int getRuleIndex() { return RULE_expr_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterExpr_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitExpr_atom(this);
		}
	}

	public final Expr_atomContext expr_atom(RuleContainer rc) throws RecognitionException {
		Expr_atomContext _localctx = new Expr_atomContext(_ctx, getState(), rc);
		enterRule(_localctx, 26, RULE_expr_atom);
		try {
			setState(193);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(180); ((Expr_atomContext)_localctx).ID = match(ID);
				 ((Expr_atomContext)_localctx).e =  new QuestionAtom(_localctx.rc, (((Expr_atomContext)_localctx).ID!=null?((Expr_atomContext)_localctx).ID.getText():null)); 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(182); ((Expr_atomContext)_localctx).NUMBER = match(NUMBER);
				 ((Expr_atomContext)_localctx).e =  new NumberAtom((((Expr_atomContext)_localctx).NUMBER!=null?((Expr_atomContext)_localctx).NUMBER.getText():null)); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(184); ((Expr_atomContext)_localctx).STRING = match(STRING);
				 ((Expr_atomContext)_localctx).e =  new StringAtom((((Expr_atomContext)_localctx).STRING!=null?((Expr_atomContext)_localctx).STRING.getText():null)); 
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(186); ((Expr_atomContext)_localctx).BOOLEAN = match(BOOLEAN);
				 ((Expr_atomContext)_localctx).e =  new BooleanAtom((((Expr_atomContext)_localctx).BOOLEAN!=null?((Expr_atomContext)_localctx).BOOLEAN.getText():null)); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 5);
				{
				setState(188); match(6);
				setState(189); ((Expr_atomContext)_localctx).expr = expr_main(_localctx.rc);
				 ((Expr_atomContext)_localctx).e =  ((Expr_atomContext)_localctx).expr.e; 
				setState(191); match(2);
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

	public static class Op_orContext extends ParserRuleContext {
		public Op_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterOp_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitOp_or(this);
		}
	}

	public final Op_orContext op_or() throws RecognitionException {
		Op_orContext _localctx = new Op_orContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_op_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_la = _input.LA(1);
			if ( !(_la==13 || _la==21) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Op_andContext extends ParserRuleContext {
		public Op_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterOp_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitOp_and(this);
		}
	}

	public final Op_andContext op_and() throws RecognitionException {
		Op_andContext _localctx = new Op_andContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_op_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); match(12);
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

	public static class Op_eqContext extends ParserRuleContext {
		public Op_eqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_eq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterOp_eq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitOp_eq(this);
		}
	}

	public final Op_eqContext op_eq() throws RecognitionException {
		Op_eqContext _localctx = new Op_eqContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_op_eq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_la = _input.LA(1);
			if ( !(_la==10 || _la==16) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Op_numContext extends ParserRuleContext {
		public Op_numContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterOp_num(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitOp_num(this);
		}
	}

	public final Op_numContext op_num() throws RecognitionException {
		Op_numContext _localctx = new Op_numContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_op_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 11) | (1L << 15) | (1L << 20))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Op_sumContext extends ParserRuleContext {
		public Op_sumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_sum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterOp_sum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitOp_sum(this);
		}
	}

	public final Op_sumContext op_sum() throws RecognitionException {
		Op_sumContext _localctx = new Op_sumContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_op_sum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_la = _input.LA(1);
			if ( !(_la==3 || _la==4) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Op_prodContext extends ParserRuleContext {
		public Op_prodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_prod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterOp_prod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitOp_prod(this);
		}
	}

	public final Op_prodContext op_prod() throws RecognitionException {
		Op_prodContext _localctx = new Op_prodContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_op_prod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_la = _input.LA(1);
			if ( !(_la==5 || _la==18) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Op_unaryContext extends ParserRuleContext {
		public Op_unaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterOp_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitOp_unary(this);
		}
	}

	public final Op_unaryContext op_unary() throws RecognitionException {
		Op_unaryContext _localctx = new Op_unaryContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_op_unary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_la = _input.LA(1);
			if ( !(_la==4 || _la==22) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\"\u00d4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\7\2\62\n"+
		"\2\f\2\16\2\65\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3=\n\3\5\3?\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6W\n\6\f\6\16\6Z\13\6\3\6\3\6\3\6\3\6\3\6\7\6a\n\6\f\6\16"+
		"\6d\13\6\3\6\5\6g\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\br\n\b\f\b"+
		"\16\bu\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t}\n\t\f\t\16\t\u0080\13\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\7\n\u0088\n\n\f\n\16\n\u008b\13\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\7\13\u0093\n\13\f\13\16\13\u0096\13\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\7\f\u009e\n\f\f\f\16\f\u00a1\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00a9"+
		"\n\r\f\r\16\r\u00ac\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b5"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u00c4\n\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\26\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*\2\b\4\2\17\17\27\27\4\2\f\f\22\22\6\2\13\13\r\r\21\21\26\26\3\2\5\6"+
		"\4\2\7\7\24\24\4\2\6\6\30\30\u00d0\2,\3\2\2\2\4>\3\2\2\2\6@\3\2\2\2\b"+
		"I\3\2\2\2\nO\3\2\2\2\fh\3\2\2\2\16k\3\2\2\2\20v\3\2\2\2\22\u0081\3\2\2"+
		"\2\24\u008c\3\2\2\2\26\u0097\3\2\2\2\30\u00a2\3\2\2\2\32\u00b4\3\2\2\2"+
		"\34\u00c3\3\2\2\2\36\u00c5\3\2\2\2 \u00c7\3\2\2\2\"\u00c9\3\2\2\2$\u00cb"+
		"\3\2\2\2&\u00cd\3\2\2\2(\u00cf\3\2\2\2*\u00d1\3\2\2\2,-\7\3\2\2-.\7\34"+
		"\2\2./\b\2\1\2/\63\7\20\2\2\60\62\5\4\3\2\61\60\3\2\2\2\62\65\3\2\2\2"+
		"\63\61\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7\25\2"+
		"\2\67\3\3\2\2\28?\7\31\2\29=\5\6\4\2:=\5\b\5\2;=\5\n\6\2<9\3\2\2\2<:\3"+
		"\2\2\2<;\3\2\2\2=?\3\2\2\2>8\3\2\2\2><\3\2\2\2?\5\3\2\2\2@A\7\34\2\2A"+
		"B\7\t\2\2BC\7\35\2\2CD\7\32\2\2DE\7\b\2\2EF\5\f\7\2FG\7\4\2\2GH\b\4\1"+
		"\2H\7\3\2\2\2IJ\7\34\2\2JK\7\t\2\2KL\7\35\2\2LM\7\32\2\2MN\b\5\1\2N\t"+
		"\3\2\2\2OP\7\n\2\2PQ\7\b\2\2QR\5\f\7\2RS\b\6\1\2ST\7\4\2\2TX\7\20\2\2"+
		"UW\5\4\3\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2"+
		"[f\7\25\2\2\\]\7\23\2\2]^\b\6\1\2^b\7\20\2\2_a\5\4\3\2`_\3\2\2\2ad\3\2"+
		"\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2eg\7\25\2\2f\\\3\2\2\2fg\3"+
		"\2\2\2g\13\3\2\2\2hi\5\16\b\2ij\b\7\1\2j\r\3\2\2\2kl\5\20\t\2ls\b\b\1"+
		"\2mn\5\36\20\2no\5\20\t\2op\b\b\1\2pr\3\2\2\2qm\3\2\2\2ru\3\2\2\2sq\3"+
		"\2\2\2st\3\2\2\2t\17\3\2\2\2us\3\2\2\2vw\5\22\n\2w~\b\t\1\2xy\5 \21\2"+
		"yz\5\22\n\2z{\b\t\1\2{}\3\2\2\2|x\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177"+
		"\3\2\2\2\177\21\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\5\24\13\2\u0082\u0089"+
		"\b\n\1\2\u0083\u0084\5\"\22\2\u0084\u0085\5\24\13\2\u0085\u0086\b\n\1"+
		"\2\u0086\u0088\3\2\2\2\u0087\u0083\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\23\3\2\2\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008d\5\26\f\2\u008d\u0094\b\13\1\2\u008e\u008f\5$\23\2\u008f\u0090\5"+
		"\26\f\2\u0090\u0091\b\13\1\2\u0091\u0093\3\2\2\2\u0092\u008e\3\2\2\2\u0093"+
		"\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\25\3\2\2"+
		"\2\u0096\u0094\3\2\2\2\u0097\u0098\5\30\r\2\u0098\u009f\b\f\1\2\u0099"+
		"\u009a\5&\24\2\u009a\u009b\5\30\r\2\u009b\u009c\b\f\1\2\u009c\u009e\3"+
		"\2\2\2\u009d\u0099\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\27\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\5\32\16"+
		"\2\u00a3\u00aa\b\r\1\2\u00a4\u00a5\5(\25\2\u00a5\u00a6\5\32\16\2\u00a6"+
		"\u00a7\b\r\1\2\u00a7\u00a9\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a9\u00ac\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\31\3\2\2\2\u00ac\u00aa"+
		"\3\2\2\2\u00ad\u00ae\5*\26\2\u00ae\u00af\5\32\16\2\u00af\u00b0\b\16\1"+
		"\2\u00b0\u00b5\3\2\2\2\u00b1\u00b2\5\34\17\2\u00b2\u00b3\b\16\1\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4\u00ad\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b5\33\3\2\2"+
		"\2\u00b6\u00b7\7\34\2\2\u00b7\u00c4\b\17\1\2\u00b8\u00b9\7\37\2\2\u00b9"+
		"\u00c4\b\17\1\2\u00ba\u00bb\7\35\2\2\u00bb\u00c4\b\17\1\2\u00bc\u00bd"+
		"\7\33\2\2\u00bd\u00c4\b\17\1\2\u00be\u00bf\7\b\2\2\u00bf\u00c0\5\f\7\2"+
		"\u00c0\u00c1\b\17\1\2\u00c1\u00c2\7\4\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00b6"+
		"\3\2\2\2\u00c3\u00b8\3\2\2\2\u00c3\u00ba\3\2\2\2\u00c3\u00bc\3\2\2\2\u00c3"+
		"\u00be\3\2\2\2\u00c4\35\3\2\2\2\u00c5\u00c6\t\2\2\2\u00c6\37\3\2\2\2\u00c7"+
		"\u00c8\7\16\2\2\u00c8!\3\2\2\2\u00c9\u00ca\t\3\2\2\u00ca#\3\2\2\2\u00cb"+
		"\u00cc\t\4\2\2\u00cc%\3\2\2\2\u00cd\u00ce\t\5\2\2\u00ce\'\3\2\2\2\u00cf"+
		"\u00d0\t\6\2\2\u00d0)\3\2\2\2\u00d1\u00d2\t\7\2\2\u00d2+\3\2\2\2\20\63"+
		"<>Xbfs~\u0089\u0094\u009f\u00aa\u00b4\u00c3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}