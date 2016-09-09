<#macro main title="Hello!" customScripts=[] customStyles=[]>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css"/>

    <script src="/resources/js/jquery-2.1.3.min.js"></script>

    <#list customStyles as style>
        <link rel="stylesheet" type="text/css" href="${style}"/>
    </#list>

    <#list customScripts as script>
        <script src="${script}"></script>
    </#list>

</head>
<body>
<#include "header.ftl"/>

<div class="content">
    <@m_body/>
</div>


</body>
</html>
</#macro>