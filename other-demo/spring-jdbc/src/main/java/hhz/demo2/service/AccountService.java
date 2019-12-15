package hhz.demo2.service;

import hhz.demo2.domain.Account;

/**
 * @ClassName: AccountService
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 18:16
 */
public interface AccountService {

    Account fineAccountById(Integer id);

    void transfer(String sourceName, String targetName, Float money);
}
