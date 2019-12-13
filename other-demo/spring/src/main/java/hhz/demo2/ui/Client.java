package hhz.demo2.ui;

import hhz.demo2.mapper.AccountMapper;
import hhz.demo2.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: Clinet
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 15:29
 */
public class Client {
    public static void main(String[] args) throws Exception {
        /*
            ClassPathXmlApplicationContext
                加载类路径下的配置文件
            FileSystemXmlApplicationContext
                加载磁盘任意文件下的配置文件
            AnnotationConfigApplicationContext
                读取注解创建容器
         */

        /*
            ApplicationContext
                读完配置文件 对象就被创建
            BeanFactory
                懒加载
         */

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        AccountMapper accountMapper = applicationContext.getBean("accountDao",AccountMapper.class);

        System.out.println(accountService);
        System.out.println(accountMapper);

    }
}
