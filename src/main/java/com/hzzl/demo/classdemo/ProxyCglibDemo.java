package com.hzzl.demo.classdemo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class ProxyCglibDemo
{

    public static void main(String[] args)
    {
        final MyPeople peo = new MyPeople();

        MyPeople o = (MyPeople)Enhancer.create(peo.getClass(), new MethodInterceptor()
        {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                throws Throwable
            {
                String methodName = method.getName();
                if (methodName.equals("say"))
                {
                    System.out.println("say方法增强");
                    return method.invoke(peo);
                }
                return null;
            }
        });

        o.say();

    }


}


class MyPeople{

    public void say(){
        System.out.println("MyPeople ... say ...");
    }

}