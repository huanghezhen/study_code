package hhz.demo10.grpc;

import hhz.demo10.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;

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
        StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(managedChannel);
        MyResponse myResponse = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("hhhh").build());
        System.out.println(myResponse.getRealname());


        System.out.println("-------------------------------");

        Iterator<StudentResponse> studentsByAge = blockingStub.getStudentsByAge(StudentRequest.newBuilder().setAge(20).build());

        while (studentsByAge.hasNext())
        {
            StudentResponse studentResponse = studentsByAge.next();
            System.out.println(studentResponse.getName()+","+studentResponse.getAge()+","+studentResponse.getCity());
        }
        System.out.println("-------------------------------");

        StreamObserver<StudentResponseList> studentResponseListStreamObserver = new StreamObserver<StudentResponseList>()
        {
            @Override
            public void onNext(StudentResponseList value)
            {
                value.getStudentResponseList().forEach(studentResponse -> {
                    System.out.println(studentResponse.getName());
                    System.out.println(studentResponse.getAge());
                    System.out.println(studentResponse.getCity());
                    System.out.println("*******");
                });
            }

            @Override
            public void onError(Throwable t)
            {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted()
            {
                System.out.println("onCompleted");
            }
        };

        StreamObserver<StudentRequest> studentRequestStreamObserver = stub.getStudentsWrapperByAges(studentResponseListStreamObserver);

        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(20).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(30).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(40).build());

        studentRequestStreamObserver.onCompleted();

        System.out.println("-------------------------------  ssssss");



        StreamObserver<StreamResponse> streamResponseStreamObserver = new StreamObserver<StreamResponse>()
        {
            @Override
            public void onNext(StreamResponse value)
            {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t)
            {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted()
            {
                System.out.println("onCompleted");
            }
        };

        StreamObserver<StreamRequest> streamRequestStreamObserver = stub.biTalk(streamResponseStreamObserver);

        streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo("client 1").build());
        streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo("client 2").build());
        streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo("client 3").build());

        streamRequestStreamObserver.onCompleted();

        try
        {
            Thread.sleep(5*1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}
