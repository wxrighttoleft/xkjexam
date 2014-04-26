<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <pd:baseurl/>
    <title>试题练习</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="css/common/base.css"/>
	<link rel="stylesheet" type="text/css" href="css/tabs/jquery.ui.all.css"/>
	<link rel="stylesheet" type="text/css" href="css/tabs/demos.css"/>
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
	<style type="text/css">
		td.title{text-align:right;}
	</style>
	<script type="text/javascript">
		$(function(){
			$("#subjectSelect").append("<option value='"+0+"'>所有</option>");
			$("#objectSelect").append("<option value='"+0+"'>所有</option>");
			$.post("stu/stuExam_getSubjectInfo.action",function(responseText,textState){
				for(var i = 0; i < responseText.length;i++){
					$("#subjectSelect").append("<option value='"+responseText[i].sjId+"'>"+responseText[i].sjName+"</option>");
				}
			},"json");
			$.post("stu/stuExam_getObjectsInfo.action",function(responseText,textState){
				for(var i = 0; i < responseText.length; i++){
					$("#objectSelect").append("<option value='"+responseText[i].OId+"'>"+responseText[i].OName+"</option>");
				}
			},"json");
			$("#dialog").dialog({
				autoOpen:false,
				show:"blind",
				hide:"explode"
			});
			$("#submitButton").button();
			$("#examSubmitForm").submit(function(){
				var count = $("#questionCount").val();
				var bo = true;
				if(count.length < 1){
					bo = false;
					$("#dialog>p").text("请输入数量");
				}else if(count <5){
					bo = false;
					$("#dialog>p").text("您输入的题量小于最小题量");
				}else if(count > 50){
					bo = false;
					$("#dialog>p").text("您输入的题量大于最大题量");
				}
				if(bo == false){
					$("#dialog").dialog("open");
					$("#dialog").dialog({
						resizable:false,
						modal:true,
						buttons:{
							确定:function(){
								$(this).dialog("close");
							}
						}
					});
				}
				return bo;
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
					$("#ExamLXDiv").removeClass();
					$("#ExamLXDiv").addClass("menuOpen");
				});
			</script>
		</div>
		<!-- 右侧内容层 -->
		<div style="width:800px; height:auto;" class="float_style" id="contentDiv">
			<div style="width:400px;height:auto;">
			<form action="stu/stuExam_getLXTestQuestions.action" method="post" id="examSubmitForm" target="_blank">
			<table cellspacing="2" cellpadding="0" style="width:400px;">
				<tr>
					<td style="width:80px;" class="title">科目：</td>
					<td>
						<select size="1" name="s.sjId" id="subjectSelect" style="border-radius:5px;padding:1px 4px;width:120px;"></select>
					</td>
				</tr>
				<tr>
					<td class="title">分类：</td>
					<td>
						<select size="1" name="o.OId" id="objectSelect" style="border-radius:5px;padding:1px 4px;width:120px;"></select>
					</td>
				</tr>
				<tr>
					<td class="title">题量：</td>
					<td>
						<input type="text" name="tq.tqContentNum" style="width:60px;border-radius:5px;border:1px solid;padding:1px 5px;" id="questionCount" /><label style="color:red">输入范围为5~50道</label>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input id="submitButton" type="submit" value="确定"/></td>
				</tr>
			</table>
			</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="dialog" title="系统提示">
		<p>dsf</p>
	</div>
  </body>
</html>
