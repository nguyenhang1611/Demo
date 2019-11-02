package login.coractions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	/**
	 * getCellValue method
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 * @param filePath
	 * @param fileName
	 * @param Sheet
	 * @param row
	 * @param col
	 * @return
	 * @throws IOException
	 */
	public String getCellValue(String filePath, String fileName, String Sheet, int row, int col) throws IOException {
		Cell cell = setWorkbook(filePath, fileName).getSheet(Sheet).getRow(row).getCell(col);
		return cell.getStringCellValue();
	}

	/**
	 * getRowCount method
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 * @param filePath
	 * @param fileName
	 * @param Sheet
	 * @return
	 * @throws IOException
	 */
	public int getRowCount(String filePath, String fileName, String Sheet) throws IOException {
		return setWorkbook(filePath, fileName).getSheet(Sheet).getLastRowNum();
	}

	/**
	 * getRowCount method
	 * 
	 * @author HangNT
	 * @since 2019/11/01
	 * @param filePath
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private Workbook setWorkbook(String filePath, String fileName) throws IOException {
		File file = new File(filePath + "/" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;

		// Find the file extension
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file then create object of XSSFWorkbook
		if (fileExtensionName.equals(".xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		}
		// Check condition if the file is xls file then create object of XSSFWorkbook
		else if (fileExtensionName.equals(".xls")) {
			workbook = new HSSFWorkbook(inputStream);
		}
		return workbook;
	}
}