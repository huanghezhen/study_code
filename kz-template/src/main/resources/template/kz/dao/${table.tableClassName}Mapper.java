package ${packageName}.dao;

import ${packageName}.entity.${table.tableClassName};

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ${table.tableClassName}Mapper
 * @Description: TODO(该类为自动生成, 请及时修改说明)
 * @Author: ${author}
 * @Date: ${data}
 */
public interface ${table.tableClassName}Mapper
{
    /**
     * 查询一条数据
     *
     * @param param
     * @return
     */
    ${table.tableClassName} get${table.tableClassName}(Map<String, Object> param);

    /**
     * 查询多条数据 count
     *
     * @param param
     * @return
     */
    int count${table.tableClassName}(Map<String, Object> param);

    /**
     * 查询多条数据 list
     *
     * @param param
     * @return
     */
    List<${table.tableClassName}> list${table.tableClassName}(Map<String, Object> param);

    /**
     * 新增一条数据
     *
     * @param param
     * @return
     */
    int add${table.tableClassName}(${table.tableClassName} param);

    /**
     * 新增多条数据
     *
     * @param param
     * @return
     */
    int add${table.tableClassName}Batch(List<${table.tableClassName}> param);

    /**
     * 删除一条数据
     *
     * @param param
     * @return
     */
    int delete${table.tableClassName}(Map<String, Object> param);

    /**
     * 更新一条数据
     *
     * @param param
     * @return
     */
    int update${table.tableClassName}(${table.tableClassName} param);
}
