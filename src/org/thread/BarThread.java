package org.thread;

public class BarThread extends ThreadSuper implements Runnable{

	@Override
	public void run() {
       while(this.x>0){
		System.out.println("this is bar thread: "+Thread.currentThread().getName()+" priority:"+Thread.currentThread().getPriority());		
        this.x--;
       }
       }

}
