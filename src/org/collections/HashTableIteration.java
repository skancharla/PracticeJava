package org.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashTableIteration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String,String> hashMap=new HashMap<String,String>(4);
		hashMap.put("andhrapradesh", "hyderabad");
		hashMap.put("uttarpradesh", "allahabad");
		hashMap.put("karnataka", "benguluru");

		Set<String> s=hashMap.keySet();
		Iterator<String> it=s.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		hashMap.put("tamilnadu", "chennai");
		hashMap.put("maharastra", "mumbai");
		hashMap.put("gujarat", "gandhinagar");
		hashMap.put("punjab", "chandigarh");
		hashMap.put("kerala", "trivendram");

		System.out.println("after table doubling");
		Set<String> s1=hashMap.keySet();
		Iterator<String> it1=s.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next().toString());
		}

	}

}
