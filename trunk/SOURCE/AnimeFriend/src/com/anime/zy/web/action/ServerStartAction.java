package com.anime.zy.web.action;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zy.util.AnthCodeImage;

public class ServerStartAction extends ActionSupport {
	private static final long serialVersionUID = -8674670243539455982L;
	private AnthCodeImage anthCode;
	public AnthCodeImage getAnthCode() {
		return anthCode;
	}
	public void setAnthCode(AnthCodeImage anthCode) {
		this.anthCode = anthCode;
	}
	
	public String getAnthCodeImage() throws Exception{
		String ac = this.anthCode.generateNumStr(4);
		BufferedImage img = this.anthCode.generateImage(60, 25, ac);
		ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		ImageIO.write(img, "jpg", ServletActionContext.getResponse().getOutputStream());
		return null;
	}

}
