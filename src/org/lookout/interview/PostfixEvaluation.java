package org.lookout.interview;

import java.util.Stack;

public class PostfixEvaluation {
    public static void evaluatePostfix(String input){
    	      char[] charArray=input.toCharArray();
    	      Stack<Character> S=new Stack<Character>();
    	      int i=0;
    	      do{
    	    	  if(isOperator(charArray[i])){
    	    	     if(S.size()<2){
    	    	    	 System.out.println("input error");
    	    	    	 return;
    	    	     }
    	    		  else{
    	    		  int a=S.pop()-'0';
    	    		  int b=S.pop()-'0';
    	    		  int c=evaluate(b,a,charArray[i]);
    	    		  char d=(char) (c+'0');
    	    		  S.push(d);
    	    		  i++;
    	    	  }
    	    	  }
    	    	  else{
    	    		  S.push(charArray[i]);
    	    		  i++;
    	    	  }
    	      }while(i<charArray.length);
    	      int k=S.pop()-'0';
    	      if(!S.isEmpty()){
    	    	  System.out.println("error while evaulating");
    	    	  return;
    	      }
    	    System.out.println("the value of the expression is: "+k);
    }
    public static boolean isOperator(char operator){
    	   if(operator=='+' || operator=='-' || operator=='*' || operator=='/'
    			   || operator=='^'){
    		   return true;
    	   }
    	   return false;
    }
    public static int evaluate(int b, int a , char operator){
    	int c=0;
    	switch(operator){
    	case('+'):
    	  c= b+a;
    	  break;
    	case('-'):
    	  c= (b-a);
    	   break;
    	case('*'):
    		c=b*a;
    	     break;
    	case('/'):
    		c=(b/a);
    	    break; 
    	case('^'):
    		c=(int)Math.pow(b, a);
    	    break;
    	}
    	return c;
    }
	public static void main(String[] args) {
		String str="534621*+-++";
		evaluatePostfix(str);

	}

}
