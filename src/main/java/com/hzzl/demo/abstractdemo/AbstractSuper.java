package com.hzzl.demo.abstractdemo;

/**
 * @ClassName: AbstractSuper
 * @Description: TODO
 * @Auther: Administrator
 * @Date: 14:18
 */
public abstract class AbstractSuper {

    public MyInterface myInterface;

    public AbstractSuper() {
        System.out.println("父类构造方法调用");
    }

    static{
        System.out.println("父类静态代码块调用");
    }

    public abstract void  run();

    public void say(){

        System.out.println("say方法调用");

    }

}


class  AbstractSon extends AbstractSuper{

    public AbstractSon() {
        System.out.println("子类构造方法调用");
    }

    static{
        System.out.println("子类静态代码块调用");
    }

    public void set(MyInterface myInterface){
        super.myInterface=myInterface;
    }

    public AbstractSon(MyInterface myInterface) {
        super.myInterface=myInterface;
        System.out.println("子类构造方法调用");
    }

    @Override
    public void run() {
        System.out.println("run方法调用");
    }

    public static void main(String[] args) {


        MyInterface myInterface = new MyInterface() {
            @Override
            public void run2() {
                System.out.println("run2方法调用");
            }
        };
        AbstractSon son = new AbstractSon(myInterface);
//        son.run();
//        son.say();
//        son.set(myInterface);
        son.myInterface.run2();
    }
}