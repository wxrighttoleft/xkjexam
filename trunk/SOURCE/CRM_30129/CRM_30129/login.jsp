<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
  <head>
  	<pd:base/>
  	<title>【登陆】</title>
  	<link rel="stylesheet" href="style/common/common.css" type="text/css" />
  	<link rel="shortcut icon" href="images/ico/logo.ico" type="image/X-icon"/>
  	<script type="text/javascript" src="js/login.js"></script>
  </head>
  
  <body>
  <center>
    <div class="div-center">
    	<form action="logon.pd" method="post" onsubmit="return LoginYan()">
	    	<div style="width:270px;border:1px solid #d96b7e; margin:100px auto;">
	    		<table cellspacing="5" cellpadding="0">
	    			<tr>
	    				<td colspan="2" style="border-bottom:1px solid #d96b7e">用户登陆<label id="lbl"></label></td>
	    			</tr>
	    			<tr>
	    				<td align="right">帐　号：</td>
	    				<td align="left"><input type="text" id="account" name="account" class="input-width"/></td>
	    			</tr>
	    			<tr>
	    				<td align="right">密　码：</td>
	    				<td align="left"><input type="password" id="accountPwd" name="accountPwd" class="input-width"/></td>
	    			</tr>
	    			<tr>
	    				<td align="right"style="width:150px;">验证码：</td>
	    				<td><input type="text" id="yzmText" name="yzmText" onchange="YZMYan(this.value)" onblur="YZMYan(this.value)" style="widht:40px;"/><img src="yzm.pd" id="yzImg"  onclick="this.src='yzm.pd?aa='+Math.random()" title="点击更换图片"/></td>
	    			</tr>
	    			<tr>
	    				<td colspan="2" align="center" style="border-top:1px solid #d96b7e; padding-top:5px;">
	    					<input type="submit" value="login" class="button-width"/>
	    					<input type="reset" value="reset" class="button-width"/>
	    					<input type="button" value="regist" class="button-width" onclick="javascript:location.href='./regist.jsp'">
	    				</td>
	    			</tr>
	    		</table>
	    	</div>
    	</form>
    	<div>${applicationScope.webCount}</div>
    	<div>ip地址:${sessionScope.ipAddress}</div>
    	<div>请求信息:${sessionScope.requestInfo}</div>
    </div>
    </center>
  </body>
</html>
