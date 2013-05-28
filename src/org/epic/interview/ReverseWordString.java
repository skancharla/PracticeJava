package org.epic.interview;

public class ReverseWordString {

	char charArray[];
	public String reverseWords(String input){
		charArray=input.toCharArray();
		reverseString(0,charArray.length-1);
		int current=0,start=0,end=0;
		while(current<charArray.length){
			if(charArray[current]==' ' || current==charArray.length-1){
				if(current==charArray.length-1){
					end=current;
				}
				else{
					end=current-1;
				}
				reverseString(start,end);
				current++;
				start=current;
			}
			else{
				current++;
			}
		}
		
		return new String(charArray);
	}
	public void reverseString(int start,int end){
		char temp;
		while(start<end){
			temp=charArray[end];
			charArray[end]=charArray[start];
			charArray[start]=temp;
			start++;
			end--;
		}
		
	}
	public static void main(String[] args) {
		
         String str="Head over Heels";
         System.out.println(new ReverseWordString().reverseWords(str.trim()));
	}

}
