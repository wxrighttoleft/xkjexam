<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<pd:baseurl/>
<title>学生信息查看</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="content-type" content="text/html; charset=utf-8;"/>
<link rel="stylesheet" type="text/css" href="css/common/base.css" />
<link rel="stylesheet" href="css/tabs/jquery.ui.all.css"/>
<link rel="stylesheet" href="css/tabs/demos.css"/>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/tabs/jquery.ui.core.js"></script>
<script type="text/javascript" src="js/tabs/jquery.ui.widget.js"></script>
<script type="text/javascript" src="js/tabs/jquery.ui.tabs.js"></script>
<script type="text/javascript" src="js/date/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="js/ui/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="js/ui/jquery.ui.button.js"></script>
<script type="text/javascript" src="js/ui/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="js/ui/jquery.ui.position.js"></script>
<script type="text/javascript" src="js/ui/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="js/ui/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="js/ui/jquery.ui.effect.js"></script>
<script type="text/javascript" src="js/ui/jquery.ui.effect-blind.js"></script>
<script type="text/javascript" src="js/ui/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript">
	$(function() {
		$("input[type=submit],input[type=button],input[type=reset]").button();
		$("#tabs").tabs();
		$("#datepicker").datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,
			showOtherMonths: true,
			selectOtherMonths: true
		});
		$("#datepicker").datepicker("option", "zh-CN", "yy-mm-dd");
		$("#infoDialog,#resultDialog,#pwdDialog").dialog({
			autoOpen: false,
			show: "blind",
			hide: "explode"
		});
		//基本信息修改
		$("#baseInfoForm").submit(function(){
			$("#infoDialog").dialog("open");
			$("#infoDialog").dialog({
				modal:true,
				resizable:false,
				buttons:{
					确定:function(){
						$(this).dialog("close");
						$.post("stu/stuExam_updateInfo.action",$("#baseInfoForm").serialize(),function(responseText,textState){
							if(textState == "success"){
								if(responseText.updateState){
									$("#resultDialog>p").text("修改成功！");
									$("#resultDialog").dialog("open");
									$("#resultDialog").dialog({
										modal:true,
										resizable:false,
										buttons:{
											确定:function(){
												$(this).dialog("close");
											}
										}
									});
								}else{
									$("#resultDialog>p").text("修改失败！");
									$("#resultDialog").dialog("open");
									$("#resultDialog").dialog({
										modal:true,
										resizable:false,
										buttons:{
											确定:function(){
												location.reload();
												$(this).dialog("close");
											}
										}
									});
								}
							}else{
								$("#resultDialog>p").text(textState);
								$("#resultDialog").dialog("open");
								$("#resultDialog").dialog({
									modal:true,
									resizable:false,
									buttons:{
										确定:function(){
											$(this).dialog("close");
										}
									}
								});
							}
						},"json");
					},
					取消:function(){
						$(this).dialog("close");
					}
				}
			});
			return false;
		});
		//修改密码
		$("#passwordForm").submit(function(){
			$("#pwdDialog").dialog("open");
			$("#pwdDialog").dialog({
				modal:true,
				resizable:false,
				buttons:{
					确定:function(){
						$(this).dialog("close");
						$.post("stu/stuExam_updatePassword.action",$("#passwordForm").serialize(),function(responseText,textState){
							if(textState == "success"){
								if(responseText.updateState){
									$("#resultDialog>p").text("修改成功！");
								}else{
									$("#resultDialog>p").text("修改失败！");
								}
							}else{
								$("#resultDialog>p").text(textState);
							}
							$("#resultDialog").dialog("open");
							$("#resultDialog").dialog({
								modal:true,
								resizable:false,
								buttons:{
									确定:function(){
										$(this).dialog("close");
									}
								}
							});
						},"json");
					},
					取消:function(){
						$(this).dialog("close");
					}
				}
			});
			return false;
		});
	});
</script>
</head>

