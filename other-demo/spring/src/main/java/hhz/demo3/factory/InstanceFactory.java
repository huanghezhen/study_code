package hhz.demo3.factory;

import hhz.demo3.service.AccountService;
import hhz.demo3.service.impl.AccountServiceImpl;

/**
 * @ClassName: InstanceFactory
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 16:18
 */
public class InstanceFactory {
    public AccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
