package Let_exp;

import java.util.ArrayList;

import Let_exp.Lexer.Token;
import Let_exp.Lexer.TokenType;
import Let_exp.Var_exp;
import Let_exp.Num_exp;
import Let_exp.Letexp;


public class Parser {
	
	  
	 public static int i=0;
	 public static Lc_Exp parser(String input) {
		 ArrayList<Token> tokens = Lexer.lex(input);
		 for (Token token : tokens)
		      System.out.println(token);
		 
		 //tokens.listIterator().next()
		
		 System.out.println(tokens.get(i).toString());
		 return parse_exp(tokens);
	 }
	 public static Lc_Exp parse_exp(ArrayList<Token> tokens){
		 switch(tokens.get(i).type)
		 {
		 case Letexp:
		 {
			 return parse_let_exp(tokens);
			 
		 }
		 case Identifier:
		 {
			 return parse_var(tokens);
			 
		 }
		 case Integeri32:
		 {
			 return parse_integer(tokens);
			 
		 }
		 case Minus:
		 {
			 return parse_Minus_exp(tokens);
			 
		 }
		 default: System.out.println(tokens.get(i).toString());
         break;
		 }
		 return new Num_exp();//change it
		 
	 }
	 public static Lc_Exp parse_let_exp(ArrayList<Token> tokens) {
		 parse_let(tokens);
		 Lc_Exp x=parse_var(tokens);
		 parse_assign(tokens);
		 Lc_Exp exp1=parse_exp(tokens);
		 parse_in(tokens);
		 Lc_Exp exp2=parse_exp(tokens);
		return new Letexp(x,exp1,exp2);
		 
		 
	 }	 
	 public static Lc_Exp parse_Minus_exp(ArrayList<Token> tokens) {
		 parse_minus(tokens);
		 parse_Lparen(tokens);
		 Lc_Exp exp1=parse_exp(tokens);
		 parse_comma(tokens);
		 Lc_Exp exp2=parse_exp(tokens);
		 parse_Rparen(tokens);
		return new Minus(exp1,exp2);
		 
		 
	 }	
	 public static void parse_let(ArrayList<Token> tokens) {
		 if (tokens.get(i).type != TokenType.Letexp)
		 {
			 System.out.println("error in parser: Let 38");
			 System.exit(1);
		 }else{i++;
		 
		 }
		 
		 
		 
	 }	
	 public static Lc_Exp parse_var(ArrayList<Token> tokens) {
		 if (tokens.get(i).type != TokenType.Identifier)
		 {
			 System.out.println("error in parser: var 46");
			 System.exit(1);
		 }else{
			 i++;}
		 
		 return new Var_exp(tokens.get(i-1));
	 }
	 
	public static void parse_assign(ArrayList<Token> tokens) {
		 if (tokens.get(i).type != TokenType.Assign)
		 {
			 System.out.println("error in parser: assign 55");
			 System.exit(1);
		 }else{i++;}
		 
		 
	 }
	public static void parse_Lparen(ArrayList<Token> tokens) {
		 if (tokens.get(i).type != TokenType.LPARN)
		 {
			 System.out.println("error in parser: LParn 55");
			 System.exit(1);
		 }else{i++;}
		 
		 
	 }
	public static void parse_Rparen(ArrayList<Token> tokens) {
		 if (tokens.get(i).type != TokenType.Rparen)
		 {
			 System.out.println("error in parser: Rparen 55");
			 System.exit(1);
		 }else{i++;}
		 
		 
	 }
	public static void parse_comma(ArrayList<Token> tokens) {
		 if (tokens.get(i).type != TokenType.Comma)
		 {
			 System.out.println("error in parser: Comma 55");
			 System.exit(1);
		 }else{i++;}
		 
		 
	 }
	 public static void parse_in(ArrayList<Token> tokens) {
		 if (tokens.get(i).type != TokenType.Inexp)
		 {
			 System.out.println("error in parser: Inexp 55");
			 System.exit(1);
		 }else{i++;}
		 
		 
	 }
	 public static void parse_minus(ArrayList<Token> tokens) {
		 if (tokens.get(i).type != TokenType.Minus)
		 {
			 System.out.println(tokens.get(i).type);
			 System.exit(1);
		 }else{i++;}
		 
		 
	 }
	 public static Lc_Exp parse_integer(ArrayList<Token> tokens) {
		 if (tokens.get(i).type != TokenType.Integeri32)
		 {
			 System.out.println("error in parser: integer 84");
			 System.exit(1);
		 }else{i++;}
		 return new Num_exp(tokens.get(i-1));
		 
	 }

}
