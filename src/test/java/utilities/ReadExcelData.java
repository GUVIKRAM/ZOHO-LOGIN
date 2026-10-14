package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadExcelData {

	@DataProvider(name = "logindata")
	public String[][] getdata(Method m) throws EncryptedDocumentException, IOException {
		String excelSheet = m.getName();
		File excelFile = new File(System.getProperty("user.dir") + "\\src\\java\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheet);
		
		
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalColoumns = rowCells.getLastCellNum();
		System.out.println(totalColoumns);
		
		DataFormatter dataformat = new DataFormatter();
		String testData[][] = new String [totalRows][totalColoumns];
		for(int i=1; i<=totalRows; i++) {
			for(int j=0; j<totalColoumns; j++) {
				testData[i-1][j] = dataformat.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}return testData;
		
	}
} 