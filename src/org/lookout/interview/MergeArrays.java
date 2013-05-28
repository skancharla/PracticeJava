package org.lookout.interview;

public class MergeArrays {

	public static void mergeArrays(int[] I1, int[] I2){
	              if(I1==null || I2==null){
	            	  System.out.println("one of the arrays is null");
	            	  return;
	              }	
	              if(I1.length<=I2.length){
	            	  System.out.println("inappropriate interview");
	            	  return ;
	              }
	              int p=0;
	              int q=0;
	              int r=0;
	              p=advance(I1,p);
	              while(p<I1.length && q<I1.length && r<I1.length){
	            	  if(I1[p]<=I2[q]){
	            		  I1[r]=I1[p];
	            		  if(p!=r)
	            			  I1[p]=-1;
	            		  p=advance(I1,p+1);
	            		  r++;
	            	  }
	            	  else{
	            		  I1[r]=I2[q];
	            		  q++;
	            		  r++;
	            	  }
	              }
	              if(q<I2.length && r<I1.length){
	            	  while(q<I2.length && r<I1.length){
	            		  I1[r]=I2[q];
	            		  q++;
	            		  r++;
	            	  }
	              }
	              
	              for (int i = 0; i < I1.length; i++) {
					System.out.print(I1[i]+" ");
				}
	}
	
	
	public static int advance(int[] I1 , int p){
		     while( p<I1.length && I1[p]==-1){
		    	 p++;
		     }
		     return p;
	}
	public static void main(String[] args) {
		int[] I1={2,-1,7,-1,-1,10,-1};
		int[] I2={5,8,12,14};
		mergeArrays(I1,I2);

	}

}
