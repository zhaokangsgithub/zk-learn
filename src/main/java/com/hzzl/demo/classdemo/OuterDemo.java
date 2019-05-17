package com.hzzl.demo.classdemo;

/**
 * ClassName: outer <br/>
 * Function: 内部类的demo ADD FUNCTION. <br/>
 * Reason: 内部类的demo ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class OuterDemo {

	int num = 1;

	public void show() {
		InnerDemo innerDemo = new InnerDemo();
		System.out.println(innerDemo.num1);

	}

	/*public static void main(String[] args) {
		InnerDemo innerDemo = new InnerDemo();

		System.out.println(num1);
	}*/

	class InnerDemo {

		int num1 = 2;

		public void show2() {
			show();
			System.out.println(num);
			System.out.println(num1);
		}
	}

}


class PartOuterDemo{

	int num1 =2;

	public void show(){

		int num =1;

		class PartInnerDemo{

			void show(){
				/***
				 * 局部内部类:
				 *		不能直接访问局部变量,只能访问被final修饰的 可以
				 */
				System.out.println(num1);

			}
		}
	}
}

class testDemo{

}
