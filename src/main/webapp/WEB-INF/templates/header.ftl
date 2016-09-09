<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<@security.authorize access="hasRole('ROLE_USER')">
    <@security.authentication property="principal.username" var="username"/>
</@security.authorize>

<header>
    <div class="col-lg-3 col-lg-offset-9 userside">
    <#if username??>
        <p>${username} <a href="/logout">Выйти</a> </p>
    <#else>
        <p><a href="/registration">Зарегистрироваться</a> или <a href="/login">Войти</a></p>
    </#if>
    </div>
</header>