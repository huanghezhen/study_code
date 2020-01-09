public class ${table.tableClassName}{

<#list table.columns as column>
    private ${column.columnJavaType} ${column.columnClassName};
</#list>

<#list table.columns as column>
    public void set${column.columnClassName?cap_first}(${column.columnJavaType} value)
    {
        this.${column.columnClassName} = value;
    }

    public ${column.columnJavaType} get${column.columnClassName?cap_first}()
    {
        return this.${column.columnClassName};
    }

</#list>
}