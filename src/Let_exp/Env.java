package Let_exp;

import java.util.ArrayList;

public class Env {
	public ArrayList<environment> env = new ArrayList<environment>();
	Env(){
	}
	
	public Env empty_env()
	{ 	ArrayList<environment> env = new ArrayList<environment>();
		return null;
	}
	
	public Env Extendenv(environment E,Env x)
	{
		x.env.add(E);
		
		return x;
	}
	public int Applyenv(Env x,String var)
	{
		if (x.env.isEmpty())
			{System.out.println("error unknown variable");
			return 0;
			}
		else{
		for (int i=x.env.size()-1;i>=0;i--)
		 {
			 String m=x.env.get(i).getvar();
			 
			 if (m.equals(var))
					 {
				 		return x.env.get(i).getval();
					 }
		 }
		}
		System.out.println("error unknown variable");
		return 0;
	}
	

}
