<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
<pd:base/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/common/common.css" type="text/css"/>
<link rel="shortcut icon" href="images/ico/logo.ico" type="image/X-icon"/>
<title>用户注册</title>
</head>
<body>
	<div class="div-center" style="margin-top:100px;">
	<form method="post" action="RegistServlet.pd">
		<table style="width:1024px;border:1px solid #d96b7e" cellspacing="5" cellpadding="0">
			<tr>
				<td style="border-bottom:1px solid #d96b7e" colspan="3"><label>用户注册</label></td>
			</tr>
			<tr>
				<td style="width:80px; text-align:right;">用户名：</td>
				<td style="width:300px;"><input type="text" class="input-width" name="account" id="account"/></td>
				<td><label id="lblAccount" style="color:red;">*请输入用户名，必填项</label></td>
			</tr>
			<tr>
				<td style="text-align:right;">密码：</td>
				<td><input type="password" class="input-width" name="accountPwd" id="pwdFirst" /></td>
				<td><label id="lblPwdFirst" style="color:red;">*请输入密码，密码由字母和数字组成,必填项</label></td>
			</tr>
			<tr>
				<td style="text-align:right;">确认密码：</td>
				<td><input type="password" class="input-width" id="pwdSecond"/></td>
				<td><label id="lblPwdSecond" style="color:red;">*重复输入密码，两次输入密码保持一致，必填项</label></td>
			</tr>
			<tr>
				<td style="text-align:right;">姓名：</td>
				<td><input type="text" class="input-width" name="accountName" id="accountName"/></td>
				<td><label id="lblAccountName" style="color:red;">*请输入姓名，必填项</label></td>
			</tr>
			<tr>
				<td style="text-align:right;">性别：</td>
				<td>
					<select size="1" name="sex" style="width:116px;">
						<option value="1">男</option>
						<option value="0">女</option>
					</select>
				</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td style="text-align:right;">出生日期：</td>
				<td><input style="width:40px;" type="text" value="1970" name="birthdayYear"/>年<input type="text" name="birthdayMonth" style="width:20px;" value="1"/>月<input type="text" name="birthdayDay" style="width:20px;" value="1" />日</td>
				<td><label id="lblBirthday" style="color:red;">*必填项</label></td>
			</tr>
			<tr>
				<td style="text-align:right;">居住地：</td>
				<td><input type="text" name="Address" class="input-width"/></td>
				<td><label>*可填项</label></td>
			</tr>
			<tr>
				<td style="text-align:right;">联系电话：</td>
				<td><input type="text" name="Tel" class="input-width"/></td>
				<td><label>*可填项</label></td>
			</tr>
			<tr>
				<td style="text-align:right;">固定电话：</td>
				<td><input type="text" name="Mobel" class="input-width"/></td>
				<td><label>*可填项</label></td>
			</tr>
			<tr>
				<td style="text-align:right;">QQ：</td>
				<td><input type="text" name="QQ" class="input-width"/></td>
				<td><label>*可填项</label></td>
			</tr>
			<tr>
				<td colspan="3" style="text-align:center; border-top:1px solid #d96b7e; padding-top:5px;">
					<input type="submit" value="submit" class="button-width"/>
					<input type="reset" value="reset" class="button-width"/>
					<input type="button" value="login" class="button-width" onclick="javascript:location.href='./login.jsp'"/>
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>