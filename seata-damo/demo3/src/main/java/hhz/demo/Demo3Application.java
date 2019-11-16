package hhz.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: Service01Application
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/27 下午 04:57
 */
@SpringBootApplication
@MapperScan(value = {"hhz.demo.dao"})
public class Demo3Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Demo3Application.class, args);
    }

}
