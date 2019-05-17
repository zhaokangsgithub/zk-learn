package com.hzzl.demo.strategy.agin;

import com.hzzl.demo.strategy.agin.UserRightImpl.SuperVIPRight;
import com.hzzl.demo.strategy.agin.UserRightImpl.VIPRight;

/**
 * ClassName:  <br/>
 * Function:  这是策略模式第二次书写的测试类,公众号看到对策略模式的描述后,进行巩固
 * date:   2019/05/17
 *
 * @author
 * @since JDK 1.6
 */
public class StrategyTest {

    /**
     * 1.策略模式是针对同一算法,互斥的情况下,对if-else多重嵌套的补充..
     * <p>
     * 组合(用来整合策略算法)
     * 抽象接口(功能抽象,不同的算法有不同的实现)
     * 具体接口的实现类(不同功能的实现)
     */
    public static void main(String[] args) {

        calcPrice(new SuperVIPRight(), 300.0);
        System.out.println("========");
        calcPrice(new VIPRight(), 300.0);
    }

    private static void calcPrice(UserRight userRight, Double srcprice) {

        PayGroup payGroup = new PayGroup(userRight);
        Double desPrice = payGroup.calcPrice(srcprice);
        System.out.println(desPrice);
    }
}
