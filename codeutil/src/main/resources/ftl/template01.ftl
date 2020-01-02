<#assign name="www">
${name}

hello,${username}
<#-- if -->
<#if flag=1>
传入数据为 1
    <#elseif flag=2>
传入数据为 2
    <#else>
传入数据为 其他
</#if>

<#-- list -->
<#list stringList as str>
${str_index} = ${str}
</#list>


<#include "template02.ftl">
