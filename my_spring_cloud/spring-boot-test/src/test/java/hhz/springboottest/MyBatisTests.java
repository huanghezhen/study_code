package hhz.springboottest;

import hhz.springboottest.domain.User;
import hhz.springboottest.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: MyBatisTests
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/4 下午 12:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootTestApplication.class)
public class MyBatisTests
{
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("hh");
        userMapper.insert(user);
        System.out.println(user);
    }

    @Test
    public void testSelect() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }
}
