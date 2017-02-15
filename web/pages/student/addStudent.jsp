<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
        <td width="44%" align="left">[添加/编辑正式学员]</td>

        <td width="52%"align="right">
            <a href="javascript:void(0)" onclick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/save.gif" /></a>
            <a href="#"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>
<c:if test="${errors != null}">
    <c:forEach var="error" items="${errors}">
        ${error.defaultMessage}
    </c:forEach>
</c:if>
<form action="${pageContext.request.contextPath}/addStudent.action" method="post">
    <table width="88%" class="emp_table">
        <tr>
            <td width="100px" align="left">姓名：</td>
            <td width="200px" align="left"><input type="text" name="name" value="${student.name}"/> </td>
            <td width="80px" align="left">性别：</td>
            <td align="left">
                <input type="radio" name="gender" value="男"/>男
                <input type="radio" name="gender" value="女"/>女
            </td>
        </tr>
        <tr>
            <td align="left">应付学费：</td>
            <td align="left"><input type="text" name="mustTuition" value="${student.mustTuition}"/></td>
            <td align="left">实付学费：</td>
            <td align="left"><input type="text" name="actualTuition" value="${student.actualTuition}"/></td>
        </tr>
        <tr>
            <td align="left">身份证号：</td>
            <td align="left"><input type="text" name="identity" value="${student.identity}" /></td>
            <td align="left">手机号：</td>
            <td align="left"><input type="text" name="telephone" value="${student.telephone}"/></td>
        </tr>
        <tr>
            <td align="left">QQ号：</td>
            <td align="left"><input type="text" name="QQ" value="${student.QQ}"/></td>
            <td align="left">邮箱：</td>
            <td align="left"><input type="text" name="email" value="${student.email}"/></td>
        </tr>
        <tr>
            <td align="left">就读班级：</td>
            <td align="left" colspan="3">
                类别 <select name="courseType.courseTypeId" onchange="showClasses(this)"
                <option value="">--选择课程--</option>
                <c:forEach var="courseType" items="${courseTypeList}">
                    <option value="${courseType.courseTypeId}">${courseType.courseName}</option>
                </c:forEach>


            </select>

                班级<select name="classes.classId" id="classId">
                <option value="">----请--选--择----</option>
            </select>
            </td>
        </tr>
        <tr>
            <td align="left">毕业学校：</td>
            <td align="left"><input type="text" name="school" value="${student.school}"/></td>
            <td align="left">学历：</td>
            <td align="left">
                <select name="education">
                    <option value="">--选择学历--</option>
                    <option value="1.博士">1.博士</option>
                    <option value="2.研究生">2.研究生</option>
                    <option value="3.本科">3.本科</option>
                    <option value="4.大专">4.大专</option>
                    <option value="5.高中">5.高中</option>
                    <option value="6.初中">6.初中</option>
                    <option value="7.其他">7.其他</option>
                </select>

                专业<input type="text" name="professional" size="17" value="${student.professional}" />
            </td>
        </tr>
        <tr>
            <td align="left">身份证地址：</td>
            <td align="left" colspan="3"><input type="text" name="identityAddress" size="60" value="${student.identityAddress}"/></td>
        </tr>
        <tr>
            <td align="left">在京地址：</td>
            <td align="left" colspan="3"><input type="text" name="address" size="60" value="${student.address}"/></td>
        </tr>
        <tr>
            <td align="left">学员描述：</td>
            <td align="left" colspan="3"><input type="text" name="remark" size="60" value="${student.remark}"/></td>
        </tr>
        <tr>
            <td colspan="6"><br />出门在外，如果发生意外，我们将通过下面的信息跟学院的家长联系</td>
        </tr>
        <tr>
            <td align="left">家庭联系电话：</td>
            <td align="left"><input type="text" name="homeTelephone" value="${student.homeTelephone}"/></td>
            <td align="left">家庭联系人：</td>
            <td align="left"><input type="text" name="homeContact" value="${student.homeContact}"/></td>
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
</body>
</html>