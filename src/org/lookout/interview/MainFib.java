package org.lookout.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainFib {

	  public  int processInput(int n){
		   int i=0;
		   int j=1;
		   int l=0;
		   if(n==1)
			   return 1;
		   if(n==3)
			   return 0;
		   for (int k = 2; k <= n; k++) {
			  l=i+j;
			  i=j;
			  j=l;
		}
		   return j;
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
						int input=Integer.parseInt(lineArray[i]);
						int out=new MainFib().processInput(input);
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

}
