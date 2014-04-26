package com.zyexam.web.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.zyexam.common.Constant;
import com.zyexam.services.TeacherServer;

public class TeacherAction {
	private TeacherServer teaServer;
	private File upload;
	private String uploadFileName;

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public TeacherServer getTeaServer() {
		return teaServer;
	}

	public void setTeaServer(TeacherServer teaServer) {
		this.teaServer = teaServer;
	}
	public String addQuestionByFile() throws Exception{
		String id = ServletActionContext.getRequest().getSession().getAttribute(Constant.STU_ANTHOR).toString();
		String destPath = ServletActionContext.getServletContext().getRealPath("/temp/"+id);
		File ftemp = new File(destPath);
		if(!ftemp.exists()){
			ftemp.mkdir();
		}
		if(!"xls".equalsIgnoreCase(this.uploadFileName.substring(this.uploadFileName.lastIndexOf(".")+1))){
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().println("{\"dialogText\":\"不是2003 Excel文档！\"}");
			return null;
		}
		File dest = new File(destPath,this.uploadFileName);
		FileUtils.copyFile(upload, dest);
		this.teaServer.updateQuestions(dest);
		dest.delete();
		return null;
	}
}
