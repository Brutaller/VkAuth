<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<#include "main-template.ftl"/>

<#macro m_body>

<div class="col-lg-4 col-lg-offset-4">
    <#list simpleUsers as user>
        <p>${user.username}</p>
        <p>${user.firstName} ${user.lastName} (${user.type})</p>
        <hr>
    </#list>
    <#list vkUsers as user>
        <div>
            <img src="${user.photo}">
            <p>${user.username}</p>
            <p>${user.firstName} ${user.lastName} (${user.type})</p>
            <hr>
        </div>
    </#list>

</div>

</#macro>

<@main title="Главная"/>
