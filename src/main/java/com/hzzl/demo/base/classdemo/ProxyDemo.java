package com.hzzl.demo.base.classdemo;

import java.lang.reflect.*;

public class ProxyDemo {

	private static Object object = null;

	public static void main(String[] args) {
		//创建被代理对象
		Constructor<?>[] declaredConstructors = LiuYan.class.getDeclaredConstructors();

		try {
			Constructor<LiuYan> declaredConstructor = LiuYan.class.getDeclaredConstructor();
			object = declaredConstructor.newInstance();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}


		//调用处理器 修改代理对象拦截被代理对象的变量
		//获得代理对象 
		Star proxy = (Star) Proxy.newProxyInstance(LiuYan.class.getClassLoader(), LiuYan.class.getInterfaces(), new InvocationHandler() {
			// 代理类中的任何方法，其实内部都是执行了处理器中的invoke方法，无论是sing,liveShow，sleep都是这样
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String name = method.getName();
				if("sing".equals(name))
				{
					System.out.println("zengqiang");
					//执行LiuYan类中的函数
					return method.invoke(object, args);
				}
				return null;
			}
		});//proxy表示动态获取的代理对象
		//使用代理对象调用函数
		proxy.sing();
	}
}

interface Star{

	public void sing();
}

class LiuYan implements Star{

	@Override
	public void sing(){
		System.out.println("sing");
	}

}