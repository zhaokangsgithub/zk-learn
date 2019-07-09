package com.hzzl.demo.designmode.strategy.agin.UserRightImpl;

import com.hzzl.demo.designmode.strategy.agin.UserRight;
import com.hzzl.demo.util.PropUtil;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class SuperVIPRight implements UserRight {

    @Override
    public Double getDiscountByLevel() {
        return  new Double(PropUtil.getProp("discounts.calc.super-vip", "application.properties"));
    }
}
