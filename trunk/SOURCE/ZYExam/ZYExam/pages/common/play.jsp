<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pd" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <pd:baseurl/>
    <title>视频播放</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8;">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="css/common/base.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/offlights.js"></script>
  </head>
  
  <body>
    <div id="video" style="position:relative;z-index: 100;width:600px;height:400px;float: left;"><div id="a1"></div></div>
	<script type="text/javascript" src="ckplayer/ckplayer.js" charset="utf-8"></script>
	<script type="text/javascript">
		var flashvars={
			f:'/ZYExam/video/1.flv',
			c:0,
			b:1,
			e:3
			};
		var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always'};
		CKobject.embedSWF('ckplayer/ckplayer.swf','a1','ckplayer_a1','600','400',flashvars,params);
	</script>
	<script type="text/javascript" src="js/swfobject.js"></script>
	<div id="MP3CuPlayer"></div>
	<script type="text/javascript">
		var so = new SWFObject("mp3CuteList/mp3CutePlayer.swf","player","120","110","9","#000000");
		so.addParam("allowfullscreen","true");
		so.addParam("allowscriptaccess","always");
		so.addParam("wmode","transparent");
		so.addParam("quality","high");
		so.addParam("scale","noscale");
		so.addParam("salign","lt");
		so.addVariable("xmlFile","stu/stuExam_getMusicConfigXML.action");//播放器配置文件可以是xml文件，也可以是程序文件asp,php,jsp,aspx
		so.write("MP3CuPlayer");
	</script>
  </body>
</html>
