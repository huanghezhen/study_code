package hhz.pay;

import org.apache.servicecomb.pack.omega.spring.EnableOmega;
import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: PayApplication
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 9:53
 */
@SpringBootApplication
@EnableServiceComb
@MapperScan(value = {"hhz.pay.dao"})
@EnableOmega
public class PayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }
}
