<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function del(id){
		if(window.confirm("是否删除")){
			window.location.href="userServlet?type=2&userid="+id;
		}
	}
	
</script>
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
                <span>用户管理页面</span>
            </div>
            <div class="search">
            	<form action="adminServlet?sertype=1" method="post">
                <span>用户名：</span>
                <input type="text" name="serchname" value=""/>
                <input type="submit" value="查询"/>
                <a href="userAdd.jsp">添加用户</a>
               </form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户类型</th>
                    <th width="30%">操作</th>
                </tr>
                <c:forEach var="user" items="${requestScope.userlist}">
                <input type="hidden" name=>
                	 <tr>
                    <td>${user.userid}</td>
                    <td>${user.username}</td>
                    <td>${user.sex}</td>
                    <td>${user.age}</td>
                    <td>${user.mobile}</td>
                    <td>${user.auth}</td>
                    <td>
                        <a href="userServlet?userid=${user.userid}&type=0"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="userServlet?userid=${user.userid}&type=1"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                       <!--  <a href="#" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a> -->
                        <a onclick="del(${user.userid})"><img src="img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            
<c:if test="${page>1}">
<a href="adminServlet?page=1">首页
</a><a href="adminServlet?page=${page-1}">上一页</a>
</c:if>
<c:if test="${page<pages}">
<a href="adminServlet?page=${page+1}">下一页</a>
<a href="adminServlet?page=${pages}">末页</a>
</c:if>
<span>当前页码：${page}/${pages}页</span>
        </div>
    </div>

${mess}



<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>