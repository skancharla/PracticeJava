package org.collections;

import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapDemo {

	
	public static void main(String[] args) {
		TreeMap<String,String> treeMap=new TreeMap<String,String>();
		treeMap.put("uttarpradesh", "lucknow");
		treeMap.put("tamilnadu", "chennai");
		treeMap.put("andhrapradesh", "hyderabad");
		
		Iterator<String> it=treeMap.keySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}

	}

}
