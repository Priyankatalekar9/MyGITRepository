package com.jbk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Excelreader {

	public static Object[][] getDP(String fileName, String sheetName) throws Exception  {
		String[][] excelData = null;
		FileInputStream fis;

		fis = new FileInputStream(fileName);
		System.out.println(2);
		Workbook workbook = Workbook.getWorkbook(fis);
		Sheet sh = workbook.getSheet(sheetName);
		System.out.println(3);
		int rows = sh.getRows();
		int cols = sh.getColumns();
		excelData = new String[rows][cols];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				excelData[i][j] = sh.getCell(j, i).getContents();
			}
		}
		return excelData;
	}
}
