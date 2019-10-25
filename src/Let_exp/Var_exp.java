package Let_exp;
import Let_exp.Lexer.Token;

public class Var_exp extends Lc_Exp {
    private Token identifier;

    public Var_exp() {
        super.vaiableType = VaiableType.VAR;
    }

    public Var_exp(Token identifier) {
        this.identifier = identifier;
        super.vaiableType = VaiableType.VAR;
    }
    public String getvar()
    {
    	return identifier.data;
    }
}
