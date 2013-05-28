package org.dotLoop;

public class Solution1 {

	public int solution ( String S ) {
		if(S==null || S.length()==0){
			System.out.println("String is either null or inappropriate length");
			return -1;
		}
		if(S.length()==1){
			return 0;
		}
		int maxLength=0;
		for (int i = 0; i < S.length()-1; i++) {
			String str1=S.substring(0,i+1);
			if(isPalindrome(str1)){
				if(str1.length()>maxLength)
					maxLength=str1.length();
			}
		}
		
		return maxLength;
		
	  }
	
	public boolean isPalindrome(String str){
		int i=0;
		int j=str.length()-1;
		while(i<j){
			  if(str.charAt(i)!=str.charAt(j))
				  return false;
			  i++;
			  j--;
		  }
		return true;
	}
	public static void main(String[] args) {
		String S="abbabba";
		String S1="a";
		String S2="ab";
		System.out.println(new Solution1().solution(S));

	}

}
