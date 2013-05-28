package org.packagetest.package1;

 public class Animal {
	
    protected String name;
    private int size;
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	 void getSound(){
		System.out.println("do animal");
	}
	
	
}
