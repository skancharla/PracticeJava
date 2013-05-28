package org.lookout.interview;

import java.util.ArrayList;

public class Integer2Binary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int n=110;
		ArrayList<Integer> aList = new ArrayList<Integer>();
		while(n>0){
			aList.add(n&1);
			n=n>>1;
		}
		System.out.println("binary form of "+n+" is:");
    for (int i = aList.size()-1; i >=0 ; i--) {
		System.out.print(aList.get(i));
	}
	}

}
