package hhz.demo.service.impl;

import hhz.demo.dao.Demo1Mapper;
import hhz.demo.demo2.service.Demo2Service;
import hhz.demo.demo3.service.Demo3Service;
import hhz.demo.service.iface.Demo1MainService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: Demo1MainServiceImpl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/16 0016 16:46
 */
@Service
public class Demo1MainServiceImpl implements Demo1MainService {

    @Reference(version = "1.0.0",check = false)
    private Demo2Service demo2Service;

    @Reference(version = "1.0.0",check = false)
    private Demo3Service demo3Service;

    @Autowired
    private Demo1Mapper mapper;

    @GlobalTransactional
    @Override
    public int updateMoney(int id) {
        // demo1
        //int demoCount1 = mapper.updateMoney();
        // demo2
        int demoCount2 = demo2Service.updateMoney();
        // demo3
        int demoCount3 = demo3Service.updateMoney();

        System.out.println(id+"    demoCount1: 0"+" demoCount2: "+demoCount2+" demoCount3: "+demoCount3);
        if (1 == id) {
            System.out.println("1 start-------------------");
            try {
                Thread.sleep(1000*60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1 end-------------------");
            throw new RuntimeException();
        }
        return 0;
    }
}
