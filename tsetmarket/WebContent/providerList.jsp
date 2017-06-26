<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function del(id){
		if(window.confirm("是否删除")){
			window.location.href="proInfoServlet?type=2&proid="+id;
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
        <nav>
           <ul class="list">
                <li ><a href="billServlet">账单管理</a></li>
            	<c:if test="${sessionScope.authuser.auth=='经理'}">
                <li><a href="proServlet">供应商管理</a></li>
                <li><a href="adminServlet">用户管理</a></li>
            	</c:if>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="exitServlet">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面</span>
        </div>
        <div class="search">
        <form action="proSerchServlet" method="post">
            <span>供应商名称：</span>
            <input type="text" name="serchproname"/>
            <span>供应商描述：</span>
            <input type="text"name="serchdes"/>
            <input type="submit" value="查询"/>
            <a href="providerAdd.jsp">添加供应商</a>
            </form>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">地址</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach var="pro" items="${prolist}">
            
            <tr>
                <td>${pro.providerid}</td>
                <td>${pro.providername}</td>
                <td>${pro.proman}</td>
                <td>${pro.mobile}</td>
                <td>${pro.address}</td>
                <td>${pro.prodate}</td>
                <td>
                    <a href="proInfoServlet?proid=${pro.providerid}&type=0"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="proInfoServlet?proid=${pro.providerid}&type=1"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a onclick="del(${pro.providerid})"><img src="img/schu.png" alt="删除" title="删除"/></a>
                </td>
            </tr>
           </c:forEach>
        </table>
<c:if test="${page>1}">
<a href="proServlet?page=1">首页
</a><a href="proServlet?page=${page-1}">上一页</a>
</c:if>
<c:if test="${page<pages}">
<a href="proServlet?page=${page+1}">下一页</a>
<a href="proServlet?page=${pages}">末页</a>
</c:if>
<span>当前页码：${page}/${pages}页</span>


${mess}
    </div>
</div>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该供应商吗？</p>
           <a href="#" id="yes">确定</a>
           <a href="#" id="no">取消</a>
       </div>
   </div>
</div>


<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>