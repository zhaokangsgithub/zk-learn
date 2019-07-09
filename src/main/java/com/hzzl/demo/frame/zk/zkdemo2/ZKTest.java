package com.hzzl.demo.frame.zk.zkdemo2;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class ZKTest implements Runnable
{

    //订单号生成类
    private static OrderNumGenerator orderNumGenerator = new OrderNumGenerator();

    private MyLock lock = new ZookeeperDistributeLock();
    //private Lock lock = new ZookeeperDistributeLock2();

    @Override
    public void run()
    {
        getNumber();
    }

    public void getNumber(){
        try {
            lock.getLock();
            String number = orderNumGenerator.getNumber();
            System.out.println(Thread.currentThread().getName() + ",产生了订单:" + number);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unLock();
        }
    }

    public static void main(String[] args) {
        System.out.println("##生成了订单####");
        ThreadPoolExecutor threadPools = new ThreadPoolExecutor
            (10,10,1000,TimeUnit.MILLISECONDS,new LinkedBlockingDeque(),
                new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build());

        for(int i=0;i<500;i++){
            threadPools.execute(new ZKTest());
        }
    }
}

class OrderNumGenerator {

    private static final String FORMAT_STR = "yyyy-MM-dd-HH-mm-ss";
    public static int count =0;

    public String getNumber(){
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_STR);
        return sdf.format(new Date()) + "_" + ++count;
    }

}

