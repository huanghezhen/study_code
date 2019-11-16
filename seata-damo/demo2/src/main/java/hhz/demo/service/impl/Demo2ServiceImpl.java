package hhz.demo.service.impl;

import hhz.demo.dao.Demo2Mapper;
import hhz.demo.demo2.service.Demo2Service;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: Demo2ServiceImpl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/16 0016 16:32
 */
@Service(version = "1.0.0")
public class Demo2ServiceImpl implements Demo2Service {

    @Autowired
    private Demo2Mapper demo2Mapper;

    @Override
    public int updateMoney() {
        demo2Mapper.updateMoney();
        return 0;
    }
}
