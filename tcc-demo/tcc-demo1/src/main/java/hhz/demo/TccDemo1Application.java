package hhz.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * @ClassName: Service01Application
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/27 下午 04:57
 */
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@MapperScan(value = {"hhz.demo.dao","org.dromara.hmily"})
public class TccDemo1Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(TccDemo1Application.class, args);
    }

}
