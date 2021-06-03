<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/16
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
  <table>
    <form action="<c:url context='${pageContext.request.contextPath}' value='/users/login'/>" method="post">
      <tr><td>用户名</td><td><input type="text" name="name"></td></tr>
      <tr><td>密码</td><td><input type="password" name="password"></td></tr>
      <tr><td><input type="submit" value="登录"></td></tr>

    </form>


  </table>
</body>
</html>
