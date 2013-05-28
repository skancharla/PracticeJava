package org.lookout.interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class YodleTriangle {

	
	public static void main(String[] args) {
	BufferedReader bReader=null;
		try {
	 bReader=new BufferedReader(new FileReader("E:\\triangle.txt"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ArrayList<ArrayList<Integer>> aList=new ArrayList<ArrayList<Integer>>();
	String str=null;
			try {
				while((str=bReader.readLine())!=null){
					String[] values=str.split(" ");
					ArrayList<Integer> list=new ArrayList<Integer>();
					for (int i = 0; i < values.length; i++) {
						int intValue=Integer.parseInt(values[i]);
						list.add(intValue);
					}
					aList.add(list);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int sum=aList.get(0).get(0);
			int currentIndex=0;
			
			for (int i = 1; i < aList.size(); i++) {
				int startIndex=0;
				int endIndex=0;
				int temp=0;
				ArrayList<Integer> currentList=aList.get(i);
				
					startIndex=currentIndex;
					endIndex=currentIndex+1;
				
				for (int j = startIndex; j <= endIndex; j++) {
					if(currentList.get(j)>=temp){
						temp=currentList.get(j);
						currentIndex=j;
					}
				}
				sum+=temp;
			}

			System.out.println("maximum triangle sum is: "+ sum);
	}

}
