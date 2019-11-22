package hhz.demo.service.impl;

import hhz.demo.dao.TccDemo2Mapper;
import hhz.demo.service.TccDemo2Service;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: TccDemo2ServiceImpl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/17 0017 11:43
 */
@Service(version = "1.0.0")
public class TccDemo2ServiceImpl implements TccDemo2Service {
    @Autowired
    private TccDemo2Mapper tccDemo2Mapper;
    @Override
    public int updateMoney() {
        return tccDemo2Mapper.updateMoney();
    }
}
