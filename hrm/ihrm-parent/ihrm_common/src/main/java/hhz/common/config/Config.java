package hhz.common.config;

import hhz.common.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: Config
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/18 14:44
 */
@Configuration
public class Config {
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