<body>
	<!-- 顶部用户基本信息层 -->
	<div style="width:980px;height:auto;">
		<!-- logo层 -->
		<div style="width:200px;height:30px" class="float_style"></div>

		<div class="clear"></div>
	</div>
	<!-- 内容板块 -->
	<div style="width:980px;">
		<!-- 左侧菜单层 -->
		<div style="width:150px; height:auto" class="float_style" id="menuDiv">
			<jsp:include page="./stuMenu.jsp" flush="true"></jsp:include>
			<script type="text/javascript">
			$(function(){
				$("#baseZLDiv").removeClass();
				$("#baseZLDiv").addClass("menuOpen");
			});
			</script>
		</div>
		<!-- 右侧内容层 -->
		<div style="width:800px; height:auto;" class="float_style" id="contentDiv">
			<div id="tabs">
				<ul>
					<li><a href="stu/stuExam_getLoginInfo.action#tabs-1">基本信息</a></li>
					<li><a href="stu/stuExam_getLoginInfo.action#tabs-2">修改密码</a></li>
				</ul>
				<div id="tabs-1">
					<!-- 基本信息 -->
					<div style="width:400px; height:auto;">
					<link rel="stylesheet" type="text/css" href="css/stu/baseInfo.css" />
					<form method="POST" id="baseInfoForm">
						<table cellpadding="2" cellspacing="5">
							<tbody>
								<tr>
									<td>姓名：</td>
									<td><input type="text" name="user.userName" value="${requestScope.loginInfo.userName }"/></td>
								</tr>
								<tr>
									<td>性别：</td>
									<td><input type="radio" name="user.userSex" value="1" ${requestScope.loginInfo.userSex == 1 ? "checked='checked'" : "" }/><span>男</span><input type="radio" name="user.userSex" value="0" ${requestScope.loginInfo.userSex == 0 ? "checked='checked'" : "" }/><span>女</span></td>
								</tr>
								<tr>
									<td>出生日期：</td>
									<td><input type="text" id="datepicker" value="${requestScope.loginInfo.userBirthday }" name="user.userBirthday"/></td>
								</tr>
								<tr>
									<td>联系电话：</td>
									<td><input type="text" name="user.userPhone" value="${requestScope.loginInfo.userPhone }"/></td>
								</tr>
								<tr>
									<td>QQ：</td>
									<td><input type="text" name="user.userQq" value="${requestScope.loginInfo.userQq }"/></td>
								</tr>
								<tr>
									<td>邮箱：</td>
									<td><input type="text" name="user.userEmail" value="${requestScope.loginInfo.userEmail }"/></td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<input type="submit" value="保存" id="saveBaseInfo" style="width:70px;"/>
										<input type="button" value="刷新" onclick="javascript:location.reload()" style="width:70px;"/>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
					<div id="infoDialog" title="温馨提示">
						<p>确认修改？</p>
					</div>
					</div>
				</div>
				<div id="tabs-2">
					<div style="width:400px; height:auto;">
					<form action="" method="POST" id="passwordForm">
						<table cellpadding="2" cellspacing="5">
							<tbody>
								<tr>
									<td>旧密码：</td>
									<td><input type="password" id="oldPwd" name="oldPwd"/></td>
								</tr>
								<tr>
									<td>新密码：</td>
									<td><input type="password" id="newPwd" name="user.userPassword"/></td>
								</tr>
								<tr>
									<td>确认密码：</td>
									<td><input type="password" id="confirmPwd"/></td>
								</tr>
								<tr>
									<td colspan="2" align="center"><input type="submit" value="修改" id="updatePwd" style="width:70px;"/></td>
								</tr>
							</tbody>
						</table>
					</form>
					</div>
					<div id="pwdDialog" title="系统提示">
						<p>确认修改密码？</p>
					</div>
				</div>
			</div>
		</div><!-- 右侧菜单层结束 -->
		<div id="resultDialog" title="系统提示">
			<p></p>
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>
