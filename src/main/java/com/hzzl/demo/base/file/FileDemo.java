package com.hzzl.demo.base.file;

import org.springframework.stereotype.Controller;

import java.io.*;
import java.util.Scanner;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
@Controller
public class FileDemo {


	public static FileFilter fileFilter = null;

	static {
		fileFilter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname != null && pathname.isFile() && "1.txt".equals(pathname.getName());
			}
		};
	}

	public static void main(String[] args) {

		try {
			//构造方法使用
//			constroctFile();

//			methodTest();
//			File file = new File("D:\\demo");
//			fileFilterDemo(file);
//			fileFilterDemo2(file);
//			FileOutputStreamDemo();
//			fileInputStreamDemo();
//			inputStreamReaderDemo();

//			inputStreamReaderDemo();
//			outputStreamWriterDemo();
//			scannerDemo();
			bufferedReaderDemo();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void bufferedReaderDemo() {

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\demo\\2.txt"));
			String line = null;
			while ((line = bufferedReader.readLine())!=null){
				String gbk = new String(line.getBytes("utf8"), "gbk");
				System.out.println(gbk);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


	private static void scannerDemo() {
		System.out.println("begin===");
		Scanner scanner = new Scanner(System.in);
		scanner.next();



	}

	private static void outputStreamWriterDemo() {
		OutputStreamWriter outputStreamWriter = null;
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:\\demo\\2.txt",true);
			outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GBK");

			outputStreamWriter.write("\r\n你好333");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void inputStreamReaderDemo() {
		InputStreamReader inputStreamReader = null;
		try {
			FileInputStream fis = new FileInputStream("D:\\demo\\2.txt");

			inputStreamReader = new InputStreamReader(fis);

			char[] ch = new char[10];
			int len = 0;

			while ((len = inputStreamReader.read(ch)) != -1) {
				System.out.println(new String(ch, 0, len));
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStreamReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void fileInputStreamDemo() {
		FileInputStream in = null;
		try {
			in = new FileInputStream("D:\\demo\\2.txt");
			byte[] br = new byte[10];

			while (in.read(br) != -1) {
				String s = new String(br);
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

	private static void FileOutputStreamDemo() {
		FileOutputStream fileOutStream = null;
		try {
			fileOutStream = new FileOutputStream("D:\\demo\\2.txt", true);

			//获取操作系统的换行符
			String property = System.getProperty("line.separator");

			fileOutStream.write(("hello java1" + property).getBytes());
			fileOutStream.write(("hello java2" + property).getBytes());
			fileOutStream.write(("hello java3" + property).getBytes());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOutStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void fileFilterDemo2(File file) {

		File[] files = file.listFiles(fileFilter);

	}


	private static void fileFilterDemo(File file) {

		//根据file对象调用listFiles()函数获得上述文件夹中的所有儿子文件和文件夹
		File[] files = file.listFiles();

		for (File file1 : files) {
			if (file1.isFile() && fileFilter.accept(file1)) {
				System.out.println("方法调用成功" + file1.getAbsolutePath());
			} else if (file.isDirectory()) {
				fileFilterDemo(file1);
			}
		}
	}

	private static void methodTest() throws Exception {

		File file = new File("D:\\demo", "src\\1.txt");
		/*System.out.println("file1"+file);

		String absolutePath = file.getAbsolutePath();
		System.out.println("absolutePath:"+absolutePath);

		System.out.println("getCanonicalPath: "+file.getCanonicalPath());

		System.out.println("getname: "+file.getName());

		System.out.println("getParent: "+file.getParent());*/

		/**
		 * 路径不存在 IO EXCEPTION
		 * 路径正常,创建文件  true
		 * 路径正常,文件已存在 false
		 */
		/*boolean newFile = file.createNewFile();
		System.out.println(newFile);*/

		boolean mkdirs = file.mkdirs();
		System.out.println("mkdirs: " + mkdirs);

		boolean newFile = file.createNewFile();
		System.out.println("newFile: " + newFile);

	}

	private static void constroctFile() {

		File file = new File("D:\\demo");
		System.out.println("pathname" + file);

		File file1 = new File("D:\\demo", "src\\1.txt");
		System.out.println("file1" + file1);

		File file2 = new File(file, "1.txt");
		System.out.println("file2" + file2);

	}
}
