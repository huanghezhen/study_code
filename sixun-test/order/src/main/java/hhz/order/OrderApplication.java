package hhz.order;

import org.apache.servicecomb.pack.omega.spring.EnableOmega;
import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: OrderApplication
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 9:54
 */
@SpringBootApplication
@EnableServiceComb
@MapperScan(value = {"hhz.order.dao"})
@EnableOmega
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
