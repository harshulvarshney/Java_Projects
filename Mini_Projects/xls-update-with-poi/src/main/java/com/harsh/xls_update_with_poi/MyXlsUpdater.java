package com.harsh.xls_update_with_poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author harshul.varshney
 *
 */
public class MyXlsUpdater {

	
	private static final String javaClassPath = "C:/TEMP/java";
	
	
	public static void main(String args[]) {
		List<String> allData = new ArrayList<>();
		readObjects(allData);
		
		new MyXlsUpdater().process(allData);
	}
	
	private static void readObjects(List<String> allData) {
		File dir = new File(javaClassPath);
		
		File[] files = dir.listFiles();
		
		for(File file : files) {
			try(Scanner s = new Scanner(file)) {
				while(s.hasNextLine()) {
					allData.add(s.nextLine());
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage() + "\n" + e);
			}
		}
	}
	
	private void process(List<String> allData) {
		
		String file = "C:/TEMP/Enrollment_Schema.xlsx";
		String targetPath = "C:/TEMP/Enrollment_Schema_target.xlsx";
		Set<String> records = new HashSet<>();
		List<Row> toRemove = new ArrayList<Row>();
				
		try (FileInputStream in = new FileInputStream(new File(file));
				FileOutputStream out = new FileOutputStream(new File(targetPath))) {
			
			//Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if(row.getRowNum() == 0) {
					continue;//skip first row
				}
				//remove duplicate
				if(isDuplicate(row, records)) {
					System.out.println("Removed duplicate row: "+row.getRowNum());
					toRemove.add(row);
					continue;
				}
				
				Cell name6 = row.getCell(2);
				if(name6 != null && name6.getCellType() != Cell.CELL_TYPE_BLANK) {
					String attr = "set"+name6.getStringCellValue();
					Optional<String> found = allData.stream().filter(line -> line.indexOf(attr) != -1).findFirst();
					if(!found.isPresent()) {
						makeCellRed(workbook, name6);
					}
				}
				else {
					toRemove.add(row);
				}
			}
			
			for(Row rowToRemove : toRemove) {
				//sheet.removeRow(rowToRemove);
				removeRow(sheet, rowToRemove.getRowNum()-1);
			}
			
            workbook.write(out);
            
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Update color of text in a cell
	 * @param wb
	 * @param cell
	 */
	private void makeCellRed(XSSFWorkbook wb, Cell cell) {
		 
		CellStyle st = wb.getCellStyleAt(cell.getColumnIndex());
//		Font cellFont = wb.createFont();
//		cellFont.setColor(IndexedColors.RED.getIndex());
//		st.setFillBackgroundColor(IndexedColors.RED.getIndex());
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.RED.getIndex());
		st.setFont(font);
		
		cell.setCellStyle(st);
	}
	
	public static void removeRow(XSSFSheet sheet, int rowIndex) {
        int lastRowNum=sheet.getLastRowNum();
        if(rowIndex>=0&&rowIndex<lastRowNum){
            sheet.shiftRows(rowIndex+1,lastRowNum, -1);
        }
        if(rowIndex==lastRowNum){
            XSSFRow removingRow=sheet.getRow(rowIndex);
            if(removingRow!=null){
                sheet.removeRow(removingRow);
            }
        }
    }
	
	/**
	 * returns true if 2 rows are duplicate, based on cell data
	 * @param row
	 * @param records
	 * @return
	 */
	private boolean isDuplicate(Row row, Set<String> records) {
		
		String value = row.getCell(1).getStringCellValue() 
					 + row.getCell(2).getStringCellValue() 
					 + (row.getCell(3).getCellType() != Cell.CELL_TYPE_BLANK ? row.getCell(3).getStringCellValue() : "");
		
		if(records.contains(value)) {
			return true;
		}
		else {
			records.add(value);
			return false;
		}
		
	}
}
