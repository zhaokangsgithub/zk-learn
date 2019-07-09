package com.hzzl.demo.base.classdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class JdkProxyDemo {

	private static Object obj= null;

	public static Object getProxy(Class<?> clazz){
		try {
			obj=clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("代理之前执行");
				Object result=method.invoke(obj,args);
				System.out.println("代理之后执行");
				return  result;
			}
		});
	}
}

interface UserService {
	public void show();
}

class UserServiceImpl implements  UserService {//接口实现类
	@Override
	public void show() {
		System.out.println("I am a User");
	}
}

class ProxyTest{

	public static void main(String[] args) {
		UserService proxy = (UserService)JdkProxyDemo.getProxy(UserServiceImpl.class);
		proxy.show();
	}

}