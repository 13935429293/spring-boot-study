package org.ywb.study.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * User: yangwenbiao
 * Date: 2017/2/25
 * Time: 15:39
 */
public class ZkClientStudy {

    public static void main(String[] args) {
        ZkClient zk = new ZkClient("172.16.10.62:2181,172.16.10.63:2181");
        zk.createPersistent("xiaoyang");
        zk.create("xiaoyang/root", "zkClient study", CreateMode.EPHEMERAL_SEQUENTIAL);

        List<String> list = zk.getChildren("xiaoyang");
        int count = zk.countChildren("xiaoyang");
        boolean exists = zk.exists("/xiaoyang/node/1");

    }
}
