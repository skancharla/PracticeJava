package org.epic.interview;

public class CoinChangeDp {
    /*holds min coins */ 
	int [] C;
	/*parent pointer*/
     int [] S;
     int[] V;
     int n;
     public CoinChangeDp(int[] V , int n){
    	 this.n=n;
    	 this.V=V;
    	 C=new int[n+1];
    	 S=new int[n+1];
     }
     
     public void calMinCoins(){
    	 //initialize
    	 C[0]=0;
    	 S[0]=-1;
    	 //main for loop
    	 for (int i = 1; i <= n; i++) {
			   int min=Integer.MAX_VALUE;
			   int index=-1;
			   for (int j = 0; j < V.length; j++) {
				      if(i>= V[j]){
				    	  if(1+C[i-V[j]]<= min){
				    		  min=1+C[i-V[j]];
				    		  index=j;
				    	  }
				      }
			}
			   C[i]=min;
			   S[i]=index;
		}
     }
     
     public void printCoins(){
    	 System.out.println("the min coins required for "+n+" cents is: "+C[n]);
    	 System.out.println("the denominations are: ");
    	 int i=n;
    	 while(i>=0 && S[i]>=0){
    		 System.out.println(V[S[i]]+" ");
    		 i=i-V[S[i]];
    	 }
     }
	
	public static void main(String[] args) {
		int n=11;
		int [] V={1,4,3};
      CoinChangeDp coinChange=new CoinChangeDp(V,n);
      coinChange.calMinCoins();
      coinChange.printCoins();
	}

}
