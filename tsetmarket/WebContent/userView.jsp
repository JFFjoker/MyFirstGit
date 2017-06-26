<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<div class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="exitServlet">退出</a>
    </div>
</div>
<!--时间-->
<div class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
</div>
<!--主体内容-->
<div class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <div>
            <ul class="list">
                <li ><a href="billServlet">账单管理</a></li>
            	<c:if test="${sessionScope.authuser.auth=='经理'}">
                <li><a href="proServlet">供应商管理</a></li>
                <li><a href="adminServlet">用户管理</a></li>
            	</c:if>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="exitServlet">退出系统</a></li>
            </ul>
        </div>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
			<p><strong>用户编号：</strong><span>${user.userid}</span></p>
            <p><strong>用户名称：</strong><span>${user.username}</span></p>
            <p><strong>用户性别：</strong><span>${user.sex}</span></p>
            <p><strong>出生日期：</strong><span>${user.age}</span></p>
            <p><strong>用户电话：</strong><span>${user.mobile}</span></p>
            <p><strong>用户地址：</strong><span>${user.address}</span></p>
            <p><strong>用户类别：</strong><span>${user.auth}</span></p>
            <a  onclick="history.back(-1)">返回</a>
        </div>
    </div>
</div>

<script src="js/time.js"></script>

</body>
</html>