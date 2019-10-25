package Let_exp;

import Let_exp.Lexer.Token;

public class Num_exp extends Lc_Exp{
	 private Token identifier;

	    public Num_exp() {
	        super.vaiableType = VaiableType.NUMBER ;
	    }

	    public Num_exp(Token identifier) {
	        this.identifier = identifier;
	        super.vaiableType = VaiableType.NUMBER;
	    }
	    public int getNum()
	    {
	    	return Integer.parseUnsignedInt(identifier.data);
	    }
}
