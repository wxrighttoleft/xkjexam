<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
	<head>
		<pd:base/>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
		<link rel="stylesheet" href="./style/common/common.css" type="text/css"/>
		<link rel="stylesheet" href="./style/emp/admin.css" type="text/css"/>
		<link rel="shortcut icon" href="image/ico/logo.ico"/>
		<script type="text/javascript">
			function trOverColor(a){
				a.style.backgroundColor="blanchedalmond";
			}
			function trOutColor(a){
				a.style.backgroundColor="Transparent";
			}
		</script>
	</head>

	<body>
		<center>
			<div class="div-center" style="width:700px; min-width:700px;">
				<table cellpadding="1" cellspacing="0" class="table-style">
					<tr class="tr-background">
						<td class="td-width">账号</td>
						<td class="td-width">姓名</td>
						<td class="td-width">性别</td>
						<td class="td-width">出生日期</td>
						<td class="td-width">联系方式</td>
						<td class="td-width">地址</td>
						<td class="td-width">操作</td>
					</tr>
					<c:forEach items="${sessionScope.empList}" var="emp">
						<tr onmouseover="trOverColor(this)" onmouseout="trOutColor(this)">
							<td class="td-width">${emp.empLoginName}</td>
							<td class="td-width">${emp.empName }</td>
							<td class="td-width">${emp.empSex == 1 ? "男" : "女" }</td>
							<td class="td-width"><fmt:formatDate value="${emp.empBirthday}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
							<td class="td-width">${emp.empTel }</td>
							<td class="td-width">${emp.empAddress }</td>
							<td class="td-width"><img class="img_caozuo_size" src="images/ico/logo.ico" title="详情"/></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="7" style="text-align:center;height:25px;">
							第${sessionScope.pageInfo.currentPage}页/共${sessionScope.pageInfo.pageCount}页  
							<input type="button" value="上一页" onclick="javascript:location.href='./servlet/emp/scan.pd?fPageButton=-1'" style="width:100px;" />
							<input type="button" value="下一页" onclick="javascript:location.href='./servlet/emp/scan.pd?fPageButton=1'"style="width:100px;"/>
						</td>
					</tr>
				</table>
			</div>
		</center>
	</body>
</html>
