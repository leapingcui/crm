/**
 * Created by Administrator on 2017/1/13.
 */

    function showClassTest(obj) {
        var courseTypeId = obj.value;
        //alert("测试一下" + courseTypeId);
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
                alert(responseDate);
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


