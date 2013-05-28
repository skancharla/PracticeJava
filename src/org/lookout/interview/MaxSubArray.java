package org.lookout.interview;

public class MaxSubArray {
    public static void maxSubArray(int[] Q){
    	int A1=Integer.MIN_VALUE,A=0;
    	int s=0,s1=0;
    	int e=0,e1=0;
    	for (int i = 0; i < Q.length; i++) {
			 if(Q[i]>Q[i]+A){
				 A=Q[i];
				 s=i;
				 e=i;
			 }
			 else{
				 A=Q[i]+A;
				 e=i;
			 }
			 if(A>A1){
				 A1=A;
				 s1=s;
				 e1=e;
			 }
		}
    	System.out.println("the maximum subarray sum is: "+A1);
    	for (int i = s1; i <= e1; i++) {
			System.out.print(Q[i]+"  ");
		}
    	System.out.println();
    } 
	public static void main(String[] args) {
		int[] Q={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		int[] Q1={1,2,3,4,5,6,7,8,9,10};
		int[]Q2={-10,-9,-8,-7,-6,-5,-4,-3,-2,-1};
		int[] Q3={-40,1,40,-50,1,50,-20,1,20,0,0};
		maxSubArray(Q);
		maxSubArray(Q1);
		maxSubArray(Q2);
		maxSubArray(Q3);

	}

}
