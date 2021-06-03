<html>
<body>
<h2>Hello World! ${username}</h2>
<%
  request.setCharacterEncoding("UTF-8");
  response.setContentType("text/html;charset=utf-8");
%>
<table>
  <tr>
    <td>用户名：</td>
    <td><input type="text" value="${username}" /></td>
  </tr>
  <tr>
    <td>密码：</td>
    <td><input type="password" value="${password}" /></td>
  </tr>
</table>


</body>
</html>
