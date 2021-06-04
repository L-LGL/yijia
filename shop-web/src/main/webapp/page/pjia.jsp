<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/21 0021
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="html/jstl.html"%>
<!DOCTYPE html>
<html >
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<%--    <script src="http://localhost:63342/ssm01/js/echarts.min.js"></script>--%>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col">用户名</div>
        <div class="col">商品名</div>
        <div class="col">用户评论</div>
        <div class="col">管理员回复</div>
        <div class="col">评分</div>
        <div class="col">操作</div>
    </div>
    <c:forEach items="${sessionScope.cs}" var="low">
        <div class="row">
            <div class="col">${low.cname}</div>
            <div class="col">${low.name}</div>
            <div class="col">${low.com}</div>
            <div class="col">${low.admincom}</div>
            <div class="col">${low.nub}</div>
            <div class="col-xs-4"><a href="/depl?id=${low.id}" class="btn btn-default btn-lg active">删除</a></div>
        </div>
    </c:forEach>
</div>
<%--<div id="main" style="width: 600px;height:400px;"></div>--%>
<%--<script type="text/javascript">--%>
<%--    // 基于准备好的dom，初始化echarts实例it--%>
<%--     var myChart = echarts.init(document.getElementById('main'));--%>
<%--    // 指定图表的配置项和数据--%>
<%--    var option = {--%>
<%--        title: {--%>
<%--            text: '商品数据分析'--%>
<%--        },--%>
<%--        tooltip: {},--%>
<%--        legend: {--%>
<%--            data:['各个商品平均评分']--%>
<%--        },--%>
<%--        xAxis: [--%>
<%--            {--%>
<%--                type : 'category',--%>
<%--                data : [--%>
<%--                    <c:forEach items="${map}" var="g">--%>
<%--                    ["${g.name}"],--%>
<%--                    </c:forEach>--%>
<%--                ]--%>
<%--            }--%>
<%--        ],--%>



<%--            // data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]--%>
<%--        yAxis: {},--%>
<%--        series: [{--%>
<%--            name: '平均分',--%>
<%--            type: 'bar',--%>
<%--            data : [--%>
<%--                <c:forEach items="${map}" var="g">--%>
<%--                ${g.nub},--%>
<%--                </c:forEach>--%>
<%--            ]--%>
<%--           // data : arr--%>
<%--           // data: [5, 20, 36, 10, 10, 20]--%>
<%--        }]--%>
<%--    };--%>

<%--    // 使用刚指定的配置项和数据显示图表。--%>
<%--    myChart.setOption(option);--%>
<%--</script>--%>
</body>
</html>
