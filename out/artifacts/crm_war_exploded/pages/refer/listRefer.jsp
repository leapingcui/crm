<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
		function selectRefer(){
			
		}
	</script>
</head>

<body>
 <table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="33%" align="left">[咨询学生管理]</td>
   
    <td width="63%"align="right">
    	<%--添加咨询 --%>
    	<a class="butbg" href="${pageContext.request.contextPath}/editBeforeAddRefer.action">
	        <img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：失去焦点马上查询 -->
<form action="${pageContext.request.contextPath}/findReferByCondition.action" method="post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">查询条件：</td>
	    <td width="300px">
	    	<input type="text" name="condition" size="20" onblur="" />
	    	（姓名|电话|QQ）
            <input type="submit" value="查询"/>
	    </td>
	    <td ></td>
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
	<td width="80px" align="center">姓名</td>
	<td width="9%" align="center">电话</td>
	<td width="11%" align="center">QQ </td>
	<td width="15%" align="center">意向类别/班级</td>
	<td width="17%" align="center">状态</td>
	<td width="10%" align="center">营销人员</td>
	<td width="8%" align="center">查看</td>
	<%-- 根据状态不同显示操作项 --%>
	<td width="8%" align="center">编辑</td>
	<td width="8%" align="center">跟踪</td>
	<td width="8%" align="center">录入学籍</td>
  </tr>
	<c:choose>
		<c:when test="${referList != null}">
			<c:forEach var="refer" items="${referList}">
				<tr class="tabtd1">
					<td align="center">${refer.name}</td>
					<td align="center">${refer.telephone}</td>
					<td align="center">${refer.QQ}</td>
					<td align="center">
						${refer.courseType.courseName}/
						${refer.classes.className}
					</td>
					<td align="center">
						${refer.status}
					</td>
					<td align="center">${refer.staff.staffName}</td>

					<!-- 查看 -->
					<td width="8%" align="center">
						<a href="${pageContext.request.contextPath}/queryRefer.action?referId=${refer.referId}"><img src="${pageContext.request.contextPath}/images/button/view.gif" class="img"/></a>
					</td>


					<!-- 编辑 -->
					<td width="8%" align="center">
						<a href="${pageContext.request.contextPath}/editBeforeUpdateRefer.action?referId=${refer.referId}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
					</td>

					<!-- 添加跟踪 -->
					<td width="8%" align="center">
						<a href="${pageContext.request.contextPath}/pages/follow/addOrEditFollow.jsp"><img src="${pageContext.request.contextPath}/images/button/new.gif" class="img"/></a>
					</td>

					<!-- 入学 -->
					<td width="8%" align="center">
						<a href="${pageContext.request.contextPath}/editBeforeEntryStatus.action?referId=${refer.referId}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
					</td>

				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>



</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>

</body>
</html>
