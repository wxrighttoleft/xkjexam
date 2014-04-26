package com.zyexam.web;

import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zyexam.services.WebSocketServer;

public class WebSocketServerStartServlet extends HttpServlet {

	private static final long serialVersionUID = 1664227716647437943L;
	@Override
	public void init() throws ServletException{
		String confurl = this.getServletContext().getRealPath("/config/zyexamconf.xml");
		SAXReader reader = new SAXReader();
		File f = new File(confurl);
		if(!f.exists()){
			System.out.println(confurl + "文件不存在");
			return;
		}
		Document doc = null;
		try {
			doc = reader.read(f);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element rootEle = doc.getRootElement();
		String port = rootEle.element("socketserver").attribute("prot").getValue();
		WebSocketServer socketServer = new WebSocketServer(Integer.parseInt(port));
		socketServer.run();
	}
}
