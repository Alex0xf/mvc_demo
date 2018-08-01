<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
    <title>'hello.jsp'</title>
	<meta charset="utf-8">

  </head>
  
  <body>
    <div class="container">
		<div class="row">
		  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"></div>
		  <h1>${hello}</h1>
		</div>
	</div>
  </body>
</html>
