package com.zyexam.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.zyexam.dao.QuestionsDAO;
import com.zyexam.entity.Objects;
import com.zyexam.entity.Questions;
import com.zyexam.entity.Subjects;
import com.zyexam.util.ExcelReder;

public class TeacherServer {
	private QuestionsDAO qDAO;
	
	
	public QuestionsDAO getqDAO() {
		return qDAO;
	}


	public void setqDAO(QuestionsDAO qDAO) {
		this.qDAO = qDAO;
	}


	public void updateQuestions(File f) throws Exception{
		List<Questions> questionsList = new ArrayList<Questions>();
		ExcelReder er = new ExcelReder();
		HSSFWorkbook workbook = er.getWookbook(f);
		HSSFSheet sheet = er.getSheet(workbook);
		for(int i = 0; i < sheet.getLastRowNum(); i++){
			if(i == 0)
				continue;
			HSSFRow row = er.getRowData(sheet, i);
			Questions q = new Questions();
			for(int j = 0; j < row.getLastCellNum(); j++){
				HSSFCell cell = er.getCell(row, j);
				switch(j){
				case 1:
					q.setQtContent(cell.getStringCellValue());
					break;
				case 2:
					q.setQtOptionA(cell.getStringCellValue());
					break;
				case 3:
					q.setQtOptionB(cell.getStringCellValue());
					break;
				case 4:
					q.setQtOptionC(cell.getStringCellValue());
					break;
				case 5:
					q.setQtOptionD(cell.getStringCellValue());
					break;
				case 6:
					int sjId = (int)cell.getNumericCellValue();
					Subjects sj = new Subjects();
					sj.setSjId(sjId);
					q.setQtSubject(sj);
					break;
				case 7:
					int oId = (int)cell.getNumericCellValue();
					Objects o = new Objects();
					o.setOId(oId);
					q.setQtObject(o);
					break;
				case 8:
					q.setQtResult(cell.getStringCellValue());
					break;
				}
			}
			questionsList.add(q);
		}
		for (Questions q : questionsList) {
			this.qDAO.add(q);
		}
	}
}
