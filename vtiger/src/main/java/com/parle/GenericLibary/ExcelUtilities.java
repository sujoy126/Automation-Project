package com.parle.GenericLibary;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	FileInputStream fis = null;
	Workbook book = null;
	DataFormatter df;
	FileOutputStream fos;
	public String singleData(String path, int row , int cell,String sheetname) {
		try {
			 fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataFormatter df = new DataFormatter();
		
		try {
			 book= WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sh = book.getSheet(sheetname);
		return df.formatCellValue(sh.getRow(row).getCell(cell));
	}
	
	
	
	public List<String> fetchDataRowWise(String path, String sheetName, int lastRowNumber, int cell) {
		List<String> l = new ArrayList<String>();
		
		try {
			fis = new FileInputStream( path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		df = new DataFormatter();
		
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sh = book.getSheet(sheetName);
		
		for(int i=0; i<lastRowNumber;i++)
		{
			String data = df.formatCellValue(sh.getRow(i).getCell(cell));
			 l.add(data);	
		}
		return l;
	}
	
	
	public int fetchLastRowNumber(String path, String sheetName, int lastRow) {
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sh = book.getSheet(sheetName);
		int p = sh.getLastRowNum();
		return p;
	}
	
	public int fetchLastCellNumber(String path, String sheetName, int row) {
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sh = book.getSheet(sheetName);
		 int cell =  sh.getRow(row).getLastCellNum();
		 return cell;
	}
	
	public void writeSingledata(String path, String sheetName, int row, int cell) {
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sh = book.getSheet(sheetName);
		df = new DataFormatter();
		df.formatCellValue(sh.createRow(row).createCell(cell));
		
		try {
			 fos = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	
	
	
	

}
