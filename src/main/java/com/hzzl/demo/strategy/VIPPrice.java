package com.hzzl.demo.strategy;

/**
 * @ClassName: VIPPrice
 * @Description: 不同等级的会员, 不同的折旧
 * @Auther: Administrator
 * @Date: 2019/4/12 15:09
 */
public class VIPPrice {

    public static void main(String[] args) {

        DaoUtil daoUtil = new DaoUtil();
        daoUtil.setSuperCal(new Add());
        daoUtil.getPriceByVipLevel();
        daoUtil.getSuperCal().baseMethod();

    }

}


interface CalStraegy {

    void calculate();

}

abstract class SuperCal implements CalStraegy{

    CalStraegy calStraegy;

    public void baseMethod(){
        System.out.println("baseMethod.....running......");
    }

}

class Add extends SuperCal{

    @Override
    public void calculate() {
        System.out.println("加法");
    }
}

class Rmv extends SuperCal{

    @Override
    public void calculate() {
        System.out.println("减法");
    }
}

class DaoUtil {

    private SuperCal superCal;


    public SuperCal getSuperCal() {
        return superCal;
    }

    public void setSuperCal(SuperCal superCal) {
        this.superCal = superCal;
    }

    public DaoUtil() {
    }

    public void getPriceByVipLevel(){
        superCal.calculate();
    }
}