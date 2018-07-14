package core;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Timesheetlib {
	 private static String[] columns = { "Staff Name","Hourly rate in $" , "Hours worked-Sunday" , "Hours worked-Monday", "Hours worked-Tuesday", "Hours worked-Wednesday", "Hours worked-Thrusday", "Hours worked-Friday","Hours worked-Saturday","Total hours","Weekly rate in $" };
     private static List<Contact> contacts = new ArrayList<Contact>();


	public static float totalHoursCalculation(float mhours,float thours,float whours,float thhours,float fhours,float shours,float suhours, float hrate)
	{
		float tothrs=0;
		tothrs = mhours+thours+whours+thhours+fhours+shours+suhours;
	 	return tothrs;
	
	}
	
	public static float weeklyRateCalculation(float mhours,float thours,float whours,float thhours,float fhours,float shours,float suhours, float hrate)
	{
		
		float wrate=0;
		float saturdaypenalty= (float) ((shours*hrate)*0.015+ (shours*hrate));
		float sundaypenalty= (float) ((suhours*hrate)*0.02+ (suhours*hrate));
	    wrate = (mhours*hrate)+ (thours*hrate)+(whours*hrate)+(thhours*hrate)+(fhours*hrate)+saturdaypenalty+sundaypenalty;
	    float roundOff = Math.round(wrate*100)/100;
		return roundOff;
	}
	public static void excelReport(String name,float hrate,float sundaywhrs,float mondaywhrs,float tuesdaywhrs,float wednesdaywhrs,float thursdaywhrs,float fridaywhrs,float saturdaywhrs,float totalhours,float weeklyrate) throws IOException
	{
		contacts.add(new Contact(name,hrate,sundaywhrs,mondaywhrs,tuesdaywhrs,wednesdaywhrs,thursdaywhrs,fridaywhrs,saturdaywhrs,totalhours,weeklyrate));
		Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Timesheet");

	    Font headerFont = workbook.createFont();
	    headerFont.setBold(true);
	    headerFont.setFontHeightInPoints((short) 14);
	    headerFont.setColor(IndexedColors.RED.getIndex());

	    CellStyle headerCellStyle = workbook.createCellStyle();
	    headerCellStyle.setFont(headerFont);

	    // Create a Row
	    Row headerRow = sheet.createRow(0);

	    for (int i = 0; i < columns.length; i++) {
	      Cell cell = headerRow.createCell(i);
	      cell.setCellValue(columns[i]);
	      cell.setCellStyle(headerCellStyle);
	    }

	    // Create Other rows and cells with contacts data
	    int rowNum = 1;

	    for (Contact contact : contacts) {
	      Row row = sheet.createRow(rowNum++);
	      //row.createCell(arg0)
	      row.createCell(0).setCellValue(contact.staffName);
	      row.createCell(1).setCellValue(contact.hourlyRate);
	      row.createCell(2).setCellValue(contact.sunday);
	      row.createCell(3).setCellValue(contact.monday);
	      row.createCell(4).setCellValue(contact.tuesday);
	      row.createCell(5).setCellValue(contact.wednesday);
	      row.createCell(6).setCellValue(contact.thrusday);
	      row.createCell(7).setCellValue(contact.friday);
	      row.createCell(8).setCellValue(contact.saturday);
	      row.createCell(9).setCellValue(contact.totalHours);
	      row.createCell(10).setCellValue(contact.weeklyRate);
	    }

	    // Resize all columns to fit the content size
	    for (int i = 0; i < columns.length; i++) {
	      sheet.autoSizeColumn(i);
	    }

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("Timesheet.xlsx");
	    workbook.write(fileOut);
	    workbook.close();
	    fileOut.close();
			

	}
}
