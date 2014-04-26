<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <pd:baseurl/>
    
    <title>出错啦</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="css/common/base.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		var num = 5;
		(function(){
			$.backi = function(){
				$("label").text(num);
				if(num <= 0){
					location.href = "${pageContext.request.contextPath}/index.jsp";
				}
				num--;
				setTimeout($.backi,1000);
			}
		})();
		$(function(){
			if(self != top){
				top.location = self.location
			}
			$.backi();
		});
	</script>
  </head>
  
  <body>
    	出错啦！<br/>
    	<label></label>秒后返回<a href="index.jsp">登录</a>页面。
  </body>
</html>
