package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @ClassName: MyMapper
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/3 下午 10:26
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T>
{
}
