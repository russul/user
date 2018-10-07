<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
   <p style="color:red;font-weight:800">
   		<c:choose>
   			<c:when test="${not empty info }">
   				<c:set var="userinfo" value="${fn:split(info, ':')}"></c:set>
   				<c:set var="username" value="${userinfo[0] }" scope="page"></c:set>
   				欢迎<c:out value="${username }"/>的光临
   				<c:remove var="info"/>
   			</c:when>
   			<c:otherwise>
   				<c:out value=""/>
   			</c:otherwise>
   		</c:choose>
   		
   </p> 
  </body>
</html>
