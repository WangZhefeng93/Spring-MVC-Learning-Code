<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎页</title>
  </head>
  <body>
  <%--<% String res = new String(request.getParameter("username").getBytes("iso8859-1"), "utf-8"); %>
  <h2>【<%=res%>】您好，您已经登录到首页！</h2>--%>
  <h2>【${user.username}】您好，您已经登录到首页！</h2>
  </body>
</html>