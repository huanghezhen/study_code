package hhz.demo.dao;

import org.apache.ibatis.annotations.Update;

/**
 * @ClassName: TccDemo2Mapper
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/17 0017 11:43
 */
public interface TccDemo2Mapper {
    @Update("update user set money = money - 1")
    int updateMoney();
}
