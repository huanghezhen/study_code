package hhz.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: Oauth2ApplicationTest
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/1 下午 03:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Oauth2ApplicationTest
{
    @Test
    public void testBCryptPasswordEncoder() {
        System.out.println(new BCryptPasswordEncoder().encode("admin888"));
    }
}
