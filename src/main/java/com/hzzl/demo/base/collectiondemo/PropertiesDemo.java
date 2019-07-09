package com.hzzl.demo.base.collectiondemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class PropertiesDemo {

	public static void main(String[] args) {


		constractProp();
	}

	private static void constractProp() {

		Properties prop = new Properties();
		prop.setProperty("地址1","南京1");
		/*prop.setProperty("1K","1V");
		prop.put("2k","2v");

		System.out.println(prop.get("2k"));
		System.out.println(prop.getProperty("1K"));*/
		try {
//			prop.store(new FileOutputStream("D:\\demo\\1.txt",true),"地址");
			prop.store(new FileWriter("D:\\demo\\1.txt"),new String("地址2".getBytes("UTF8"),"GBK"));
			prop.load(new FileReader("D:\\demo\\1.txt"));



		} catch (IOException e) {
			e.printStackTrace();
		}


	}


}
