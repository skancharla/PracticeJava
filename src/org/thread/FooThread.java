package org.thread;

public class FooThread extends ThreadSuper implements Runnable {

	@Override
	public void run() {
		while(this.x>0){
		System.out.println("this is foo thread: "+Thread.currentThread().getName()+" priority:"+Thread.currentThread().getPriority());
		this.x--;
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
