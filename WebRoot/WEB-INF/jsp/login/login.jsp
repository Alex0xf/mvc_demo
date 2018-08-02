<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
    
    <title>'login.jsp'</title>
    
	<meta charset="utf-8">
    
	<!--
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	-->

  </head>
  
  <body>
    <div class="container">
		<div class="row">
		  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		  	登录页面
		  	<br>
		  	<form action="login/doLogin" method="post">
		  		<p>用户名<input name="username"/></p>
		  		<p>密码<input name="password" type="password"/></p>
		  		<p><input type="submit" value="登录"/></p>
		  	</form>
		  </div>
		</div>
	</div>
  </body>
</html>
