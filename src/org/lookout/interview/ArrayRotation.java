package org.lookout.interview;

public class ArrayRotation {

	public static int getRotationPoint(int[] A, int p,int q){
		       if(A[p]>=A[q] && q==p+1){
		    	   return p;
		       }
		       int a=0;
		       int b=1;
		       while((int)Math.pow(2, b)-1+p <=q){
		    	   int k=(int)Math.pow(2, a)-1+p;
		    	   int m=(int)Math.pow(2, b)-1+p;
		    	   if(A[k]>=A[m])
		    		   return getRotationPoint(A,k,m);
		    	   a=b;
		    	   b=b+1;
		       }
		       if(Math.pow(2, b)-1>p+q && Math.pow(2, b-1)-1+p<q){
		    	   return getRotationPoint(A,(int)Math.pow(2, b-1)-1+p,q);
		       }
		       return -1;
	}
	public static int mBSearch(int[] A,int p,int q,int x){
		     int pr=getRotationPoint(A,p,q);
		     
		     if(pr==-1){
		    	System.out.println("no point of rotation");
		    	 return gBSearch(A,p,q,x);
		     }
		     System.out.println("point of rotation is: "+pr);
		     if(A[pr]==x)
		    	 return pr;
		     if(x>=A[p] && x<A[pr])
		    	 return gBSearch(A,p,pr-1,x);
		     if(x>=A[pr+1] && x<=A[q])
		    	 return gBSearch(A,pr+1,q,x);
		     return -1;
	}
	public static int gBSearch(int[] A,int p,int q,int x){
		    if(p==q){
		    	if(A[p]==x)
		    		return p;
		    }
		    
		    	int k=(p+q)/2;
		    	if(A[k]==x)
		    		return k;
		    	 if(x<A[k])
		    		return gBSearch(A,p,k-1,x);
		    	if(x>A[k])
		    		return gBSearch(A,k+1,q,x);
		    	
		 return -1;
		    
		    
	}
	
	public static int rotatedSearch(int[] A ,int x){
		int p=0;
		int q=A.length-1;
		while(p<q){
			int r=(p+q)/2;
			if(A[r]==x)
				return r;
			else if(x<A[r]){
				if(x>=A[p])
					q=r-1;
				else
					p=r+1;
			}
			else{
				if(x<=A[q])
					p=r+1;
				else
					q=r-1;
			}
		}
		
		if(A[p]==x)
			return p;
		
		return -1;
		
	}
	public static void main(String[] args) {
		int[] A={6,7,8,9,10,1,2,3,4,5};
		int [] A1={3,3,4,5,5,1,1,2};
      // int index=mBSearch(A,0,A.length-1,2);
       int index=rotatedSearch(A1,4 );
       if(index==-1)
    	   System.out.println("element not found");
       else
    	   System.out.println("index of the element is: "+index);
	}

}
