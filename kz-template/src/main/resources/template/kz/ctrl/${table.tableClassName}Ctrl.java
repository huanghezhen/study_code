package ${packageName}.ctrl;

import ${packageName}.service.iface.${table.tableClassName}Service;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.core.MediaType;

/**
 * @ClassName: ${table.tableClassName}Ctrl
 * @Description: TODO(该类为自动生成, 请及时修改说明)
 * @Author: ${author}
 * @Date: ${data}
 */
@RestSchema(schemaId = "${table.tableClassName?uncap_first}Ctrl")
@RequestMapping(path = "/${projectName}/${table.tableClassName?uncap_first}Ctrl", produces = MediaType.APPLICATION_JSON)
public class ${table.tableClassName}Ctrl
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ${table.tableClassName}Service ${table.tableClassName?uncap_first}Service;

    /**
     * 查询一条数据
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/get${table.tableClassName}", produces = MediaType.TEXT_PLAIN)
    public String get${table.tableClassName}(@RequestBody String data)
    {
        logger.info("/${projectName}/${table.tableClassName?uncap_first}Ctrl/get${table.tableClassName} start data: " + data);
        String ret = ${table.tableClassName?uncap_first}Service.get${table.tableClassName}(data);
        logger.info("/${projectName}/${table.tableClassName?uncap_first}Ctrl/get${table.tableClassName} end ret: " + ret);
        return ret;
    }

    /**
     * 查询多条数据
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/list${table.tableClassName}", produces = MediaType.TEXT_PLAIN)
    public String list${table.tableClassName}(@RequestBody String data)
    {
        logger.info("/${projectName}/${table.tableClassName?uncap_first}Ctrl/list${table.tableClassName} start data: " + data);
        String ret = ${table.tableClassName?uncap_first}Service.list${table.tableClassName}(data);
        logger.info("/${projectName}/${table.tableClassName?uncap_first}Ctrl/list${table.tableClassName} end ret: " + ret);
        return ret;
    }

    /**
     * 新增一条数据
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/add${table.tableClassName}", produces = MediaType.TEXT_PLAIN)
    public String add${table.tableClassName}(@RequestBody String data)
    {
        logger.info("/${projectName}/${table.tableClassName?uncap_first}Ctrl/add${table.tableClassName} start data: " + data);
        String ret = ${table.tableClassName?uncap_first}Service.add${table.tableClassName}(data);
        logger.info("/${projectName}/${table.tableClassName?uncap_first}Ctrl/add${table.tableClassName} end ret: " + ret);
        return ret;
    }

    /**
     * 新增多条数据
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/add${table.tableClassName}Batch", produces = MediaType.TEXT_PLAIN)
    public String add${table.tableClassName}Batch(@RequestBody String data)
    {
        logger.info("/${projectName}/${table.tableClassName?uncap_first}Ctrl/add${table.tableClassName}Batch start data: " + data);
        String ret = ${table.tableClassName?uncap_first}Service.add${table.tableClassName}Batch(data);
        logger.info("/${projectName}/${table.tableClassName?uncap_first}Ctrl/add${table.tableClassName}Batch end ret: " + ret);
        return ret;
    }

    /**
     * 删除一条数据
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/delete${table.tableClassName}", produces = MediaType.TEXT_PLAIN)
    public String delete${table.tableClassName}(@RequestBody String data)
    {
        logger.info("/${projectName}/${table.tableClassName?uncap_first}Ctrl/delete${table.tableClassName} start data: " + data);
        String ret = ${table.tableClassName?uncap_first}Service.delete${table.tableClassName}(data);
        logger.info("/${projectName}/${table.tableClassName?uncap_first}Ctrl/delete${table.tableClassName} end ret: " + ret);
        return ret;
    }

    /**
     * 更新一条数据
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/update${table.tableClassName}", produces = MediaType.TEXT_PLAIN)
    public String update${table.tableClassName}(@RequestBody String data)
    {
        logger.info("/${projectName}/${table.tableClassName?uncap_first}Ctrl/update${table.tableClassName} start data: " + data);
        String ret = ${table.tableClassName?uncap_first}Service.update${table.tableClassName}(data);
        logger.info("/${projectName}/${table.tableClassName?uncap_first}Ctrl/update${table.tableClassName} end ret: " + ret);
        return ret;
    }
}
