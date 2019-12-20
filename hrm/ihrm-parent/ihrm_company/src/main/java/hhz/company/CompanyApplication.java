package hhz.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: CompanyApplication
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/18 14:18
 */
@SpringBootApplication
@EntityScan("hhz.common.model.domain")
@ComponentScan("hhz")
public class CompanyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }
}
