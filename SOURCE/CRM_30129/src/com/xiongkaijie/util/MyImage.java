package com.xiongkaijie.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpSession;

public class MyImage {
	public static BufferedImage getImage(HttpSession session){
		BufferedImage img = new BufferedImage(60, 25, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 60, 25);
		//绘制验证码背景
		for(int i = 0; i<60;i+=3) {
			for(int j = 0; j < 25; j+=3) {
				g.setColor(getColor(150));
				g.drawLine(i, j, i, j);
			}
		}
		String str = "";
		char c = 'a';
		//生成验证码
		for(int i = 0; i <4; i++) {
			Random rand = new Random();
			int num = rand.nextInt(126);
			if(num<48){
				i--;
				continue;
			}
			if(num>57 && num<65){
				i--;
				continue;
			}
			if(num>90 && num <97){
				i--;
				continue;
			}
			if(num>122){
				i--;
				continue;
			}
			c = (char)num;
			str += String.valueOf(c);
			String s = String.valueOf(c);
			g.setFont(new Font("幼圆", Font.BOLD, 18));
			g.setColor(getFontColor(70));
			g.drawString(s, i*13+6, 16);
		}
		//绘制干扰线
		for(int i=0; i<5; i++) {
			Random rand = new Random();
			//生成干扰线的两点
			int x1 = rand.nextInt(60);
			int y1 = rand.nextInt(25);
			int x2 = rand.nextInt(60);
			int y2 = rand.nextInt(25);
			g.setColor(getColor(70));
			g.drawLine(x1, y1, x2, y2);
		}
		session.setAttribute(Constant.SESSION_YAN, str);
		g.dispose();
		return img;
	}
	
	public static Color getColor(int num){
		Random rand = new Random();
		int r = rand.nextInt(num) + 255 - num;
		int g = rand.nextInt(num) + 255 - num;
		int b = rand.nextInt(num) + 255 - num;
		return new Color(r,g,b);
	}
	public static Color getFontColor(int num) {
		Random rand = new Random();
		int r = rand.nextInt(num);
		int g = rand.nextInt(num);
		int b = rand.nextInt(num);
		return new Color(r,g,b);
	}

}
