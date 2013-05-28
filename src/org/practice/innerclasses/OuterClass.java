package org.practice.innerclasses;

public class OuterClass {
	private static int x=7;
	static class InnerClass{
		public void seeInner(){
			System.out.println("value of outer x is: "+x);
			//System.out.println("inner class is: "+this);
			//System.out.println("outer class is: "+OuterClass.this);
		}
	}
	
	public static void main(String[] args) {
		//OuterClass outer=new OuterClass();
		OuterClass.InnerClass inner= new OuterClass.InnerClass();
		inner.seeInner();
	}

}
