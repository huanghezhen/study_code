package hhz.core;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import hhz.utils.FileUtils;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Generator
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2020/1/3 14:59
 */
public class Generator {
    private String templatePath;
    private String outPath;

    private Configuration configuration;

    public Generator(String templatePath, String outPath) {
        this.templatePath = templatePath;
        this.outPath = outPath;

        configuration = new Configuration();
        try {
            configuration.setTemplateLoader(new FileTemplateLoader(new File(templatePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void scanAndGenerator(Map<String, Object> dataModel) throws Exception {
        List<File> files = FileUtils.searchAllFile(new File(templatePath));
        for (File file : files) {
            execute(dataModel, file);
        }
    }

    public void execute(Map<String, Object> dataModel, File file) throws Exception {
        //file.getAbsolutePath().replace(this.templatePath,"");
        String absolutePath = file.getAbsolutePath().replace(this.templatePath,"");
        String outPathName = processTemplateString(absolutePath, dataModel);
        Template template = configuration.getTemplate(absolutePath);
        template.setOutputEncoding("utf-8");
        File mkdir = FileUtils.mkdir(outPath, outPathName);
        FileWriter fw = new FileWriter(mkdir);
        template.process(dataModel, fw);
        fw.close();
    }


    public String processTemplateString(String templateString, Map<String, Object> dataModel) throws Exception {
        StringWriter out = new StringWriter();
        Template template = new Template("ts", new StringReader(templateString), configuration);
        template.process(dataModel, out);
        return out.toString();
    }

}
