package org.lookout.interview;

public class BitsinInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n=110;
		int count=0;
		int k=n;
		while(k>0){
			count++;
			k=k&(k-1);
		}
		
		System.out.println("number of set bits in "+n+" are: "+count);
		

	}

}
