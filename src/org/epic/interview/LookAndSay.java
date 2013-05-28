package org.epic.interview;

public class LookAndSay {

	public void lookAndSay(String input){
		int i=0;
		/*print the next 10 numbers of the sequence*/
		while(i<10){
			char[] charArray=input.toCharArray();
			StringBuffer sb=new StringBuffer();
			boolean isCont=false;
			int count=0;
			if(charArray.length==1){
				String str="1"+charArray[0];
				System.out.println(str);
				input=str;
				continue;
			}
			else{
				for (int j = 0; j < charArray.length-1; j++) {
					if(isCont){
						count++;
						if(charArray[j]!=charArray[j+1]){
							sb.append(count);
							sb.append(charArray[j]);
							count=0;
							isCont=false;
						}
					}
					else{
						count++;
						if(charArray[j]==charArray[j+1]){
							isCont=true;
						}
						else{
							sb.append(count);
							sb.append(charArray[j]);
							count=0;
						}
					}
				} //end of for loop
				if(isCont){
					count++;
					sb.append(count);
					sb.append(charArray[charArray.length-1]);
				}
				else{
					sb.append(1);
					sb.append(charArray[charArray.length-1]);
				}
			}
			input=new String(sb);
			System.out.println(input);
			i++;
		}//end of while loop
	}
	
	public static void main(String[] args) {
		String input="11";
		LookAndSay lookSay = new LookAndSay();
		lookSay.lookAndSay(input);

	}

}
