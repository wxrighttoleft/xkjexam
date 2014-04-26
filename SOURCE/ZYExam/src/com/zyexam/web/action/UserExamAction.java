package com.zyexam.web.action;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.imageio.ImageIO;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.dom4j.io.XMLWriter;

import com.opensymphony.xwork2.ActionSupport;
import com.zy.aespwd.AESUtil;
import com.zy.util.AnthCodeImage;
import com.zyexam.common.Constant;
import com.zyexam.entity.Objects;
import com.zyexam.entity.Subjects;
import com.zyexam.entity.SysUsers;
import com.zyexam.entity.TestQuestions;
import com.zyexam.entity.TestResult;
import com.zyexam.services.ExamUserServer;
import com.zyexam.util.PageInfo;

/**
 * @author Administrator
 *
 */
public class UserExamAction extends ActionSupport {

	private static final long serialVersionUID = -1879760011308625022L;
	private SysUsers user;
	private ExamUserServer eus;
	private AnthCodeImage anthCodeImg;
	private AESUtil aesUtil;
	private String anthCodeString;
	private String oldPwd;
	private PageInfo pi;
	private TestResult result;
	private TestQuestions tq;
	private Objects o;
	private Subjects s;
	private String message;
	private String lxda;
	
	public String getLxda() {
		return lxda;
	}

