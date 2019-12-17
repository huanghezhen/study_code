package hhz.dao;

import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: UserMapper
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/17 12:56
 */
public interface UserMapper {
    @Select("select count(*) from xc_user")
    int getCount();
}
