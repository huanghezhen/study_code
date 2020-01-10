package hhz.method;

import hhz.config.Config;
import hhz.config.Mysql;
import hhz.metadata.Column;
import hhz.metadata.PrimaryKey;
import hhz.metadata.Table;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName: MetaDataUtil
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2020/1/9 15:18
 */
public class MetaDataUtil
{
    private static Connection getConnection() throws Exception
    {
        Properties props = new Properties();
        Mysql mysql = Config.init.getMysql();
        //获取数据库的备注信息
        props.put("remarksReporting", "true");
        props.put("user", mysql.getUsername());
        props.put("password", mysql.getPassword());
        //注册驱动
        Class.forName(mysql.getDriver());
        return DriverManager.getConnection(mysql.getUrl(), props);
    }

    public static List<Table> getTable() throws Exception
    {
        List<Table> tableList = new ArrayList<>();
        Connection connection = getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        List<String> tableNameList = Config.init.getTableNameList();
        Table table;
        for (String tableName : tableNameList)
        {
            ResultSet tableRet = metaData.getTables(null, null, tableName, new String[] {"TABLE"});
            while (tableRet.next())
            {
                table = new Table();
                table.setTableName(tableName);
                table.setTableClassName(StringUtil.removePrefix(tableName));
                table.setTableComment(tableRet.getString("REMARKS"));
                List<PrimaryKey> primaryKeyList = listPrimaryKey(tableName);
                table.setPrimaryKeyList(primaryKeyList);
                List<String> primaryKeyStringList = new ArrayList<>();
                for (PrimaryKey primaryKey : primaryKeyList)
                {
                    primaryKeyStringList.add(primaryKey.getName());
                }
                List<Column> columnList = listColumn(tableName, primaryKeyStringList);
                table.setColumns(columnList);
                tableList.add(table);
            }
        }
        return tableList;
    }

    private static List<PrimaryKey> listPrimaryKey(String tableName) throws Exception
    {
        List<PrimaryKey> primaryKeyList = new ArrayList<>();
        Connection connection = getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, tableName);
        PrimaryKey primaryKey;
        while (primaryKeys.next())
        {
            primaryKey = new PrimaryKey();
            String name = primaryKeys.getString("COLUMN_NAME");
            primaryKey.setName(name);
            primaryKey.setJavaName(StringUtil.camelCaseName(name));
            primaryKeyList.add(primaryKey);
        }
        return primaryKeyList;
    }

    private static List<Column> listColumn(String tableName, List<String> primaryKeyStringList) throws Exception
    {
        Connection connection = getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet columnRet = metaData.getColumns(null, null, tableName, null);
        List<Column> columnList = new ArrayList<>();
        Column column;
        while (columnRet.next())
        {
            String columnName = columnRet.getString("COLUMN_NAME");
            // 字段被忽略 直接跳过
            if (Config.init.getIgnoreColumn().contains(columnName))
            {
                continue;
            }
            column = new Column();
            String columnClassName = StringUtil.camelCaseName(columnName);
            String columnType = columnRet.getString("TYPE_NAME");
            String columnJavaType = Config.init.getReplacementRule().get(columnType);
            String columnComment = columnRet.getString("REMARKS");
            if (primaryKeyStringList.contains(columnName))
            {
                column.setPrimaryKeyAble(true);
            }
            else
            {
                column.setPrimaryKeyAble(false);
            }
            column.setColumnClassName(columnClassName);
            column.setColumnComment(columnComment);
            column.setColumnJavaType(columnJavaType);
            column.setColumnName(columnName);
            column.setColumnType(columnType);
            columnList.add(column);
        }
        return columnList;
    }
}
