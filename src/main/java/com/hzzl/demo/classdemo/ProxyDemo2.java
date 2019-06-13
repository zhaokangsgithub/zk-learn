package com.hzzl.demo.classdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 二次理解动态代理
 *
 * @author
 * @since JDK 1.6
 */
public class ProxyDemo2 implements InvocationHandler
{

    private static Object object = new MyStudent();

    public static void main(String[] args)
    {
        people o = (people)Proxy.newProxyInstance(MyStudent.class.getClassLoader(),
            MyStudent.class.getInterfaces(),
            new ProxyDemo2());
        o.say();
        o.study();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable
    {
        System.out.println("代理方法运行");
        String methodName = method.getName();
        if ("say".equals(methodName))
        {
            System.out.println("学生不能乱说话....");
            Object result = method.invoke(object);
            return result;
        }
        if ("study".equals(methodName))
        {
            System.out.println("学生要好好学习");
            Object result = method.invoke(object);
            return result;
        }
        return null;
    }
}

/**
 * 使用jdk的动态代理..接口存在
 */
interface people
{

    void say();

    void study();
}

class MyStudent implements people
{
    @Override
    public void say()
    {
        System.out.println("student...say...");
    }

    @Override
    public void study()
    {
        System.out.println("student...study...");
    }
}