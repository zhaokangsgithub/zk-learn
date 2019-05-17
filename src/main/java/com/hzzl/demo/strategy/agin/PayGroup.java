package com.hzzl.demo.strategy.agin;

import java.math.BigDecimal;

/**
 * ClassName:  <br/>
 * Function:  组合类,将不同的策略组合起来
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class PayGroup {

    private UserRight userRight;

    public PayGroup(UserRight userRight) {
        this.userRight = userRight;
    }

    public Double calcPrice(Double srcPrice) {
        Double discounts = userRight.getDiscountByLevel();
        BigDecimal srcBDPrice = new BigDecimal(srcPrice);
        BigDecimal discountsBD = new BigDecimal(discounts);
        return srcBDPrice.multiply(discountsBD).doubleValue();
    }
}