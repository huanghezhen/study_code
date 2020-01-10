package com.kz.bi.controller.demo.service.iface;

/**
 * @ClassName: AgentLedgerRecordService
 * @Description: TODO(该类为自动生成, 请及时修改说明)
 * @Author: huanghz
 * @Date: 2020/1/10 9:39
 */
public interface AgentLedgerRecordService
{
    /**
     * 查询一条数据
     *
     * @param data
     * @return
     */
    String getAgentLedgerRecord(String data);

    /**
     * 查询多条数据
     *
     * @param data
     * @return
     */
    String listAgentLedgerRecord(String data);

    /**
     * 新增一条数据
     *
     * @param data
     * @return
     */
    String addAgentLedgerRecord(String data);

    /**
     * 新增多条数据
     *
     * @param data
     * @return
     */
    String addAgentLedgerRecordBatch(String data);

    /**
     * 删除一条数据
     *
     * @param data
     * @return
     */
    String deleteAgentLedgerRecord(String data);

    /**
     * 删除多条数据
     *
     * @param data
     * @return
     */
    String updateAgentLedgerRecord(String data);
}
