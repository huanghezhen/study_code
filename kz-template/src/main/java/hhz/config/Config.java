package hhz.config;

import com.alibaba.fastjson.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Config
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2020/1/9 14:05
 */
public class Config
{

    public static Config init;

    static
    {
        Yaml yaml = new Yaml();
        InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("config.yaml");
        String jsonString = JSONObject.toJSONString(yaml.load(inputStream));
        init = JSONObject.parseObject(jsonString, Config.class);
    }

    // mysql 配置文件
    private Mysql               mysql;
    // sql类型和java类型替换规则
    private Map<String, String> replacementRule;
    // 生成文件的绝对路径
    private String              generatePath;
    private String              author;
    // 是否生成ctrl文件
    private Boolean             generateCtrlAble;
    // 是否生成 dao文件
    private Boolean             generateDaoAble;
    // 是否生成entity文件
    private Boolean             generateEntityAble;
    // 是否生成service文件
    private Boolean             generateServiceAble;
    private String              packageName;
    private List<String>        tableNameList;
    private List<String>        ignoreColumn;
    private String              tableRemovePrefixes;

    public String getPackageName()
    {
        return packageName;
    }

    public void setPackageName(String packageName)
    {
        this.packageName = packageName;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public List<String> getIgnoreColumn()
    {
        return ignoreColumn;
    }

    public void setIgnoreColumn(List<String> ignoreColumn)
    {
        this.ignoreColumn = ignoreColumn;
    }

    public String getTableRemovePrefixes()
    {
        return tableRemovePrefixes;
    }

    public void setTableRemovePrefixes(String tableRemovePrefixes)
    {
        this.tableRemovePrefixes = tableRemovePrefixes;
    }

    public List<String> getTableNameList()
    {
        return tableNameList;
    }

    public void setTableNameList(List<String> tableNameList)
    {
        this.tableNameList = tableNameList;
    }

    public Mysql getMysql()
    {
        return mysql;
    }

    public void setMysql(Mysql mysql)
    {
        this.mysql = mysql;
    }

    public Map<String, String> getReplacementRule()
    {
        return replacementRule;
    }

    public void setReplacementRule(Map<String, String> replacementRule)
    {
        this.replacementRule = replacementRule;
    }

    public String getGeneratePath()
    {
        return generatePath;
    }

    public void setGeneratePath(String generatePath)
    {
        this.generatePath = generatePath;
    }

    public Boolean getGenerateCtrlAble()
    {
        return generateCtrlAble;
    }

    public void setGenerateCtrlAble(Boolean generateCtrlAble)
    {
        this.generateCtrlAble = generateCtrlAble;
    }

    public Boolean getGenerateDaoAble()
    {
        return generateDaoAble;
    }

    public void setGenerateDaoAble(Boolean generateDaoAble)
    {
        this.generateDaoAble = generateDaoAble;
    }

    public Boolean getGenerateEntityAble()
    {
        return generateEntityAble;
    }

    public void setGenerateEntityAble(Boolean generateEntityAble)
    {
        this.generateEntityAble = generateEntityAble;
    }

    public Boolean getGenerateServiceAble()
    {
        return generateServiceAble;
    }

    public void setGenerateServiceAble(Boolean generateServiceAble)
    {
        this.generateServiceAble = generateServiceAble;
    }
}
