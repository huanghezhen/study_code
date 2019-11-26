package hhz.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: BIOService
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/22 11:11
 */
public class BIOService {




    public static void main(String[] args) throws Exception {
        // 线程池机制
        /*
        思路
        1 创建线程池
        2 如果有客户端连接 就创建一个线程 与之通信(单独写一个方法)
         */

        ExecutorService executorService = Executors.newCachedThreadPool();

        // 创建serverSocket
        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("服务器启动了");
        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            // 创建线程与之通信

            handler(socket);
        }
    }


    /**
     * @Description: 编写一个handler方法 和客户端通信
     * @Param: [socket]
     * @Return: void
     * @Author: huanghz
     * @Date: 2019/11/25 9:10
     */
    private static void handler(Socket socket) {
        try {
            System.out.println("线程信息: "+Thread.currentThread().getId());
            byte[] bytes = new byte[1024];
            // 通过socket 获取输入流
            InputStream inputStream = socket.getInputStream();
            int length = 0;
            while (length != -1) {
                length = inputStream.read(bytes);
                System.out.print("线程信息: "+Thread.currentThread().getId()+"   ");
                System.out.println(new String(bytes, 0, bytes.length));
            }
            System.out.println("结束循环");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
