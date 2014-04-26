package com.zyexam.services;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zy.aespwd.AESUtil;
import com.zyexam.dao.ObjectsDAO;
import com.zyexam.dao.QuestionsDAO;
import com.zyexam.dao.SubjectsDAO;
import com.zyexam.dao.SysUsersDAO;
import com.zyexam.dao.TestQuestionsDAO;
import com.zyexam.dao.TestResultDAO;
import com.zyexam.entity.Objects;
import com.zyexam.entity.Questions;
import com.zyexam.entity.Subjects;
import com.zyexam.entity.SysUsers;
import com.zyexam.entity.TestQuestions;
import com.zyexam.entity.TestResult;
import com.zyexam.util.PageInfo;

public class ExamUserServer {
	private SysUsersDAO suDAO;
	private AESUtil aesUtil;
	private TestResultDAO trDAO;
	private TestQuestionsDAO tqDAO;
	private SubjectsDAO sDAO;
	private ObjectsDAO oDAO;
	private QuestionsDAO qDAO;
	
	public QuestionsDAO getqDAO() {
		return qDAO;
	}

	public void setqDAO(QuestionsDAO qDAO) {
		this.qDAO = qDAO;
	}

	public ObjectsDAO getoDAO() {
		return oDAO;
	}
	
	public void setoDAO(ObjectsDAO oDAO) {
		this.oDAO = oDAO;
	}
	
	public SubjectsDAO getsDAO() {
		return sDAO;
	}
	
	public void setsDAO(SubjectsDAO sDAO) {
		this.sDAO = sDAO;
	}
	
	public TestQuestionsDAO getTqDAO() {
		return tqDAO;
	}
	
	public void setTqDAO(TestQuestionsDAO tqDAO) {
		this.tqDAO = tqDAO;
	}
	
	public TestResultDAO getTrDAO() {
		return trDAO;
	}
	
	public void setTrDAO(TestResultDAO trDAO) {
		this.trDAO = trDAO;
	}

	public AESUtil getAesUtil() {
		return aesUtil;
	}

	public void setAesUtil(AESUtil aesUtil) {
		this.aesUtil = aesUtil;
	}

	public SysUsersDAO getSuDAO() {
		return suDAO;
	}

	public void setSuDAO(SysUsersDAO suDAO) {
		this.suDAO = suDAO;
	}


