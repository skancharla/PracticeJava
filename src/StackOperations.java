import java.util.Stack;


public class StackOperations {

	public int solution( String S ) {
		
		   if(S==null){
			   return -1;
		   }
		   if(S.length()<3){
			   return -1;
		   }
	      Stack<Integer> stack=new Stack<Integer>();
	      
	      for(int i=0;i<S.length();i++){
	    	  char ch=S.charAt(i);
	    	  if(ch>='0' && ch<='9'){
	    		  stack.push(Integer.parseInt(""+ch));
	    	  }
	    	  else if(ch=='+'){
	    		  if(!stack.isEmpty()){
	    			  int operand1=stack.pop();
	    			  if(!stack.isEmpty()){
	    				  int operand2=stack.pop();
	    				  int result=operand1+operand2;
	    				  stack.push(result);
	    			  }
	    			  else{
	    				  return -1;
	    			  }
	    		  }
	    		  else{
	    			  return -1;
	    		  }
	    	  }
	    	  else if(ch=='*'){
	    		  if(!stack.isEmpty()){
	    			  int operand1=stack.pop();
	    			  if(!stack.isEmpty()){
	    				  int operand2=stack.pop();
	    				  int result=operand1*operand2;
	    				  stack.push(result);
	    			  }
	    			  else{
	    				  return -1;
	    			  }
	    		  }
	    		  else{
	    			  return -1;
	    		  }
	    	  }
	    	  else{
	    		  return -1;
	    	  }
	      }
	      
	      if(!stack.isEmpty()){
	    	   if(stack.size()==1){
	    		   return stack.pop();
	    	   }
	    	   else
	    		   return -1;
	      }
	      
	      return -1;
	  }
	public static void main(String[] args) {
		String s1="11++";
		String s2="13+62*7+*";
		String s3="15+32**";
		System.out.println(new StackOperations().solution(s3));

	}

}
