package Let_exp;

public class environment {

	
	    int value1;
	    String variable1;

	    environment(String v1,int v2) {
	        value1 = v2;
	        variable1 = v1;
	    }
	    
	    public String getvar()
	    {
	    	return variable1;
	    }
	    public int getval()
	    {
	    	return value1;
	    }
	
	
}
