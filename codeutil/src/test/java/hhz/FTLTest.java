package hhz;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: FTLTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2020/1/2 15:44
 */
public class FTLTest {
    @Test
    public void ftl01() throws Exception {
        // 创建类
        Configuration configuration = new Configuration();
        // 设置模板引擎
        File file = new File(getClass().getClassLoader().getResource("ftl").getPath());
        FileTemplateLoader fileTemplateLoader = new FileTemplateLoader(file);
        configuration.setTemplateLoader(fileTemplateLoader);
        // 获取模板
        Template template = configuration.getTemplate("template01.ftl");
        // 构造数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("username", "啦啦啦");
        dataModel.put("flag", 3);

        List<String> stringList = new ArrayList<>();
        stringList.add("qq");
        stringList.add("ww");
        stringList.add("ee");
        dataModel.put("stringList", stringList);
        // 文件输出
        //template.process(dataModel, new FileWriter(new File("D:\\HHZ\\ideaws\\otherws\\codeutil\\src\\main\\resources\\ftl\\out\\template01.txt")));
        // 输入到控制台
        template.process(dataModel,new PrintWriter(System.out));
    }


    @Test
    public void ftl02() throws Exception {
        Configuration configuration = new Configuration();
        configuration.setTemplateLoader(new StringTemplateLoader());
        String temp = "hello,${username}";
        Template template = new Template("name1", temp, configuration);
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("username", "啦啦啦");
        template.process(dataModel,new PrintWriter(System.out));
    }
}
