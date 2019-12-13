package hhz.demo4.service.impl;

import hhz.demo4.service.AccountService;

import java.util.Date;

/**
 * @ClassName: AccountServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 14:40
 */
public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;


    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("saveAccount 执行");
        System.out.println(name);
        System.out.println(age);
        System.out.println(birthday);
    }

}
