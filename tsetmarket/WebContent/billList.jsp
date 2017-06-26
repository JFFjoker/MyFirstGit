<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function del(id){
		if(window.confirm("是否删除")){
			window.location.href="billInfoServlet?type=2&billid="+id;
		}
	}
	function go(frm,page){
		frm.pageindex.value=page;
		frm.submit();
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
    <div class="publicMian">
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
                <span>账单管理页面</span>
            </div>
            <div class="search">
            	<form action="billServlet" method="post">
            	<input type="hidden" id="pageindex" name="page" value="${page}">
                <span>商品名称：</span>
                <input name ="serchbill"type="text" value="${serchbill}"/>
                <span>供应商：</span>
                <select name="serchprovider" >
                    <option value="">--请选择--</option>
                    <c:forEach var="billname" items="${namelist}">
                    <option value="${billname.providername}" <c:if test="${serchprovider eq billname.providername}">selected="selected"</c:if>>${billname.providername}</option>
                    </c:forEach>
                </select>
                <span>是否付款：</span>
                <select name="serchpay">
                    <option value="">--请选择--</option>
                    <option value="是" <c:if test="${serchpay=='是'}" > selected="selected"</c:if>>已付款</option>
                    <option value="否" <c:if test="${serchpay=='否'}" > selected="selected"</c:if>>未付款</option>
                </select>
                <input type="submit" value="查询"/>
                <a href="billAdd.jsp">添加订单</a>
                </form>
            </div>
            <!--账单表格 样式和供应商公用-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">账单编号</th>
                    <th width="10%">商品名称</th>
                    <th width="10%">商品数量</th>
                    <th width="10%">交易金额</th>
                    <th width="10%">是否付款</th>
                    <th width="10%">供应商</th>
                    <th width="10%">商品描述</th>
                    <th width="10%">创建时间</th>
                    <th width="30%">操作</th>
                </tr>
                <c:forEach var="bill" items="${billlist}">
                <tr>
                    <td>${bill.billid} </td>
                    <td>${bill.proname}</td>
                    <td>${bill.count}</td>
                    <td>${bill.money}</td>
                    <td>${bill.pay}</td>
                    <td>${bill.providername}</td>
                    <td>${bill.prodes}</td>
                    <td>${bill.date}</td>
                    <td>
                       <a href="billInfoServlet?billid=${bill.billid}&type=0"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="billInfoServlet?billid=${bill.billid}&type=1"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a onclick="del(${bill.billid})"><img src="img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <c:if test="${page>1}">
            <!-- serchbill  serchpro  pay page pages -->
<a href="javascript:go(document.forms[0],1)">首页
</a><a href="javascript:go(document.forms[0],${page-1})">上一页</a>
</c:if>
<c:if test="${page<pages}">
<a href="javascript:go(document.forms[0],${page+1})">下一页</a>
<a href="javascript:go(document.forms[0],${pages})">末页</a>
</c:if>
<span>当前页码：${page}/${pages}页</span>


${mess}
        </div>
    </div>

<!--点击删除按钮后弹出的页面-->
<!-- <div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="billServlet" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div> -->

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>