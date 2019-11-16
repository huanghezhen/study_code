package hhz.demo.service.impl;

import hhz.demo.dao.Demo3Mapper;
import hhz.demo.demo3.service.Demo3Service;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: Demo3ServiceImpl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/16 0016 16:32
 */
@Service(version = "1.0.0")
public class Demo3ServiceImpl implements Demo3Service {

    @Autowired
    private Demo3Mapper demo3Mapper;

    @Override
    public int updateMoney() {
        demo3Mapper.updateMoney();
        return 0;
    }
}
