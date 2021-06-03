<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/14
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
  <table>
    <form action="<c:url context='${pageContext.request.contextPath}' value="/users/aus" />" method="post">
      <tr><td>姓名</td><td><input type="text" name="name"/></td></tr>
      <tr><td>密码</td><td><input type="text" name="password"/></td></tr>
      <tr><td>年龄</td><td><input type="text" name="age"/></td></tr>
      <tr>
        <c:forEach items="${rolesList}" var="roles">
          <td><input type="checkbox" name="role" value="${roles.rid}"></td><td>${roles.rname}</td>
        </c:forEach>
      </tr>
      <tr><td><input type="submit" value="提交"/></td></tr>

    </form>


  </table>
</body>
</html>
