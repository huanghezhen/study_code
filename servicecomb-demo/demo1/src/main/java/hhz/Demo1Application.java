package hhz;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: Demo1Application
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/12 15:17
 */
@SpringBootApplication
@EnableServiceComb
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
}
