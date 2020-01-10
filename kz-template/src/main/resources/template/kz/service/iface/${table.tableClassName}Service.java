package ${packageName}.service.iface;

/**
 * @ClassName: ${table.tableClassName}Service
 * @Description: TODO(该类为自动生成, 请及时修改说明)
 * @Author: ${author}
 * @Date: ${data}
 */
public interface ${table.tableClassName}Service
{
    /**
     * 查询一条数据
     *
     * @param data
     * @return
     */
    String get${table.tableClassName}(String data);

    /**
     * 查询多条数据
     *
     * @param data
     * @return
     */
    String list${table.tableClassName}(String data);

    /**
     * 新增一条数据
     *
     * @param data
     * @return
     */
    String add${table.tableClassName}(String data);

    /**
     * 新增多条数据
     *
     * @param data
     * @return
     */
    String add${table.tableClassName}Batch(String data);

    /**
     * 删除一条数据
     *
     * @param data
     * @return
     */
    String delete${table.tableClassName}(String data);

    /**
     * 更新一条数据
     *
     * @param data
     * @return
     */
    String update${table.tableClassName}(String data);
}
