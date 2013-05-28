package org.lookout.interview;

public class StringtoInteger {

	public static boolean getInteger(String input){
		char[] charArray=null;
		boolean isPositive=true;
		 if(input.charAt(0)=='-'){
			 isPositive=false;
			 charArray=input.substring(1).toCharArray();
		 }
		 else
		   charArray=input.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			if(!(charArray[i]>='0' && charArray[i]<= '9')){
				System.out.println("input is not compatible");
				return false;
			}
		}
		long sum=0;
		for (int i = charArray.length-1; i >=0; i--) {
			
			  if(isPositive)
			sum+=Math.pow(10, charArray.length-1-i)*(charArray[i]-'0');
			  else
				  sum+=(0-Math.pow(10, charArray.length-1-i)*(charArray[i]-'0'));
			  if(isPositive && sum >Integer.MAX_VALUE){
					System.out.println("positive integer over flow");
					return false;
				}
				if(!isPositive && sum<Integer.MIN_VALUE){
					System.out.println("negative integer over flow");
					return false;
				}
		}
		
		System.out.println("integer is: "+sum);
		return true;
	}
	public static void main(String[] args) {
		String str="-2147483649";
		if(getInteger(str))
			System.out.println("Is an integer");
		else
			System.out.println("not an Integer");
   
	}

}
