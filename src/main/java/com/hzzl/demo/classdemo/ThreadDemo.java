package com.hzzl.demo.classdemo;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class ThreadDemo {

	public static void main(String[] args) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("run........");
			}
		}).start();
	}

}


class TaskDemo implements Runnable{

	@Override
	public void run() {
		System.out.println("run........");
	}
}