package com.hzzl.demo.zk;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;

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

//    static CountDownLatch threadLatch = new CountDownLatch(10);

    public static void main(String[] args)
    {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                DistributedLock lock = null;
                try {
                    lock = new DistributedLock("127.0.0.1:2181", "test1");
//                    threadLatch.await();
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
            Thread t = new Thread(runnable);
//            threadLatch.countDown();
            t.start();
        }
    }
}
