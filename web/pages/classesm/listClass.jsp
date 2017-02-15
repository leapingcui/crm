<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sys.css" type="text/css"/>
<title>班级管理</title>
</head>

<body>
<!--距离页面顶端5px-->
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topg"></td>
  </tr>
</table>
<form name="createForm" action="" method="post">
<table border="0" cellspacing="0" cellpadding="0" class="wukuang">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="20%" align="left">[班级管理]</td>
    <td width="42%"align="center">&nbsp;</td>
    <td width="36%"align="right">
    	<%--添加班级  /html/classesm/addClass.jsp--%>
    	<a href="${pageContext.request.contextPath}/editClassBeforeAdd.action">
    		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" class="img"/>
    	</a>
    	<%--高级查询 
        <a href="queryClass.html"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" class="img"/></a>
    	--%>
    </td>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
</form>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topg"></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="97%" border="1">
<thead>
  <tr class="henglan" style="font-weight:bold;">
	<th width="150px" align="center">班级名称</th>
    <th width="200px" align="center">所属课程</th>
    <th width="80px" align="center">开班时间</th>
    <th width="80px" align="center">毕业时间</th>
    
    <th width="80px" align="center">状态</th>
    <th width="70px" align="center">学生总数</th>
    <th width="70px" align="center">升学数</th>
    <th width="70px" align="center">转班数</th>
    <th width="50px" align="center">编辑</th>
	<th width="50px" align="center">查看</th>
	<th align="center">课表</th>
  </tr>
  </thead>
  <tbody>
  		<c:choose>
			<c:when test="${classesList != null}">
				<c:forEach var="classes" items="${classesList}">
					<tr class="tabtd1">
						<td align="center">${classes.className} </td>
						<td align="center">${classes.courseType.courseName}</td>

						<td align="center"><fmt:formatDate value="${classes.beginTime}" pattern="yyyy-mm-dd"/></td>
						<td align="center"><fmt:formatDate value="${classes.endTime}" pattern="yyyy-mm-dd"/></td>
						<td align="center">${classes.status}</td>
						<td align="center">${classes.totalCount} </td>
						<td align="center">${classes.upgradeCount} </td>
						<td align="center">${classes.changeCount} </td>
						<td align="center">
							<a href="${pageContext.request.contextPath}/editClassesBeforeUpdate.action?classId=${classes.classId}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
						</td>
						<td align="center">
							<a href="${pageContext.request.contextPath}/showClasses.action?classId=${classes.classId}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
						</td>
						<td align="center" title="上次上传时间：">
							<a href="${pageContext.request.contextPath}/beforeUpload.action?classId=${classes.classId}">上传</a>
                            <c:choose>
                                <c:when test="${classes.uploadFilename != null}">
                                    <a href="${pageContext.request.contextPath}/downloadSchedule.action?classId=${classes.classId}">下载</a> <br/>
                                </c:when>
                                <c:otherwise>
                                    暂无
                                </c:otherwise>
                            </c:choose>


						</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>


  
  </tbody>
</table>


<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/1页</span>
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
