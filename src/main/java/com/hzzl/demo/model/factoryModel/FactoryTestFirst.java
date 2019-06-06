package com.hzzl.demo.model.factoryModel;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class FactoryTestFirst
{

    public static void main(String[] args)
    {
        Double result = cacle(10, 5, "add");
        System.out.println(result);
    }

    public static Double cacle(double srcNum,double desNum, String operator){

        if("add".equals(operator)){
            return srcNum+desNum;
        }else if("remove".equals(operator)){
            return srcNum-desNum;
        }
        return null;
    }
}
