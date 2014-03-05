package org.uva.sea.ql.parser.jacc;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.BooleanLiteral;
import org.uva.sea.ql.ast.literal.IntegerLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;

public class QLLexer implements QLTokens {
	private static final Map<String, Integer> KEYWORDS;
	
	static {
		KEYWORDS = new HashMap<String, Integer>();
		
		KEYWORDS.put("true", BOOLEANLITERAL);
		KEYWORDS.put("false", BOOLEANLITERAL);
		KEYWORDS.put("form", FORM);
		KEYWORDS.put("if", IF);
		KEYWORDS.put("else", ELSE);
		KEYWORDS.put("integer", INTEGER);
		KEYWORDS.put("boolean", BOOLEAN);
		KEYWORDS.put("string", STRING);
		KEYWORDS.put("money", MONEY);
	}
	
	
	private int token;
	private int c = ' ';
	
	private ASTNode yylval;
	private final Reader input;

	public QLLexer(Reader input) {
		this.input = input;
		nextChar();
	}
	
	
	private void nextChar() {
		if (c >= 0) {
			try {
				
				c = input.read();
			}
			catch (IOException e) {
				c = -1;
			}
		}
		
	}
	
	public int nextToken() {
		boolean inCommentMultipleLines = false;
		boolean inCommentSingleLine = false; 
		for (;;) {
			if (inCommentMultipleLines) {
				while (c != '*' && c != -1) {
					nextChar();
				}
				if (c == '*') {
					nextChar();
					if (c == '/') {
						nextChar();
						inCommentMultipleLines = false;
					}
					continue;
				}
			}
			if(inCommentSingleLine){
				while(c != '\n'&& c != -1){
					nextChar();
				}
				if(c == '\n'){
					nextChar();
					inCommentSingleLine = false;
				}
				//if the comment is the last line (no \n)
				else if(c < 0)
				{
					return token = ENDINPUT;
				}
				continue;
			}
			
			while (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
				nextChar();
			}
			
			
			if (c < 0) {
				return token = ENDINPUT;
			}
			
			switch (c) {
			    case '/': {
			    	nextChar();
			    	if (c == '*') {
			    		inCommentMultipleLines = true;
			    		nextChar();
			    		continue;
			    	}
			    	else if(c == '/'){
			    		inCommentSingleLine = true;
			    		nextChar();
			    		continue;
			    	}
			    	return token = '/'; 
			    }
			    
			    case ':': nextChar(); return token = ':';
			    case ')': nextChar(); return token = ')';
			    case '(': nextChar(); return token = '(';
			    case '}': nextChar(); return token = '}';
			    case '{': nextChar(); return token = '{';
			    
			    case '*': {
			    	nextChar();
			    	if (inCommentMultipleLines && c == '/') {
			    		inCommentMultipleLines = false;
			    		nextChar();
			    		continue;
			    	}
			    	return token = '*';
			    }
			    case '+': nextChar(); return token = '+';
			    case '-': nextChar(); return token = '-';
			    
			    case '&': {
			    	nextChar(); 
			    	if  (c == '&') {
			    		nextChar();
			    		return token = AND;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
			    }
			    case '|': {
			    	nextChar(); 
			    	if  (c == '|') {
			    		nextChar();
			    		return token = OR;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
			    }
			    case '!': {
			    	nextChar();
			    	if(c == '='){
			    		nextChar();
			    		return token = NEQ;
			    	}
			    	return token = '!';
			    }
			    
			    case '<': {
			    	nextChar();
			    	if (c == '=') {
			    		nextChar();
			    		return token = LEQ;
			    	}
			    	return token = '<';
			    }
			    case '=': { 
			    	nextChar(); 
			    	if  (c == '=') {
			    		nextChar();
			    		return token = EQ;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
			    }
			    
			    case '>': {
			    	nextChar();
			    	if (c == '=') {
			    		nextChar();
			    		return token = GEQ;
			    	}
			    	return token = '>';
			    }
			    
			    case '"':{
			    	nextChar();
			    	StringBuilder sb = new StringBuilder();
			    	while(c != '"'){
		    			sb.append((char)c);
		    			nextChar();
			    	}
			    	String name = sb.toString();
			    	yylval = new StringLiteral(name);
			    	nextChar();
			    	return token = STRINGLITERAL;
			    }
			   
			
			    default: {
			    	if (Character.isDigit(c)) {
			    		int n = 0; 
			    		do {
			    			n = 10 * n + (c - '0');
			    			nextChar(); 
			    		} while (Character.isDigit(c)); 
			    		yylval = new IntegerLiteral(n);
			    		return token = INTEGERLITERAL;
			    	}
			    	if (Character.isLetter(c)) {
			    		StringBuilder sb = new StringBuilder();
			    		do {
			    			sb.append((char)c);
			    			nextChar();
			    		}
			    		while (Character.isLetterOrDigit(c));
			    		String name = sb.toString();
			    		if(name.equals("true")){yylval = new BooleanLiteral(true);}
			    		if(name.equals("false")){yylval = new BooleanLiteral(false);}
			    		if (KEYWORDS.containsKey(name)) {
			    			return token = KEYWORDS.get(name);
			    		}
						yylval = new Identifier(name);
			    		return token = IDENTIFIER;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
			    }
			}
		}
	}

	
	public int getToken() {
		return token;
	}

	public ASTNode getSemantic() {
		return yylval;
	}



}
