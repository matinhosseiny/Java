package Let_exp;

public class Minus extends Lc_Exp {
	
	private Lc_Exp exp1;
	private Lc_Exp exp2;

    public Minus() {
        super.vaiableType = VaiableType.Minus ;
    }

    public Minus(Lc_Exp exp1,Lc_Exp exp2) {
        
        this.exp1=exp1;
        this.exp2=exp2;
        super.vaiableType = VaiableType.Minus;
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
