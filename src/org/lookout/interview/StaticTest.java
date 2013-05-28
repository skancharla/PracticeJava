package org.lookout.interview;

public class StaticTest {
    static int x;
    int y;
    static{
    	x=x+1;
    	System.out.println("value of x in static block: "+x);
    }
    public StaticTest(int y){
    	this.y=y;
    }
    {
    	y=y+4;
    	System.out.println("value of y in instance block: "+y);
    }
   
    
    public void printVariables(){
    	System.out.println("x is: "+x);
    	System.out.println("y is: "+y);
    }
	public static void main(String[] args) {
		new StaticTest(7).printVariables();
		new StaticTest(5).printVariables();

	}

}
