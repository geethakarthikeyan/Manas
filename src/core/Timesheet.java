package core;


import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import core.Timesheetlib;

public class Timesheet {

		// TODO Auto-generated method stub
				 
				  public static void main(String[] args) throws IOException, 
					InvalidFormatException {
					  @SuppressWarnings("resource")
					Scanner s = new Scanner(System.in);
					  System.out.println("Enter number of employees");
					  int n=s.nextInt();
					  	
					  for(int j=1;j<=n;j++){
						System.out.println("Enter staff name");
						String name = s.next();
						/*System.out.println("Enter DOB");
						String dob = s.next();*/
						float hrate=0;
						System.out.println("Enter Hourly rate(in decimal)-should not exceed $50");
						while((hrate=s.nextFloat())>50){
							System.out.println("Enter Hourly rate(in decimal)-should not exceed $50");
						}
											
						System.out.println("Enter working hours detail for sunday");
						float sundaywhrs = s.nextFloat();
						System.out.println("Enter working hours detail for Monday");
						float mondaywhrs = s.nextFloat();
						System.out.println("Enter working hours detail for Tuesday");
						float tuesdaywhrs = s.nextFloat();
						System.out.println("Enter working hours detail for Wednesday");
						float wednesdaywhrs = s.nextFloat();
						System.out.println("Enter working hours detail for Thrusday");
						float thursdaywhrs = s.nextFloat();
						System.out.println("Enter working hours detail for Friday");
						float fridaywhrs = s.nextFloat();
						System.out.println("Enter working hours detail for Saturday");
						float saturdaywhrs = s.nextFloat();
						
					//Calculating Total hours for Staffs	
					float totalhours = Timesheetlib.totalHoursCalculation(mondaywhrs,tuesdaywhrs,wednesdaywhrs,thursdaywhrs,fridaywhrs,saturdaywhrs,sundaywhrs, hrate);
					
					//Calculating Weekly rate for Staffs
					float weeklyrate = Timesheetlib.weeklyRateCalculation(mondaywhrs, tuesdaywhrs, wednesdaywhrs, thursdaywhrs, fridaywhrs, saturdaywhrs, sundaywhrs, hrate);
					
					//Writing Excel Report for Weekly Time sheet
					Timesheetlib.excelReport(name, hrate, sundaywhrs, mondaywhrs, tuesdaywhrs, wednesdaywhrs, thursdaywhrs, fridaywhrs, saturdaywhrs, totalhours, weeklyrate);
					  }
					}

				  
					}
					 



				
				
				  
				
	
			
			



