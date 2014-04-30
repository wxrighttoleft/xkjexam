<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <tags:baseurl></tags:baseurl>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="漫友社,动漫">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/basic.css">
	<link rel="stylesheet" type="text/css" href="css/button.css"/>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#loginButton,#regButton").hover(function(){
				$(this).removeClass("login_button");
				$(this).addClass("login_button_hover");
			},function(){
				$(this).removeClass("login_button_hover");
				$(this).addClass("login_button");
			});
		});
	</script>
  </head>
  
  <body>
  	<!-- logo + login div -->
    <div>
    	<div><a href="#"><img src="images/anime_logo.png"/></a></div>
    	<div class="login">
    		<ul>
    			<li><label>账号：</label></li>
    			<li><input type="text" value="请输入邮箱账号或用户名"/></li>
    			<li><label>密码：</label></li>
    			<li><input type="password"/></li>
    			<li><input type="submit" value="登陆" class="login_button" id="loginButton"/></li>
    			<li><input type="button" value="注册" class="login_button" id="regButton"/></li>
    		</ul>
    		<div style="clear: both;"></div>
    	</div>
    </div>
  </body>
</html>
