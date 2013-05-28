import java.io.IOException;


public class PropagateException {
    public int stringLength(String input) throws SampleException{
    	if(input.length()<1){
    	throw new SampleException("Enter valid argument");
    	}
    	else
    		return input.length();
    }
    public void go(int num){
    	if(num<0)
    		throw new NumberFormatException();
    	else
    		System.out.println("number is valid");
    }
	
	public static void main(String[] args)  {
		PropagateException pe=new PropagateException();
		pe.go(-1);
      try {
		System.out.println(pe.stringLength("srimanth"));
	} catch (SampleException e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
      int i=5/0;
      System.out.println(i);
	}

}
