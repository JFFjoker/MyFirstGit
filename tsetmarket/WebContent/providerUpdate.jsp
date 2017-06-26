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
            <span>供应商管理页面 >> 供应商修改页</span>
        </div>
        <div class="providerAdd">
            <form action="proInfoServlet?proid=${pro.providerid}&type=1" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div >
                    <label >供应商编码：</label>
                    <input type="text" name="proid" value="${pro.providerid}"/>
                </div>
                <div>
                    <label >供应商名称：</label>
                    <input type="text" name="proname" id="providerName" value="${pro.providername} "/>
                </div>
                <div>
                    <label >联系人：</label>
                    <input type="text" name="proman" id="people" value="${pro.proman}"/>
                </div>
                <div>
                    <label >联系电话：</label>
                    <input type="text" name="mobile" id="phone" value="${pro.mobile}"/>
                    
                </div>
                <div>
                    <label for="address">联系地址：</label>
                    <input type="text" name="address" id="address" value="${pro.address}"/>
                </div>
                <div>
                    <label for="fax">传真：</label>
                    <input type="text" name="fax" id="fax" value="${pro.fax}"/>
                </div>
                <div>
                    <label for="describe">描述：</label>
                    <input type="text" name="des" value="${pro.des}"/>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="providerList.jsp">返回</a>-->
                    <input type="submit" value="保存"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</div>

<script src="js/time.js"></script>

</body>
</html>