package com.hzzl.demo.zk.zkdemo1;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class ZKDemo {

    private static final String ZK_IP_PORT = "127.0.0.1:2181";

    private static final int CONNECT_OUT_TIME = 5000;

    private static  ZkClient zkClient = null;

    static{
        zkClient = new ZkClient(ZK_IP_PORT,CONNECT_OUT_TIME);
        System.out.println("ZK 成功建立连接！");
        //根节点信息 node_zk
    }

    public static void main(String[] args) {
        try {
           //创建节点 createNode();
            //查询所有节点
            watcherTest("/node_zk/aaa");
            Thread.sleep(2000);
//            createNode("/node_zk/aaa",100);
            setData("/node_zk/aaa",200);
            readData("/node_zk/aaa");
//            deleteNode("/node_zk/aa");
            while (true){

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("节点已存在,创建失败");
        }finally {
            if (zkClient != null) {
                zkClient.close();
            }
        }
    }

    public static void deleteNode(String path){

        boolean delete = zkClient.delete(path);
        System.out.println(delete);

    }

    public static void setData(String path,Object value){
        zkClient.writeData(path, value);
        System.out.println("set node value successful");
    }


    public static void readData(String path){
        Object o = zkClient.readData(path);
        System.out.println(o);
    }


    public static void createNode(String path,Object value){
        String s = zkClient.create(path, value, CreateMode.PERSISTENT);
        System.out.println("创建节点: "+s+" 成功");
    }

    public static void watcherTest(String path){

        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("检测节点变化");
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("检测节点删除");
            }
        });


    }
}