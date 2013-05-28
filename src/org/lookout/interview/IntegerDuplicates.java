package org.lookout.interview;

import java.util.ArrayList;
import java.util.HashMap;

public class IntegerDuplicates {

	
	public static void main(String[] args) {
		int[] A={4,8,7,5,6,9,88,77,44,7,4,5};
		if(A==null || A.length==0){
			System.out.println("array is null or empty");
		}
		else if(A.length==1){
			System.out.println("no duplicate elements");
		}
		else{
			HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
			ArrayList<Integer> aList=new ArrayList<Integer>();
			boolean duplicateExists=false;
			for (int i = 0; i < A.length; i++) {
				 if(!hashMap.containsKey(A[i])){
					 hashMap.put(A[i], A[i]);
					 aList.add(A[i]);
				 }
				 else{
					 duplicateExists=true;
					 int element=hashMap.get(A[i]);
					 System.out.println("duplicate for: "+element);
			}	
			}
			if(!duplicateExists)
				System.out.println("duplicate doesn't exists");
			else{
				System.out.println("list with out duplicates is: ");
				for(int i:aList)
					System.out.print(i+" ");
			}
			
		}

	}

}