	/**
	 * 根据用户ID查询用户信息
	 * @param id 用户ID
	 * @return 返回用户信息
	 */
	@SuppressWarnings("rawtypes")
	public SysUsers selectSysUsersById(int id){
		String hql = "from SysUsers su where su.userId = ?";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(id);
		List l = this.suDAO.select(hql, paramList,null);
		SysUsers su = null;
		if(l != null && !l.isEmpty()){
			su = (SysUsers)l.get(0);
		}
		return su;
	}
	/**
	 * 修改用户基本信息
	 * @param su 用户的信息
	 * @return 返回修改结果
	 */
	public boolean updateBaseInfo(SysUsers su){
		String hql = "update SysUsers sus set sus.userName = ?, sus.userSex = ?, sus.userBirthday=?,"+
	" sus.userPhone=?, sus.userQq=?, sus.userEmail=?, sus.userState=?,sus.userIpAddress=? where sus.userId=?";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(su.getUserName());
		paramList.add(su.getUserSex());
		paramList.add(su.getUserBirthday());
		paramList.add(su.getUserPhone());
		paramList.add(su.getUserQq());
		paramList.add(su.getUserEmail());
		paramList.add(su.getUserState());
		paramList.add(su.getUserIpAddress());
		paramList.add(su.getUserId());
		int row = this.suDAO.update(hql, paramList);
		if(row == 1){
			return true;
		}else{
			String errMsg = "修改用户Id为"+su.getUserId() +"发生错误";
			throw new IllegalArgumentException(errMsg);
		}
	}
	/**
	 * 修改学生登陆用户密码
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 * @return 返回修改结果，修改成功返回true，修改失败返回false
	 */
	@SuppressWarnings("rawtypes")
	public boolean updateUserPassword(int id, String oldPwd,String newPwd){
		// 验证旧密码是否正确
		String hql = "select su.userPassword from SysUsers su where su.userId = ?";
		List<Object> parameList = new ArrayList<Object>();
		parameList.add(id);
		List l = this.suDAO.select(hql, parameList, null);
		if(l == null || l.isEmpty()){
			return false;
		}
		String sqlPwd = l.get(0).toString();
		try {
			oldPwd = this.aesUtil.parseByte2HexStr(this.aesUtil.encrypt(oldPwd, AESUtil.publicPassword));
		} catch (Exception e){
			e.printStackTrace();
		}
		if(!oldPwd.equals(sqlPwd)){
			return false;
		}
		// 创建hql语句修改密码
		hql = "update SysUsers su set su.userPassword=? where su.userId=?";
		try {
			newPwd = this.aesUtil.parseByte2HexStr(this.aesUtil.encrypt(newPwd, AESUtil.publicPassword));
		} catch (Exception e){
			e.printStackTrace();
		}
		parameList.clear();
		parameList.add(newPwd);
		parameList.add(id);
		int row = this.suDAO.update(hql, parameList);
		if(row == 1){
			return true;
		}else{
			throw new RuntimeException("用户ID为"+id+"修改密码时出错");
		}
	}
	// 查看成绩
	/**
	 * 获取学生考试成绩
	 * @param id 学生ID编号
	 * @param pi 分页信息
	 * @return 返回成绩单
	 */
	@SuppressWarnings("unchecked")
	public List<TestResult> getResultById(int id,PageInfo pi){
		// 构建hql查询语句
		String hql = "from TestResult result where result.trUser.userId = ?";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(id);
		List<TestResult> resultList = null;
		resultList = this.trDAO.select(hql, paramList, pi);
		return resultList;
	}
	/**
	 * 获取单条结果信息
	 * @param id 成绩单编号
	 * @return 返回测试结果
	 */
	@SuppressWarnings("unchecked")
	public TestResult getResultById(int id){
		String hql = "from TestResult result where result.trId = ?";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(id);
		List<TestResult> result = null;
		result = this.trDAO.select(hql, paramList, null);
		if(result != null && !result.isEmpty()){
			return result.get(0);
		}
		return null;
	}
	/**
	 * 根据试卷ID编号查询
	 * @param id 试卷ID编号
	 * @return 返回试卷信息
	 */
	@SuppressWarnings("unchecked")
	public TestQuestions getTestQuestionsById(int id){
		String hql = "from TestQuestions tq where tq.tqId = ?";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(id);
		List<TestQuestions> tqList = null;
		tqList = this.tqDAO.select(hql, paramList,null);
		if(tqList != null && !tqList.isEmpty()){
			return tqList.get(0);
		}
		return null;
	}
	/**
	 * 获取科目列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Subjects> getSubjectList(){
		String hql = "from Subjects";
		List<Subjects> l = null;
		l = this.sDAO.select(hql, null, null);
		return l;
	}
	/**
	 * 获取分类列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Objects> getObjectsList(){
		String hql = "from Objects";
		List<Objects> l = null;
		l = this.oDAO.select(hql, null, null);
		return l;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TestQuestions getGenerateTestQuestion(int count,int oid, int sid){
		// 声明查询语句变量
		StringBuffer hql = new StringBuffer();
		// 构建查询语句
		hql.append("select count(*) from Questions q where 1=1 ");
		List<Object> paramList = new ArrayList<Object>();
		if(oid > 0){
			hql.append(" and q.qtObject.OId = ? ");
			paramList.add(oid);
		}
		if(sid > 0){
			hql.append(" and q.qtSubject.sjId = ? ");
			paramList.add(sid);
		}
		int hqlCount = 0;
		// 得到试题数量
		List l = this.qDAO.select(hql.toString(), paramList, null);
		hqlCount = Integer.parseInt(l.get(0).toString());
		if(hqlCount >= count){
			// 重写查询语句
			hql = new StringBuffer();
			hql.append("from Questions q where 1=1 ");
			paramList.clear();
			if(oid > 0){
				hql.append(" and q.qtObject.OId = ? ");
				paramList.add(oid);
			}
			if(sid > 0){
				hql.append(" and q.qtSubject.sjId = ? ");
				paramList.add(sid);
			}
			List<Questions> qList = null;
			qList = this.qDAO.select(hql.toString(), paramList, null);
			// 剔除无用题目
			int sub = hqlCount - count;
			List<Integer> subList = new ArrayList<Integer>();
			for(int i = 0; i < sub; i++){
				Random rand = new Random();
				int s = rand.nextInt(hqlCount);
				if(subList.contains(s)){
					i--;
				}else{
					subList.add(s);
				}
			}
			List<Questions> qTempList = new ArrayList<Questions>();
			for (Integer integer : subList) {
				Questions q = qList.get(integer);
				qTempList.add(q);
			}
			for (Questions qt : qTempList){
				qList.remove(qt);
			}
			TestQuestions tq = new TestQuestions();
			tq.setQuestionsList(qList);
			tq.setTqContentNum(count);
			tq.setTqFullMark(count * 2);
			return tq;
		}
		return null;
	}
	/**
	 * 发送信息
	 * =_=zly
	 * @author Administrator
	 * @createDate 2014-4-12下午2:04:29
	 * @param id 用户Id编号
	 * @param msg 用户发送的信息
	 */
	@SuppressWarnings("unchecked")
	public void sendMsg(int id, String msg){
		// 获取发送者的信息
		String hql = "from SysUsers su where su.userId = ?";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(id);
		List<SysUsers> l = null;
		l = this.suDAO.select(hql, paramList, null);
		SysUsers user = null;
		if(l != null && !l.isEmpty()){
			user = l.get(0);
		}
		if(user == null){
			return;
		}
		// 封装需要发送的信息
		StringBuffer sendMsg = new StringBuffer();
		sendMsg.append("{\"sendAnthor\":"+user.getUserName());
		sendMsg.append(",\"message\":\""+msg+"\"}");
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		byte[] buf = sendMsg.toString().getBytes();
		DatagramPacket dp = null;
		// 获取在线用户
		hql = "from SysUsers su where su.userState = ?";
		paramList.clear();
		paramList.add(0);
		l = this.suDAO.select(hql, paramList, null);
		// 给每位在线用户发送数据包
		if(l != null && !l.isEmpty()){
			for (SysUsers u : l) {
				try {
					dp = new DatagramPacket(buf, 0, buf.length, InetAddress.getByName(u.getUserIpAddress()),8888);
					ds.send(dp);
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		ds.close();
		
		/*
		 * HTML5 —— WebSocket    ---------------> Netty框架
		 */
		
	}
	
	public String reveiceMsg(){
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		byte[] buf = new byte[2048];
		DatagramPacket dp = new DatagramPacket(buf,0,buf.length);
		try {
			ds.receive(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String reveiceData = new String(dp.getData());
		ds.close();
		return reveiceData;
	}
	
	public TestResult compute(TestQuestions tq,String stuDa){
		TestResult tr = new TestResult();
		tr.setTestQuestions(tq);
		tr.setTrMark(stuDa);
		String[] stuan = stuDa.split("/");
		int res = 0;
		for(int i = 0; i < tq.getQuestionsList().size(); i++){
			if(tq.getQuestionsList().get(i).getQtResult().equalsIgnoreCase(stuan[i])){
				res += 2;
			}
		}
		tr.setTrResult(res);
		return tr;
	}
	
	public Document getMusic(String url) throws IOException,Exception{
		File f = new File(url);
		if(!f.exists()){
			throw new IOException("文件不存在");
		}
		if(!f.isFile()){
			throw new IOException("url不是一个文件");
		}else if(!"xml".equalsIgnoreCase(f.getName().substring(f.getName().lastIndexOf(".") + 1))){
			throw new IOException("此文件不是一个xml文件");
		}
		SAXReader sr = new SAXReader();
		Document doc = sr.read(f);
		Element rootElement = doc.getRootElement();
		Element songsElement = rootElement.addElement("songs");
		Element songE = songsElement.addElement("song");
		songE.addElement("url").addText("/ZYExam/video/b.mp3");
		songE.addElement("songname").addText("无名");
		songE.addElement("artist").addText("d");
		return doc;
	}
	
	public void updateStudentIp(String ip,int id){
		String hql = "update SysUsers su set su.userIpAddress = ? where su.userId = ?";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(ip);
		paramList.add(id);
		this.suDAO.update(hql, paramList);
	}
}
