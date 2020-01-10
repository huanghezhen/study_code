package com.kz.bi.controller.demo.ctrl;

import com.kz.bi.controller.demo.service.iface.AgentLedgerRecordService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.core.MediaType;

/**
 * @ClassName: AgentLedgerRecordCtrl
 * @Description: TODO(该类为自动生成, 请及时修改说明)
 * @Author: huanghz
 * @Date: 2020/1/10 9:35
 */
@RestSchema(schemaId = "agentLedgerRecordCtrl")
@RequestMapping(path = "/kzPlatformBI/agentLedgerRecordCtrl", produces = MediaType.APPLICATION_JSON)
public class AgentLedgerRecordCtrl
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AgentLedgerRecordService agentLedgerRecordService;

    /**
     * 查询一条数据
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/getAgentLedgerRecord", produces = MediaType.TEXT_PLAIN)
    public String getAgentLedgerRecord(@RequestBody String data)
    {
        logger.info("/kzPlatformBI/agentLedgerRecordCtrl/getAgentLedgerRecord start data: " + data);
        String ret = agentLedgerRecordService.getAgentLedgerRecord(data);
        logger.info("/kzPlatformBI/agentLedgerRecordCtrl/getAgentLedgerRecord end ret: " + ret);
        return ret;
    }

    /**
     * 查询多条数据
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/listAgentLedgerRecord", produces = MediaType.TEXT_PLAIN)
    public String listAgentLedgerRecord(@RequestBody String data)
    {
        logger.info("/kzPlatformBI/agentLedgerRecordCtrl/listAgentLedgerRecord start data: " + data);
        String ret = agentLedgerRecordService.listAgentLedgerRecord(data);
        logger.info("/kzPlatformBI/agentLedgerRecordCtrl/listAgentLedgerRecord end ret: " + ret);
        return ret;
    }

    /**
     * 新增一条数据
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/addAgentLedgerRecord", produces = MediaType.TEXT_PLAIN)
    public String addAgentLedgerRecord(@RequestBody String data)
    {
        logger.info("/kzPlatformBI/agentLedgerRecordCtrl/addAgentLedgerRecord start data: " + data);
        String ret = agentLedgerRecordService.addAgentLedgerRecord(data);
        logger.info("/kzPlatformBI/agentLedgerRecordCtrl/addAgentLedgerRecord end ret: " + ret);
        return ret;
    }

    /**
     * 新增多条数据
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/addAgentLedgerRecordBatch", produces = MediaType.TEXT_PLAIN)
    public String addAgentLedgerRecordBatch(@RequestBody String data)
    {
        logger.info("/kzPlatformBI/agentLedgerRecordCtrl/addAgentLedgerRecordBatch start data: " + data);
        String ret = agentLedgerRecordService.addAgentLedgerRecordBatch(data);
        logger.info("/kzPlatformBI/agentLedgerRecordCtrl/addAgentLedgerRecordBatch end ret: " + ret);
        return ret;
    }

    /**
     * 删除一条数据
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/deleteAgentLedgerRecord", produces = MediaType.TEXT_PLAIN)
    public String deleteAgentLedgerRecord(@RequestBody String data)
    {
        logger.info("/kzPlatformBI/agentLedgerRecordCtrl/deleteAgentLedgerRecord start data: " + data);
        String ret = agentLedgerRecordService.deleteAgentLedgerRecord(data);
        logger.info("/kzPlatformBI/agentLedgerRecordCtrl/deleteAgentLedgerRecord end ret: " + ret);
        return ret;
    }

    /**
     * 删除多条数据
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/updateAgentLedgerRecord", produces = MediaType.TEXT_PLAIN)
    public String updateAgentLedgerRecord(@RequestBody String data)
    {
        logger.info("/kzPlatformBI/agentLedgerRecordCtrl/updateAgentLedgerRecord start data: " + data);
        String ret = agentLedgerRecordService.updateAgentLedgerRecord(data);
        logger.info("/kzPlatformBI/agentLedgerRecordCtrl/updateAgentLedgerRecord end ret: " + ret);
        return ret;
    }
}
