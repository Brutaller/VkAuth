<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>

<#macro m_body>

<div class="col-lg-2 col-lg-offset-5">
    <@sf.form action="/registration" method="post" modelAttribute="userform">
        <div class="form-group">
            <label for="username">Логин</label>
            <@sf.input path="username" id="username" cssClass="form-control" placeholder="Логин"/>
            <@sf.errors path="username"/>
        </div>
        <div class="form-group">
            <label for="firstName">Имя</label>
            <@sf.input path="firstName" id="firstName" cssClass="form-control" placeholder="Имя"/>
            <@sf.errors path="firstName"/>
        </div>
        <div class="form-group">
            <label for="lastName">Фамилия</label>
            <@sf.input path="lastName" id="lastName" cssClass="form-control" placeholder="Фамилия"/>
            <@sf.errors path="lastName"/>
        </div>
        <div class="form-group">
            <label for="password">Пароль</label>
            <@sf.input path="password" id="password" cssClass="form-control" placeholder="Пароль"/>
            <@sf.errors path="password"/>
        </div>
        <button type="submit" class="btn btn-default">Зарегистрироваться</button>
    </@sf.form>
</div>

</#macro>

<@main title="Зарегистрироваться"/>