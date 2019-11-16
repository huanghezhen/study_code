package hhz.demo.dao;

import org.apache.ibatis.annotations.Update;

/**
 * @ClassName: Demo2Mapper
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/16 0016 16:40
 */

public interface Demo2Mapper {

    @Update("update user set money = money - 1")
    int updateMoney();
}
