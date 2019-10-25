package Let_exp;

import Let_exp.Lexer.Token;

public class Letexp extends Lc_Exp {
	public Lc_Exp identifier;
	private Lc_Exp exp1;
	private Lc_Exp exp2;

    public Letexp() {
        super.vaiableType = VaiableType.Let ;
    }

    public Letexp(Lc_Exp identifier,Lc_Exp exp1,Lc_Exp exp2) {
        this.identifier = identifier;
        this.exp1=exp1;
        this.exp2=exp2;
        super.vaiableType = VaiableType.Let;
    }
    public Lc_Exp getid()
    {
    	return identifier;
    }
    public Lc_Exp getexp1()
    {
    	return exp1;
    }
    public Lc_Exp getexp2()
    {
    	return exp2;
    }
}
