<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css" />
<script type="text/javascript">
$(function(){
	$("#menuDiv>div:first").css("border-top","1px solid #dedede");
	$("#menuDiv>div").hover(function(){
		$(this).css("background-color","lavender");
	},function(){
		$(this).css("background-color","transparent");
	});
	$("#baseZLDiv").click(function(){
		location.href="${pageContext.request.contextPath}/stu/stuExam_getLoginInfo.action";
	});
	$("#resultSelectDiv").click(function(){
		location.href="${pageContext.request.contextPath}/stu/stuExam_getResultList.action";
	});
	$("#ExamLXDiv").click(function(){
		location.href="${pageContext.request.contextPath}/pages/stu/testExerciseDialog.jsp";
	});
});
</script>
<div class="menuBase" id="baseZLDiv">
	<span>基本资料</span>
</div>
<div class="menuBase" id="resultSelectDiv">
	<span>成绩查询</span>
</div>
<div class="menuBase" id="ExamLXDiv">
	<span>考试练习</span>
</div>
<div class="menuBase" id="MYExamDiv">
	<span>模拟考试</span>
</div>