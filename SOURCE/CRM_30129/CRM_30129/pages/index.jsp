<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
<pd:base />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>【欢迎进入】</title>
<link rel="stylesheet" href="style/common/common.css" type="text/css" />
<link rel="stylesheet" href="style/welcome/index.css" type="text/css" />
<link rel="shortcut icon" href="images/ico/logo.ico" type="image/X-icon" />
</head>
<body>
	<div class="div-center">
		<div class="top">
			<div class="top_logo" style="float:left;"></div>
			<div style="float:right;"><label>${sessionScope.author }</label>&nbsp;【<a href="empExit.pd" style="color:red;">退出</a>】</div>
			<div class="float-clear"></div>
		</div>
		<div style="width:1000px; height:auto; padding:12px 0px;">
			<div style="width:182px;height:auto; border-right:1px solid red; float:left;">
				<iframe style="width:182px; height:500px;" frameborder="0" src="pages/common/menu.jsp" scrolling="auto"></iframe>
			</div>
			<div style="width:817px; height:auto; float:right;">
				<iframe style="width:817px; height:500px;" frameborder="0" src="pages/common/welcome.jsp" name="content" scrolling="auto"></iframe>
			</div>
			<div class="float-clear"></div>
		</div>
	</div>
</body>
</html>
