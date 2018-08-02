<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
    
    <title>'500.jsp'</title>
    
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
  </head>
  
  <body>
    <div class="container">
		<div class="row">
		  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		     <h1>页面异常:${myErroMessage}</h1> 
		     <h1>全局异常:${allErroMessage}</h1>
		  </div>
		</div>
	</div>
  </body>
</html>
