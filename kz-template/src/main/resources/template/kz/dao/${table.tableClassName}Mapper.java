package com.kz.bi.controller.demo.dao;

import com.kz.bi.controller.demo.entity.AgentLedgerRecord;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: AgentLedgerRecordMapper
 * @Description: TODO(该类为自动生成, 请及时修改说明)
 * @Author: huanghz
 * @Date: 2020/1/10 9:42
 */
public interface AgentLedgerRecordMapper
{
    /**
     * 查询一条数据
     *
     * @param param
     * @return
     */
    AgentLedgerRecord getAgentLedgerRecord(Map<String, Object> param);

    /**
     * 查询多条数据 count
     *
     * @param param
     * @return
     */
    int countAgentLedgerRecord(Map<String, Object> param);

    /**
     * 查询多条数据 list
     *
     * @param param
     * @return
     */
    List<AgentLedgerRecord> listAgentLedgerRecord(Map<String, Object> param);

    /**
     * 新增一条数据
     *
     * @param param
     * @return
     */
    int addAgentLedgerRecord(AgentLedgerRecord param);

    /**
     * 新增多条数据
     *
     * @param param
     * @return
     */
    int addAgentLedgerRecordBatch(List<AgentLedgerRecord> param);

    /**
     * 删除一条数据
     *
     * @param param
     * @return
     */
    int deleteAgentLedgerRecord(Map<String, Object> param);

    /**
     * 删除多条数据
     *
     * @param param
     * @return
     */
    int updateAgentLedgerRecord(AgentLedgerRecord param);
}
