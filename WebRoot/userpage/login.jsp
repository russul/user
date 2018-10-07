<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <h1>登录</h1>
   <%--处理注册返回的信息 --%>
   <p style="color:red; font-weight:800">
	<c:choose>
		<c:when test="${not empty success}">
			<%--显示注册成功信息，注册成功重定向到此页面 --%>
			<c:out value="${success}"/>
			<%--如果是直接访问此页面，删除session里存储的注册成功信息，显示空字符 --%>
			<c:remove var="success" scope="session"/>
		</c:when>
		<c:otherwise><c:out value=""/></c:otherwise>
		
	</c:choose>
   </p>
   
   <%--处理登录返回的信息 --%>
   
   
   <p style="color:green; font-weight:800">

			<c:out value="${msg}"/>
	
   </p>
   <form action="${basePath}LoginServlet" method="post">
   		用户名：<input type="text" name="username"/><br/>
   		密    码：<input type="password" name="password"/><br/>
   			<input type="submit"  name="userinfo" value="登录"><br/>
   			
   </form>
  </body>
</html>
