package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.parle.GenericLibary.Iconstant;

public class ExcelFetch {
	public void m1() throws Throwable {
		FileInputStream fis = new FileInputStream(Iconstant.vtigerExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh =  book.getSheet("Demo");
		
		for(int i=0; i<sh.getLastRowNum(); i++){
			for(int j=0;j<sh.getLastRowNum();j++) {
				
			}
			
		}
		
	}

}
