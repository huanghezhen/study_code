package hhz.dubbo.consumer;

import hhz.dubbo.api.HelloServer;
import hhz.dubbo.netty.NettyClient;

/**
 * huanghz
 * 2019/12/1 下午4:22
 */
public class ClientBootstrap {
    public static final String pName = "HelloServer#hello#";

    public static void main(String[] args) throws Exception {
        NettyClient nettyClient = new NettyClient();
        HelloServer helloServer = (HelloServer) nettyClient.getBean(HelloServer.class, pName);


        String hh = helloServer.hello("hh");

        System.out.println("调用的结果=" + hh);
    }
}
