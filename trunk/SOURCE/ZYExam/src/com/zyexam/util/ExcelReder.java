package com.zyexam.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReder {
	public HSSFWorkbook getWorkBook(String url) throws IOException{
		File f = new File(url);
		if(!f.exists()){
			throw new IOException("文件不存在");
		}
		if(f.isDirectory()){
			throw new IOException("这不是一个文件");
		}
		InputStream is = new FileInputStream(f);
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		return workbook;
	}
	public HSSFWorkbook getWookbook(File f) throws IOException{
		if(!f.exists()){
			throw new IOException("文件不存在");
		}
		if(f.isDirectory()){
			throw new IOException("这不是一个文件");
		}
		InputStream is = new FileInputStream(f);
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		return workbook;
	}
	
	public HSSFSheet getSheet(HSSFWorkbook workbook) throws IllegalAccessException{
		int numSheets = workbook.getNumberOfSheets();
		if(numSheets <= 0){
			throw new IllegalAccessException("此工作薄无效");
		}
		HSSFSheet sheet = workbook.getSheetAt(0);
		return sheet;
	}
	
	public HSSFRow getRowData(HSSFSheet sheet, int row) throws IllegalAccessException{
		int rowNum = sheet.getLastRowNum();
		if(row > rowNum){
			throw new IllegalAccessException("读取的行大于文档中的最大行数");
		}
		HSSFRow rowData = sheet.getRow(row);
		return rowData;
	}
	public HSSFCell getCell(HSSFRow rowData, int cellNum) throws IllegalAccessException{
		int maxCellNum = rowData.getLastCellNum();
		if(cellNum > maxCellNum)
			throw new IllegalAccessException("列数已超过最大列数");
		HSSFCell cell = rowData.getCell(cellNum);
		return cell;
	}
}
