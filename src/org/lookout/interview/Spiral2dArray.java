package org.lookout.interview;

public class Spiral2dArray {


	public static void main(String[] args) {
      int[][] input={{4,8,11,33},{1,18,7,22},{13,14,15,16},{3,28,17,44},{77,38,41,37}};
      int u=0;
      int d=input.length-1;
      int l=0;
      int r=input[u].length-1;
      while(u<=d && l<=r){
    	   if(u<=d){
    		   int j=l;
    		   while(j<=r){
    			   System.out.print(input[u][j]+" ");
    			   j++;
    		   }
    		   u++;
    	   }
    	   
    	   if(r>=l){
    		   int i=u;
    		   while(i<=d){
    			   System.out.print(input[i][r]+" ");
    		       i++;
    		   }
    		   r--;
    	   }
    	   
    	   if(d>=u){
    		   int j=r;
    		   while(j>=l){
    			   System.out.print(input[d][j]+" ");
    			   j--;
    		   }
    		   d--;
    	   }
    	   if(l<=r){
    		   int i=d;
    		   while(i>=u){
    			   System.out.print(input[i][l]+" ");
    			   i--;
    		   }
    		   l++;
    	   }
      }

	}

}
