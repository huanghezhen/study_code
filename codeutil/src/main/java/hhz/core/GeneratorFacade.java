package hhz.core;

import hhz.entity.DataBase;
import hhz.entity.Settings;
import hhz.entity.Table;
import hhz.utils.DataBaseUtils;
import hhz.utils.PropertiesUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: GeneratorFacade
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2020/1/3 14:56
 */
public class GeneratorFacade {
    private String templatePath;

    private String outPath;

    private Settings settings;

    private DataBase dataBase;
    private Generator generator;

    public GeneratorFacade(String templatePath, String outPath, Settings settings, DataBase dataBase) {
        this.templatePath = templatePath;
        this.outPath = outPath;
        this.settings = settings;
        this.dataBase = dataBase;
        this.generator = new Generator(templatePath, outPath);
    }

    public void generatorByDataBase() throws Exception {
        List<Table> tableList = DataBaseUtils.getTable(dataBase);
        for (Table table : tableList) {
            Map<String, Object> dataModel = getDataModel(table);
            generator.scanAndGenerator(dataModel);
        }
    }

    private Map<String, Object> getDataModel(Table table) {
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.putAll(PropertiesUtils.customMap);
        dataModel.put("table", table);
        dataModel.putAll(settings.getSettingMap());
        dataModel.put("ClassName", table.getName2());
        return dataModel;
    }
}
