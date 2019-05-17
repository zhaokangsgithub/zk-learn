package com.hzzl.demo.interfacedemo;

public interface MyInterface {

    public static final String NUM = "1";

    public abstract void show();

}

interface MyInterface2 {
    public static final String NUM = "1";

    public void show();

    public void show2();
}

class InterfaceClass extends SuperClass {

    public int num = 10;

   /* @Override
    public void show() {
        System.out.println("show zi");
    }*/


    public static void main(String[] args) {
        SuperClass fu = new InterfaceClass();

        /**
         * 多态指向成员变量时, 编译看左边 运行不向下转换类型也看左边
         * */
        int num = ((InterfaceClass)fu).num;

        /**
         * 多态调用非静态成员方法时,编译看左边,运行先看右边,子类有就调用子类,没有调用父类
         */
        fu.show();



    }

}

class SuperClass {
    public int num = 100;

    public void show() {
        System.out.println("show fu");
    }
}
