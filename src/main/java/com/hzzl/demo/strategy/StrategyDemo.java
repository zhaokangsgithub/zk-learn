package com.hzzl.demo.strategy;


/**
 * @ClassName: StrategyDemo
 * @Description: TODO
 * @Auther: Administrator
 * @Date: 2019/4/12 14:10
 */
public class StrategyDemo {

    public static void main(String[] args) {

        DuckSon1 duckSon1 = new DuckSon1();
        duckSon1.fly();
        duckSon1.eat();

        /*DuckSon1 duckSon1 = new DuckSon1(new Fly() {
            @Override
            public void fly() {
                System.out.println("fly具体实现方法调用");
            }
        });
        duckSon1.f.fly();
        duckSon1.eat();*/
    }
}


interface Fly{
    void fly();
}

abstract class SuperDuck implements Fly{

    public void eat(){
        System.out.println("eat方法调用....");
    }

}


class DuckSon1 extends SuperDuck{

    @Override
    public void fly() {
        System.out.println("fly具体实现方法调用22");
    }
}