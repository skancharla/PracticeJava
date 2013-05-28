
public class Solution {

	public int solution ( int[] A ) {
	       if(A==null){
	    	   System.out.println("array is null");
	    	   return -1;
	       }
	       if(A.length<1){
	    	   System.out.println("empty array");
	    	   return -1;
	       }
	       boolean[] bol=new boolean[A.length];
	       int len=A.length;
	       int jumps=0;
	       int i=0;
	       do{
	    	 if(bol[i]){
	    		 return -1;
	    	 }
	    	 bol[i]=true;  
	    	 i=i+A[i];
	    	 jumps++;
	       }while(i>=0 && i<len);
	       return jumps;
	  }
	
	
	

}
