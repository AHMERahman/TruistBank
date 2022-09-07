package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import reporting.Loggers;


public class ExcelData {

	Workbook workbook;
	Sheet sheet;
	
	FileInputStream fileInputStream;

	public ExcelData(String path, String sheetName) {
		try {
			fileInputStream = new FileInputStream(path);
		} catch (IOException e) {
			e.printStackTrace();
			Loggers.obtainLog("File not found in ---> " + path);
			
		}
		if (path.endsWith(".xls")) {
			try {
				workbook = new HSSFWorkbook(fileInputStream);
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				Loggers.obtainLog("File not found in ---> " + path);
				
			}
		} else if (path.endsWith(".xlsx")) {
			try {
				workbook = new XSSFWorkbook(fileInputStream);
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				Loggers.obtainLog("File not found in ---> " + path);
				
			}
		}
		sheet = workbook.getSheet(sheetName);
	}
	
	public String[][] dataObjects() {
		String[][] data = null;
		int yRowsNumber = 0;
		int totalCellNumber = sheet.getRow(0).getLastCellNum() - 2;
		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			try {
				if (sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase("Y")) {
					yRowsNumber++;
				}
			} catch (NullPointerException e) {
				//
			}
		}

		//System.out.println(yRowsNumber);
		
		data = new String[yRowsNumber][totalCellNumber];
		
		int row = 0;
		for(int i = 1; i <= sheet.getLastRowNum(); i++) {
			try {
				if (sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase("Y")) {
 					for(int j = 2; j < sheet.getRow(i).getLastCellNum(); j++) {
						String value = sheet.getRow(i).getCell(j).getStringCellValue();
						//System.out.println(value);
						data[row][j-2] = value;
					}
					row++;
				}
			} catch (NullPointerException e) {
				//
			}
		}
		return data;
	}
	
	public Map<Integer, Map<String, String>> dataMap() {
		Map<Integer, Map<String, String>> maps = new HashMap<Integer, Map<String, String>>();
		/*
		 * 1. A Map where every row number is a key and another map is a value 2. Inside
		 * Map, key will be header (Row number 0), and value will be each row with y
		 * execution
		 */
		int yRows = 0;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {    // header excluded hence, i=1
			Map<String, String> map = new HashMap<String, String>();
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				try {
					String key = sheet.getRow(0).getCell(j).getStringCellValue(); //header
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				} catch (NullPointerException | IllegalStateException e) {
					// TODO: handle exception
				}
			}
			try {
				if (map.get("Execution").equalsIgnoreCase("Y")) {
					maps.put(yRows, map);
					yRows++;
				}
			} catch (NullPointerException e) {

			}
		}
		/*
		 * 1. A Map where every row number is a key and another map is a value 
		 * 2. InsideMap, key will be header (Row number 0), and value will be each row with y
		 * execution 
		 * define yRows = 0, so that we can add row as Main map key 
		 * i - Iterate each row till the last row {
		 * Create a map for each row {
		 * 	j - Iterate through each cell of the row 
		 * 	define key(header) = where row 0 , j number cell has the value
		 * 	define value = where row i, j number cell has the value
		 * 	add the key and value into the inside map }
		 * Condition - if insideMapOfEachRow.get("Execution") has ignore case "Y"
		 * 	add into Main map, where key is yRow and value is insideMap
		 * 	yRows increment; }
		 */
		return maps;
	}

	/*
	 * public static void main(String[] args) { Configuration configuration = new
	 * Configuration(null); String pathString =
	 * configuration.getConfiguration("excelPath"); String sheetNameString =
	 * configuration.getConfiguration("excelSheetMap"); ExcelUtil excelUtil = new
	 * ExcelUtil(pathString, sheetNameString); Map<Integer, Map<String, String>>
	 * maps = excelUtil.dataMap(); for (Integer keys : maps.keySet()) {
	 * System.out.println("----------------------" + keys); Map<String, String> map
	 * = maps.get(keys); for (String key : map.keySet()) { System.out.print(key +
	 * " ---- > " + map.get(key) + "  []  "); }
	 * System.out.println("----------------------"); }
	 * 
	 * }
	 */

}
