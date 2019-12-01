package hhz.dubbo.provider;

import hhz.dubbo.netty.NettyServer;

/**
 * huanghz
 * 2019/12/1 下午3:29
 */
public class ServerBootstrap {
    public static void main(String[] args) throws Exception {
        NettyServer.startServer(8888);
    }
}
