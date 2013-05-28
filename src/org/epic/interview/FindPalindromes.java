package org.epic.interview;

public class FindPalindromes {

	public void findPalindromes(int startYear,int startMonth,int startDay,int endYear,int endMonth,int endDay){
		for (int i = startYear; i <= endYear; i++) {
			for (int j = 1; j <= 12; j++) {
				for (int k = 1; k <= 31; k++) {
					if(!((i==startYear&&k<startDay&&j<=startMonth)||(i==endYear&&k>endDay&&j>=endMonth))){
						String str=""+k+j+i;
						if(isPalindrome(str)){
							System.out.println(str);
						}
					}
				}
			}
		}
		
	}
	
	public boolean isPalindrome(String str){
		int i=0;
		int j=str.length()-1;
		while(i<j){
			if(str.charAt(i)!=str.charAt(j)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		new FindPalindromes().findPalindromes(1111,11,10,1111,11,12);

	}

}
