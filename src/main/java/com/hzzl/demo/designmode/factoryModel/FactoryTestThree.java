package com.hzzl.demo.designmode.factoryModel;

/**
 * 工厂测试类
 */
public class FactoryTestThree
{
    public static void main(String[] args)
    {
        /*Sales discount = SalesFactory.createSale("discount");
        Double result = discount.getResult(10, 5, 0.75);
        System.out.println(result);*/
        Context context = new Context("reduce");
        double v = context.calaResult(10, 5, 10, 7);
        System.out.println(v);
    }
}

/**
 * 功能描述:
 * 实现数据累加(单价*数量)
 * 打折功能
 * 满减功能
 */
interface Sales
{
    public Double getResult(double price, double num, double... params);
}

/**
 * 满减折扣
 */
class ReduceSales implements Sales
{
    @Override
    public Double getResult(double price, double num, double... params)
    {
        //参数校验
        checkReduceParam(params);
        double baseRes = price * num;
        if (!(baseRes < params[0]))
        {
            double param = baseRes / params[0]; //1  2  3
            double floorNum = Math.floor(param);
            baseRes = baseRes - (floorNum * params[1]);
        }
        return baseRes;
    }

    private void checkReduceParam(double... params)
    {
        if (params.length < 2 || params[0] < 0 || params[1] < 0 || params[0] < params[1])
        {
            throw new IllegalArgumentException("ReduceSales params参数异常:" + params);
        }
    }
}

/**
 * 按折扣价打折
 */
class DiscountSales implements Sales
{

    @Override
    public Double getResult(double price, double num, double... params)
    {
        //参数校验
        checkDisountParam(params);
        double dis = params[0];
        return price * num * dis;
    }

    private void checkDisountParam(double[] params)
    {
        if (params.length == 0 || params[0] > 1 || params[0] < 0)
        {
            throw new IllegalArgumentException("DiscountSales params参数异常:" + params);
        }
    }
}

class Context
{

    private Sales sales = null;

    public Context(String saleType)
    {
        switch (saleType)
        {
            case "discount":
                this.sales = new DiscountSales();
                break;
            case "reduce":
                this.sales = new ReduceSales();
                break;
        }
    }

    public double calaResult(double price, double num, double... params)
    {
        return sales.getResult(price, num, params);
    }
}


/*
class SalesFactory
{
    public static Sales createSale(String saleType)
    {
        switch (saleType)
        {
            case "discount":
                return new DiscountSales();
            case "reduce":
                return new ReduceSales();
        }
        System.out.println("saleType有误,未找到对用的类型");
        return null;
    }
}*/
