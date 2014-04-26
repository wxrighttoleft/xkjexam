<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd"%>
<!DOCTYPE HTML>
<html>
<head>
	<pd:baseurl/>
	<title>Web Socket Client</title>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</head>  
<body>  
<script type="text/javascript">  
var socket;  
var loginState = false;
window.WebSocket = window.MozWebSocket || window.WebSocket;
// Javascript Websocket Client  
if (window.WebSocket) {  
    socket = new WebSocket("ws://192.168.1.102:8888/websocket");  
    socket.onmessage = function(event) {  
    	var msg = JSON.parse(event.data);
        $("#responseText").append("<label style='color:blue;'>"+msg.id+"</label><p></p>");
        $("#responseText>p:empty").text(msg.message);
        loginState = msg.ls;
    };  
    socket.onopen = function(event) {  
    	$("#responseText").append("<label style='color:green'>Web Socket opened!</label>");  
    };  
    socket.onclose = function(event) {  
    	$("#responseText").append("<label style='color:red;'>Web Socket closed</label>");  
    };  
} else {  
    alert("Your browser does not support Web Socket.");
}  
// Send Websocket data  
function send(message) {  
	var name = $("input[name=message]").val();  
    var msg = {
    		id:$("#stuId").val(),
    		message:name,
    		target:"student",
    		ls:loginState
    };
    socket.send(JSON.stringify(msg));
}  
</script>  
<h3>Send :</h3>  
<form onsubmit="return false;">
<input type="hidden" id="stuId" value="${sessionScope.stuAnthor}"/>  
<input type="text" name="message" value="Hello World!"/><input type="button" value="Send Web Socket Data" onclick="send(this.form.message.value)" />  
<h3>Receive :</h3>  
<div id="responseText" style="width:500px;height:300px;overflow-y:scroll;border:1px solid #dedede; "></div>  
</form>  
</body>  
</html>  