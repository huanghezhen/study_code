package hhz.demo.service.impl;

import hhz.demo.dao.Demo1Mapper;
import hhz.demo.demo1.service.Demo1Service;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: Demo1ServiceImpl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/16 0016 16:31
 */
@Service(version = "1.0.0")
public class Demo1ServiceImpl implements Demo1Service {
    @Autowired
    private Demo1Mapper demo1Mapper;
    @Override
    public int updateMoney() {
        return demo1Mapper.updateMoney();
    }
}
