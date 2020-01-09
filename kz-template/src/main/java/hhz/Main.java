package hhz;

import hhz.config.Config;
import hhz.core.Generator;
import hhz.metadata.Table;
import hhz.method.MetaDataUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
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

        Generator generator = new Generator();

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Map<String, Object> model = new HashMap<>();
        model.put("packageName", Config.init.getPackageName());
        model.put("author", Config.init.getAuthor());
        model.put("data", format.format(new Date().getTime()));
        for (Table table : MetaDataUtil.getTable())
        {
            model.put("table", table);
            generator.scanAndGenerator(model);
        }

    }
}
