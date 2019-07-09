package com.hzzl.demo.frame.zk.zkdemo2;

import org.I0Itec.zkclient.ZkClient;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public abstract class AbstrackLock implements MyLock
{

    private static String CONNECT_PATH = "127.0.0.1:2181";

    protected ZkClient zkClient = new ZkClient(CONNECT_PATH);

    protected static final String PATH = "/lock";

    protected static final String PATH2 = "/lock2";

    @Override
    public void getLock()
    {
        if(tryLock()){
            System.out.println("##获取锁的资源===============");
        }else{
            waitLock();
            getLock();
        }
    }

    /**
     * 尝试拿到锁
     * @return
     */
    public abstract boolean tryLock();

    /**
     * 等待锁
     * @return
     */
    public abstract void waitLock();
}
