package hhz.service.impl;

import hhz.dao.UserMapper;
import hhz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/17 13:05
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int getCount() {
        return userMapper.getCount();
    }
}
