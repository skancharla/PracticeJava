package org.lookout.interview;

public class FactorialZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n=1000;
		int count=0;
		for (int i = 5; i <= n; i=i+5) {
			//System.out.println("number evaluated is: "+i); 
			int j=i;
			 while(j%5==0){
				 count++;
				 j=j/5;
			 }
		}
      System.out.println("number of trailing zeroes in "+ n +" factorial is: "+count);
	}

}
