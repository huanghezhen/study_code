package hhz.dubbo.provider;

import hhz.dubbo.api.HelloServer;

/**
 * huanghz
 * 2019/12/1 下午3:26
 */
public class HelloServerImpl implements HelloServer {

    @Override
    public String hello(String msg) {
        System.out.println("收到客户端的消息:" + msg);
        if (msg != null) {
            return "你好客户端,我已经收到你的消息 [ "+ msg +" ]";
        }
        return "你好客户端,你发送的消息为空";
    }
}
