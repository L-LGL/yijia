<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/13 0013
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@include file="html/jstl.html"%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <title>Title</title>
</head>
<body style="background-color:#A23C3B;">


<div style="margin-top: 50px">
<form id="sj">


            <div class=" col-md-3 col-md-offset-3" >用户名</div>
            <input type="text" name="cname" value="${sessionScope.cname}" readonly class="form-control"/>

            <div class=" col-md-3 col-md-offset-3">商品</div>

            <input type="text" name="name" value="${sessionScope.map}"  readonly  class="form-control"/>





            <div class=" col-md-3 col-md-offset-3">输入评分</div>

                <input type="number" name="nub"  id="xx" class="form-control"/>

            <div class=" col-md-3 col-md-offset-3">输入评论</div>

                <textarea cols="50" rows="1" name="com" class="form-control"></textarea>




    <button type="button" class="btn btn-primary btn-lg btn-block" onclick="addpl()" style="background-color:#A1100B ">提交</button>
<button type="button" class="btn btn-secondary btn-lg btn-block" style="background-color:#A1100B "><a href="/tujian" >退出</a></button>
</form>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script>




    function addpl() {

        if (confirm('确定要评论吗?')) {
            $.ajax({
                url:"addpl2",
                data:$("#sj").serialize(),

            });
        }

    }



</script>
</body>
</html>
