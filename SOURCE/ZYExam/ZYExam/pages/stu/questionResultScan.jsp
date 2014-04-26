<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <pd:baseurl/>
    <title>查看试卷结果</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="css/common/base.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<style type="text/css">
		html,table,td,th{font-size:18px;}
		table{border:1px solid;}
		td{border-right:1px solid; border-bottom:1px solid;}
		td.title{background-color:azure;text-align:right;}
	</style>
  </head>
  <body>
  	<!-- 顶部用户基本信息层 -->
	<div style="width:980px;height:auto;">
		<!-- logo层 -->
		<div style="width:200px;height:30px" class="float_style"></div>
		<div class="clear"></div>
	</div>
	<!-- 个人考试试卷信息 -->
	<div style="width:980px;height:auto;">
		<table cellspacing="0" cellpadding="0" style="width:978px;">
			<tbody>
				<tr>
					<td class="title">试卷名：</td>
					<td class="titleContent">${requestScope.result.testQuestions.tqName }</td>
					<td class="title">题量：</td>
					<td class="titleContent">${requestScope.result.testQuestions.tqContentNum }</td>
				</tr>
				<tr>
					<td class="title bottom">满分：</td>
					<td class="titleContent bottom">${requestScope.result.testQuestions.tqFullMark }</td>
					<td class="title bottom">得分：</td>
					<td class="titleContent bottom">${requestScope.result.trResult }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- 试卷内容 -->
	<div style="width:980px;height:auto;">
	<c:forEach items="${requestScope.result.testQuestions.questionsList}" var="questions" varStatus="i">
		<!-- 试题 -->
		<div style="width:980px;height:auto;margin-top:10px;">
			<div style="width:100px;margin-left:0px;background-color:lawngreen;">第【${i.index + 1}】题</div>
		</div>
		<div style="width:980px;height:auto;">
			<div style="width:980px;height:auto;">
				<table cellspacing="0" cellpadding="0" style="width:978px;">
					<tr>
						<td style="width:60px;" class="title">题号：</td>
						<td>${questions.qtId}</td>
						<td style="width:80px;" class="title">科目：</td>
						<td>${questions.qtSubject.sjName }</td>
						<td style="width:120px;" class="title">考察对象:</td>
						<td>${questions.qtObject.OName }</td>
					</tr>
					<tr>
						<td class="title">题目：</td>
						<td colspan="5">${questions.qtContent }</td>
					</tr>
					<tr>
						<td class="title">A:</td>
						<td colspan="5">${questions.qtOptionA }</td>
					</tr>
					<tr>
						<td class="title">B:</td>
						<td colspan="5">${questions.qtOptionB }</td>
					</tr>
					<tr>
						<td class="title">C:</td>
						<td colspan="5">${questions.qtOptionC }</td>
					</tr>
					<tr>
						<td class="title">D:</td>
						<td colspan="5">${questions.qtOptionD }</td>
					</tr>
					<tr>
						<td colspan="2" class="title">选择答案：</td>
						<td colspan="2">${requestScope.resultAn[i.index] }</td>
						<td class="title">正确答案：</td>
						<td>${questions.qtResult }</td>
					</tr>
				</table>
			</div>
		</div>
	</c:forEach>
	</div>
  </body>
</html>
