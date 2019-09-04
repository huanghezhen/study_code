package hhz.demo10.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @ClassName: GrpcServer
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/3 下午 07:49
 */
public class GrpcServer
{
    private Server server;

    private void start() throws IOException
    {
        this.server = ServerBuilder.forPort(8899).addService(new StudentServiceImpl()).build().start();
        System.out.println("服务器启动");


        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("关闭jvm");
            GrpcServer.this.stop();
        }));

        System.out.println("执行到这");


    }

    private void stop()
    {
        if (null != server)
        {
            server.shutdown();
        }
    }

    private void awaitTerminatioin() throws InterruptedException
    {
        if (null != server)
        {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException
    {
        GrpcServer grpcServer = new GrpcServer();
        grpcServer.start();
        grpcServer.awaitTerminatioin();
    }
}
