package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetFirstAndSecondColumnDataTest {

	
		public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigerTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowNo = sheet.getLastRowNum();
		for(int i=1; i<=rowNo;i++) {
			Row row = sheet.getRow(i);
			String firstColumnData= row.getCell(0).getStringCellValue();
			String secondColumnData = row.getCell(1).getStringCellValue();
			System.out.println(firstColumnData+"\t"+secondColumnData);
		}
		workbook.close();
			
			
	}

}
