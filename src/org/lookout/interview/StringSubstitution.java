
package org.lookout.interview;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StringSubstitution implements Comparator<ReplaceString> {
    
	public  String processInput(String input){
		ArrayList<ReplaceString> aList=new ArrayList<ReplaceString>();
		//if the input is null , print the error statement
		if(input==null){
			System.out.println("no input");
			return null;
		}
		String[] result1=input.split(";");
		//checking the input format
		if(result1==null || result1.length!=2 || result1[0]==null || result1[1]==null){
			System.out.println("input not in correct format");
			return null;
		}
		String mainString=result1[0];
		char[] mainStringArray=mainString.toCharArray();
		String[] result2=result1[1].split(",");
		//if the substrings are odd in number print appropriate error statement   
		if(result2.length%2!=0){
			   System.out.println("no sufficent replacements for given strings");
			   return null;
		   }
		   for (int i = 0; i < result2.length; i++) {
			   if(result2[i]==null){
				   System.out.println("input not in correct format");
				   return null;
			   }
		}
		 for (int i = 0; i < result2.length; i=i+2) {
			
			String searchString=result2[i];
			String replaceString=result2[i+1];
			int endIndex=0;
			int startIndex=0;
			do{
			String mainString1=new String(mainStringArray);	
			startIndex=mainString1.indexOf(searchString);
			if(startIndex!=-1){
			   endIndex=searchString.length()+startIndex-1;
			   ReplaceString rString=new ReplaceString();
			   rString.setStartIndex(startIndex);
			   rString.setEndIndex(endIndex);
			   rString.setReplaceString(replaceString);
			   //fill from start index to end index with '$'
			   for (int j = startIndex; j <= endIndex; j++) {
				    mainStringArray[j]='$';
			}
			   aList.add(rString);
			}
		 }while(endIndex+1<mainString.length() && startIndex!=-1);
			
		}  //end of main for loop
		 //if the original string remains unchanged print the appropriate message
		 if(aList.isEmpty()){
			  System.out.println(mainString);
			  return null;
		  }
		 
		 else{
		 //sort the array list by indices stored
		 Collections.sort(aList, this);
		 //iterate through the list and build the changed string
		 int prev=-1;
		 //string buffer to hold the target string
		 StringBuilder sb=new StringBuilder();
		 for (int i = 0; i < aList.size(); i++) {
			int startIndex=aList.get(i).getStartIndex();
			 if(startIndex!=prev+1){
				while(startIndex!=prev+1){
				 prev=prev+1;
				sb.append(mainStringArray[prev]);
				}
			}
			 sb.append(aList.get(i).getReplaceString());
			 prev=aList.get(i).getEndIndex();
		}
		 prev=prev+1;
		 if(prev< mainString.length()){
			 while(prev<mainString.length()){
				 
				 sb.append(mainStringArray[prev]);
				 prev=prev+1;
			 }
		 }
		 return new String(sb);
	}
	}
	
	public static void main(String[] args) {
		try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	            String[] lineArray = line.split("\\s");
	            if (lineArray.length > 0) {
	                for (int i = 0; i < lineArray.length; i++) {
					String out=new StringSubstitution().processInput(lineArray[i]);
					 if(out!=null)	
					System.out.println(out);
					 
					 
					}
	            } 
	        }
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	        System.exit(0);
	    } 
		System.exit(0);
	}

	@Override
	public int compare(ReplaceString o1, ReplaceString o2) {
		if(o1.getStartIndex()>o2.getStartIndex())
			return 1;
		else if (o1.getStartIndex()<o2.getStartIndex())
			return -1;
		else
			return 0;
	}

	

	

}


/*This is an auxilary class used to hold the indices and replacement strings*/
 class ReplaceString {

	 private int startIndex;
	 private int endIndex;
	 private String replaceString;
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public String getReplaceString() {
		return replaceString;
	}
	public void setReplaceString(String replaceString) {
		this.replaceString = replaceString;
	}
}

