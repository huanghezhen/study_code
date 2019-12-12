package hhz.service.impl;

import hhz.dao.UserMapper;
import hhz.service.iface.DemoService;
import org.apache.servicecomb.pack.omega.transaction.annotations.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DemoServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/12 15:48
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Compensable(compensationMethod = "cancel")
    public void updateMoney() {
        System.out.println("demo2 updateMoney");
        userMapper.reduceMoney();
    }

    public void cancel() {
        System.out.println("demo2 cancel");
        userMapper.addMoney();
    }
}
