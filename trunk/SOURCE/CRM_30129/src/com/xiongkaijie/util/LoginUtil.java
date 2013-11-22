package com.xiongkaijie.util;

public class LoginUtil {
	public static StringBuffer LoginError(String msg, String urlPath){
		StringBuffer str = new StringBuffer();
		str.append("<html><head><meta http-equiv='content-type' content='text/html; charset=UTF-8'/>");
		str.append("<script type='text/javascript'>");
		if(msg == null || "".equals(msg)){
			str.append("alert('登陆错误，请重新登陆!');");
		}else{
			if(msg.contains("\n")){
				msg = msg.replaceAll("\n", ";");
			}
			str.append("alert('"+msg+"');");
		}
		if(urlPath != null && !"".equals(urlPath)){
			str.append("location.href='"+urlPath+"'");
		}else{
			str.append("location.href='./login.jsp';");
		}
		str.append("</script></head><body></body></html>");
		return str;
	}
}
