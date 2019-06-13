package com.hzzl.demo.designmode.factoryModel;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class FactoryTestTow
{
    public static void main(String[] args)
    {
        Operator add = OperatorFactory.createOperator("add");
        Double result = add.getResult(1d, 2d);
        System.out.println(result);
    }


}

class AddOperator implements Operator
{

    @Override
    public Double getResult(Double srcNum, Double decNum)
    {
        return srcNum + decNum;
    }
}

class RemoveOperator implements Operator
{

    @Override
    public Double getResult(Double srcNum, Double decNum)
    {
        return srcNum - decNum;
    }
}

interface Operator
{

    Double srcNum = null;

    Double decNum = null;

    public Double getResult(Double srcNum, Double decNum);

}

class OperatorFactory
{

    public static  Operator createOperator(String opeType)
    {
        switch (opeType){
            case "add":
                    return new AddOperator();
            case "remove":
                    return new RemoveOperator();

        }
        return null;
    }

}
