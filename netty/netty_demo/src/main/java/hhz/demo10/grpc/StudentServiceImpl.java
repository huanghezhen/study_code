package hhz.demo10.grpc;

import hhz.demo10.proto.*;
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

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver)
    {
        System.out.println("接收到客户端信息: " + request.getAge());
        responseObserver.onNext(StudentResponse.newBuilder().setName("1").setAge(20).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("2").setAge(20).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("3").setAge(20).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("4").setAge(20).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("5").setAge(20).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("6").setAge(20).setCity("北京").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAges(StreamObserver<StudentResponseList> responseObserver)
    {
        return new StreamObserver<StudentRequest>()
        {
            @Override
            public void onNext(StudentRequest value)
            {
                System.out.println("onNext: "+ value.getAge());
            }

            @Override
            public void onError(Throwable t)
            {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted()
            {
                StudentResponse studentResponse = StudentResponse.newBuilder().setName("1").setAge(20).setCity("南京").build();
                StudentResponse studentResponse2 = StudentResponse.newBuilder().setName("2").setAge(20).setCity("南京").build();

                StudentResponseList studentResponseList = StudentResponseList.newBuilder().addStudentResponse(studentResponse)
                        .addStudentResponse(studentResponse2).build();
                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver)
    {
        return new StreamObserver<StreamRequest>()
        {

            @Override
            public void onNext(StreamRequest value)
            {
                System.out.println("onNext: "+ value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo("server to " + value.getRequestInfo()).build());
            }

            @Override
            public void onError(Throwable t)
            {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted()
            {

                responseObserver.onCompleted();
            }
        };
    }
}
