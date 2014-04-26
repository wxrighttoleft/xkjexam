<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <pd:baseurl/>
    <title>成绩查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="content-type" content="text/html; charset=UTF-8;"/>
	<link rel="stylesheet" type="text/css" href="css/common/base.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pageStyle/paging.css"/>
	<style type="text/css">
		td{border-right:1px solid;border-bottom:1px solid;height:20px;text-align:center; }
		th{border-right:1px solid;border-bottom:1px solid; width:100px;}
		table{border:1px solid;}
		td.bottom{border-bottom:none;}
		td.right,th.right{border-right:none;}
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			$("tbody tr").hover(function(){
				$(this).css("background-color","pink");
			},function(){
				$("tbody tr").css("background-color","transparent");
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
					$("#resultSelectDiv").removeClass();
					$("#resultSelectDiv").addClass("menuOpen");
				});
			</script>
		</div>
		<!-- 右侧内容层 -->
		<div style="width:800px; height:auto;" class="float_style" id="contentDiv">
			<table cellspacing="0" cellpadding="0">
				<thead>
					<th>试卷项目</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>题量</th>
					<th>总分</th>
					<th>成绩</th>
					<th class="right">操作</th>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.resultList}" var="result">
						<tr>
							<td>${result.testQuestions.tqName }</td>
							<td>${result.testQuestions.tqStartTime }</td>
							<td>${result.testQuestions.tqEndTime }</td>
							<td>${result.testQuestions.tqContentNum }</td>
							<td>${result.testQuestions.tqFullMark }</td>
							<td>${result.trResult }</td>
							<td><a href="stu/stuExam_getResultById.action?result.trId=${result.trId }" target="_blank">查看试卷</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="7">
							<div style="margin:2px 0px;">
								<pd:pageinfo pageurl="stu/stuExam_getResultList.action" currentPage="true" selectpagesize="true" selectpagenum="false" pageparmamname="pi" pageinfo="${requestScope.pageInfo}"></pd:pageinfo>
								<div style="clear:both;"></div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="clear"></div>
	</div>
  </body>
</html>
