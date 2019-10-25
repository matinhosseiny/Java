package Let_exp;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Lexer {
	
	
	  public static enum TokenType {
	    // Token types cannot have underscores
		  Integeri32("-?[0-9]+"), LPARN("[(]"),
		  Rparen("[)]"),
			Comma("[,]"),
			Minus("[-]"),
			Assign("[=]"),
			IsZero("Iszero"),
			Ifexp("if"),
			Thenexp("then"),
			Elseexp("else"),
			Letexp("let"),
			Inexp("in"),
			Identifier("-?[a-z]+"),WHITESPACE("[ \t\f\r\n]+");

	    public final String pattern;

	    private TokenType(String pattern) {
	      this.pattern = pattern;
	    }
	  }

	  public static class Token {
	    public TokenType type;
	    public String data;

	    public Token(TokenType type, String data) {
	      this.type = type;
	      this.data = data;
	    }

	    @Override
	    public String toString() {
	      return String.format("(%s %s)", type.name(), data);
	    }
	  }

	  public static ArrayList<Token> lex(String input) {
	    // The tokens to return
	    ArrayList<Token> tokens = new ArrayList<Token>();

	    // Lexer logic begins here
	    StringBuffer tokenPatternsBuffer = new StringBuffer();
	    for (TokenType tokenType : TokenType.values())
	      tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
	    Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

	    // Begin matching tokens
	    Matcher matcher = tokenPatterns.matcher(input);
	    while (matcher.find()) {
	      if (matcher.group(TokenType.Integeri32.name()) != null) {
	        tokens.add(new Token(TokenType.Integeri32, matcher.group(TokenType.Integeri32.name())));
	        continue;
	      } else if (matcher.group(TokenType.LPARN.name()) != null) {
	        tokens.add(new Token(TokenType.LPARN, matcher.group(TokenType.LPARN.name())));
	        continue;
	      } else if (matcher.group(TokenType.Rparen.name()) != null) {
		        tokens.add(new Token(TokenType.Rparen, matcher.group(TokenType.Rparen.name())));
		        continue;
	      }else if (matcher.group(TokenType.Minus.name()) != null) {
		        tokens.add(new Token(TokenType.Minus, matcher.group(TokenType.Minus.name())));
		        continue;
		  }else if (matcher.group(TokenType.Comma.name()) != null) {
			    tokens.add(new Token(TokenType.Comma, matcher.group(TokenType.Comma.name())));
			    continue;
		}else if (matcher.group(TokenType.Assign.name()) != null) {
		    tokens.add(new Token(TokenType.Assign, matcher.group(TokenType.Assign.name())));
		    continue;
	    }else if (matcher.group(TokenType.IsZero.name()) != null) {
	        tokens.add(new Token(TokenType.IsZero, matcher.group(TokenType.IsZero.name())));
	        continue;
        }
	    else if (matcher.group(TokenType.Ifexp.name()) != null) {
	        tokens.add(new Token(TokenType.Ifexp, matcher.group(TokenType.Ifexp.name())));
	        continue;
        }
	    else if (matcher.group(TokenType.Elseexp.name()) != null) {
	        tokens.add(new Token(TokenType.Elseexp, matcher.group(TokenType.Elseexp.name())));
	        continue;
        } else if (matcher.group(TokenType.Thenexp.name()) != null) {
	        tokens.add(new Token(TokenType.Thenexp, matcher.group(TokenType.Thenexp.name())));
	        continue;
        }
        else if (matcher.group(TokenType.Letexp.name()) != null) {
	        tokens.add(new Token(TokenType.Letexp, matcher.group(TokenType.Letexp.name())));
	        continue;
        }
        else if (matcher.group(TokenType.Inexp.name()) != null) {
	        tokens.add(new Token(TokenType.Inexp, matcher.group(TokenType.Inexp.name())));
	        continue;
        }
        else if (matcher.group(TokenType.Identifier.name()) != null) {
	        tokens.add(new Token(TokenType.Identifier, matcher.group(TokenType.Identifier.name())));
	        continue;
        }
	    else if (matcher.group(TokenType.WHITESPACE.name()) != null)
	        continue;
	    }

	    return tokens;
	  }


}
