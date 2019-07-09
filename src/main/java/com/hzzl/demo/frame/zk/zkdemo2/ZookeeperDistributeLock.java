package com.hzzl.demo.frame.zk.zkdemo2;

import org.I0Itec.zkclient.IZkDataListener;

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
public class ZookeeperDistributeLock extends AbstrackLock
{
    private CountDownLatch countDownLatch = null;

    @Override
    public void unLock()
    {
        if(zkClient != null){
            zkClient.delete(PATH);
            zkClient.close();
            System.out.println("释放锁资源");
        }
    }

    @Override
    public boolean tryLock()
    {
        /**
         * 创建节点是否成功,成功则返回true,异常的时候则表明节点已存在
         */
        try
        {
            zkClient.createEphemeral(PATH);
            return true;
        }
        catch (RuntimeException e)
        {
            return false;
        }
    }

    @Override
    public void waitLock()
    {
        //节点删除了,就可以拿到锁了
        IZkDataListener listener = new IZkDataListener()
        {
            @Override
            public void handleDataChange(String dataPath, Object data)
                throws Exception
            {

            }

            @Override
            public void handleDataDeleted(String dataPath)
                throws Exception
            {
                //唤醒被等待的线程
                if(countDownLatch != null){
                    countDownLatch.countDown();
                }
            }
        };

        //监听器已经创建,需要监听事件
        zkClient.subscribeDataChanges(PATH,listener);

        //如果节点存在了，则需要等待一直到接收到了事件通知
        if(zkClient.exists(PATH)){
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(PATH,listener);
    }
}
