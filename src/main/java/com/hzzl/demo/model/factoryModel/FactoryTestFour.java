package com.hzzl.demo.model.factoryModel;

/**
 * 工厂方法模式
 *
 * 简单工厂: 实现了将客户端和具体实现解耦,利用工厂类做媒介..用工厂类的switch 来得到具体的实现,工厂类内部有具体的实现
 *          但是也违背了开闭原则 对扩展开放,对修改封闭  增加方法时,需要增加简单工厂的switch 的case分支
 *
 * 工厂方法;
 *          将选择具体的逻辑放到了客户端来进行处理,客户端进行创建具体工厂,调用具体方法..无需修改
 *
 *
 */
public class FactoryTestFour
{
    public static void main(String[] args)
    {
        LeiFeng leiFeng = new VolunteerFactory().createLeiFeng();
    }

}

interface IFactory{

   LeiFeng createLeiFeng();
}

class VolunteerFactory implements IFactory{

    @Override
    public LeiFeng createLeiFeng()
    {
        return new Volunteer();
    }
}

class Volunteer extends LeiFeng{}

class LeiFeng{

    public void sweep(String a,String B){
        System.out.println("sweep");
    }
}




