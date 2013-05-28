package org.lookout.interview;

public class BitMagic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 byte x=12;
		System.out.println("bit wise negation of "+ x + " is: "+ (~x));
		System.out.println("left shifted by 3: "+(x<<3));
        System.out.println("binary representation of" +x+"is:"+Integer.toBinaryString(x));
	}

}
