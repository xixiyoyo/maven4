<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/13
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login17" method="post" enctype="multipart/form-data">
  <input type="text" name="username"><br>
  <input type="file" name="updateFile"><br>
  <input type="file" name="updateFile"><br>
  <input type="submit" value="提交">

</form>


</body>
</html>
