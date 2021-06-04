<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/22 0022
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<%--    <style>/* 定义模态对话框外面的覆盖层样式 */--%>
<%--    #modal-overlay {--%>
<%--        visibility: hidden;--%>
<%--        position: absolute;   /* 使用绝对定位或固定定位  */--%>
<%--        left: 0;--%>
<%--        top: 0;--%>
<%--        width:100%;--%>
<%--        height:100%;--%>
<%--        text-align:center;--%>
<%--        z-index: 1000;--%>
<%--        background-color: #333;--%>
<%--        opacity: 0.5;   /* 背景半透明 */--%>
<%--    }--%>
<%--    /* 模态框样式 */--%>
<%--    .modal-data{--%>
<%--        width:500px;--%>
<%--        margin: 100px auto;--%>
<%--        background-color: #fff;--%>
<%--        border:1px solid #000;--%>
<%--        padding:15px;--%>
<%--        text-align:center;--%>
<%--    }--%>
<%--    </style>--%>
    <script src="js/jquery.min.js"></script>
    <script src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/xadmin.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.6.20/dist/css/uikit.min.css" />
    <!-- UIkit JS -->
    <script src="https://cdn.jsdelivr.net/npm/uikit@3.6.20/dist/js/uikit.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/uikit@3.6.20/dist/js/uikit-icons.min.js"></script>
    <title>评论</title>
</head>
<body style="background-color:#A23C3B;">

<nav class="uk-navbar-container" uk-navbar style="color: #ff3f0c">
    <div class="uk-navbar-left">

        <ul class="uk-navbar-nav">
            <li class="uk-active"><a href="/tujian">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;首页</a></li>
        </ul>

    </div>
    <div class="uk-navbar-right" style="color: #c9302c">

        <ul class="uk-navbar-nav">
            <li>
                <a href="/tujian">退出&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>

            </li>
        </ul>
    </div>
</nav>

<c:set var="csgo" value="${sessionScope.csgo}"/>
<div class="uk-child-width-expand@s uk-text-center" uk-grid>

    <div class="uk-child-width-1-2@s uk-text-center" uk-grid>
        <c:forEach items="${csgo}" var="low">
        <div>
            <div class="uk-background-secondary uk-light uk-padding uk-panel">
                <p class="uk-h4">来自${low.cname}的评论</p>
                <p class="uk-h4">${low.com}</p>
                <p class="uk-h4">评分：${low.nub}分</p>

            </div>
        </div>
        </c:forEach>
    </div>

</div>

<%--<c:forEach items="${csgo}" var="low">--%>
<%--    <div id="modal-overlay" >--%>
<%--        <div class="modal-data">--%>

<%--            <p>评论内容</p>--%>
<%--            <p>来自${low.cname}的评论:${low.com}</p>--%>
<%--            <p>来自管理员的回复:${low.admincom}</p>--%>
<%--            <p>点击<a href="/lookpl">这里</a>关闭</p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</c:forEach>--%>
<%--<a href="#" onclick="overlay()">点击查看</a>--%>
<%--<script>--%>
<%--    function overlay(){--%>
<%--        var e1 = document.getElementById('modal-overlay');--%>
<%--        e1.style.visibility = (e1.style.visibility == "visible")? "hidden" : "visible";--%>
<%--    }</script>--%>

</body>
</html>
