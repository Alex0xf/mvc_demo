<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
    
    <title>游戏添加页，测试文件上传</title>
    
	<meta charset="utf-8">
    
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>


  </head>
  
  <body>
     <div class="container">
		<div class="row">
		  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		  	<!-- <form action="game_upload/upload_one" method="post" enctype="multipart/form-data"> -->
		  	<form action="game_upload/upload_many" method="post" enctype="multipart/form-data">
		  		<p>游戏名字：<input name="gamename" class=""></p>
		  		<p>游戏下载地址：<input name="gameurl" class=""></p>
		  		
		  		<p>游戏图标：<input name="gameIcon" type="file"></p>
		  		<p>游戏图标：<input name="gameIcon" type="file"></p>
		  		<p>游戏图标：<input name="gameIcon" type="file"></p>
		  		<p><input value="提交" type="submit"></p>
		  	</form>
		  </div>
		</div>
		<div class="row">
		  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		  	${savePath },${viewPath }
		  	<img alt="" src="${viewPath }">
		  </div>
		 </div>
	</div>
  </body>
</html>
