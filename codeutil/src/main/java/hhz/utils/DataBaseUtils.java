package hhz.utils;


import hhz.entity.Column;
import hhz.entity.DataBase;
import hhz.entity.Table;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataBaseUtils {

    //获取到mysql中所有的数据库名称

    //获取数据库连接
    public static Connection getConnection(DataBase db) throws Exception {
        Properties props = new Properties();
        props.put("remarksReporting","true");//获取数据库的备注信息
        props.put("user",db.getUserName());
        props.put("password",db.getPassWord());
        Class.forName(db.getDriver());//注册驱动
        return DriverManager.getConnection(db.getUrl(),props);
    }


    //获取数据库列表
    public static List<String> getSchemas(DataBase db) throws Exception {
        //1.获取元数据
        Connection connection = getConnection(db);
        DatabaseMetaData metaData = connection.getMetaData();
        //2.获取所有数据库列表
        ResultSet rs = metaData.getCatalogs();
        List<String> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        rs.close();
        connection.close();
        return list;
    }



    public static List<Table> getTable(DataBase dataBase) throws Exception{
        Connection connection = getConnection(dataBase);
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
        List<Table> list = new ArrayList<>();
        while (tables.next()) {
            Table table = new Table();
            String tableName = tables.getString("TABLE_NAME");
            String className = removePrefix(tableName);
            String remarks = tables.getString("REMARKS");
            ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, tableName);
            StringBuilder keys = new StringBuilder();
            while (primaryKeys.next()) {
                String column_name = primaryKeys.getString("COLUMN_NAME");
                keys.append(column_name).append(",");
            }
            table.setName(tableName);
            table.setName2(className);
            table.setComment(remarks);
            table.setKey(keys.toString());
            List<Column> columnList = new ArrayList<>();
            ResultSet columns = metaData.getColumns(null, null, tableName, null);
            while (columns.next()) {
                Column column = new Column();
                String columnName = columns.getString("COLUMN_NAME");
                String name2 = StringUtils.toJavaVariableName(columnName);
                String dbType = columns.getString("TYPE_NAME");
                String javaType = PropertiesUtils.customMap.get(dbType);
                String remarks1 = columns.getString("REMARKS");
                if (StringUtils.contains(columnName, keys.toString().split(","))) {
                    column.setColumnKey("PRI");
                }
                column.setColumnComment(remarks1);
                column.setColumnDbType(dbType);
                column.setColumnType(javaType);
                column.setColumnName(columnName);
                column.setColumnName2(name2);
                columnList.add(column);
            }

            table.setColumns(columnList);
            list.add(table);
        }
        return list;
    }

    public static String removePrefix(String tableName) {
        String tableRemovePrefixes = PropertiesUtils.customMap.get("tableRemovePrefixes");
        String temp = tableName;
        for (String pf : tableRemovePrefixes.split(",")) {
            temp = StringUtils.removePrefix(temp, pf, true);
        }
        return StringUtils.makeAllWordFirstLetterUpperCase(temp);
    }

    public static void main(String[] args) throws Exception {
        DataBase db = new DataBase("MYSQL","ihrm");
        db.setUserName("root");
        db.setPassWord("123456");


        List<Table> table = DataBaseUtils.getTable(db);
        for (Table table1 : table) {
            System.out.println(table1);
        }
    }
}
