<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户登录</title>
    </head>
    <body>
        <h3>用户登录</h3>
        <form action="doLogin.action" method="post">
            <table width="300px;" border=1>
                <tr>
                    <td>用户编号：</td>
                    <td><input type="text" name="userId" id="userId" /></td>
                </tr>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="username" id="username" /></td>
                </tr>
                <tr>
                    <td>密 码：</td>
                    <td><input type="password" name="password" id="password" /></td>
                </tr>
            </table>
            <br/>
            <input type="submit" id="login_button" value="用户登录" />
        </form>
    </body>
</html> 