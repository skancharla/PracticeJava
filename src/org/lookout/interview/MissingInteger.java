package org.lookout.interview;

public class MissingInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A={1,2,3,4,6,5,8};
		int n=8;
		int xor1=0;
		int xor2=0;
		for (int i = 0; i < A.length; i++) {
			xor1^=A[i];
		}
		for (int i = 1; i <= n; i++) {
			xor2^=i;
		}
		
		System.out.println("missing element is: "+(xor1^xor2));

	}

}
