package hhz.metadata;

/**
 * @ClassName: Column
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2020/1/9 15:11
 */
public class Column
{
    // 列名称
    private String  columnName;
    // 列名称对应的属性名称
    private String  columnClassName;
    // 列类型
    private String  columnType;
    // 列对应的Java类型
    private String  columnJavaType;
    // 列备注
    private String  columnComment;
    // 是否是主键
    private Boolean primaryAble;

    public Boolean getPrimaryAble()
    {
        return primaryAble;
    }

    public void setPrimaryAble(Boolean primaryAble)
    {
        this.primaryAble = primaryAble;
    }

    public String getColumnName()
    {
        return columnName;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }

    public String getColumnClassName()
    {
        return columnClassName;
    }

    public void setColumnClassName(String columnClassName)
    {
        this.columnClassName = columnClassName;
    }

    public String getColumnType()
    {
        return columnType;
    }

    public void setColumnType(String columnType)
    {
        this.columnType = columnType;
    }

    public String getColumnJavaType()
    {
        return columnJavaType;
    }

    public void setColumnJavaType(String columnJavaType)
    {
        this.columnJavaType = columnJavaType;
    }

    public String getColumnComment()
    {
        return columnComment;
    }

    public void setColumnComment(String columnComment)
    {
        this.columnComment = columnComment;
    }
}
