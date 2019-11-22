package hhz.demo.service.impl;

import hhz.demo.dao.TccDemo1Mapper;
import hhz.demo.service.TccDemo1Service;
import hhz.demo.service.TccDemo2Service;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TccDemo1ServiceImpl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/17 0017 11:45
 */
@Service
public class TccDemo1ServiceImpl implements TccDemo1Service {
    @Autowired
    private TccDemo1Mapper tccDemo1Mapper;

    @Reference(version = "1.0.0",check = false)
    private TccDemo2Service tccDemo2Service;


    @Override
    public int updateMoney() {
        tccDemo1Mapper.updateMoney();
        tccDemo2Service.updateMoney();
        return 0;
    }
}
