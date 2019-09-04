package hhz.io.decorate;

import java.io.*;

/**
 * @ClassName: DataTest01
 * @Description: 数据流
 * @author: huanghz
 * @date: 2019/7/4 11:09
 *
 * 1 先写出 后读取
 * 2 读取的顺序与写出的顺序保持一致
 *
 * DataOutputStream
 * DataInputStream
 */
public class DataTest01
{
    public static void main(String[] args) throws IOException
    {
        // 写
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        dos.writeUTF("编码心酸泪");
        dos.writeInt(18);
        dos.writeBoolean(true);
        dos.writeChar('a');
        dos.flush();

        // 读取
        byte[] datas = baos.toByteArray();
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(datas));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char a = dis.readChar();

        System.out.println(msg);
        System.out.println(age);
        System.out.println(flag);
        System.out.println(a);
    }
}
