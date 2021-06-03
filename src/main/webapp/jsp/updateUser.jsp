<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/14
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>更新用户信息</title>
</head>
<body>
  <form action="<c:url context='${pageContext.request.contextPath}' value="/users/uus" /> " method="post">
    <input type="text" value="${users.id}" name="id" readonly/>
    <input type="text" value="${users.name}" name="name"/>
    <input type="text" value="${users.password}" name="password"/>
    <input type="text" value="${users.age}" name="age"/>
    <input type="text" value="${users.role}" name="role"/>
    <c:forEach items="${rolesList}" var="roles">
      <input type="checkbox" name="role" value="${roles.rid}">${roles.rname}
    </c:forEach>
    <input type="submit" value="提交"/>
  </form>
</body>
</html>
