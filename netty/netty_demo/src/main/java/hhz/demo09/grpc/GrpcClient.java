package hhz.demo09.grpc;

import hhz.demo09.proto.MyRequest;
import hhz.demo09.proto.MyResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @ClassName: GrpcClient
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/3 下午 07:57
 */
public class GrpcClient
{
    public static void main(String[] args)
    {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext().build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        MyResponse myResponse = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("hhhh").build());
        System.out.println(myResponse.getRealname());

    }
}
