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
public class FactoryTestSecond implements calcul
{

    @Override
    public Double add(double...num)
    {
        double res= num[0]+ num[1];
        System.out.println(res);
        return res;
    }

    @Override
    public Double remove(double...num)
    {
        double res= num[0]- num[1];
        System.out.println(res);
        return res;
    }

    public Double getResult(double srcNum,double desNum,String operator){

        switch (operator){
            case "add":
                    return add(srcNum,desNum);
            case "remove":
                    return remove(srcNum,desNum);
            default:
                    System.out.println("无效操作");
                    break;
        }

        return null;
    }

    public static void main(String[] args)
    {
      new FactoryTestSecond().getResult(1,2,"add");

    }

}


interface calcul {

    Double add(double...num);

    Double remove(double...numm);

}