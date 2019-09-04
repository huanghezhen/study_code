package hhz.io.decorate;

import java.io.*;
import java.util.Date;

/**
 * @ClassName: ObjectTest01
 * @Description: 对象流
 * @author: huanghz
 * @date: 2019/7/4 11:27
 *
 * 不是所有的对象都能使用对象流，需要实现序列化 Serializable
 *
 * ObjectOutputStream
 * ObjectInputStream
 */
public class ObjectTest01 implements Serializable
{
    public static void main(String[] args) throws Exception
    {
        // 写
        ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream("hhz/data/ObjectTest01"));

        dos.writeUTF("编码心酸泪");
        dos.writeInt(18);
        dos.writeBoolean(true);
        dos.writeChar('a');
        dos.writeObject("对象");
        dos.writeObject(new Date());
        Emp emp = new Emp("hhz", 500000D);
        dos.writeObject(emp);
        dos.flush();
        dos.close();


        // 读取
        ObjectInputStream dis = new ObjectInputStream(new FileInputStream("hhz/data/ObjectTest01"));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char a = dis.readChar();
        String o1 = (String) dis.readObject();
        Date o2 = (Date) dis.readObject();
        Emp o3 = (Emp) dis.readObject();

        System.out.println(msg);
        System.out.println(age);
        System.out.println(flag);
        System.out.println(a);
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);

    }
}

class Emp implements Serializable
{
    private String name;
    // 该数据不需要序列化
    private transient Double salary;

    public Emp(String name, Double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getSalary()
    {
        return salary;
    }

    public void setSalary(Double salary)
    {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"salary\":")
                .append(salary);
        sb.append('}');
        return sb.toString();
    }
}
