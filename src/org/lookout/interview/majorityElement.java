package org.lookout.interview;

public class majorityElement {

	public void majorityElement(int[] A){
		if(A==null || A.length==0){
			System.out.println("null or empty array");
			return;
		}
		if(A.length==1){
			System.out.println("no majority element");
			return;
		}
		int maj=A[0];
		int count=1;
		for (int i = 1; i < A.length; i++) {
			if(maj==A[i])
				count++;
			
			else
				count--;
		 if(count==0){
				maj=A[i];
				count=1;
			}
		}
		if(count==0){
			System.out.println("no majority element");
			return;
		}
		count=0;
		for (int i = 0; i < A.length; i++) {
			if(A[i]==maj)
				count++;
		}
		if(count<=A.length/2){
			System.out.println("no majority element");
			return;
		}
		
		System.out.println("majority element is: "+maj);
		
	}
	public static void main(String[] args) {
		int[] A={3,3,4,2,4,4,2,4,5};
		new majorityElement().majorityElement(A);

	}

}
