package org.epic.interview;


public class SubSumArray {

int[][] S; // bottom-up table with calculated values

public int[][] subSum(int[] list){
	int n=list.length;
	S=new int[n][n];
	//initialize S from list values
	for (int i = 0; i < n; i++) {
		S[i][i]=list[i];
	}
	//calculate the values by bottom up fashion
	for (int k = 1; k < n; k++) {
		int i=0;
		int j=i+k;
		while(j<n && i<j){
		 if(i!=j)
			S[i][j]=S[i][i]+S[i+1][j];
		 i=i+1;
		 j=i+k;
		}
	}
	return S;
}
	public static void main(String[] args) {
		int[] list={-1,-7,-6,-3,-5,-8,-9}; //input array
		int total=22;
        int[][] S=new SubSumArray().subSum(list);
        int length=0;
        int start=0;
        int end=0;
        //iterate to look for given total
        for (int i = 0; i < S.length; i++) {
			for (int j = 0; j < S.length; j++) {
				if(S[i][j]==total){
					if(j-i+1>length){
						length=j-i+1;
						start=i;
						end=j;
					}
				}
			}
		}
        //print the longest sub sequence
        for (int i = start; i <=end; i++) {
			System.out.print(list[i]+"  ");
		}
	}

}
