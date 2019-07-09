package com.hzzl.demo.base.netdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class HostDemo {

	public static void main(String[] args) {

		getHostName();

	}

	private static void getHostName() {

		try {
			InetAddress address = InetAddress.getByName("10.73.158.136");
			String hostName = address.getHostName();
			String hostAddress = address.getHostAddress();
			byte[] address1 = address.getAddress();


		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}

class UDPClientDemo{

	public static void main(String[] args) {

		try {
			//创建客户端对象,用来接收数据
			DatagramSocket datagramSocket = new DatagramSocket(10086);
			//拆包接收数据的 byte[] buf, int length, InetAddress address, int port
			byte[] buf = new byte[1024];
			int length= buf.length;
			DatagramPacket datagramPacket = new DatagramPacket(buf,length);
			datagramSocket.receive(datagramPacket);

			InetAddress address = datagramPacket.getAddress();
			byte[] data = datagramPacket.getData();

			System.out.println(address+"接收成功: "+new String(data));
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}

class UDPServerDemo{

	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			byte[] buf = "你好".getBytes();
			int length= buf.length;
			InetAddress address = InetAddress.getByName("127.0.0.1");
			DatagramPacket p = new DatagramPacket(buf, length, address, 10086);
			datagramSocket.send(p);
			datagramSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


class ClientDemo {
	public static void main(String[] args) throws Exception, IOException {
		// A：创建客户端套接字对象；
		Socket s = new Socket("127.0.0.1",10000);
		//B：获取输出流，关联通道；
		OutputStream os = s.getOutputStream();
		//C：写数据；
		os.write("hello，TCP,我来了".getBytes());
		//D：释放资源；
		//os.close();
		s.close();//在关闭客户端的同时，这个通道输出流也会被关闭
	}
}

class ServerDemo {
	public static void main(String[] args) throws Exception {
		// A：创建服务端套接字；
		ServerSocket serverSocket = new ServerSocket(10000);
		// B：侦听并获取客户端套接字；
		Socket socket = serverSocket.accept();
		//C：获取输入流，数据源是通道；
		InputStream is = socket.getInputStream();
		//获取客户端IP
		String ip = socket.getInetAddress().getHostAddress();
		System.out.println("["+ip+"]:");
		//D：读取数据；
		byte[] buf=new byte[1024];
		int len=0;
		while((len=is.read(buf))!=-1)
		{
			//输出数据
			System.out.println(new String(buf,0,len));
		}
		//关闭资源
		socket.close();
		serverSocket.close();
	}
}
