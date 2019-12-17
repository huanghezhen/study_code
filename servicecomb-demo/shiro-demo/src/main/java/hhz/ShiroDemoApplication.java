package hhz;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: ShiroDemoApplication
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/17 15:53
 */
@SpringBootApplication
@EnableServiceComb
public class ShiroDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiroDemoApplication.class, args);
    }
}
