<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>JSON交互</title>
  </head>
  <body>
    <textarea id="jsonMsg" cols="30" rows="5" placeholder="请输入json格式信息"></textarea>
    <br/><br/>
    <button onclick="submitMsg()">发送</button>
    ${student}
  </body>
  <script type="text/javascript"
  		src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
  <script type="text/javascript">  
        //请求格式为json，输出格式为json  
        function submitMsg(){  
            var message=$('#jsonMsg').val();
            console.log(message);
            $.ajax({
                type:'post',
                url:"doJson.action",
                contentType:"application/json;charset=utf-8",
                dataType : 'json',
                data:message,//数据格式是json串
                success:function(data){//返回json结果 
                    alert("name="+data["studentName"]+
                        ",password="+data["password"]);
                }

            });  
        }  
   </script>  
</html>
