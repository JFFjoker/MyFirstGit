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
            <span>账单管理页面 >> 订单修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="billInfoServlet?billid=${bill.billid}&type=1" method="post"">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="providerId" >订单编码：</label>
                    <input type="text" name="billid" id="providerId" readonly="readonly" value="${bill.billid}"/>
                    <span>*</span>
                </div>
                <div>
                    <label>商品名称：</label>
                    <input type="text" name="proname" id="providerName" value="${bill.proname}"/>
                </div>
                <div>
                    <label >商品描述：</label>
                    <input type="text" name="prodes" id="people" value="${bill.prodes}"/>
                </div>
                <div>
                    <label >商品数量：</label>
                    <input type="text" name="count"  value="${bill.count}"/>
                </div>
                <div>
                    <label >总金额：</label>
                    <input type="text" name="money"  value="${bill.money}"/>
                </div>
                <div>
                    <label >供应商：</label>
                    <input type="text" name="providername" value="${bill.providername}"/>
                </div>
                <div>
                    <label >是否付款：</label>
                    <input type="radio" name="pay" value="是"/>未付款
                    <input type="radio" name="pay" value="否" checked="checked"/>已付款
                </div>
               
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.jsp">返回</a>-->
                    <input type="submit" value="保存" onclick="billInfoServlet"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</div>
<script src="js/time.js"></script>

</body>
</html>