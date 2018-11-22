<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>上传成功</title>
</head>
<body>
    <c:if test="${fileName != null}">
        <h1>单个文件上传成功！</h1>
        ${fileName}：<br/><img src="/demo/images/${fileName}">
    </c:if>
    <c:if test="${fileName != null} && ${fileNames != null}">
        <br/>
        <hr/>
        <br/>
    </c:if>
    <c:if test="${fileNames != null}">
        <h1>多个文件上传成功！</h1>
        <c:forEach items="${fileNames}" var="fileName">
            ${fileName}：<br/><img src="/demo/images/${fileName}"><br/>
        </c:forEach>
    </c:if>
</body>
</html>
