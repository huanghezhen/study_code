package hhz.demo3.service.impl;

import hhz.demo3.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: AccountServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 15:05
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public void save() {
        System.out.println("save");
    }
}
