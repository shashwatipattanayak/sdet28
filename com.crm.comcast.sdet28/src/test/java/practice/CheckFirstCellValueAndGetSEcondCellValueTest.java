package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CheckFirstCellValueAndGetSEcondCellValueTest {

	//If first cell has accepted value, fetch second cell data
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigerTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		String cellData = "CreateOrganization";
		int rowNo = sheet.getLastRowNum();
		for(int i=1; i<=rowNo; i++) {
			Row row = sheet.getRow(i);
			String firstCellData=row.getCell(0).getStringCellValue();
			if(firstCellData.equals(cellData)) {
				String secondCellData = row.getCell(1).getStringCellValue();
				System.out.println(secondCellData);
			}
			workbook.close();	
		}
		
	}

}
