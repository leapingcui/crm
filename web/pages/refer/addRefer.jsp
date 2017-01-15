<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />



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
    <td width="44%" align="left">[添加咨询学生]</td>
   
    <td width="52%"align="right">
    	<!--<a href="listLog.html"><img src="${pageContext.request.contextPath}/images/button/find.gif" class="img"/></a>
        <a href="addLog.html"><img src="${pageContext.request.contextPath}/images/button/add.gif" class="img"/></a>~-->
        
       <!-- <a href="#"><img src="${pageContext.request.contextPath}/images/button/close.gif" class="img"/></a>-->
       <%--保存 --%>
       <a href="javascript:void(0)" onclick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/save.gif" /></a>
       <a href="#"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
 <c:if test="${errorList != null}">
	 <c:forEach var="error" items="${errorList}">
		 ${error.defaultMessage}<br/>
	 </c:forEach>
 </c:if>
<form action="${pageContext.request.contextPath}/addRefer.action" method="post">
	<table width="89%" class="emp_table"    style="" align="left" cellspacing="0">
	  <tr>
	    <td width="120px" height="35" align="left" >姓名：</td>
	    <td width="300px" align="left">
	    	<input type="text" name="name" value=""/>
	    </td>
	    <td>
	    	
	    </td>
	  </tr>
	  <tr>
	    <td>电话：</td>
	    <td><input type="text" name="telephone" value="" /> </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>QQ：</td>
	    <td><input type="text" name="QQ" value=""/></td>
	    <td>&nbsp;</td>
	  </tr>
	  
	  <tr>
	    <td>意向级别：</td>
	    <td>
	    	<select name="intentionLevel">
			    <option value="">--请选择意向级别--</option>
			    <option value="A.马上报名">A.马上报名</option>
			    <option value="B.想报名，考虑中">B.想报名，考虑中</option>
			    <option value="C.有报名集合，但暂时不能报名">C.有报名集合，但暂时不能报名</option>
			    <option value="D.不能报名，以及其他原因">D.不能报名，以及其他原因</option>
			</select>
	    </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td>意向学科：</td>
	    <td>
	    	<select name="courseType.courseTypeId" onchange="showClasses(this)">
			    <option value="">----请--选--择----</option>
				<c:choose>
					<c:when test="${courseTypeList != null}">
						<c:forEach var="courseType" items="${courseTypeList}">
							<option value="${courseType.courseTypeId}">${courseType.courseName}</option>
						</c:forEach>
					</c:when>
				</c:choose>

			</select>
	    	&nbsp;&nbsp;&nbsp;意向班级：
    		<select id="classId" name="classes.classId">
				<option value="">----请--选--择----</option>
			</select>
	    </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td height="41" align="left">来源：</td>
	    <td align="left">
	    	<select name="source">
			    <option value="">--请选择来源--</option>
			    <option value="1.QQ">1.QQ</option>
			    <option value="2.电话咨询">2.电话咨询</option>
			    <option value="3.上门">3.上门</option>
			    <option value="4.其他（老学员介绍）">4.其他（老学员介绍）</option>
			</select>
	    </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td align="left">备注：</td>
	    <td align="left">
	    	<textarea name="remark" cols="60" rows="5"></textarea>
	    </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td colspan="3">&nbsp;</td>
	  </tr>
	</table>
</form>
 <script type="text/javascript">
	 function showClasses(obj) {
		 var courseTypeId = obj.value;
		 //alert("测试" + courseTypeId);
		 //2.1 获得引擎
		 var xmlHttp = null;
		 if (window.XMLHttpRequest)
		 {// code for IE7+, Firefox, Chrome, Opera, Safari
			 xmlHttp=new XMLHttpRequest();
		 }
		 else
		 {// code for IE6, IE5
			 xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		 }
		 //2.2重点是回调函数
		 xmlHttp.onreadystatechange = function () {
			 if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				 //3、获取响应数据，并将json字符串提取出来
				 var responseDate = xmlHttp.responseText;
				 //alert(responseDate);
				 //3.1 将json字符串转为json对象
				 var jsonDate = eval("(" + responseDate + ")");
				 //3.2 获取页面上post的
				 var classSelectedElement = document.getElementById("classId");
				 //3.3 遍历json对象，将其输出到页面
				 classSelectedElement.innerHTML = "<option>----请--选--择----</option>";
				 for(var i = 0; i < jsonDate.length; i++) {
					 var classObj = jsonDate[i];
					 var classId = classObj.classId;
					 var className = classObj.className;
					 classSelectedElement.innerHTML += "<option value='" + classId + "'>" + className + "</option>";
				 }


			 }

		 };
		 //2.3 创建连接
		 var url = "${pageContext.request.contextPath}/findClassesByCourseTypeId.action?courseType.courseTypeId=" + courseTypeId;
		 xmlHttp.open("GET", url);
		 //2.4 发送请求
		 xmlHttp.send(null);
	 }

 </script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/showClassesByAjax.js"/>
</body>
</html>
