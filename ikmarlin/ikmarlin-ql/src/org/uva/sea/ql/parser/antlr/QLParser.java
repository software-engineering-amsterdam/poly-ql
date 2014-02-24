// $ANTLR 3.4 C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2014-02-23 16:20:24

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stmt.*;
import org.uva.sea.ql.ast.form.*;
import antlr.ANTLRException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "Decimal", "Ident", "Int", "MLCOMMENT", "SLComment", "Str", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'decimal'", "'form'", "'if'", "'integer'", "'money'", "'string'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int Bool=4;
    public static final int Decimal=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int MLCOMMENT=8;
    public static final int SLComment=9;
    public static final int Str=10;
    public static final int WS=11;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public QLParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }


    	private ArrayList<String> errors = new ArrayList <String> ();
    	 
    	public List<String> getAllErrors() {
    	  return new ArrayList<String>(errors);
    	}
    	
    	public boolean hasErrors() {
    	  return !errors.isEmpty();
    	}
    	 
    	public void reportError(RecognitionException e) {
    		if ( state.errorRecovery ) {
    		  return;
    		}
    		state.syntaxErrors++;
    		state.errorRecovery = true;
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
    		msg = null;
    		if ( e instanceof NoViableAltException ) {
    			NoViableAltException nvae = (NoViableAltException)e;
    			msg = " unexpected token: '"+e.token.getText()+"'";
    		} else {
    			msg = getErrorMessage(e, tokenNames);
    		}
        errors.add(hdr+msg);
    	}



    // $ANTLR start "primary"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:1: primary returns [Expr result] : ( Bool | Decimal | Int | Str | Ident );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Bool1=null;
        Token Decimal2=null;
        Token Int3=null;
        Token Str4=null;
        Token Ident5=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:49:5: ( Bool | Decimal | Int | Str | Ident )
            int alt1=5;
            switch ( input.LA(1) ) {
            case Bool:
                {
                alt1=1;
                }
                break;
            case Decimal:
                {
                alt1=2;
                }
                break;
            case Int:
                {
                alt1=3;
                }
                break;
            case Str:
                {
                alt1=4;
                }
                break;
            case Ident:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:49:7: Bool
                    {
                    Bool1=(Token)match(input,Bool,FOLLOW_Bool_in_primary64); 


                            if((Bool1!=null?Bool1.getText():null).equals("true")){
                              result = new Bool(true);
                            }else{
                              result = new Bool(false);
                            }
                          

                    }
                    break;
                case 2 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:7: Decimal
                    {
                    Decimal2=(Token)match(input,Decimal,FOLLOW_Decimal_in_primary74); 

                    result = new Decimal(Float.parseFloat((Decimal2!=null?Decimal2.getText():null)));

                    }
                    break;
                case 3 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:7: Int
                    {
                    Int3=(Token)match(input,Int,FOLLOW_Int_in_primary84); 

                    result = new Int(Integer.parseInt((Int3!=null?Int3.getText():null)));

                    }
                    break;
                case 4 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:7: Str
                    {
                    Str4=(Token)match(input,Str,FOLLOW_Str_in_primary94); 

                    result = new Str((Str4!=null?Str4.getText():null));

                    }
                    break;
                case 5 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:7: Ident
                    {
                    Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_primary104); 

                    result = new Ident((Ident5!=null?Ident5.getText():null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:62:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt2=1;
                }
                break;
            case 19:
                {
                alt2=2;
                }
                break;
            case 12:
                {
                alt2=3;
                }
                break;
            case Bool:
            case Decimal:
            case Ident:
            case Int:
            case Str:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:8: '+' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr132); 

                    pushFollow(FOLLOW_unExpr_in_unExpr136);
                    x=unExpr();

                    state._fsp--;


                     result = new Pos(x); 

                    }
                    break;
                case 2 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:8: '-' x= unExpr
                    {
                    match(input,19,FOLLOW_19_in_unExpr147); 

                    pushFollow(FOLLOW_unExpr_in_unExpr151);
                    x=unExpr();

                    state._fsp--;


                     result = new Neg(x); 

                    }
                    break;
                case 3 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:65:8: '!' x= unExpr
                    {
                    match(input,12,FOLLOW_12_in_unExpr162); 

                    pushFollow(FOLLOW_unExpr_in_unExpr166);
                    x=unExpr();

                    state._fsp--;


                     result = new Not(x); 

                    }
                    break;
                case 4 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr179);
                    x=primary();

                    state._fsp--;


                     result = x; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:69:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr217);
            lhs=unExpr();

            state._fsp--;


             result =lhs; 

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17||LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==17||input.LA(1)==20 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr237);
            	    rhs=unExpr();

            	    state._fsp--;


            	     
            	          if ((op!=null?op.getText():null).equals("*")) {
            	            result = new Mul(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("/")) {
            	            result = new Div(result, rhs);      
            	          }
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:81:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr275);
            lhs=mulExpr();

            state._fsp--;


             result =lhs; 

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= 18 && LA4_0 <= 19)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 18 && input.LA(1) <= 19) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr293);
            	    rhs=mulExpr();

            	    state._fsp--;


            	     
            	          if ((op!=null?op.getText():null).equals("+")) {
            	            result = new Add(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("-")) {
            	            result = new Sub(result, rhs);      
            	          }
            	        

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr328);
            lhs=addExpr();

            state._fsp--;


             result =lhs; 

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13||(LA5_0 >= 22 && LA5_0 <= 26)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==13||(input.LA(1) >= 22 && input.LA(1) <= 26) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr352);
            	    rhs=addExpr();

            	    state._fsp--;


            	     
            	          if ((op!=null?op.getText():null).equals("<")) {
            	            result = new LT(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("<=")) {
            	            result = new LEq(result, rhs);      
            	          }
            	          if ((op!=null?op.getText():null).equals(">")) {
            	            result = new GT(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals(">=")) {
            	            result = new GEq(result, rhs);      
            	          }
            	          if ((op!=null?op.getText():null).equals("==")) {
            	            result = new Eq(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("!=")) {
            	            result = new NEq(result, rhs);
            	          }
            	        

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr390);
            lhs=relExpr();

            state._fsp--;


             result =lhs; 

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:46: ( '&&' rhs= relExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:48: '&&' rhs= relExpr
            	    {
            	    match(input,14,FOLLOW_14_in_andExpr396); 

            	    pushFollow(FOLLOW_relExpr_in_andExpr400);
            	    rhs=relExpr();

            	    state._fsp--;


            	     result = new And(result, rhs); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:121:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:122:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:122:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr434);
            lhs=andExpr();

            state._fsp--;


             result = lhs; 

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:122:48: ( '||' rhs= andExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==35) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:122:50: '||' rhs= andExpr
            	    {
            	    match(input,35,FOLLOW_35_in_orExpr440); 

            	    pushFollow(FOLLOW_andExpr_in_orExpr444);
            	    rhs=andExpr();

            	    state._fsp--;


            	     result = new Or(result, rhs); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "orExpr"



    // $ANTLR start "type"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:125:1: type returns [Expr result] : ( 'boolean' | 'string' | 'integer' | 'decimal' | 'money' );
    public final Expr type() throws RecognitionException {
        Expr result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:5: ( 'boolean' | 'string' | 'integer' | 'decimal' | 'money' )
            int alt8=5;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt8=1;
                }
                break;
            case 33:
                {
                alt8=2;
                }
                break;
            case 31:
                {
                alt8=3;
                }
                break;
            case 28:
                {
                alt8=4;
                }
                break;
            case 32:
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:7: 'boolean'
                    {
                    match(input,27,FOLLOW_27_in_type474); 

                    result = new Bool(false); 

                    }
                    break;
                case 2 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:127:7: 'string'
                    {
                    match(input,33,FOLLOW_33_in_type484); 

                    result = new Str(""); 

                    }
                    break;
                case 3 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:7: 'integer'
                    {
                    match(input,31,FOLLOW_31_in_type494); 

                    result = new Int(0); 

                    }
                    break;
                case 4 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:130:7: 'decimal'
                    {
                    match(input,28,FOLLOW_28_in_type505); 

                    result = new Decimal(Float.parseFloat("0")); 

                    }
                    break;
                case 5 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:131:7: 'money'
                    {
                    match(input,32,FOLLOW_32_in_type515); 

                    result = new Money(Float.parseFloat("0.00")); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "stmt"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:134:1: stmt returns [Stmt result] : ( computedQuestion | answerableQuestion | conditionalQestion );
    public final Stmt stmt() throws RecognitionException {
        Stmt result = null;

        int stmt_StartIndex = input.index();

        Stmt computedQuestion6 =null;

        Stmt answerableQuestion7 =null;

        Stmt conditionalQestion8 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:135:5: ( computedQuestion | answerableQuestion | conditionalQestion )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Ident) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==21) ) {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==Str) ) {
                        switch ( input.LA(4) ) {
                        case 27:
                            {
                            int LA9_5 = input.LA(5);

                            if ( (LA9_5==15) ) {
                                alt9=1;
                            }
                            else if ( (LA9_5==Ident||LA9_5==30||LA9_5==36) ) {
                                alt9=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 5, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 33:
                            {
                            int LA9_6 = input.LA(5);

                            if ( (LA9_6==15) ) {
                                alt9=1;
                            }
                            else if ( (LA9_6==Ident||LA9_6==30||LA9_6==36) ) {
                                alt9=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 6, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 31:
                            {
                            int LA9_7 = input.LA(5);

                            if ( (LA9_7==15) ) {
                                alt9=1;
                            }
                            else if ( (LA9_7==Ident||LA9_7==30||LA9_7==36) ) {
                                alt9=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 7, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 28:
                            {
                            int LA9_8 = input.LA(5);

                            if ( (LA9_8==15) ) {
                                alt9=1;
                            }
                            else if ( (LA9_8==Ident||LA9_8==30||LA9_8==36) ) {
                                alt9=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 8, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 32:
                            {
                            int LA9_9 = input.LA(5);

                            if ( (LA9_9==15) ) {
                                alt9=1;
                            }
                            else if ( (LA9_9==Ident||LA9_9==30||LA9_9==36) ) {
                                alt9=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 9, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 4, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA9_0==30) ) {
                alt9=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:135:7: computedQuestion
                    {
                    pushFollow(FOLLOW_computedQuestion_in_stmt542);
                    computedQuestion6=computedQuestion();

                    state._fsp--;


                     result = computedQuestion6; 

                    }
                    break;
                case 2 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:7: answerableQuestion
                    {
                    pushFollow(FOLLOW_answerableQuestion_in_stmt552);
                    answerableQuestion7=answerableQuestion();

                    state._fsp--;


                     result = answerableQuestion7; 

                    }
                    break;
                case 3 :
                    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:7: conditionalQestion
                    {
                    pushFollow(FOLLOW_conditionalQestion_in_stmt562);
                    conditionalQestion8=conditionalQestion();

                    state._fsp--;


                     result = conditionalQestion8; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "stmt"



    // $ANTLR start "conditionalQestion"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:140:1: conditionalQestion returns [Stmt result] : 'if' '(' condition= orExpr ')' '{' block '}' ;
    public final Stmt conditionalQestion() throws RecognitionException {
        Stmt result = null;

        int conditionalQestion_StartIndex = input.index();

        Expr condition =null;

        Block block9 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:5: ( 'if' '(' condition= orExpr ')' '{' block '}' )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:7: 'if' '(' condition= orExpr ')' '{' block '}'
            {
            match(input,30,FOLLOW_30_in_conditionalQestion589); 

            match(input,15,FOLLOW_15_in_conditionalQestion591); 

            pushFollow(FOLLOW_orExpr_in_conditionalQestion595);
            condition=orExpr();

            state._fsp--;


            match(input,16,FOLLOW_16_in_conditionalQestion597); 

            match(input,34,FOLLOW_34_in_conditionalQestion599); 

            pushFollow(FOLLOW_block_in_conditionalQestion601);
            block9=block();

            state._fsp--;


            match(input,36,FOLLOW_36_in_conditionalQestion603); 

             result = new ConditionalQuestion(condition, block9); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "conditionalQestion"



    // $ANTLR start "computedQuestion"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:1: computedQuestion returns [Stmt result] : Ident ':' Str type '(' computation= orExpr ')' ;
    public final Stmt computedQuestion() throws RecognitionException {
        Stmt result = null;

        int computedQuestion_StartIndex = input.index();

        Token Ident10=null;
        Token Str11=null;
        Expr computation =null;

        Expr type12 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:145:5: ( Ident ':' Str type '(' computation= orExpr ')' )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:145:7: Ident ':' Str type '(' computation= orExpr ')'
            {
            Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion630); 

            match(input,21,FOLLOW_21_in_computedQuestion632); 

            Str11=(Token)match(input,Str,FOLLOW_Str_in_computedQuestion634); 

            pushFollow(FOLLOW_type_in_computedQuestion636);
            type12=type();

            state._fsp--;


            match(input,15,FOLLOW_15_in_computedQuestion638); 

            pushFollow(FOLLOW_orExpr_in_computedQuestion644);
            computation=orExpr();

            state._fsp--;


            match(input,16,FOLLOW_16_in_computedQuestion646); 

             result = new ComputedQuestion(new Ident((Ident10!=null?Ident10.getText():null)), (Str11!=null?Str11.getText():null), type12, computation); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "computedQuestion"



    // $ANTLR start "answerableQuestion"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:1: answerableQuestion returns [Stmt result] : Ident ':' Str type ;
    public final Stmt answerableQuestion() throws RecognitionException {
        Stmt result = null;

        int answerableQuestion_StartIndex = input.index();

        Token Ident13=null;
        Token Str14=null;
        Expr type15 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:5: ( Ident ':' Str type )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:7: Ident ':' Str type
            {
            Ident13=(Token)match(input,Ident,FOLLOW_Ident_in_answerableQuestion673); 

            match(input,21,FOLLOW_21_in_answerableQuestion675); 

            Str14=(Token)match(input,Str,FOLLOW_Str_in_answerableQuestion677); 

            pushFollow(FOLLOW_type_in_answerableQuestion679);
            type15=type();

            state._fsp--;


             result = new AnswerableQuestion(new Ident((Ident13!=null?Ident13.getText():null)), (Str14!=null?Str14.getText():null), type15); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "answerableQuestion"



    // $ANTLR start "block"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:152:1: block returns [Block result] : ( stmt )* ;
    public final Block block() throws RecognitionException {
        Block result = null;

        int block_StartIndex = input.index();

        Stmt stmt16 =null;



              result = new Block();
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:157:5: ( ( stmt )* )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:157:7: ( stmt )*
            {
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:157:7: ( stmt )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Ident||LA10_0==30) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:157:8: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_block716);
            	    stmt16=stmt();

            	    state._fsp--;


            	     result.addStmt(stmt16); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "block"



    // $ANTLR start "form"
    // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:160:1: form returns [Form result] : 'form' Ident '{' block '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident17=null;
        Block block18 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:161:5: ( 'form' Ident '{' block '}' )
            // C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:161:7: 'form' Ident '{' block '}'
            {
            match(input,29,FOLLOW_29_in_form745); 

            Ident17=(Token)match(input,Ident,FOLLOW_Ident_in_form747); 

            match(input,34,FOLLOW_34_in_form749); 

            pushFollow(FOLLOW_block_in_form751);
            block18=block();

            state._fsp--;


            match(input,36,FOLLOW_36_in_form753); 

             result = new Form(new Ident((Ident17!=null?Ident17.getText():null)), block18); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "form"

    // Delegated rules


 

    public static final BitSet FOLLOW_Bool_in_primary64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Decimal_in_primary74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Str_in_primary94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr132 = new BitSet(new long[]{0x00000000000C14F0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unExpr147 = new BitSet(new long[]{0x00000000000C14F0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_unExpr162 = new BitSet(new long[]{0x00000000000C14F0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr217 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_set_in_mulExpr225 = new BitSet(new long[]{0x00000000000C14F0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr237 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr275 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_set_in_addExpr283 = new BitSet(new long[]{0x00000000000C14F0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr293 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr328 = new BitSet(new long[]{0x0000000007C02002L});
    public static final BitSet FOLLOW_set_in_relExpr336 = new BitSet(new long[]{0x00000000000C14F0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr352 = new BitSet(new long[]{0x0000000007C02002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr390 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_andExpr396 = new BitSet(new long[]{0x00000000000C14F0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr400 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr434 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_orExpr440 = new BitSet(new long[]{0x00000000000C14F0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr444 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_27_in_type474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_type494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_type505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_type515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computedQuestion_in_stmt542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_answerableQuestion_in_stmt552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalQestion_in_stmt562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_conditionalQestion589 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditionalQestion591 = new BitSet(new long[]{0x00000000000C14F0L});
    public static final BitSet FOLLOW_orExpr_in_conditionalQestion595 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_conditionalQestion597 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_conditionalQestion599 = new BitSet(new long[]{0x0000001040000040L});
    public static final BitSet FOLLOW_block_in_conditionalQestion601 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_conditionalQestion603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_computedQuestion630 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_computedQuestion632 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_Str_in_computedQuestion634 = new BitSet(new long[]{0x0000000398000000L});
    public static final BitSet FOLLOW_type_in_computedQuestion636 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_computedQuestion638 = new BitSet(new long[]{0x00000000000C14F0L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion644 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_computedQuestion646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_answerableQuestion673 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_answerableQuestion675 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_Str_in_answerableQuestion677 = new BitSet(new long[]{0x0000000398000000L});
    public static final BitSet FOLLOW_type_in_answerableQuestion679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stmt_in_block716 = new BitSet(new long[]{0x0000000040000042L});
    public static final BitSet FOLLOW_29_in_form745 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form747 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_form749 = new BitSet(new long[]{0x0000001040000040L});
    public static final BitSet FOLLOW_block_in_form751 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_form753 = new BitSet(new long[]{0x0000000000000002L});

}