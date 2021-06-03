<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/13
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>查看用户界面</title>
</head>
<body>
  <table>
    <tr>
      <td>编号</td>
      <td>用户名</td>
      <td>密码</td>
      <td>年龄</td>
      <td>角色</td>
      <td colspan="2">操作</td>
    </tr>
    <c:forEach items="${usersList}" var="list">
      <tr>
        <td>${list.id}</td>
        <td>${list.name}</td>
        <td>${list.password}</td>
        <td>${list.age}</td>
        <td><c:forEach items="${list.roles}" var="role">
          &nbsp;&nbsp;${role.rname}
        </c:forEach></td>
        <td><a href="<c:url context='${pageContext.request.contextPath}' value='/users/dus?id=${list.id}' />">删除</a></td>
        <td><a href="<c:url context='${pageContext.request.contextPath}' value='/users/cusid?id=${list.id}' />">修改</a></td>
      </tr>
    </c:forEach>
    <tr><td><a href="<c:url context='${pageContext.request.contextPath}' value='/users/ausUI' />">添加用户</a></td></tr>

  </table>
</body>
</html>
