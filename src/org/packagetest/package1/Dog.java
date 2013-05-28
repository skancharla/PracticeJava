package org.packagetest.package1;

class Dog extends Animal{

	public Dog(String name){
		setName(name);
		
	}
	public void go(){
		getSound();
	}
	
	 void getSound(){
		System.out.println("do dog");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal a=new Dog("germanshepard");
		a.getSound();
		

	}

}
