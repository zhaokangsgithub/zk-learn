package com.hzzl.demo.zk.zkdemo1;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

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
public class ZKLockTest
{

    static int n = 500;

    public static void secskill() {
        System.out.println(--n);
    }

    public static void main(String[] args)
    {
        ThreadPoolExecutor threadPools = new ThreadPoolExecutor(10,10,1000,TimeUnit.MILLISECONDS,new LinkedBlockingDeque()
        ,  new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                DistributedLock lock = null;
                try {
                    lock = new DistributedLock("127.0.0.1:2181", "test1");
                    lock.lock();
                    secskill();
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                } catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            threadPools.execute(runnable);
        }
    }
}
