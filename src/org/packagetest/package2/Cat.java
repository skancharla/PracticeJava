package org.packagetest.package2;

import org.packagetest.package1.Animal;

public class Cat extends Animal{

	public Cat(String name){
		setName(name);
	}
	public void go(){
		//getSound();
	}
	void getSound(){
		System.out.println("do cat");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		Cat a= new Cat("tiger");
        a.getSound();
        long end=System.currentTimeMillis();
        System.out.println("run time is: "+(end-start)*1000+" seconds");
	}

}
