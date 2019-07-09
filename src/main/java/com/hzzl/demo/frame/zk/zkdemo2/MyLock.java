package com.hzzl.demo.frame.zk.zkdemo2;

public interface MyLock
{
    /**
     * 获取锁
     */
    void getLock();

    /**
     * 释放锁
     */
    void unLock();
}
