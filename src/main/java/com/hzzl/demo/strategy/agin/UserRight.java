package com.hzzl.demo.strategy.agin;

/**
 * 会员计算费用的向上抽取
 */
public interface UserRight {

    /**
     *  获取具体的会员折扣
     */
    public Double getDiscountByLevel();
}
