<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>彝家在线购物系统</title>
    <!--head.html包含了需要引入的样式表和js文件-->
    <%@include file="/page/html/head.html"%>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css"/>
    <script type="text/javascript" src="/static/js/ajax/init.js"></script>
</head>
<body>
<%--<h1>888${sessionScope.tjiana}</h1>--%>
    <c:set var="cname" value="${sessionScope.cname}"/>

    <%@include file="/page/html/title.html"%><%--标题部分--%>
    <%@include file="/page/html/search.html"%><%-- 搜索框部分 --%>
    <%@include file="/page/html/menu.html"%><%-- 用户登录注册 --%>
    <%@include file="/page/html/nav.html"%><%-- 导航栏 --%>
    <%@include file="/page/html/user.html"%><%-- 用户信息栏--%>
    <%@include file="/page/html/index.html"%><%--商品品类+轮播图--%>
    <%@include file="/page/html/goodsDisplay.html"%><%-- 主页商品展示 --%>
    <%@include file="/page/html/recommend02.html"%><%-- 后台推荐   两个重叠在一起了--%>
<%--    <%@include file="/page/html/recommend01.html"%>&lt;%&ndash; 评分推荐 &ndash;%&gt;--%>
    <%@include file="/page/html/prompt.html"%><%-- 支付窗口+--%>
    <%@include file="/page/html/foot.html"%><%-- 底部 --%>


</body>
<script type="text/javascript" src="/static/js/style/index.js"></script>
</html>
