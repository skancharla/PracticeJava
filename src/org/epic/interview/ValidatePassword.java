package org.epic.interview;

/* password must be 5-12 characters long
 * must contain atleast one digit and atleast one lowercase character
 * a sequence must not be followed  by same sequence. for example 123123qs is invalid where as 123qs123 is valid
 * the following class validates the password by checking the above constraints
 * */
public class ValidatePassword {

	  String str;
	  int length;
	  public ValidatePassword(String str){
		  this.str=str;
		  this.length=str.length();
	  }
	  public boolean validatePassword(){
		  if(!checkLength()){
			  System.out.println("check the length of the password");
			  return false;
		  }
		  if(!checkConstraint()){
			 System.out.println("include atleast one digit and one lower case character");
			  return false;
		  }
		  if(!checkSequence()){
			  System.out.println("avoid the sequences in the password");
			  return false;
		  }
		  return true;
					  
	  }
	  public boolean checkLength(){
		   if(length>=5 && length<=12)
			   return true;
		   
		   return false;
	  }
	  
	  public boolean checkConstraint(){
		  int count1=0;
		  int count2=0;
		  for (int i = 0; i < length; i++) {
			if(str.charAt(i)>='1' && str.charAt(i)<= '9')
				count1++;
			else if(str.charAt(i)>= 'a' && str.charAt(i)<= 'z')
				count2++;
		}
		  if(count1>=1 && count2>=1)
			  return true;
		  
		  return false;
	  }
	  
	  public boolean checkSequence(){
		  for (int k = 0; k < length; k++) {
			  int i=0;
			  int j=i+k;
			  while(i<j && j< length){
				  if(str.charAt(i)==str.charAt(j)){
					  int a=i+1;
					  int b=j+1;
					  boolean sequence=true;
					  for (int l = 1; l < k ; l++) {
						  if(a<b && b<length){  
						  if(sequence){
						    	if(str.charAt(a)!=str.charAt(b)){
						    		sequence=false;
						    	}
						    	else{
						    		a++;
						    		b++;
						    	}
						    }
						    else{
						    	break;
						    }
						  }
						  else{
							  sequence=false;
						  }
						    
					}
					  if(sequence)
						  return false;
					  
				  }
				  i++;
				  j++;
				  
			  }//end of while loop
			
		}//end of k for loop
		   return true; 
	  }//end of checkSequence method
	
	public static void main(String[] args) {
		String str="124123123qs";
		ValidatePassword vPassword=new ValidatePassword(str);
		if(vPassword.validatePassword())
			System.out.println("password is validated");
		else
			System.out.println("invalid password");

	}

}
