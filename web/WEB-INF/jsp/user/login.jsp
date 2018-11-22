<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户登录</title>
        <%--<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>--%>
    </head>
    <body>
        <%--<script type="text/javascript">
            $(function () {
                $("#login_button").click(function () {
                    var userId = $("#userId").val();
                    var username = $("#username").val();
                    var password = $("#password").val();
                    $.ajax({
                        url: "doLogin.action",
                        type: "post",
                        contentType: "application/x-www-form-urlencoded; charset=utf-8",
                        data: {
                            userId: userId,
                            username: username,
                            password: password
                        },
                        success: function (data) {
                            var str1 = "用户编号："+data.user1.userId+"  用户名："+data.user1.username+"  用户密码："+data.user1.password+"\n";
                            var str2 = "用户编号："+data.user2.userId+"  用户名："+data.user2.username+"  用户密码："+data.user2.password+"\n";
                            var str3 = "用户编号："+data.user3.userId+"  用户名："+data.user3.username+"  用户密码："+data.user3.password+"\n"
                            alert(str1+str2+str3);
                            /*var string = "";
                            $(data).each(function (index) {
                                string += "用户编号："+data[index].userId+"  用户名："+data[index].username+"  用户密码："+data[index].password+"\n";
                            })
                            alert(string)*/
                            //alert("用户编号："+data.userId+"\n用户名："+data.username+"\n用户密码："+data.password);
                            //alert("注册成功！欢迎您"+data+"！");
                            //alert("您是第"+data+"个注册的用户");
                            /*var myJson = eval("(" + data + ")");
                            alert(myJson.userId+" "+myJson.username+" "+myJson.password);*/
                        }
                    });
                });
            });
        </script>--%>
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