<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
	<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxCore.js"></script>--%>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<form action="${pageContext.request.contextPath}/addStaff.action" method="post">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><input type="text" name="loginName" value="" /> </td>
	    <td>密码：</td>
	    <td><input type="password" name="loginPwd" /> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="staffName" value="" id="staffAction_add_staffName"/> </td>
	    <td>性别：</td>
	    <td><input type="radio" name="gender"  value="男"/>男
	    	<input type="radio" name="gender"  value="女"/>女
		</td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	    	<select name="post.department.depId"onchange="showPost(this)">
			    <option value="">----请--选--择----</option>
				<c:forEach var="department" items="${departmentList}">
					<option value="${department.depId}">${department.depName}</option>
				</c:forEach>

			</select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<select id="postSelectId" name="post.postId">
	    		<option>----请--选--择----</option>
	    	</select>
	    </td>
	  </tr>
	   <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="onDutyDate" value="" readonly="readonly"  onfocus="c.showMoreDay=true; c.show(this);" />
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</form>
	<script type="text/javascript">
		function showPost(obj) {
			/**
			 * 1、获取选中部门
			 * 2、发送ajax，通过部门查询职务
			 * 	2.1 获得引擎
			 * 	2.2 设置回调函数
			 * 	2.3 创建连接
			 * 	2.4 发送请求
			 *
			 */
					//1、获取选中部门
			var depId = obj.value;
			//2.1 获得引擎
			var xmlhttp = null;
			if (window.XMLHttpRequest)
			{// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp=new XMLHttpRequest();
			}
			else
			{// code for IE6, IE5
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			//2.2重点是回调函数
			xmlhttp.onreadystatechange = function () {
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
					//3、获取响应数据，并将json字符串提取出来
					var responseDate = xmlhttp.responseText;
					//alert(responseDate);
					//3.1 将json字符串转为json对象
					var jsonDate = eval("(" + responseDate + ")");
					//3.2 获取页面上post的
					var postSelectedElement = document.getElementById("postSelectId");
					//3.3 遍历json对象，将其输出到页面
					postSelectedElement.innerHTML = "<option>----请--选--择----</option>";
					for(var i = 0; i < jsonDate.length; i++) {
						var postObj = jsonDate[i];
						var postId = postObj.postId;
						var postName = postObj.postName;
						postSelectedElement.innerHTML += "<option value='" + postId + "'>" + postName + "</option>";
					}


				}
			};
			//2.3 创建连接
			var url = "${pageContext.request.contextPath}/findPostByIdBeforeAddStaff.action?depId=" + depId;
			xmlhttp.open("GET", url);
			//2.4 发送请求
			xmlhttp.send(null);
			//alert("test");
		}
	</script>
</body>
</html>
