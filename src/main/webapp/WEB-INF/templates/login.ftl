<#include "main-template.ftl"/>

<#macro m_body>

<div class="col-lg-2 col-lg-offset-5">
    <form action="/login/process" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Логин</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Логин" name="username">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Пароль</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Пароль" name="password">
        </div>
        <#if error??>
            <p>Неправильный логин или пароль</p>
        </#if>
        <button type="submit" class="btn btn-default">Войти</button>
        <a href="/login/vk">
            <img src="http://www.rppl.ru/images/login_vk.png" style="margin-top: 5px">
        </a>
    </form>
</div>

</#macro>

<@main title="Войти"/>
