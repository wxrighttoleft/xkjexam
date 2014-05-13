<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <tags:baseurl></tags:baseurl>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="漫友社,动漫"/>
	<meta http-equiv="description" content="This is my page"/>
	<link rel="stylesheet" type="text/css" href="css/basic.css"/>
	<link rel="stylesheet" type="text/css" href="css/button.css"/>
	<link rel="stylesheet" type="text/css" href="css/logo.css"/>
	<link rel="stylesheet" type="text/css" href="css/menu.css"/>
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
			$("#anthorText").focus(function(){
				if($(this).val() == this.defaultValue){
					$(this).val("");
					$(this).css("color","black");
				}
			}).blur(function(){
				if($(this).val() == ""){
					$(this).val(this.defaultValue);
					$(this).css("color","#dedede");
				}
			});
			$("#pwdText").focus(function(){
				$("#pwdTitle").css("display","none");
			}).blur(function(){
				if($(this).val() == ""){
					$("#pwdTitle").css("display","block");
				}
			});
			$("#pwdTitle").click(function(){
				$("#pwdText")[0].focus();
			});
			$("#acimg").click(function(){
				$(this).attr("src","server_getAnthCodeImage.action?aaa=" + Math.random());
			});
		});
		$(window).resize(function(){
			var y = $("#pwdText").position().top;
			var x = $("#pwdText").position().left;
			$("#pwdTitle").css("top",y-1).css("left",x+5);
		});
		$(window).load(function(){
			var y = $("#pwdText").position().top;
			var x = $("#pwdText").position().left;
			$("#pwdTitle").css("top",y-6).css("left",x+1);
		});
	</script>
  </head>
  
  <body>
  	<!-- logo + login div -->
    <div style="line-height:60px;" class="base toptitle">
    	<div class="logo"><a href="#"><img src="images/anime_logo.png"/></a></div>
    	<div class="login" id="loginDiv">
    		<ul>
    			<li><label>账号：</label></li>
    			<li><input type="text" value="请输入邮箱账号或用户名" style="color:#dedede;" id="anthorText" name=""/></li>
    			<li><label>密码：</label></li>
    			<li><input type="password" id="pwdText" name=""/><label id="pwdTitle" class="login_label">请输入密码</label></li>
    			<li><label>验证码：</label></li>
    			<li><input type="text" class="login_anth_text"/></li>
    			<li><img src="server_getAnthCodeImage.action" id="acimg" style="cursor:pointer;" title="点击换一张"/></li>
    			<li><input type="submit" value="登陆" class="login_button" id="loginButton"/></li>
    			<li><input type="button" value="注册" class="login_button" id="regButton"/></li>
    		</ul>
    		<div style="clear: both;"></div>
    	</div>
    	<div style="clear:both;"></div>
    </div>
    <!-- 导航菜单 -->
    <div class="base menuroot">
   		<ul>
   			<li><a href="#">动画首页</a></li>
   			<li><a href="#">动漫周边</a></li>
   			<li><a href="#">动漫情报</a></li>
   			<li><a href="#">动漫图展</a></li>
   		</ul>
    </div>
    <!-- 领头动漫层 -->
    <div class="base">
    	<!-- 最热动漫 -->
    	<div>
    		<ul>
    			<li>最热动画</li>
    			<li>
    				<img src="" width="90px" height="68px"  align="middle"/>
    				<div></div>
    			</li>
    			<li>
    				<img src="" width="90px" height="68px" align="middle"/>
    				<div></div>
    			</li>
    			<li>
    				<img src="" width="90px" height="68px" align="middle"/>
    				<div></div>
    			</li>
    		</ul>
    	</div>
    	<!-- 精彩推荐 -->
    	<div></div>
    	<!-- 动漫更新表 -->
    	<div></div>
    </div>
  </body>
</html>