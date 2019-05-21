package com.hzzl.demo.zk.zkdemo2;

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
