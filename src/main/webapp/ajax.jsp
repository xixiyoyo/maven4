<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/12
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
  <script src="./js/jquery.js"></script>
  <script>
    var arrsList = new Array();
    arrsList.push({name:"zhangsan",age:18,money:4588});
    arrsList.push({name:"lisi",age:28,money:345435345});
    $.ajax({
      type:"post",
      url:"${pageContext.request.contextPath}/user/login12",
      data:JSON.stringify(arrsList),
      contentType:"application/json;charset=utf-8",
      success:function () {
        alert("success");
      },
      error:function () {
        alert("error");
      }
    });
  </script>
</head>
<body>


</body>
</html>
