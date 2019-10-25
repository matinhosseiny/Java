


package Let_exp;

import java.util.ArrayList;

import Let_exp.Lexer.*;

import Let_exp.Parser.*;

public class main {
	
	 public static void main(String[] args) {
		    String input = "let x=7 in let y=2 in let y=let x= -(x,1) in -(x,y) in -(-(x,8),y) ";

		    // Create tokens and print them
		    ArrayList<Token> tokens = Lexer.lex(input);
		    for (Token token : tokens)
		      System.out.println(token);
		   Lc_Exp test= Parser.parser(input);
		   System.out.println("test");
		   Env E=new Env();
		   
		   int res=value_of(test, E);
		   System.out.println(res);
		  }
	 
	 public static int value_of(Lc_Exp input,Env E)
	 {
		 switch(input.vaiableType){
			 case Let:
				 Lc_Exp idlet=input.getid();
				 String x=idlet.getvar();
				 int exp1=value_of(input.getexp1(),E);
				 environment t = new environment(x, exp1);
				 
				 E.Extendenv(t,E);
				 
				 return value_of(input.getexp2(),E);//TODO
				 
				 
			 case VAR:
				 return E.Applyenv(E, input.getvar());
				 
				
			 case NUMBER:
				 return input.getNum();
			 case Minus:
				 exp1=value_of(input.getexp1(),E);
				 int exp2=value_of(input.getexp2(),E);
				 return exp1-exp2;
			 default:
				 return 0;
			
				 
		 }	 
	 }
	
}
