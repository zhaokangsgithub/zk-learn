package com.hzzl.demo.base.classdemo;

/**
 * @ClassName: StaticDemo
 * @Description: TODO
 * @Auther: Administrator
 * @Date: 2019/4/17 10:53
 */
public class StaticDemo extends superStatic{

    public static String name = "zi";

    {
        System.out.println("代码块执行");
    }

    static{
        System.out.println("静态代码块执行");
    }

    public StaticDemo() {
        System.out.println("构造代码块执行");
    }

    @Override
    public void show(){
        System.out.println("show方法执行"+name);
    }
}

class superStatic{

    public static String name = "fu";
    {
        System.out.println("fu......代码块执行");
    }
    static{
        System.out.println("fu......静态代码块执行");
    }

    public superStatic() {
        System.out.println("fu......构造代码块执行");
    }

    public void show(){
        System.out.println("fu......show2方法执行"+name);
    }
}

class TestStatic{

    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo();
        staticDemo.show();
        System.out.println("========");
        StaticDemo staticDemo2 = new StaticDemo();
        staticDemo2.show();
    }
}