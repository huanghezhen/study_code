package com.kz.bi.controller.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kz.bi.controller.demo.dao.AgentLedgerRecordMapper;
import com.kz.bi.controller.demo.entity.AgentLedgerRecord;
import com.kz.bi.controller.demo.service.iface.AgentLedgerRecordService;
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
 * @ClassName: AgentLedgerRecordServiceImpl
 * @Description: TODO(该类为自动生成, 请及时修改说明)
 * @Author: huanghz
 * @Date: 2020/1/10 9:39
 */
@Service
public class AgentLedgerRecordServiceImpl implements AgentLedgerRecordService
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AgentLedgerRecordMapper agentLedgerRecordMapper;

    @Override
    public String getAgentLedgerRecord(String data)
    {
        BasePlatformResponse resp = new BasePlatformResponse();
        BasePlatformResponseData basePlatformResponseData = new BasePlatformResponseData();
        Map<String, Object> param = JSONObject.parseObject(data, Map.class);
        AgentLedgerRecord agentLedgerRecord = agentLedgerRecordMapper.getAgentLedgerRecord(param);
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("data", agentLedgerRecord);
        basePlatformResponseData.setBaseMapResponse(retMap);
        resp.setBasePlatformResponseData(basePlatformResponseData);
        return JSONObject.toJSONString(resp);
    }

    @Override
    public String listAgentLedgerRecord(String data)
    {
        BasePlatformResponse resp = new BasePlatformResponse();
        BasePlatformResponseData basePlatformResponseData = new BasePlatformResponseData();
        Map<String, Object> param = JSONObject.parseObject(data, Map.class);
        List<AgentLedgerRecord> agentLedgerRecordList = new ArrayList<>();
        int count = agentLedgerRecordMapper.countAgentLedgerRecord(param);
        if (count > 0)
        {
            agentLedgerRecordList = agentLedgerRecordMapper.listAgentLedgerRecord(param);
        }
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("total", count);
        retMap.put("rows", agentLedgerRecordList);
        basePlatformResponseData.setBaseMapResponse(retMap);
        resp.setBasePlatformResponseData(basePlatformResponseData);
        return JSONObject.toJSONString(resp);
    }

    @Override
    public String addAgentLedgerRecord(String data)
    {
        BasePlatformResponse resp = new BasePlatformResponse();
        AgentLedgerRecord agentLedgerRecord = JSONObject.parseObject(data, AgentLedgerRecord.class);
        try
        {
            agentLedgerRecordMapper.addAgentLedgerRecord(agentLedgerRecord);
        }
        catch (Exception e)
        {
            // TODO(该方法为自动生成,请及时修改错误码)
            resp.setResultCode("-1");
            logger.error("AgentLedgerRecordServiceImpl addAgentLedgerRecord error: \n" + e);
        }
        return JSONObject.toJSONString(resp);
    }

    @Override
    public String addAgentLedgerRecordBatch(String data)
    {
        BasePlatformResponse resp = new BasePlatformResponse();
        List<AgentLedgerRecord> agentLedgerRecordList = JSONArray.parseArray(data, AgentLedgerRecord.class);
        try
        {
            agentLedgerRecordMapper.addAgentLedgerRecordBatch(agentLedgerRecordList);
        }
        catch (Exception e)
        {
            // TODO(该方法为自动生成,请及时修改错误码)
            resp.setResultCode("-1");
            logger.error("AgentLedgerRecordServiceImpl addAgentLedgerRecordBatch error: \n" + e);
        }
        return JSONObject.toJSONString(resp);
    }

    @Override
    public String deleteAgentLedgerRecord(String data)
    {
        BasePlatformResponse resp = new BasePlatformResponse();
        Map<String, Object> param = JSONObject.parseObject(data, Map.class);
        try
        {
            agentLedgerRecordMapper.deleteAgentLedgerRecord(param);
        }
        catch (Exception e)
        {
            // TODO(该方法为自动生成,请及时修改错误码)
            resp.setResultCode("-1");
            logger.error("AgentLedgerRecordServiceImpl deleteAgentLedgerRecord error: \n" + e);
        }
        return JSONObject.toJSONString(resp);
    }

    @Override
    public String updateAgentLedgerRecord(String data)
    {
        BasePlatformResponse resp = new BasePlatformResponse();
        AgentLedgerRecord agentLedgerRecord = JSONObject.parseObject(data, AgentLedgerRecord.class);
        try
        {
            agentLedgerRecordMapper.updateAgentLedgerRecord(agentLedgerRecord);
        }
        catch (Exception e)
        {
            // TODO(该方法为自动生成,请及时修改错误码)
            resp.setResultCode("-1");
            logger.error("AgentLedgerRecordServiceImpl updateAgentLedgerRecord error: \n" + e);
        }
        return JSONObject.toJSONString(resp);
    }
}
