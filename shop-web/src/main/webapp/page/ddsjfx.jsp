<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/28 0028
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="/static/js/style/echarts.min.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 1150px;height:650px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例it
    var myChart = echarts.init(document.getElementById('main'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '评分数据分析'
        },
        tooltip: {},
        legend: {
            data:['各个商品评分平均分计算']
        },
        xAxis: [
            {
                type : 'category',
                data : [
                    <c:forEach items="${sessionScope.ery}" var="g">
                        ["${g.name}"],
                    </c:forEach>
                ]
            }
        ],



        // data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        yAxis: {},
        series: [{
            name: '平均分',
            type: 'bar',
            data : [
                <c:forEach items="${sessionScope.sz}" var="g">
                ${g},
                </c:forEach>
            ]
            // data : arr
            // data: [5, 20, 36, 10, 10, 20]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>
