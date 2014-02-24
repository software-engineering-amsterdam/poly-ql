// $ANTLR 3.5.1 C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g 2014-02-06 23:40:51

  package a.b.c;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SampleParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "COLONS", "COMMENT", 
		"IDENT", "INT", "MONEY", "WS", "'!'", "'!='", "'\"'", "'&&'", "'('", "')'", 
		"'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'form'", 
		"'if'", "'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__11=11;
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
	public static final int BOOLEAN=4;
	public static final int COLONS=5;
	public static final int COMMENT=6;
	public static final int IDENT=7;
	public static final int INT=8;
	public static final int MONEY=9;
	public static final int WS=10;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public SampleParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public SampleParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return SampleParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g"; }



	// $ANTLR start "rule"
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:17:1: rule : 'form' IDENT '{' form '}' ;
	public final void rule() throws RecognitionException {
		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:17:5: ( 'form' IDENT '{' form '}' )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:17:7: 'form' IDENT '{' form '}'
			{
			match(input,26,FOLLOW_26_in_rule40); 
			match(input,IDENT,FOLLOW_IDENT_in_rule42); 
			match(input,28,FOLLOW_28_in_rule44); 
			pushFollow(FOLLOW_form_in_rule46);
			form();
			state._fsp--;

			match(input,30,FOLLOW_30_in_rule48); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rule"



	// $ANTLR start "form"
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:18:1: form : ( statement )* ;
	public final void form() throws RecognitionException {
		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:18:5: ( ( statement )* )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:18:7: ( statement )*
			{
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:18:7: ( statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==IDENT||LA1_0==27) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:18:7: statement
					{
					pushFollow(FOLLOW_statement_in_form55);
					statement();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "form"



	// $ANTLR start "statement"
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:19:1: statement : ( question | if_block );
	public final void statement() throws RecognitionException {
		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:19:10: ( question | if_block )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==IDENT) ) {
				alt2=1;
			}
			else if ( (LA2_0==27) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:19:12: question
					{
					pushFollow(FOLLOW_question_in_statement62);
					question();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:19:23: if_block
					{
					pushFollow(FOLLOW_if_block_in_statement66);
					if_block();
					state._fsp--;

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
	}
	// $ANTLR end "statement"



	// $ANTLR start "question"
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:20:1: question : IDENT COLONS string ( type | type '(' expression ')' ) ;
	public final void question() throws RecognitionException {
		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:20:9: ( IDENT COLONS string ( type | type '(' expression ')' ) )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:20:11: IDENT COLONS string ( type | type '(' expression ')' )
			{
			match(input,IDENT,FOLLOW_IDENT_in_question72); 
			match(input,COLONS,FOLLOW_COLONS_in_question74); 
			pushFollow(FOLLOW_string_in_question76);
			string();
			state._fsp--;

			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:20:31: ( type | type '(' expression ')' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==BOOLEAN||LA3_0==MONEY) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==IDENT||LA3_1==27||LA3_1==30) ) {
					alt3=1;
				}
				else if ( (LA3_1==15) ) {
					alt3=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:20:32: type
					{
					pushFollow(FOLLOW_type_in_question79);
					type();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:20:39: type '(' expression ')'
					{
					pushFollow(FOLLOW_type_in_question83);
					type();
					state._fsp--;

					match(input,15,FOLLOW_15_in_question84); 
					pushFollow(FOLLOW_expression_in_question85);
					expression();
					state._fsp--;

					match(input,16,FOLLOW_16_in_question86); 
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "question"



	// $ANTLR start "string"
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:21:1: string : '\"' ( . )* '\"' ;
	public final void string() throws RecognitionException {
		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:21:7: ( '\"' ( . )* '\"' )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:21:9: '\"' ( . )* '\"'
			{
			match(input,13,FOLLOW_13_in_string94); 
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:21:13: ( . )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==13) ) {
					alt4=2;
				}
				else if ( ((LA4_0 >= BOOLEAN && LA4_0 <= 12)||(LA4_0 >= 14 && LA4_0 <= 30)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:21:13: .
					{
					matchAny(input); 
					}
					break;

				default :
					break loop4;
				}
			}

			match(input,13,FOLLOW_13_in_string99); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "string"



	// $ANTLR start "type"
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:22:1: type : ( BOOLEAN | MONEY );
	public final void type() throws RecognitionException {
		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:22:5: ( BOOLEAN | MONEY )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:
			{
			if ( input.LA(1)==BOOLEAN||input.LA(1)==MONEY ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"



	// $ANTLR start "if_block"
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:23:1: if_block : 'if' ( expression ) '{' ( statement )* '}' ;
	public final void if_block() throws RecognitionException {
		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:23:9: ( 'if' ( expression ) '{' ( statement )* '}' )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:23:11: 'if' ( expression ) '{' ( statement )* '}'
			{
			match(input,27,FOLLOW_27_in_if_block115); 
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:23:16: ( expression )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:23:17: expression
			{
			pushFollow(FOLLOW_expression_in_if_block118);
			expression();
			state._fsp--;

			}

			match(input,28,FOLLOW_28_in_if_block121); 
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:23:33: ( statement )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==IDENT||LA5_0==27) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:23:33: statement
					{
					pushFollow(FOLLOW_statement_in_if_block123);
					statement();
					state._fsp--;

					}
					break;

				default :
					break loop5;
				}
			}

			match(input,30,FOLLOW_30_in_if_block126); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "if_block"



	// $ANTLR start "expression"
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:24:1: expression : orExpr ;
	public final void expression() throws RecognitionException {
		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:24:11: ( orExpr )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:24:13: orExpr
			{
			pushFollow(FOLLOW_orExpr_in_expression132);
			orExpr();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "primary"
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:26:1: primary returns [Expr result] : ( INT | IDENT | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;


		Expr x =null;

		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:27:3: ( INT | IDENT | '(' x= orExpr ')' )
			int alt6=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt6=1;
				}
				break;
			case IDENT:
				{
				alt6=2;
				}
				break;
			case 15:
				{
				alt6=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:27:5: INT
					{
					match(input,INT,FOLLOW_INT_in_primary147); 
					 result = new Int(Integer.parseInt($Int.text)); 
					}
					break;
				case 2 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:28:5: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_primary157); 
					 result = new Ident($Ident.text); 
					}
					break;
				case 3 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:29:5: '(' x= orExpr ')'
					{
					match(input,15,FOLLOW_15_in_primary165); 
					pushFollow(FOLLOW_orExpr_in_primary169);
					x=orExpr();
					state._fsp--;

					match(input,16,FOLLOW_16_in_primary171); 
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
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:32:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;


		Expr x =null;

		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:33:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt7=4;
			switch ( input.LA(1) ) {
			case 18:
				{
				alt7=1;
				}
				break;
			case 19:
				{
				alt7=2;
				}
				break;
			case 11:
				{
				alt7=3;
				}
				break;
			case IDENT:
			case INT:
			case 15:
				{
				alt7=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:33:8: '+' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr196); 
					pushFollow(FOLLOW_unExpr_in_unExpr200);
					x=unExpr();
					state._fsp--;

					 result = new Pos(x); 
					}
					break;
				case 2 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:34:8: '-' x= unExpr
					{
					match(input,19,FOLLOW_19_in_unExpr211); 
					pushFollow(FOLLOW_unExpr_in_unExpr215);
					x=unExpr();
					state._fsp--;

					 result = new Neg(x); 
					}
					break;
				case 3 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:35:8: '!' x= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr226); 
					pushFollow(FOLLOW_unExpr_in_unExpr230);
					x=unExpr();
					state._fsp--;

					 result = new Not(x); 
					}
					break;
				case 4 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:36:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr243);
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
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:39:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:40:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:40:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr281);
			lhs=unExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:40:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==17||LA8_0==20) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:40:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==17||input.LA(1)==20 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr301);
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
					break loop8;
				}
			}

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
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:52:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:53:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:53:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr342);
			lhs=mulExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:53:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 18 && LA9_0 <= 19)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:53:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 18 && input.LA(1) <= 19) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr360);
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
					break loop9;
				}
			}

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
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:64:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:65:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:65:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr395);
			lhs=addExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:65:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==12||(LA10_0 >= 21 && LA10_0 <= 25)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:65:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==12||(input.LA(1) >= 21 && input.LA(1) <= 25) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr419);
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
					break loop10;
				}
			}

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
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:88:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:89:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:89:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr457);
			lhs=relExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:89:46: ( '&&' rhs= relExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==14) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:89:48: '&&' rhs= relExpr
					{
					match(input,14,FOLLOW_14_in_andExpr463); 
					pushFollow(FOLLOW_relExpr_in_andExpr467);
					rhs=relExpr();
					state._fsp--;

					 result = new And(result, rhs); 
					}
					break;

				default :
					break loop11;
				}
			}

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
	// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:93:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:94:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:94:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr502);
			lhs=andExpr();
			state._fsp--;

			 result = lhs; 
			// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:94:48: ( '||' rhs= andExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==29) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\George\\Desktop\\Construction\\ANTLR-First\\src\\a\\b\\c\\Sample.g:94:50: '||' rhs= andExpr
					{
					match(input,29,FOLLOW_29_in_orExpr508); 
					pushFollow(FOLLOW_andExpr_in_orExpr512);
					rhs=andExpr();
					state._fsp--;

					 result = new Or(result, rhs); 
					}
					break;

				default :
					break loop12;
				}
			}

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

	// Delegated rules



	public static final BitSet FOLLOW_26_in_rule40 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_IDENT_in_rule42 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_rule44 = new BitSet(new long[]{0x0000000048000080L});
	public static final BitSet FOLLOW_form_in_rule46 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_rule48 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_form55 = new BitSet(new long[]{0x0000000008000082L});
	public static final BitSet FOLLOW_question_in_statement62 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_block_in_statement66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_question72 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_COLONS_in_question74 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_string_in_question76 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_type_in_question79 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_question83 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_question84 = new BitSet(new long[]{0x00000000000C8980L});
	public static final BitSet FOLLOW_expression_in_question85 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_question86 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_string94 = new BitSet(new long[]{0x000000007FFFFFF0L});
	public static final BitSet FOLLOW_13_in_string99 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_if_block115 = new BitSet(new long[]{0x00000000000C8980L});
	public static final BitSet FOLLOW_expression_in_if_block118 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_if_block121 = new BitSet(new long[]{0x0000000048000080L});
	public static final BitSet FOLLOW_statement_in_if_block123 = new BitSet(new long[]{0x0000000048000080L});
	public static final BitSet FOLLOW_30_in_if_block126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orExpr_in_expression132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_primary147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_primary165 = new BitSet(new long[]{0x00000000000C8980L});
	public static final BitSet FOLLOW_orExpr_in_primary169 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_primary171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr196 = new BitSet(new long[]{0x00000000000C8980L});
	public static final BitSet FOLLOW_unExpr_in_unExpr200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_unExpr211 = new BitSet(new long[]{0x00000000000C8980L});
	public static final BitSet FOLLOW_unExpr_in_unExpr215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr226 = new BitSet(new long[]{0x00000000000C8980L});
	public static final BitSet FOLLOW_unExpr_in_unExpr230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr281 = new BitSet(new long[]{0x0000000000120002L});
	public static final BitSet FOLLOW_set_in_mulExpr289 = new BitSet(new long[]{0x00000000000C8980L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr301 = new BitSet(new long[]{0x0000000000120002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr342 = new BitSet(new long[]{0x00000000000C0002L});
	public static final BitSet FOLLOW_set_in_addExpr350 = new BitSet(new long[]{0x00000000000C8980L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr360 = new BitSet(new long[]{0x00000000000C0002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr395 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_set_in_relExpr403 = new BitSet(new long[]{0x00000000000C8980L});
	public static final BitSet FOLLOW_addExpr_in_relExpr419 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr457 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_andExpr463 = new BitSet(new long[]{0x00000000000C8980L});
	public static final BitSet FOLLOW_relExpr_in_andExpr467 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr502 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_orExpr508 = new BitSet(new long[]{0x00000000000C8980L});
	public static final BitSet FOLLOW_andExpr_in_orExpr512 = new BitSet(new long[]{0x0000000020000002L});
}
