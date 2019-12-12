package hhz.service.impl;

import hhz.service.iface.DemoApiService;
import org.apache.servicecomb.provider.pojo.RpcSchema;

/**
 * @ClassName: RpcServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/12 17:28
 */
@RpcSchema(schemaId = "RpcService")
public class RpcServiceImpl implements DemoApiService {
    @Override
    public String getString() {
        return "demo2 rpc";
    }
}
