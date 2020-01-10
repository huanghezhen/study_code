package ${packageName}.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ${packageName}.dao.${table.tableClassName}Mapper;
import ${packageName}.entity.${table.tableClassName};
import ${packageName}.service.iface.${table.tableClassName}Service;
import com.qm.csp.api.base.BasePlatformResponse;
import com.qm.csp.api.base.BasePlatformResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ${table.tableClassName}ServiceImpl
 * @Description: TODO(该类为自动生成, 请及时修改说明)
 * @Author: ${author}
 * @Date: ${data}
 */
@Service
public class ${table.tableClassName}ServiceImpl implements ${table.tableClassName}Service
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ${table.tableClassName}Mapper ${table.tableClassName?uncap_first}Mapper;

    @Override
    public String get${table.tableClassName}(String data)
    {
        BasePlatformResponse resp = new BasePlatformResponse();
        BasePlatformResponseData basePlatformResponseData = new BasePlatformResponseData();
        Map<String, Object> param = JSONObject.parseObject(data, Map.class);
        ${table.tableClassName} ${table.tableClassName?uncap_first} = ${table.tableClassName?uncap_first}Mapper.get${table.tableClassName}(param);
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("data", ${table.tableClassName?uncap_first});
        basePlatformResponseData.setBaseMapResponse(retMap);
        resp.setBasePlatformResponseData(basePlatformResponseData);
        return JSONObject.toJSONString(resp);
    }

    @Override
    public String list${table.tableClassName}(String data)
    {
        BasePlatformResponse resp = new BasePlatformResponse();
        BasePlatformResponseData basePlatformResponseData = new BasePlatformResponseData();
        Map<String, Object> param = JSONObject.parseObject(data, Map.class);
        List<${table.tableClassName}> ${table.tableClassName?uncap_first}List = new ArrayList<>();
        int count = ${table.tableClassName?uncap_first}Mapper.count${table.tableClassName}(param);
        if (count > 0)
        {
            ${table.tableClassName?uncap_first}List = ${table.tableClassName?uncap_first}Mapper.list${table.tableClassName}(param);
        }
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("total", count);
        retMap.put("rows", ${table.tableClassName?uncap_first}List);
        basePlatformResponseData.setBaseMapResponse(retMap);
        resp.setBasePlatformResponseData(basePlatformResponseData);
        return JSONObject.toJSONString(resp);
    }

    @Override
    public String add${table.tableClassName}(String data)
    {
        BasePlatformResponse resp = new BasePlatformResponse();
        ${table.tableClassName} ${table.tableClassName?uncap_first} = JSONObject.parseObject(data, ${table.tableClassName}.class);
        try
        {
            ${table.tableClassName?uncap_first}Mapper.add${table.tableClassName}(${table.tableClassName?uncap_first});
        }
        catch (Exception e)
        {
            // TODO(该方法为自动生成,请及时修改错误码)
            resp.setResultCode("-1");
            logger.error("${table.tableClassName}ServiceImpl add${table.tableClassName} error: \n" + e);
        }
        return JSONObject.toJSONString(resp);
    }

    @Override
    public String add${table.tableClassName}Batch(String data)
    {
        BasePlatformResponse resp = new BasePlatformResponse();
        List<${table.tableClassName}> ${table.tableClassName?uncap_first}List = JSONArray.parseArray(data, ${table.tableClassName}.class);
        try
        {
            ${table.tableClassName?uncap_first}Mapper.add${table.tableClassName}Batch(${table.tableClassName?uncap_first}List);
        }
        catch (Exception e)
        {
            // TODO(该方法为自动生成,请及时修改错误码)
            resp.setResultCode("-1");
            logger.error("${table.tableClassName}ServiceImpl add${table.tableClassName}Batch error: \n" + e);
        }
        return JSONObject.toJSONString(resp);
    }

    @Override
    public String delete${table.tableClassName}(String data)
    {
        BasePlatformResponse resp = new BasePlatformResponse();
        Map<String, Object> param = JSONObject.parseObject(data, Map.class);
        try
        {
            ${table.tableClassName?uncap_first}Mapper.delete${table.tableClassName}(param);
        }
        catch (Exception e)
        {
            // TODO(该方法为自动生成,请及时修改错误码)
            resp.setResultCode("-1");
            logger.error("${table.tableClassName}ServiceImpl delete${table.tableClassName} error: \n" + e);
        }
        return JSONObject.toJSONString(resp);
    }

    @Override
    public String update${table.tableClassName}(String data)
    {
        BasePlatformResponse resp = new BasePlatformResponse();
        ${table.tableClassName} ${table.tableClassName?uncap_first} = JSONObject.parseObject(data, ${table.tableClassName}.class);
        try
        {
            ${table.tableClassName?uncap_first}Mapper.update${table.tableClassName}(${table.tableClassName?uncap_first});
        }
        catch (Exception e)
        {
            // TODO(该方法为自动生成,请及时修改错误码)
            resp.setResultCode("-1");
            logger.error("${table.tableClassName}ServiceImpl update${table.tableClassName} error: \n" + e);
        }
        return JSONObject.toJSONString(resp);
    }
}
