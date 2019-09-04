package hhz.demo08;

import hhz.demo08.thrift.generated.DataException;
import hhz.demo08.thrift.generated.Person;
import hhz.demo08.thrift.generated.PersonService;
import org.apache.thrift.TException;

/**
 * @ClassName: PersonServiceImpl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/3 下午 01:04
 */
public class PersonServiceImpl implements PersonService.Iface
{
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException
    {
        System.out.println("Got Client Param: " + username);
        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException
    {
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