	public void setLxda(String lxda) {
		this.lxda = lxda;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TestQuestions getTq() {
		return tq;
	}

	public void setTq(TestQuestions tq) {
		this.tq = tq;
	}

	public Objects getO() {
		return o;
	}

	public void setO(Objects o) {
		this.o = o;
	}

	public Subjects getS() {
		return s;
	}

	public void setS(Subjects s) {
		this.s = s;
	}

	public TestResult getResult() {
		return result;
	}

	public void setResult(TestResult result) {
		this.result = result;
	}

	public PageInfo getPi() {
		return pi;
	}

	public void setPi(PageInfo pi) {
		this.pi = pi;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public AESUtil getAesUtil() {
		return aesUtil;
	}

	public void setAesUtil(AESUtil aesUtil) {
		this.aesUtil = aesUtil;
	}

	public String getAnthCodeString() {
		return anthCodeString;
	}

	public void setAnthCodeString(String anthCodeString) {
		this.anthCodeString = anthCodeString;
	}

	public AnthCodeImage getAnthCodeImg() {
		return anthCodeImg;
	}

	public void setAnthCodeImg(AnthCodeImage anthCodeImg) {
		this.anthCodeImg = anthCodeImg;
	}

	public SysUsers getUser() {
		return user;
	}

	public void setUser(SysUsers user) {
		this.user = user;
	}

	public ExamUserServer getEus() {
		return eus;
	}

	public void setEus(ExamUserServer eus) {
		this.eus = eus;
	}

	/**
	 * 登陆
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		this.user.setUserPassword(this.aesUtil.parseByte2HexStr(this.aesUtil.encrypt(this.user.getUserPassword(), AESUtil.publicPassword)));
		SysUsers su = this.eus.selectSysUsersById(this.user.getUserId());
		StringBuffer sb = new StringBuffer();
		sb.append("{\"loginState\":");
		if(su == null){
			sb.append(false);
			sb.append(",\"errMsg\":\"用户名不存在\"");
		}else if(!this.user.getUserPassword().equals(su.getUserPassword())){
			sb.append(false);
			sb.append(",\"errMsg\":\"密码不正确\"");
		}else if(!this.anthCodeYan(this.anthCodeString)){
			sb.append(false);
			sb.append(",\"errMsg\":\"验证码输入错误\"");
		}else{
			sb.append(true);
			ServletActionContext.getRequest().getSession().setAttribute(Constant.STU_ANTHOR, su.getUserId());
			ServletActionContext.getRequest().getSession().removeAttribute(Constant.ANTHCODE);
		}
		sb.append("}");
		su.setUserState(0);
		su.setUserIpAddress(this.getIPAddress());
		this.eus.updateBaseInfo(su);
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().getWriter().println(sb.toString());
		return null;
	}
	private String getIPAddress(){
		String ipAddress = ServletActionContext.getRequest().getHeader("x-forwarded-for");
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
			ipAddress = ServletActionContext.getRequest().getHeader("Proxy-Client-IP");
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
			ipAddress = ServletActionContext.getRequest().getHeader("WL-Proxy-Client-IP");
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
			ipAddress = ServletActionContext.getRequest().getRemoteAddr();
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
			ipAddress = ServletActionContext.getRequest().getHeader("http-client-ip");
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
			ipAddress = ServletActionContext.getRequest().getHeader("HTTP-X-FORWARDED-FOR");
		if(ipAddress != null && ipAddress.indexOf(",") != -1){
			ipAddress = ipAddress.substring(ipAddress.indexOf(",") + 1 ,ipAddress.length()).trim();
		}
		return ipAddress;
	}
	/**
	 * 获得验证码图片
	 * @return
	 * @throws Exception
	 */
	public String getAnthCode() throws Exception{
		String anthCodeString = this.anthCodeImg.generateNumStr(4);
		BufferedImage img = this.anthCodeImg.generateImage(80, 30, anthCodeString);
		ServletActionContext.getRequest().getSession().setAttribute(Constant.ANTHCODE, anthCodeString);
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ImageIO.write(img, "jpg", ServletActionContext.getResponse().getOutputStream());
		return null;
	}
	/**
	 * 验证验证码的正确性
	 * @param anthCodeString
	 * @return
	 */
	private boolean anthCodeYan(String anthCodeString){
		String sessionAnthCode = ServletActionContext.getRequest().getSession().getAttribute(Constant.ANTHCODE).toString();
		if(anthCodeString.equalsIgnoreCase(sessionAnthCode)){
			return true;
		}
		return false;
	}
	public String anthCodeCheck() throws Exception{
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		String content = "";
		if(this.anthCodeYan(this.anthCodeString)){
			content = "{\"anthCodeCheck\":true}";
		}else{
			content = "{\"anthCodeCheck\":false}";
		}
		ServletActionContext.getResponse().getWriter().println(content);
		return null;
	}
	//信息修改
	/**
	 * 信息修改
	 * @return
	 * @throws Exception
	 */
	public String updateInfo() throws Exception{
		int id = Integer.valueOf(ServletActionContext.getRequest().getSession().getAttribute(Constant.STU_ANTHOR).toString());
		this.user.setUserId(id);
		boolean bo = false;
		try{
		bo = this.eus.updateBaseInfo(this.user);
		}catch (Exception e) {
		}
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().getWriter().println("{\"updateState\":"+bo+"}");
		return null;
	}
	
	/**
	 * 密码修改
	 * @return 
	 * @throws Exception
	 */
	public String updatePassword() throws Exception{
		int id = Integer.parseInt(ServletActionContext.getRequest().getSession().getAttribute(Constant.STU_ANTHOR).toString());
		boolean bo = false;
		try{
			bo = this.eus.updateUserPassword(id, oldPwd, this.user.getUserPassword());
		}catch(Exception e){}
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().getWriter().println("{\"updateState\":"+bo+"}");
		return null;
	}
	/**
	 * 获取登录者的信息
	 * @return
	 * @throws Exception
	 */
	public String getLoginInfo() throws Exception{
		int id = Integer.parseInt(ServletActionContext.getRequest().getSession().getAttribute(Constant.STU_ANTHOR).toString());
		SysUsers su = this.eus.selectSysUsersById(id);
		ServletActionContext.getRequest().setAttribute("loginInfo", su);
		return "baseInfoPage";
	}
	/**
	 * 获取考试结果集
	 * @return 
	 * @throws Exception
	 */
	public String getResultList() throws Exception{
		if(this.pi == null){
			pi = new PageInfo();
			pi.setPageSize(1);
			pi.setPartPageCount(3);
			pi.setCurrentPage(1);
		}
		int id = Integer.parseInt(ServletActionContext.getRequest().getSession().getAttribute(Constant.STU_ANTHOR).toString());
		List<TestResult> resultList = this.eus.getResultById(id, pi);
		ServletActionContext.getRequest().setAttribute("resultList", resultList);
		ServletActionContext.getRequest().setAttribute("pageInfo", pi);
		return "resultScan";
	}
	/**
	 * 查看结果
	 * @return
	 * @throws Exception
	 */
	public String getResultById() throws Exception{
		this.result = this.eus.getResultById(this.result.getTrId());
		if(this.result != null){
			ServletActionContext.getRequest().setAttribute("result", this.result);
			String[] strArr = this.result.getTrMark().split("/");
			ServletActionContext.getRequest().setAttribute("resultAn", strArr);
		}
		return "questionScan";
	}
	/**
	 * 过去科目信息
	 * @return
	 * @throws Exception
	 */
	public String getSubjectInfo() throws Exception{
		List<Subjects> subList = this.eus.getSubjectList();
		String str = JSONArray.fromObject(subList).toString();
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().getWriter().print(str);
		return null;
	}
	public String getObjectsInfo() throws Exception{
		List<Objects> objsList = this.eus.getObjectsList();
		String str = JSONArray.fromObject(objsList).toString();
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().getWriter().println(str);
		return null;
	}
	public String getLXTestQuestions() throws Exception{
		int count = this.tq.getTqContentNum();
		int oid = this.o.getOId();
		int sid = this.s.getSjId();
		TestQuestions tqs = this.eus.getGenerateTestQuestion(count, oid, sid);
		ServletActionContext.getRequest().getSession().setAttribute("lxtq", tqs);
		return "lxExam";
	}
	public String sendMsg() throws Exception{
		int id = Integer.parseInt(ServletActionContext.getRequest().getSession().getAttribute(Constant.STU_ANTHOR).toString());
		this.eus.sendMsg(id, this.message);
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().getWriter().println("{\"sendState\":"+true+"}");
		return null;
	}
	public String reveiceMsg() throws Exception{
		String reveiceData = this.eus.reveiceMsg();
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().getWriter().println(reveiceData);
		return null;
	}
	public String computeResult() throws Exception{
		TestResult tr =this.eus.compute((TestQuestions)ServletActionContext.getRequest().getSession().getAttribute("lxtq"), lxda);
		String result = "{\"result\":\""+tr.getTrResult()+"\",\"fullmark\":\""+tr.getTestQuestions().getTqFullMark()+"\"}";
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().getWriter().println(result);
		return null;
	}
	
	public String getMusicConfigXML() throws Exception{
		XMLWriter writer = new XMLWriter(ServletActionContext.getResponse().getOutputStream());
		String url = ServletActionContext.getServletContext().getRealPath("/config/mp3player.xml");
		writer.write(this.eus.getMusic(url));
		return null;
	}
}
