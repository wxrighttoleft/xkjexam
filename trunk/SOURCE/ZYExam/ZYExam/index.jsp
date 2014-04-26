<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <pd:baseurl/>
    <title>学员登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="css/common/base.css">
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<link rel="stylesheet" type="text/css" href="css/tabs/jquery.ui.all.css"/>
	<link rel="stylesheet" type="text/css" href="css/tabs/demos.css"/>
	<link rel="shortcut icon" type="image/X-icon" href="images/logo.ico"/>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/tabs/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/tabs/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="js/ui/jquery.ui.mouse.js"></script>
	<script type="text/javascript" src="js/ui/jquery.ui.button.js"></script>
	<script type="text/javascript" src="js/ui/jquery.ui.draggable.js"></script>
	<script type="text/javascript" src="js/ui/jquery.ui.position.js"></script>
	<script type="text/javascript" src="js/ui/jquery.ui.resizable.js"></script>
	<script type="text/javascript" src="js/ui/jquery.ui.dialog.js"></script>
	<script type="text/javascript" src="js/ui/jquery.ui.effect.js"></script>
	<script type="text/javascript" src="js/ui/jquery.ui.effect-blind.js"></script>
	<script type="text/javascript" src="js/ui/jquery.ui.effect-explode.js"></script>
	<script type="text/javascript">
		$(function(){
			$("input[type=submit]").button();
			$("#dialog").dialog({
				autoOpen: false,
				show: "blind",
				hide: "explode"
			});
			$("form").submit(function(){
				$.post("stu/stuExam_login.action",$("form").serialize(),function(responseText,textState){
					if(textState == "success"){
						if(responseText.loginState){
							location.href="stu/stuExam_getLoginInfo.action";
						}else{
							$("#dialog>p").text(responseText.errMsg);
							$("#dialog").dialog("open");
							$("#dialog").dialog({
								resizeable:false,
								modal:true,
								buttons:{
									确定:function(){
										$("#dialog").dialog("close");
									}
								}
							});
						}
					}else{
						$("#dialog>p").text("登陆失败");
						$("#dialog").dialog("open");
						$("#dialog").dialog({
							modal:true,
							resizable:false,
							buttons:{
								确定 :function(){
									$("#dialog").dialog("close");
								}
							}
						});
					}
				},"json");
				return false;
			});
			
		});
	</script>
  </head>
  
  <body>
    <div class="bg" style="margin-top:150px;">
    <form action="" method="POST">
    	<table cellpadding="0" cellspacing="2">
    		<tr>
    			<td colspan="2" align="left" style="border-bottom:1px solid lavender;">学员登陆</td>
    		</tr>
    		<tr>
    			<td style="width:60px;">用户名：</td>
    			<td align="left"><input type="text" name="user.userId" class="text"/></td>
    		</tr>
    		<tr>
    			<td>密　码：</td>
    			<td align="left"><input type="password" name="user.userPassword" class="text"/></td>
   			</tr>
   			<tr>
   				<td>验证码：</td>
   				<td><input type="text" class="text" style="width:60px; margin-right:10px;" name="anthCodeString"/><img align="middle" src="stu/stuExam_getAnthCode.action" id="anthCodeImg"/></td>
   			</tr>
   			<tr>
   				<td colspan="2" align="center" style="border-top:1px solid lavender;padding-top:2px;">
   					<input type="submit" value="登陆" style="width:100px;"/>
   				</td>
   			</tr>
    	</table>
    </form>
    </div>
    <div id="dialog" title="系统提示">
    	<p></p>
    </div>
  </body>
</html>
