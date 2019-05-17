package com.hzzl.demo.designmode;

/**
 * ClassName: singleton <br/>
 * Function: 单例设计模式 ADD FUNCTION. <br/>
 * Reason: 单例设计模式 ADD REASON(可选). <br/>
 * date: 2019/01/18 08:52 <br/>
 *
 * @author zhaokang
 * @since JDK 1.6
 */
public class SingletonDemo {

	//饿汉式  初始化的时候就调用了

	/*private static SingletonDemo s=new SingletonDemo();

	private SingletonDemo() {
		System.out.println("构造方法调用");
	}

	public static SingletonDemo getInstance(){

		return s;
	}*/

	//懒汉式,需要创建对象的时候才创建 volatile

	private volatile static SingletonDemo s = null;

	private SingletonDemo() {
		System.out.println("构造方法调用");
	}

	public static SingletonDemo getInstance() {

		synchronized (SingletonDemo.class) {
			if (s == null) {
				s = new SingletonDemo();
			}
		}
		return s;
	}
}

class SingletonTest {

	public static void main(String[] args) {
		SingletonDemo s1 = SingletonDemo.getInstance();
		SingletonDemo s2 = SingletonDemo.getInstance();
		System.out.println(s1 == s2);
	}
}
