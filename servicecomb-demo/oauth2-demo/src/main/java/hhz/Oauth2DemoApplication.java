package hhz;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: Oauth2DemoApplication
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/17 11:52
 */
@SpringBootApplication
@EnableServiceComb
@MapperScan("hhz.dao")
public class Oauth2DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2DemoApplication.class, args);
    }
}
