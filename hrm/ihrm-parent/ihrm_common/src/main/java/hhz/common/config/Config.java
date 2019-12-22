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
/*@Configuration
public class Config extends WebMvcConfigurationSupport {
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
    @Bean
    public JwtUtils jwtUtils() {
        return new JwtUtils();
    }

    @Bean
    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
        return new OpenEntityManagerInViewFilter();
    }

    @Autowired
    private JwtInterceptor jwtInterceptor;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/sys/login", "/frame/register/**");
    }
}*/

@Configuration
public class Config {
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

}