package org.epic.interview;

public class MaxSubArray {
  /*array to store the totals up to that index*/
	int[] S;
	/*array to hold the starting index */
	int[] startList;
	int[] inputList;
	
	public MaxSubArray(int [] inputList){
		S=new int[inputList.length];
		startList=new int[inputList.length];
		this.inputList=inputList;
	}
	
	public void calMaxSubArray(){
		int n=inputList.length;
		//initialize the values
		S[0]=inputList[0];
		startList[0]=0;
		
		//main for loop
		for (int i = 1; i < n; i++) {
			 if(S[i-1]+inputList[i] > inputList[i]){
				 S[i]=S[i-1]+inputList[i];
				 startList[i]=startList[i-1];
			 } 
			 else{
				 S[i]=inputList[i];
				 startList[i]=i;
			 }
		}
	}
	
	public void printMaxSubArray(){
		   int maxSum=Integer.MIN_VALUE;
		   int maxIndex=-1;
		   //scan S for the max total
		for (int i = 0; i < S.length; i++) {
			if(S[i]>maxSum){
				maxSum=S[i];
				maxIndex=i;
			}
		}
		System.out.println("max sum is: "+maxSum);
		System.out.println("the max sub array is:");
		for (int i = startList[maxIndex]; i <= maxIndex; i++) {
			System.out.print(inputList[i]+"  ");
		}
	}
	public static void main(String[] args) {
      int[] inputlist1={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
      int[] inputlist2={-1,-2,-3,-4,-5};
      MaxSubArray maxSub=new MaxSubArray(inputlist2);
      maxSub.calMaxSubArray();
      maxSub.printMaxSubArray();

	}

}
