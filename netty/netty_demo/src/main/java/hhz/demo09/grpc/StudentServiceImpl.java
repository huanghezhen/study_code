package hhz.demo09.grpc;

import hhz.demo09.proto.MyRequest;
import hhz.demo09.proto.MyResponse;
import io.grpc.stub.StreamObserver;

/**
 * @ClassName: StudentServiceImpl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/3 下午 07:45
 */
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase
{
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver)
    {
        System.out.println("接收到客户端信息: " + request.getUsername());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onCompleted();
    }
}
