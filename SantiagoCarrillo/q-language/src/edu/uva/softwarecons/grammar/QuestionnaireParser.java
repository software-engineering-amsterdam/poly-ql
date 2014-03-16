// Generated from Questionnaire.g4 by ANTLR 4.2
package edu.uva.softwarecons.grammar;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class QuestionnaireParser
    extends Parser
{
    protected static final DFA[] _decisionToDFA;

    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();

    public static final int T__5 = 1, T__4 = 2, T__3 = 3, T__2 = 4, T__1 = 5, T__0 = 6, BOOL_TYPE = 7, STRING_TYPE = 8,
        INT_TYPE = 9, DATE_TYPE = 10, DECIMAL_TYPE = 11, MONEY_TYPE = 12, MUL = 13, DIV = 14, ADD = 15, SUB = 16, NOT =
        17, AND = 18, OR = 19, LT = 20, LEq = 21, GT = 22, GEq = 23, Eq = 24, NEq = 25, BOOLEAN = 26, IF = 27, ELSE =
        28, ID = 29, INT = 30, STRING = 31, COMMENT = 32, MULTYLINE_COMMENT = 33, WS = 34;

    public static final String[] tokenNames =
        { "<INVALID>", "'form'", "'{'", "')'", "':'", "'('", "'}'", "'boolean'", "'string'", "'integer'", "'date'",
            "'decimal'", "'money'", "'*'", "'/'", "'+'", "'-'", "'!'", "'&&'", "'||'", "'<'", "'<='", "'>'", "'>='",
            "'=='", "'!='", "BOOLEAN", "'if'", "'else'", "ID", "INT", "STRING", "COMMENT", "MULTYLINE_COMMENT", "WS" };

    public static final int RULE_questionnaire = 0, RULE_question = 1, RULE_elsestat = 2, RULE_type = 3, RULE_expr = 4;

    public static final String[] ruleNames = { "questionnaire", "question", "elsestat", "type", "expr" };

    @Override
    public String getGrammarFileName()
    {
        return "Questionnaire.g4";
    }

    @Override
    public String[] getTokenNames()
    {
        return tokenNames;
    }

    @Override
    public String[] getRuleNames()
    {
        return ruleNames;
    }

    @Override
    public String getSerializedATN()
    {
        return _serializedATN;
    }

    @Override
    public ATN getATN()
    {
        return _ATN;
    }

    public QuestionnaireParser( TokenStream input )
    {
        super( input );
        _interp = new ParserATNSimulator( this, _ATN, _decisionToDFA, _sharedContextCache );
    }

    public static class QuestionnaireContext
        extends ParserRuleContext
    {
        public QuestionContext question( int i )
        {
            return getRuleContext( QuestionContext.class, i );
        }

        public TerminalNode ID()
        {
            return getToken( QuestionnaireParser.ID, 0 );
        }

        public List<QuestionContext> question()
        {
            return getRuleContexts( QuestionContext.class );
        }

        public QuestionnaireContext( ParserRuleContext parent, int invokingState )
        {
            super( parent, invokingState );
        }

        @Override
        public int getRuleIndex()
        {
            return RULE_questionnaire;
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitQuestionnaire( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public final QuestionnaireContext questionnaire()
        throws RecognitionException
    {
        QuestionnaireContext _localctx = new QuestionnaireContext( _ctx, getState() );
        enterRule( _localctx, 0, RULE_questionnaire );
        int _la;
        try
        {
            enterOuterAlt( _localctx, 1 );
            {
                setState( 10 );
                match( 1 );
                setState( 11 );
                match( ID );
                setState( 12 );
                match( 2 );
                setState( 14 );
                _errHandler.sync( this );
                _la = _input.LA( 1 );
                do
                {
                    {
                        {
                            setState( 13 );
                            question();
                        }
                    }
                    setState( 16 );
                    _errHandler.sync( this );
                    _la = _input.LA( 1 );
                }
                while ( _la == IF || _la == ID );
                setState( 18 );
                match( 6 );
            }
        }
        catch ( RecognitionException re )
        {
            _localctx.exception = re;
            _errHandler.reportError( this, re );
            _errHandler.recover( this, re );
        }
        finally
        {
            exitRule();
        }
        return _localctx;
    }

    public static class QuestionContext
        extends ParserRuleContext
    {
        public QuestionContext( ParserRuleContext parent, int invokingState )
        {
            super( parent, invokingState );
        }

        @Override
        public int getRuleIndex()
        {
            return RULE_question;
        }

        public QuestionContext()
        {
        }

        public void copyFrom( QuestionContext ctx )
        {
            super.copyFrom( ctx );
        }
    }

    public static class SimpleQuestionContext
        extends QuestionContext
    {
        public TerminalNode ID()
        {
            return getToken( QuestionnaireParser.ID, 0 );
        }

        public TypeContext type()
        {
            return getRuleContext( TypeContext.class, 0 );
        }

        public TerminalNode STRING()
        {
            return getToken( QuestionnaireParser.STRING, 0 );
        }

        public SimpleQuestionContext( QuestionContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitSimpleQuestion( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class ComputedQuestionContext
        extends QuestionContext
    {
        public ExprContext expr()
        {
            return getRuleContext( ExprContext.class, 0 );
        }

        public TerminalNode ID()
        {
            return getToken( QuestionnaireParser.ID, 0 );
        }

        public TypeContext type()
        {
            return getRuleContext( TypeContext.class, 0 );
        }

        public TerminalNode STRING()
        {
            return getToken( QuestionnaireParser.STRING, 0 );
        }

        public ComputedQuestionContext( QuestionContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitComputedQuestion( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class IfContext
        extends QuestionContext
    {
        public ElsestatContext elsestat()
        {
            return getRuleContext( ElsestatContext.class, 0 );
        }

        public QuestionContext question( int i )
        {
            return getRuleContext( QuestionContext.class, i );
        }

        public ExprContext expr()
        {
            return getRuleContext( ExprContext.class, 0 );
        }

        public List<QuestionContext> question()
        {
            return getRuleContexts( QuestionContext.class );
        }

        public IfContext( QuestionContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitIf( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public final QuestionContext question()
        throws RecognitionException
    {
        QuestionContext _localctx = new QuestionContext( _ctx, getState() );
        enterRule( _localctx, 2, RULE_question );
        int _la;
        try
        {
            setState( 46 );
            switch ( getInterpreter().adaptivePredict( _input, 3, _ctx ) )
            {
                case 1:
                    _localctx = new SimpleQuestionContext( _localctx );
                    enterOuterAlt( _localctx, 1 );
                {
                    setState( 20 );
                    match( ID );
                    setState( 21 );
                    match( 4 );
                    setState( 22 );
                    match( STRING );
                    setState( 23 );
                    type();
                }
                break;

                case 2:
                    _localctx = new ComputedQuestionContext( _localctx );
                    enterOuterAlt( _localctx, 2 );
                {
                    setState( 24 );
                    match( ID );
                    setState( 25 );
                    match( 4 );
                    setState( 26 );
                    match( STRING );
                    setState( 27 );
                    type();
                    setState( 28 );
                    match( 5 );
                    setState( 29 );
                    expr( 0 );
                    setState( 30 );
                    match( 3 );
                }
                break;

                case 3:
                    _localctx = new IfContext( _localctx );
                    enterOuterAlt( _localctx, 3 );
                {
                    setState( 32 );
                    match( IF );
                    setState( 33 );
                    match( 5 );
                    setState( 34 );
                    expr( 0 );
                    setState( 35 );
                    match( 3 );
                    setState( 36 );
                    match( 2 );
                    setState( 38 );
                    _errHandler.sync( this );
                    _la = _input.LA( 1 );
                    do
                    {
                        {
                            {
                                setState( 37 );
                                question();
                            }
                        }
                        setState( 40 );
                        _errHandler.sync( this );
                        _la = _input.LA( 1 );
                    }
                    while ( _la == IF || _la == ID );
                    setState( 42 );
                    match( 6 );
                    setState( 44 );
                    _la = _input.LA( 1 );
                    if ( _la == ELSE )
                    {
                        {
                            setState( 43 );
                            elsestat();
                        }
                    }

                }
                break;
            }
        }
        catch ( RecognitionException re )
        {
            _localctx.exception = re;
            _errHandler.reportError( this, re );
            _errHandler.recover( this, re );
        }
        finally
        {
            exitRule();
        }
        return _localctx;
    }

    public static class ElsestatContext
        extends ParserRuleContext
    {
        public ElsestatContext( ParserRuleContext parent, int invokingState )
        {
            super( parent, invokingState );
        }

        @Override
        public int getRuleIndex()
        {
            return RULE_elsestat;
        }

        public ElsestatContext()
        {
        }

        public void copyFrom( ElsestatContext ctx )
        {
            super.copyFrom( ctx );
        }
    }

    public static class ElseContext
        extends ElsestatContext
    {
        public QuestionContext question( int i )
        {
            return getRuleContext( QuestionContext.class, i );
        }

        public List<QuestionContext> question()
        {
            return getRuleContexts( QuestionContext.class );
        }

        public ElseContext( ElsestatContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitElse( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public final ElsestatContext elsestat()
        throws RecognitionException
    {
        ElsestatContext _localctx = new ElsestatContext( _ctx, getState() );
        enterRule( _localctx, 4, RULE_elsestat );
        int _la;
        try
        {
            _localctx = new ElseContext( _localctx );
            enterOuterAlt( _localctx, 1 );
            {
                setState( 48 );
                match( ELSE );
                setState( 49 );
                match( 2 );
                setState( 51 );
                _errHandler.sync( this );
                _la = _input.LA( 1 );
                do
                {
                    {
                        {
                            setState( 50 );
                            question();
                        }
                    }
                    setState( 53 );
                    _errHandler.sync( this );
                    _la = _input.LA( 1 );
                }
                while ( _la == IF || _la == ID );
                setState( 55 );
                match( 6 );
            }
        }
        catch ( RecognitionException re )
        {
            _localctx.exception = re;
            _errHandler.reportError( this, re );
            _errHandler.recover( this, re );
        }
        finally
        {
            exitRule();
        }
        return _localctx;
    }

    public static class TypeContext
        extends ParserRuleContext
    {
        public TypeContext( ParserRuleContext parent, int invokingState )
        {
            super( parent, invokingState );
        }

        @Override
        public int getRuleIndex()
        {
            return RULE_type;
        }

        public TypeContext()
        {
        }

        public void copyFrom( TypeContext ctx )
        {
            super.copyFrom( ctx );
        }
    }

    public static class StringTypeContext
        extends TypeContext
    {
        public TerminalNode STRING_TYPE()
        {
            return getToken( QuestionnaireParser.STRING_TYPE, 0 );
        }

        public StringTypeContext( TypeContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitStringType( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class DecimalTypeContext
        extends TypeContext
    {
        public TerminalNode DECIMAL_TYPE()
        {
            return getToken( QuestionnaireParser.DECIMAL_TYPE, 0 );
        }

        public DecimalTypeContext( TypeContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitDecimalType( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class BooleanTypeContext
        extends TypeContext
    {
        public TerminalNode BOOL_TYPE()
        {
            return getToken( QuestionnaireParser.BOOL_TYPE, 0 );
        }

        public BooleanTypeContext( TypeContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitBooleanType( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class IntTypeContext
        extends TypeContext
    {
        public TerminalNode INT_TYPE()
        {
            return getToken( QuestionnaireParser.INT_TYPE, 0 );
        }

        public IntTypeContext( TypeContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitIntType( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class DateTypeContext
        extends TypeContext
    {
        public TerminalNode DATE_TYPE()
        {
            return getToken( QuestionnaireParser.DATE_TYPE, 0 );
        }

        public DateTypeContext( TypeContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitDateType( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class MoneyTypeContext
        extends TypeContext
    {
        public TerminalNode MONEY_TYPE()
        {
            return getToken( QuestionnaireParser.MONEY_TYPE, 0 );
        }

        public MoneyTypeContext( TypeContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitMoneyType( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public final TypeContext type()
        throws RecognitionException
    {
        TypeContext _localctx = new TypeContext( _ctx, getState() );
        enterRule( _localctx, 6, RULE_type );
        try
        {
            setState( 63 );
            switch ( _input.LA( 1 ) )
            {
                case BOOL_TYPE:
                    _localctx = new BooleanTypeContext( _localctx );
                    enterOuterAlt( _localctx, 1 );
                {
                    setState( 57 );
                    match( BOOL_TYPE );
                }
                break;
                case STRING_TYPE:
                    _localctx = new StringTypeContext( _localctx );
                    enterOuterAlt( _localctx, 2 );
                {
                    setState( 58 );
                    match( STRING_TYPE );
                }
                break;
                case INT_TYPE:
                    _localctx = new IntTypeContext( _localctx );
                    enterOuterAlt( _localctx, 3 );
                {
                    setState( 59 );
                    match( INT_TYPE );
                }
                break;
                case DATE_TYPE:
                    _localctx = new DateTypeContext( _localctx );
                    enterOuterAlt( _localctx, 4 );
                {
                    setState( 60 );
                    match( DATE_TYPE );
                }
                break;
                case DECIMAL_TYPE:
                    _localctx = new DecimalTypeContext( _localctx );
                    enterOuterAlt( _localctx, 5 );
                {
                    setState( 61 );
                    match( DECIMAL_TYPE );
                }
                break;
                case MONEY_TYPE:
                    _localctx = new MoneyTypeContext( _localctx );
                    enterOuterAlt( _localctx, 6 );
                {
                    setState( 62 );
                    match( MONEY_TYPE );
                }
                break;
                default:
                    throw new NoViableAltException( this );
            }
        }
        catch ( RecognitionException re )
        {
            _localctx.exception = re;
            _errHandler.reportError( this, re );
            _errHandler.recover( this, re );
        }
        finally
        {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprContext
        extends ParserRuleContext
    {
        public ExprContext( ParserRuleContext parent, int invokingState )
        {
            super( parent, invokingState );
        }

        @Override
        public int getRuleIndex()
        {
            return RULE_expr;
        }

        public ExprContext()
        {
        }

        public void copyFrom( ExprContext ctx )
        {
            super.copyFrom( ctx );
        }
    }

    public static class NotContext
        extends ExprContext
    {
        public ExprContext expr()
        {
            return getRuleContext( ExprContext.class, 0 );
        }

        public TerminalNode NOT()
        {
            return getToken( QuestionnaireParser.NOT, 0 );
        }

        public NotContext( ExprContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitNot( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class IdContext
        extends ExprContext
    {
        public TerminalNode ID()
        {
            return getToken( QuestionnaireParser.ID, 0 );
        }

        public IdContext( ExprContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitId( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class IntegerContext
        extends ExprContext
    {
        public TerminalNode INT()
        {
            return getToken( QuestionnaireParser.INT, 0 );
        }

        public IntegerContext( ExprContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitInteger( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class OrContext
        extends ExprContext
    {
        public List<ExprContext> expr()
        {
            return getRuleContexts( ExprContext.class );
        }

        public TerminalNode OR()
        {
            return getToken( QuestionnaireParser.OR, 0 );
        }

        public ExprContext expr( int i )
        {
            return getRuleContext( ExprContext.class, i );
        }

        public OrContext( ExprContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitOr( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class StringContext
        extends ExprContext
    {
        public TerminalNode STRING()
        {
            return getToken( QuestionnaireParser.STRING, 0 );
        }

        public StringContext( ExprContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitString( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class MulDivContext
        extends ExprContext
    {
        public TerminalNode MUL()
        {
            return getToken( QuestionnaireParser.MUL, 0 );
        }

        public TerminalNode DIV()
        {
            return getToken( QuestionnaireParser.DIV, 0 );
        }

        public List<ExprContext> expr()
        {
            return getRuleContexts( ExprContext.class );
        }

        public ExprContext expr( int i )
        {
            return getRuleContext( ExprContext.class, i );
        }

        public MulDivContext( ExprContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitMulDiv( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class CompareContext
        extends ExprContext
    {
        public TerminalNode GEq()
        {
            return getToken( QuestionnaireParser.GEq, 0 );
        }

        public List<ExprContext> expr()
        {
            return getRuleContexts( ExprContext.class );
        }

        public TerminalNode LT()
        {
            return getToken( QuestionnaireParser.LT, 0 );
        }

        public ExprContext expr( int i )
        {
            return getRuleContext( ExprContext.class, i );
        }

        public TerminalNode Eq()
        {
            return getToken( QuestionnaireParser.Eq, 0 );
        }

        public TerminalNode LEq()
        {
            return getToken( QuestionnaireParser.LEq, 0 );
        }

        public TerminalNode GT()
        {
            return getToken( QuestionnaireParser.GT, 0 );
        }

        public TerminalNode NEq()
        {
            return getToken( QuestionnaireParser.NEq, 0 );
        }

        public CompareContext( ExprContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitCompare( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class AddSubContext
        extends ExprContext
    {
        public List<ExprContext> expr()
        {
            return getRuleContexts( ExprContext.class );
        }

        public ExprContext expr( int i )
        {
            return getRuleContext( ExprContext.class, i );
        }

        public TerminalNode SUB()
        {
            return getToken( QuestionnaireParser.SUB, 0 );
        }

        public TerminalNode ADD()
        {
            return getToken( QuestionnaireParser.ADD, 0 );
        }

        public AddSubContext( ExprContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitAddSub( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class BooleanContext
        extends ExprContext
    {
        public TerminalNode BOOLEAN()
        {
            return getToken( QuestionnaireParser.BOOLEAN, 0 );
        }

        public BooleanContext( ExprContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitBoolean( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class ParenthesisContext
        extends ExprContext
    {
        public ExprContext expr()
        {
            return getRuleContext( ExprContext.class, 0 );
        }

        public ParenthesisContext( ExprContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitParenthesis( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public static class AndContext
        extends ExprContext
    {
        public List<ExprContext> expr()
        {
            return getRuleContexts( ExprContext.class );
        }

        public TerminalNode AND()
        {
            return getToken( QuestionnaireParser.AND, 0 );
        }

        public ExprContext expr( int i )
        {
            return getRuleContext( ExprContext.class, i );
        }

        public AndContext( ExprContext ctx )
        {
            copyFrom( ctx );
        }

        @Override
        public <T> T accept( ParseTreeVisitor<? extends T> visitor )
        {
            if ( visitor instanceof QuestionnaireVisitor )
            {
                return ( (QuestionnaireVisitor<? extends T>) visitor ).visitAnd( this );
            }
            else
            {
                return visitor.visitChildren( this );
            }
        }
    }

    public final ExprContext expr()
        throws RecognitionException
    {
        return expr( 0 );
    }

    private ExprContext expr( int _p )
        throws RecognitionException
    {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExprContext _localctx = new ExprContext( _ctx, _parentState );
        ExprContext _prevctx = _localctx;
        int _startState = 8;
        enterRecursionRule( _localctx, 8, RULE_expr, _p );
        int _la;
        try
        {
            int _alt;
            enterOuterAlt( _localctx, 1 );
            {
                setState( 76 );
                switch ( _input.LA( 1 ) )
                {
                    case NOT:
                    {
                        _localctx = new NotContext( _localctx );
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState( 66 );
                        match( NOT );
                        setState( 67 );
                        expr( 8 );
                    }
                    break;
                    case 5:
                    {
                        _localctx = new ParenthesisContext( _localctx );
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState( 68 );
                        match( 5 );
                        setState( 69 );
                        expr( 0 );
                        setState( 70 );
                        match( 3 );
                    }
                    break;
                    case BOOLEAN:
                    {
                        _localctx = new BooleanContext( _localctx );
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState( 72 );
                        match( BOOLEAN );
                    }
                    break;
                    case INT:
                    {
                        _localctx = new IntegerContext( _localctx );
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState( 73 );
                        match( INT );
                    }
                    break;
                    case STRING:
                    {
                        _localctx = new StringContext( _localctx );
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState( 74 );
                        match( STRING );
                    }
                    break;
                    case ID:
                    {
                        _localctx = new IdContext( _localctx );
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState( 75 );
                        match( ID );
                    }
                    break;
                    default:
                        throw new NoViableAltException( this );
                }
                _ctx.stop = _input.LT( -1 );
                setState( 95 );
                _errHandler.sync( this );
                _alt = getInterpreter().adaptivePredict( _input, 8, _ctx );
                while ( _alt != 2 && _alt != -1 )
                {
                    if ( _alt == 1 )
                    {
                        if ( _parseListeners != null )
                        {
                            triggerExitRuleEvent();
                        }
                        _prevctx = _localctx;
                        {
                            setState( 93 );
                            switch ( getInterpreter().adaptivePredict( _input, 7, _ctx ) )
                            {
                                case 1:
                                {
                                    _localctx = new MulDivContext( new ExprContext( _parentctx, _parentState ) );
                                    pushNewRecursionContext( _localctx, _startState, RULE_expr );
                                    setState( 78 );
                                    if ( !( precpred( _ctx, 11 ) ) )
                                    {
                                        throw new FailedPredicateException( this, "precpred(_ctx, 11)" );
                                    }
                                    setState( 79 );
                                    _la = _input.LA( 1 );
                                    if ( !( _la == MUL || _la == DIV ) )
                                    {
                                        _errHandler.recoverInline( this );
                                    }
                                    consume();
                                    setState( 80 );
                                    expr( 12 );
                                }
                                break;

                                case 2:
                                {
                                    _localctx = new AddSubContext( new ExprContext( _parentctx, _parentState ) );
                                    pushNewRecursionContext( _localctx, _startState, RULE_expr );
                                    setState( 81 );
                                    if ( !( precpred( _ctx, 10 ) ) )
                                    {
                                        throw new FailedPredicateException( this, "precpred(_ctx, 10)" );
                                    }
                                    setState( 82 );
                                    _la = _input.LA( 1 );
                                    if ( !( _la == ADD || _la == SUB ) )
                                    {
                                        _errHandler.recoverInline( this );
                                    }
                                    consume();
                                    setState( 83 );
                                    expr( 11 );
                                }
                                break;

                                case 3:
                                {
                                    _localctx = new CompareContext( new ExprContext( _parentctx, _parentState ) );
                                    pushNewRecursionContext( _localctx, _startState, RULE_expr );
                                    setState( 84 );
                                    if ( !( precpred( _ctx, 9 ) ) )
                                    {
                                        throw new FailedPredicateException( this, "precpred(_ctx, 9)" );
                                    }
                                    setState( 85 );
                                    _la = _input.LA( 1 );
                                    if ( !( ( ( ( _la ) & ~0x3f ) == 0 &&
                                        ( ( 1L << _la ) & ( ( 1L << LT ) | ( 1L << LEq ) | ( 1L << GT ) | ( 1L << GEq )
                                            | ( 1L << Eq ) | ( 1L << NEq ) ) ) != 0 ) ) )
                                    {
                                        _errHandler.recoverInline( this );
                                    }
                                    consume();
                                    setState( 86 );
                                    expr( 10 );
                                }
                                break;

                                case 4:
                                {
                                    _localctx = new AndContext( new ExprContext( _parentctx, _parentState ) );
                                    pushNewRecursionContext( _localctx, _startState, RULE_expr );
                                    setState( 87 );
                                    if ( !( precpred( _ctx, 7 ) ) )
                                    {
                                        throw new FailedPredicateException( this, "precpred(_ctx, 7)" );
                                    }
                                    {
                                        setState( 88 );
                                        match( AND );
                                    }
                                    setState( 89 );
                                    expr( 8 );
                                }
                                break;

                                case 5:
                                {
                                    _localctx = new OrContext( new ExprContext( _parentctx, _parentState ) );
                                    pushNewRecursionContext( _localctx, _startState, RULE_expr );
                                    setState( 90 );
                                    if ( !( precpred( _ctx, 6 ) ) )
                                    {
                                        throw new FailedPredicateException( this, "precpred(_ctx, 6)" );
                                    }
                                    {
                                        setState( 91 );
                                        match( OR );
                                    }
                                    setState( 92 );
                                    expr( 7 );
                                }
                                break;
                            }
                        }
                    }
                    setState( 97 );
                    _errHandler.sync( this );
                    _alt = getInterpreter().adaptivePredict( _input, 8, _ctx );
                }
            }
        }
        catch ( RecognitionException re )
        {
            _localctx.exception = re;
            _errHandler.reportError( this, re );
            _errHandler.recover( this, re );
        }
        finally
        {
            unrollRecursionContexts( _parentctx );
        }
        return _localctx;
    }

    public boolean sempred( RuleContext _localctx, int ruleIndex, int predIndex )
    {
        switch ( ruleIndex )
        {
            case 4:
                return expr_sempred( (ExprContext) _localctx, predIndex );
        }
        return true;
    }

    private boolean expr_sempred( ExprContext _localctx, int predIndex )
    {
        switch ( predIndex )
        {
            case 0:
                return precpred( _ctx, 11 );

            case 1:
                return precpred( _ctx, 10 );

            case 2:
                return precpred( _ctx, 9 );

            case 3:
                return precpred( _ctx, 7 );

            case 4:
                return precpred( _ctx, 6 );
        }
        return true;
    }

    public static final String _serializedATN =
        "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3$e\4\2\t\2\4\3\t\3" +
            "\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\6\2\21\n\2\r\2\16\2\22\3\2\3" +
            "\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3" +
            "\3\3\6\3)\n\3\r\3\16\3*\3\3\3\3\5\3/\n\3\5\3\61\n\3\3\4\3\4\3\4\6\4\66" +
            "\n\4\r\4\16\4\67\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5B\n\5\3\6\3\6\3\6" +
            "\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6O\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6" +
            "\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6`\n\6\f\6\16\6c\13\6\3\6\2\3\n\7\2" +
            "\4\6\b\n\2\5\3\2\17\20\3\2\21\22\3\2\26\33t\2\f\3\2\2\2\4\60\3\2\2\2\6" +
            "\62\3\2\2\2\bA\3\2\2\2\nN\3\2\2\2\f\r\7\3\2\2\r\16\7\37\2\2\16\20\7\4" +
            "\2\2\17\21\5\4\3\2\20\17\3\2\2\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3\2" +
            "\2\2\23\24\3\2\2\2\24\25\7\b\2\2\25\3\3\2\2\2\26\27\7\37\2\2\27\30\7\6" +
            "\2\2\30\31\7!\2\2\31\61\5\b\5\2\32\33\7\37\2\2\33\34\7\6\2\2\34\35\7!" +
            "\2\2\35\36\5\b\5\2\36\37\7\7\2\2\37 \5\n\6\2 !\7\5\2\2!\61\3\2\2\2\"#" +
            "\7\35\2\2#$\7\7\2\2$%\5\n\6\2%&\7\5\2\2&(\7\4\2\2\')\5\4\3\2(\'\3\2\2" +
            "\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+,\3\2\2\2,.\7\b\2\2-/\5\6\4\2.-\3\2\2" +
            "\2./\3\2\2\2/\61\3\2\2\2\60\26\3\2\2\2\60\32\3\2\2\2\60\"\3\2\2\2\61\5" +
            "\3\2\2\2\62\63\7\36\2\2\63\65\7\4\2\2\64\66\5\4\3\2\65\64\3\2\2\2\66\67" +
            "\3\2\2\2\67\65\3\2\2\2\678\3\2\2\289\3\2\2\29:\7\b\2\2:\7\3\2\2\2;B\7" +
            "\t\2\2<B\7\n\2\2=B\7\13\2\2>B\7\f\2\2?B\7\r\2\2@B\7\16\2\2A;\3\2\2\2A" +
            "<\3\2\2\2A=\3\2\2\2A>\3\2\2\2A?\3\2\2\2A@\3\2\2\2B\t\3\2\2\2CD\b\6\1\2" +
            "DE\7\23\2\2EO\5\n\6\nFG\7\7\2\2GH\5\n\6\2HI\7\5\2\2IO\3\2\2\2JO\7\34\2" +
            "\2KO\7 \2\2LO\7!\2\2MO\7\37\2\2NC\3\2\2\2NF\3\2\2\2NJ\3\2\2\2NK\3\2\2" +
            "\2NL\3\2\2\2NM\3\2\2\2Oa\3\2\2\2PQ\f\r\2\2QR\t\2\2\2R`\5\n\6\16ST\f\f" +
            "\2\2TU\t\3\2\2U`\5\n\6\rVW\f\13\2\2WX\t\4\2\2X`\5\n\6\fYZ\f\t\2\2Z[\7" +
            "\24\2\2[`\5\n\6\n\\]\f\b\2\2]^\7\25\2\2^`\5\n\6\t_P\3\2\2\2_S\3\2\2\2" +
            "_V\3\2\2\2_Y\3\2\2\2_\\\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\13\3\2" +
            "\2\2ca\3\2\2\2\13\22*.\60\67AN_a";

    public static final ATN _ATN = new ATNDeserializer().deserialize( _serializedATN.toCharArray() );

    static
    {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for ( int i = 0; i < _ATN.getNumberOfDecisions(); i++ )
        {
            _decisionToDFA[i] = new DFA( _ATN.getDecisionState( i ), i );
        }
    }
}