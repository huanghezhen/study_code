package hhz;

import com.alibaba.fastjson.JSONObject;
import hhz.core.Generator;
import hhz.metadata.Table;
import hhz.method.MetaDataUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Main
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2020/1/9 13:53
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(JSONObject.toJSONString(MetaDataUtil.getTable()));

        Generator generator = new Generator();

        for (Table table : MetaDataUtil.getTable())
        {
            Map<String, Object> model = new HashMap<>();
            model.put("table", table);
            generator.scanAndGenerator(model);
        }

    }
}
