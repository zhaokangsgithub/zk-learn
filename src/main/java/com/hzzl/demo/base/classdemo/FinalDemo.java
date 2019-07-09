package com.hzzl.demo.base.classdemo;

import java.io.UnsupportedEncodingException;

/**
 * ClassName:  <br/>
 * Function: Final ADD FUNCTION. <br/>
 * Reason: Final ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class FinalDemo {

	public static final int NUM1 = 1;

	public final int NUM2 = 2;

	public static void main(String[] args) throws UnsupportedEncodingException {
		/*String a ="你好";//u8
		byte[] gbks = a.getBytes("GBK");
		String s = new String(gbks, "UTF-8");
		System.out.println(s);//乱码*/
		String a ="浣犲ソ";//

		test(a);

	}

	public static void test(String str) throws UnsupportedEncodingException {

		/*byte[] u8s = str.getBytes("UTF-8");
		String gbkstr = new String(u8s, "GBK");
		System.out.println(gbkstr);*/
		byte[] gbks = str.getBytes("GBK");
		String u8str = new String(gbks, "UTF-8");
		System.out.println(u8str);
	}

}



