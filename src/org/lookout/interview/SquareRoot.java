package org.lookout.interview;

public class SquareRoot {
    public static int getSquareRoot(int n){
    	if(n>=1 && n<=3){
    		return 1;
    	}   
    	int low=1;
    	   int high=n/2;
    	   while(low<high){
    		   int mid=(low+high)/2;
    		   if(mid*mid==n)
    			   return mid;
    		   else if(mid*mid<n)
    			   low=mid+1;
    		   else
    			   high=mid-1;
    	   }
    	   if(low*low<=n)
    		   return low;
    	   else
    		   return low-1;
    }
	
	public static void main(String[] args) {
	int n=101;
	System.out.println("rounded square root of "+n+" is: "+getSquareRoot(n));

	}

}
