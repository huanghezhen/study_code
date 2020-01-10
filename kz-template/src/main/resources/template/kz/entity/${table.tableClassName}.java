package ${packageName}.entity;

/**
 * @ClassName: ${table.tableClassName}
 * @Description: TODO(该类为自动生成,请及时修改说明)
 * @Author: ${author}
 * @Date: ${data}
 */
public class ${table.tableClassName}{

<#list table.columns as column>
    // ${column.columnComment}
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