<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
  	<head>
    	<pd:base></pd:base>
    	<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
  		<link rel="stylesheet" href="./style/common/common.css" type="text/css"></link>
  		<link rel="stylesheet" href="./style/admin.css" type="text/css"/>
  		<link rel="shortcut icon" href="images/ico/logo.ico"/>
  		<script type="text/javascript" src="./js/menu.js"></script>
	</head>
  <body>
  	<div class="menu_top" onclick="menuUp(this)" id="employeeAdmin" style="cursor:pointer;">员工管理</div>
	<div class="menu_2" id="yuan1">
		<div class="menu_2_1"><a href="./servlet/emp/scan.pd?fPageButton=0" target="content">员工查询</a></div>
		<div class="menu_2_1"><a href="" target="content">添加员工</a></div>
		<div class="menu_2_1"><a href="" target="content">删除员工</a></div>
	</div>
	<div class="menu_top" id="infoAdmin" onclick="menuUp(this)">信息管理</div>
	<div class="menu_2" id="yuan2">
		<div class="menu_2_1"><a href="" target="content">员工查询</a></div>
		<div class="menu_2_1"><a href="" target="content">添加员工</a></div>
		<div class="menu_2_1"><a href="" target="content">删除员工</a></div>
	</div>
  </body>
</html>
