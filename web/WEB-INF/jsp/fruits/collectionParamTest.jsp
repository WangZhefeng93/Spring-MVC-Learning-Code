<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
  <title>集合类型参数绑定Demo</title>
</head>  
<body>
  <h3>水果列表</h3>
  <%--演示数组类型的请求参数开始--%>
  <form action="showParam.action" method="post">
      <table width="300px;" border=1>
          <tr>
              <td>选择</td>
              <td>编号</td>
              <td>名称</td>
              <td>价格</td>
              <td>产地</td>
          </tr>
          <c:if test="${fruitsList==null}">
              <b>水果商品信息为空！</b>
          </c:if>
          <c:forEach items="${fruitsList}" var="fruit">
              <tr>
                  <td><input type="checkbox" name="fruitsIdArray" value="${fruit.id}" /></td>
                  <td>${fruit.id }</td>
                  <td>${fruit.name }</td>
                  <td>${fruit.price }</td>
                  <td>${fruit.producing_area }</td>
              </tr>
          </c:forEach>
      </table>
      <br/>
      <input type="submit" value="数组类型批量测试提交" />
  </form>
  <%--演示数组类型的请求参数结束--%>

  <%--演示泛型为基本数据类型或String类型的List类型的请求参数开始--%>
  <hr/>
  <h4>演示泛型为基本数据类型或String类型的List类型的请求参数</h4>
  <form action="showBasicListParam.action" method="post">
      <table width="300px;" border=1>
          <tr>
              <td>选择</td>
              <td>编号</td>
              <td>名称</td>
              <td>价格</td>
              <td>产地</td>
          </tr>
          <c:if test="${fruitsList==null}">
              <b>水果商品信息为空！</b>
          </c:if>
          <c:forEach items="${fruitsList}" var="fruit" varStatus="status">
              <tr>
                  <td><input type="checkbox" name="fruitsIdList[${status.index}]" value="${fruit.id}" /></td>
                  <td>${fruit.id}</td>
                  <td>${fruit.name}</td>
                  <td>${fruit.price}</td>
                  <td>${fruit.producing_area}</td>
              </tr>
          </c:forEach>
      </table>
      <br/>
      <input type="submit" value="基本数据类型批量测试提交" />
  </form>
  <%--演示泛型为基本数据类型或String类型的List类型的请求参数结束--%>

  <%--演示泛型为引用类型的List类型的请求参数开始--%>
  <hr/>
  <h4>演示泛型为引用类型的List类型的请求参数</h4>
  <form action="showListParam.action" method="post">
      <table width="300px;" border=1>
          <tr>
              <td>编号</td>
              <td>名称</td>
              <td>价格</td>
              <td>产地</td>
          </tr>
          <c:if test="${fruitsList==null}">
              <b>水果商品信息为空！</b>
          </c:if>
          <c:forEach items="${fruitsList}" var="fruit" varStatus="status">
              <tr>
                  <td><input name="fruitsList[${status.index}].id" value="${fruit.id}" /></td>
                  <td><input name="fruitsList[${status.index}].name" value="${fruit.name}" /></td>
                  <td><input name="fruitsList[${status.index}].price" value="${fruit.price}" /></td>
                  <td><input name="fruitsList[${status.index}].producing_area" value="${fruit.producing_area}" /></td>
              </tr>
          </c:forEach>
      </table>
      <br/>
      <input type="submit" value="引用类型批量测试提交" />
  </form>
  <%--演示泛型为引用类型的List类型的请求参数结束--%>

  <%--演示Map类型的请求参数开始--%>
  <hr/>
  <h4>演示Map类型的请求参数</h4>
  <form action="showMapParam.action" method="post">
      <table width="300px;" border=1>
          <tr>
              <td>编号</td>
              <td>名称</td>
              <td>价格</td>
              <td>产地</td>
          </tr>
          <tr>
              <td><input name="fruitsMap['id']" value="3" /></td>
              <td><input name="fruitsMap['name']" value="凤梨" /></td>
              <td><input name="fruitsMap['price']" value="5.7" /></td>
              <td><input name="fruitsMap['producing_area']" value="广州" /></td>
          </tr>
      </table>
      <br/>
      <input type="submit" value="Map类型批量测试提交" />
  </form>
  <%--演示Map类型的请求参数结束--%>
</body>
</html>