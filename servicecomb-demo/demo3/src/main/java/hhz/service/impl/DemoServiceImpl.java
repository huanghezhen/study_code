package hhz.service.impl;

import hhz.dao.UserMapper;
import hhz.service.iface.DemoService;
import org.apache.servicecomb.pack.omega.context.annotations.SagaStart;
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
    @SagaStart
    @Compensable(compensationMethod = "cancel")
    public void updateMoney() {
        System.out.println("demo3 updateMoney");
        userMapper.reduceMoney();
        throw new RuntimeException("主动报错");
    }

    public void cancel() {
        System.out.println("demo3 cancel");
        userMapper.addMoney();
    }
}
