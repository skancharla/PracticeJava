package org.dotLoop;

import java.util.Stack;

public class Solution {

	public int solution ( String S ) {
	      if(S==null || S.length()==0 || S.length()==1){
	    	  System.out.println("String is either null or has insufficient length");
	    	  return 0;
	      }
	      Stack<Character> stack=new Stack<Character>();
	      int i=0;
	      do{
	    	 char ch=S.charAt(i);
	    	 if(ch=='(')
	    		 stack.push('(');
	    	 else if(ch==')'){
	    		 if(!stack.isEmpty()){
	    			 stack.pop();
	    		 }
	    		 else
	    			 return 0;
	    	 }
	    	 
	    	 else if(ch==' '){
	    		 i++;
	    		 continue;
	    	 }
	    	 else{
	    		 System.out.println("bad input");
	    		 return 0;
	    	 }
	    		 
	    	 i++;
	      }while(i<S.length());
	      
	      if(stack.isEmpty()){
	    	  return 1;
	      }
	      
	      return 0;
	      
	  }
	
	
	public static void main(String[] args) {
		
       String S1="(( )(( ))()  )";
       String S2="()*)()";
       System.out.println(new Solution().solution(S1));
	}

}
