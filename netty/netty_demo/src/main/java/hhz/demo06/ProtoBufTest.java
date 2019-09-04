package hhz.demo06;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @ClassName: ProtoBufTest
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/1 下午 03:24
 */
public class ProtoBufTest
{
    public static void main(String[] args) throws InvalidProtocolBufferException
    {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("张三")
                .setAge(20)
                .setAddress("南京")
                .build();

        byte[] student2ByteArray = student.toByteArray();

        DataInfo.Student student1 = DataInfo.Student.parseFrom(student2ByteArray);

        System.out.println(student1.getName());
        System.out.println(student1.getAge());
        System.out.println(student1.getAddress());
    }
}
