package com.hzzl.demo.base.classdemo;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class ExeceptionDemo  {

	public static void main(String[] args) {
		new Calculate(-1,3);
	}


}


class Calculate{

	public int length;
	public int weigth;

	public Calculate(int length, int weigth) {

		if(length < 0){
			throw new IllegalLength("非法长度异常");
		}

		if(weigth < 0){
			throw new IllegalWeigth("非法长度异常");
		}

		this.length = length;
		this.weigth = weigth;
	}
}

class IllegalLength extends RuntimeException{

	public IllegalLength() {
	}

	public IllegalLength(String message) {
		super(message);
	}
}


class IllegalWeigth extends RuntimeException{

	public IllegalWeigth() {
	}

	public IllegalWeigth(String message) {
		super(message);
	}
}
