<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiaobaixiaoda
  Date: 2018/11/14
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录错误</title>
</head>
<body>
    <h1>登录错误！</h1>
    <c:if test="${allErrors != null}">
        <c:forEach items="${allErrors}" var="error">
            <font color="red">${error.defaultMessage}</font><br/>
        </c:forEach>
    </c:if>
</body>
</html>
