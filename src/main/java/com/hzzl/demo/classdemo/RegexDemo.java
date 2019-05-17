package com.hzzl.demo.classdemo;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class RegexDemo {

	public static void main(String[] args) {

//		method1();
//		systemDemo();
		datedemo();
	}

	public static void datedemo() {


		try {
			/*Date date = new Date();
			long time = date.getTime();
			System.out.println(time);*/
//			String format = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(date);
//			String format = DateFormat.getDateTimeInstance().format(date);
//			System.out.println(format);
			/*String dateStr = "2019-4-22 9:03:35";
			Date parse = DateFormat.getDateTimeInstance().parse(dateStr);
			System.out.println(parse);*/

			Calendar c = Calendar.getInstance();
			c.set(2012, 13, 1);//2013年2月1日
			c.add(Calendar.DAY_OF_MONTH,29);
			//获取年月日
			int year=c.get(Calendar.YEAR);//年
			int month=c.get(Calendar.MONTH)+1;//月
			int day=c.get(Calendar.DAY_OF_MONTH);//日
			//输出
			System.out.println(year+"年"+month+"月"+day+"日");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void systemDemo() {
//		Properties properties = System.getProperties();
		String property = System.getProperty("user.name");

	}

	public static void method1() {

		/**
		 * 基本转包装
		 */
		/*int a=10;
		Integer integer = Integer.valueOf(a);
		System.out.println(integer);
		Integer integer1 = new Integer(a);
		System.out.println(integer1);
		System.out.println(integer=integer1);*/

		/**
		 * 包装转基本
		 */
		/*Integer integer = Integer.valueOf(10);
		int i = integer.intValue();
		System.out.println(i);
		long l = integer.longValue();
		System.out.println(l);*/

		/**
		 * 字符串转包装类
		 */
		/*String s="100";
		Integer integer = new Integer(s);
		System.out.println(integer);
		Integer integer1 = Integer.valueOf(s);
		System.out.println(integer1);*/

		/**
		 * 包装类转字符串
		 */
		/*Integer integer = new Integer(100);
		String s = integer.toString();
		System.out.println(s);*/

		/**
		 * 基本类型转字符串
		 */
		/*int a = 100;
		String s = String.valueOf(a);
		System.out.println(s);*/

		DateFormat.getInstance();

		/**
		 * 字符串转基本类型
		 */
		String s = "100";
		int i = new Integer(s).intValue();
		System.out.println(i);
		int i1 = Integer.parseInt(s);
		System.out.println(i1);

		int i2 = new Integer(s);
		Integer integer = 5;
	}
}
