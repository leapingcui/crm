<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/showClassesByAjax.js"></script>
</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[在校学生管理]</td>
   
    <td width="57%"align="right">
    	<%--查询 --%>
		<a href="javascript:void(0)" onclick="document.forms[0].submit();"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--添加 --%>
    	<a href="${pageContext.request.contextPath}/editBeforeAddStudent.action">
    		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：添加或选择马上查询 -->
<form action="${pageContext.request.contextPath}/findStudentByCondition.action?currentPage=1" method="post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">查询条件</td>
	    <td width="300px"><input type="text" name="condition" size="15" value=""/>（姓名|电话|QQ|性别）</td>
	    <td width="500px">
	    	课程类别：
	    	<select name="student.courseType.courseTypeId" onchange="showClasses(this)">
			    <option value="">--选择课程--</option>
                <c:forEach var="courseType" items="${courseTypeList}">
                    <option value="${courseType.courseTypeId}">${courseType.courseName}</option>
                </c:forEach>

			</select>

	    	班级：<select name="student.classes.classId" id="classId" >
				    <option value="">----请--选--择----</option>
				</select>
	    </td>
	    <td></td>
	  </tr>
	</table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="100%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">

    <td width="10%" align="center">姓名</td>
    <td width="10%" align="center">入学时间</td>
    <td width="10%" align="center">班级</td>
    <td width="10%" align="center">QQ</td>
    <td width="10%" align="center">联系电话</td>
    <td width="10%" align="center">已付/应付学费</td>
    <td width="10%" align="center">状态</td>  <!-- 新生、转班、升级、退费、毕业 -->
  	<td width="5%" align="center">编辑</td>
  	<td width="5%" align="center">升级/转班</td>
  	<td width="5%" align="center">查看</td>
  	<td width="5%" align="center">流失</td>
  </tr>
	<c:choose>
		<c:when test="${studentPageBean != null}">
			<c:forEach var="student" items="${studentPageBean.pageBean}">
				<tr class="tabtd1">
					<td align="center">${student.name}(${student.gender}) </td>
					<td align="center"><fmt:formatDate value="${student.admissionDate}" pattern="yyyy-mm-dd"></fmt:formatDate> </td>
					<td align="center">${student.classes.className} </td>
					<td align="center">${student.QQ} </td>
					<td align="center">${student.telephone} </td>
					<td align="center">${student.mustTuition}/${student.actualTuition} </td>
					<td align="center">
							${student.status}
					</td>

					<td align="center">
						<a href="${pageContext.request.contextPath}/pages/student/addOrEditStudent.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
					</td>

					<td align="center">
						<a href="${pageContext.request.contextPath}/pages/station/editStation.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
					</td>
					<!-- 查询详情 -->
					<td align="center">
						<a href="${pageContext.request.contextPath}/showStudent.action?studentId=${student.studentId}"><img src="${pageContext.request.contextPath}/images/button/view.gif" class="img"/></a>
					</td>

					<td align="center">
						<a href="${pageContext.request.contextPath}/pages/runoff/addRunoff.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
					</td>
				</tr>
			</c:forEach>

		</c:when>
	</c:choose>

</table>



<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第${studentPageBean.currentPage}/${studentPageBean.totalPage}页</span>
        <span>
            <c:if test="${studentPageBean.currentPage gt 1}">
                <a href="${pageContext.request.contextPath}/findStudentByCondition.action?condition=${condition}&currentPage=1">[首页]</a>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/findStudentByCondition.action?condition=${condition}&currentPage=${studentPageBean.currentPage - 1}">[上一页]</a>&nbsp;&nbsp;
            </c:if>
            <c:forEach var="num" begin="${studentPageBean.start}" end="${studentPageBean.end}">
                <c:choose>
                    <c:when test="${num eq studentPageBean.currentPage}">
                        ${studentPageBean.currentPage}&nbsp;&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/findStudentByCondition.action?condition=${condition}&currentPage=${num}">[${num}]</a>&nbsp;&nbsp;
                    </c:otherwise>
                </c:choose>

            </c:forEach>
            <c:if test="${studentPageBean.currentPage lt studentPageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/findStudentByCondition.action?condition=${condition}&currentPage=${studentPageBean.currentPage + 1}">[下一页]</a>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/findStudentByCondition.action?condition=${condition}&currentPage=${studentPageBean.totalPage}">[尾页]</a>
            </c:if>


        </span>
    </td>
  </tr>
</table>
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
</body>
</html>