package com.hzzl.demo.concurrent.lockdemo;

/*
 * 演示线程死锁的问题
 */
//定义一个线程任务类
class DeadLockTask implements Runnable
{
	//定义两个锁对象
	private Object lock_a=new Object();
	private Object lock_b=new Object();
	//定义一个变量作为标记，控制取锁的方式
	 boolean flag=true;

	 @Override
	 public void run() {
		//当线程进来之后，一个线程进入到if中，另一个进入到else中
		if(flag)
		{
			while(true)
			{
				synchronized(lock_a)
				{
					System.out.println(Thread.currentThread().getName()+"if.....lock_a");
					synchronized(lock_a)
					{
						System.out.println(Thread.currentThread().getName()+"if.....lock_b");
					}
				}
			}
		}else
		{
			while(true)
			{
				synchronized(lock_b)
				{
					System.out.println(Thread.currentThread().getName()+"else.....lock_b");
					synchronized(lock_b)
					{
						System.out.println(Thread.currentThread().getName()+"else.....lock_a");
					}
				}
			}
		}
	}
}
public class DeadThreadLockDemo {

	public static void main(String[] args) throws InterruptedException {
		// 创建任务类对象
		DeadLockTask dlt = new DeadLockTask();
		//创建线程对象
		Thread t1 = new Thread(dlt);
		Thread t2 = new Thread(dlt);
		//开启第一个线程
		t1.start();
		Thread.sleep(12);
		//修改标记让下一个线程进入到else中
		dlt.flag=false;
		t2.start();
	}
}