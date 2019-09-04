package hhz.demo08;

import hhz.demo08.thrift.generated.Person;
import hhz.demo08.thrift.generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @ClassName: ThriftClient
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/3 下午 01:14
 */
public class ThriftClient
{
    public static void main(String[] args)
    {
        TTransport tTransport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(tTransport);
        PersonService.Client client = new PersonService.Client(protocol);

        try
        {
            tTransport.open();

            Person person = client.getPersonByUsername("张三");

            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            Person person1 = new Person();
            person1.setUsername("lisi");
            person1.setAge(20);
            person1.setMarried(true);

            client.savePerson(person1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage(), e);
        }finally
        {
            tTransport.close();
        }
    }
}
