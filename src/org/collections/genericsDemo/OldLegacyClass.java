package org.collections.genericsDemo;

import java.util.Iterator;
import java.util.List;

public class OldLegacyClass {
	
	public int addAll(List list){
		Iterator it=list.iterator();
		int total=0;
		while(it.hasNext()){
			int i=((Integer)it.next()).intValue();
			total+=i;
		}
		return total;
	}

	public void insert(List list){
		list.add(new String("42"));
	}
}
