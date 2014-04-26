<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <pd:baseurl/>
    <title>考试练习</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8;"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="css/common/base.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<style type="text/css">
		td.title{text-align:right;}
	</style>
	<script type="text/javascript">
		$(function(){
			$("li").click(function(){
				var value = $(this).text();
				$("#qt"+value).css("display","block");
				$("#questionsContent div:not(#qt"+value+")").css("display","none");
			});
			$("li:first").trigger("click");
			$("input[id^=upQuestion]").click(function(){
				var value = $(this).parent().parent().parent().parent().parent().attr("id");
				value = value.substr(2,value.length);
				value = value - 1;
				if(value > 0){
					$("#qt"+value).css("display","block");
					$("#questionsContent div:not(#qt"+value+")").css("display","none");
				}else{
					alert("已经是第一题！");
				}
			});
			$("input[id^=downQuestion]").click(function(){
				var value = $(this).parent().parent().parent().parent().parent().attr("id");
				value = value.substr(2,value.length);
				value = value - 1 + 2;
				var maxCount = $("#questionsContent>div").length;
				if(value <= maxCount){
					$("#qt"+value).css("display","block");
					$("#questionsContent div:not(#qt"+value+")").css("display","none");
				}else{
					alert("已经是最后一题！");
				}
			});
			$("#submitButton").click(function(){
				var da = "";
				$("#questionsContent>div").each(function(){
					var bo = false;
					var $e = "#" + $(this).attr("id") + " input[type=checkbox]";
					$($e).each(function(){
						if($(this).is(":checked")){
							da += $(this).val() + ",";
							bo = true;
						}
					});
					if(bo){
						da = da.substr(0,da.length - 1);
						da += "/";
					}else{
						da += "null/";
					}
				});
				$.post("stu/stuExam_computeResult.action",{lxda:da},function(responsText){
					alert("得分："+responsText.result +"\n满分："+responsText.fullmark);
				},"json");
			});
			$("#idli,input[id*=Question]").click(function(){
				$("#questionsContent>div").each(function(){
					var bo = false;
					var $e = "#" + $(this).attr("id") + " input[type=checkbox]";
					$($e).each(function(){
						if($(this).is(":checked")){
							bo = true;
						}
					});
					var value = $(this).attr("id");
					value = value.substr(2,1);
					var $ele = $("#li" + value);
					if(bo){
						$ele.css("background-color","green");
					}else{
						$ele.css("background-color","coral");
					}
				});
			});
		});
	</script>
  </head>
  
  <body>
    <div style="width:980px;height:auto;padding-top:10px;">
    	<div style="float:left; width:75px; overflow:hidden;">
    		<div style="width:75px;"><hr style="margin-top:0px;"/></div>
    		<ul style="list-style:none;list-style-position:inherit;" id="idli">
    			<c:forEach begin="1" end="${sessionScope.lxtq.tqContentNum}" step="1" var="i">
    				<li id="li${i}" style="width:20px; height:20px; margin:0px 5px 5px 0px; float:left;cursor:pointer; background-color:coral;text-align:center;border-radius:5px;line-height:20px;">${i}</li>
    			</c:forEach>
    		</ul>
    		<div class="clear"></div>
    		<div style="width:75px;"><hr style="margin-top:0px;"/></div>
    		<div style="width:60px;">
    			<input type="button" id="submitButton" value="交卷" style="width:60px;border-radius:5px;background-color:coral;"/>
    		</div>
    	</div>
    	<div style="float:left; width:880px; margin-left:20px;" id="questionsContent">
    		<c:forEach items="${sessionScope.lxtq.questionsList}" var="qt" varStatus="i">
    		<div style="width:860px;display:none;" id="qt${i.index +1}">
    			<table cellspacing="2" cellpadding="0">
    				<tbody>
    					<tr>
    						<td style="width:60px;background-color:lightcyan;" class="title">题目：</td>
    						<td style="width:780px;">${qt.qtContent }</td>
    					</tr>
    					<tr>
    						<td style="background-color:lightcyan;" class="title">
    							<input type="checkbox" value="A"/>A
    						</td>
    						<td>${qt.qtOptionA }</td>
    					</tr>
    					<tr>
    						<td style="background-color:lightcyan;" class="title">
    							<input type="checkbox" value="B"/>B
    						</td>
    						<td>${qt.qtOptionB }</td>
    					</tr>
    					<tr>
    						<td style="background-color:lightcyan;" class="title">
    							<input type="checkbox" value="C"/>C
    						</td>
    						<td>${qt.qtOptionC }</td>
    					</tr>
    					<tr>
    						<td style="background-color:lightcyan;" class="title">
    							<input type="checkbox" value="D"/>D
    						</td>
    						<td>${qt.qtOptionD }</td>
    					</tr>
    					<tr>
    						<td colspan="2" align="center">
    							<input type="button" id="upQuestion${i.index+1}" value="上一题" style="width:70px; margin-right:5px;"/>
    							<input type="button" value="下一题" id="downQuestion${i.index+1}" style="width:70px;"/>
    						</td>
    					</tr>
    				</tbody>
    			</table>
    		</div>
    		</c:forEach>
    	</div>
    	<div class="clear"></div>
    </div>
  </body>
</html>
