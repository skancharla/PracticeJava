package org.lookout.interview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class RandomGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileWriter fWriter=null;
		BufferedWriter pWriter=null;
				try {
					fWriter= new FileWriter("E:\\doc.txt");
					pWriter= new BufferedWriter(fWriter);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				//double generator=Math.random();
				for (int i = 1; i <=1000000; i++) {
				 double d=Math.random()*(100000);
				 int j=(int)d;
				 try {
					pWriter.write(""+j);
					pWriter.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				}

	}

}
