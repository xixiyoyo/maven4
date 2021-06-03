<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/12
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/user/login11" method="post">
    <input type="text" name="userList[0].name"/>
    <input type="text" name="userList[0].age"/>
    <input type="text" name="userList[0].money"/>
    <input type="text" name="userList[1].name"/>
    <input type="text" name="userList[1].age"/>
    <input type="text" name="userList[1].money"/>
    <input type="submit" value="提交">
  </form>

</body>
</html>
