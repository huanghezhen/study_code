package hhz.demo1.factory;

import hhz.demo1.service.AccountService;
import hhz.demo1.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: BeanFactory
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 22:56
 */
@Component
public class BeanFactory {

    @Autowired
    private TransactionManager transactionManager;

    @Autowired
    private AccountService accountService;

    public AccountService getAccountServiceProxy() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object invoke = null;
                        try {
                            transactionManager.begin();
                            invoke = method.invoke(accountService, args);
                            transactionManager.commit();
                        } catch (Exception e) {
                            transactionManager.rollback();
                        } finally {
                            transactionManager.release();
                        }
                        return invoke;
                    }
                });
    }
}
