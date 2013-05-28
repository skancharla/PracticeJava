package org.thread;

public class ThreadTest extends ThreadSuper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("this is main thread"+" priority:"+Thread.currentThread().getPriority());
		Thread t1=new Thread(new FooThread());
		Thread t2=new Thread(new BarThread());
		Thread t3=new Thread(new OpusThread());
		t1.start();
		t2.start();
		t3.start();
		while(x>0){
			System.out.println("this is main thread: "+Thread.currentThread().getName()+" priority: "+Thread.currentThread().getPriority());
		}

	}

}
