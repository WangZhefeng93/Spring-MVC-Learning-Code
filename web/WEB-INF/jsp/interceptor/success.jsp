<%--
  Created by IntelliJ IDEA.
  User: xiaobaixiaoda
  Date: 2018/10/30
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录成功</title>
  </head>
  <body>
  <script type="text/javascript">
      onload=function(){
          setInterval(go, 1000);
      };
      var x=10; //利用了全局变量来执行
      function go(){
          x--;
          if(x>0){
              document.getElementById("sp").innerHTML=x+"秒后跳转到首页";  //每次设置的x的值都不一样了。
          }else{
              location.href='${pageContext.request.contextPath}/InterceptorTest/index.action';
          }
      }
  </script>

  <h2>登录成功！</br></br>欢迎您【${user.username}】！</h2>
  <br/>
  <h3><span id="sp">10秒后跳转到首页</span> </h3>
  <hr/>
  <h3>使用user参数显示用户登录信息</h3>
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
