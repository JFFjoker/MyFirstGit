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
        <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.username}</span> , 欢迎你！</p>
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
            <span>供应商管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>供应商编码：</strong><span>${pro.providerid}</span></p>
            <p><strong>供应商名称：</strong><span>${pro.providername}</span></p>
            <p><strong>联系人：</strong><span>${pro.proman}</span></p>
            <p><strong>联系电话：</strong><span>${pro.mobile}</span></p>
            <p><strong>传真：</strong><span>${pro.fax}</span></p>
            <p><strong>供应商描述：</strong><span>${pro.des}</span></p>
            <p><strong>供应商地址：</strong><span>${pro.address}</span></p>

            <a onclick="history.back(-1)">返回</a>
        </div>
    </div>
</div>

<script src="js/time.js"></script>

</body>
</html>