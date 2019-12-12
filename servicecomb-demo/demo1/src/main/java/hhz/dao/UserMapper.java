package hhz.dao;

import org.apache.ibatis.annotations.Update;

/**
 * @ClassName: UserMapper
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/12 15:43
 */
public interface UserMapper {
    @Update("update user set money = money - 1")
    int reduceMoney();

    @Update("update user set money = money + 1")
    int addMoney();
}
