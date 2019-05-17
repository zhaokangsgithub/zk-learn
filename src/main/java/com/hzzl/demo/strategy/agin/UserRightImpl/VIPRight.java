package com.hzzl.demo.strategy.agin.UserRightImpl;

import com.hzzl.demo.strategy.agin.UserRight;
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
public class VIPRight implements UserRight {
    
    @Override
    public Double getDiscountByLevel() {
        return  new Double(PropUtil.getProp("discounts.calc.vip", "application.properties"));
    }
}
