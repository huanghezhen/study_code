package hhz.metadata;

import java.util.List;

/**
 * @ClassName: Table
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2020/1/9 15:11
 */
public class Table
{
    // 表名称
    private String       tableName;
    // 表名称对应的类名称
    private String       tableClassName;
    // 介绍
    private String       tableComment;
    // 列集合
    private List<Column> columns;
    // 主键集合
    private List<PrimaryKey> primaryKeyList;

    public List<PrimaryKey> getPrimaryKeyList()
    {
        return primaryKeyList;
    }

    public void setPrimaryKeyList(List<PrimaryKey> primaryKeyList)
    {
        this.primaryKeyList = primaryKeyList;
    }

    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getTableClassName()
    {
        return tableClassName;
    }

    public void setTableClassName(String tableClassName)
    {
        this.tableClassName = tableClassName;
    }

    public String getTableComment()
    {
        return tableComment;
    }

    public void setTableComment(String tableComment)
    {
        this.tableComment = tableComment;
    }

    public List<Column> getColumns()
    {
        return columns;
    }

    public void setColumns(List<Column> columns)
    {
        this.columns = columns;
    }
}
