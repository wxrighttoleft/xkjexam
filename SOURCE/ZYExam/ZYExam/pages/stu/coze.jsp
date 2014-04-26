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
if (!window.WebSocket) {  
    window.WebSocket = window.MozWebSocket;  
}  
// Javascript Websocket Client  
if (window.WebSocket) {  
    socket = new WebSocket("ws://192.168.1.102:8888/websocket");  
    socket.onmessage = function(event) {  
        $("#responseText").text($("#responseText").text() + "\n" +  event.data);
    };  
    socket.onopen = function(event) {  
    	$("#responseText").text("Web Socket opened!");  
    };  
    socket.onclose = function(event) {  
    	$("#responseText").text($("#responseText").text() + "\nWeb Socket closed");  
    };  
} else {  
    alert("Your browser does not support Web Socket.");
}  
// Send Websocket data  
function send(message) {  
	var name = $("input[name=message]").val();  
    alert("websocket send message:"+name); 
    socket.send(name);
}  
</script>  
<h3>Send :</h3>  
<form onsubmit="return false;">  
<input type="text" name="message" value="Hello World!"/><input type="button" value="Send Web Socket Data" onclick="send(this.form.message.value)" />  
<h3>Receive :</h3>  
<pre  id="responseText" style="width:500px;height:300px;"></pre>  
</form>  
</body>  
</html>  