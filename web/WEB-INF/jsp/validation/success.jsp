<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录成功</title>
</head>
<body>
  <h2>登录成功！</br></br>欢迎您${user.username}！</h2>

  <hr/>

  <h3>使用user参数显示用户注册信息</h3>
  <table width="300px;" border=1>
    <tr>
      <td>用户编号：</td>
      <td>${user.userId}</td>
    </tr>
    <tr>
      <td>用户名：</td>
      <td>${user.username}</td>
    </tr>
    <tr>
      <td>密 码：</td>
      <td>${user.password}</td>
    </tr>
  </table>
</body>
</html>