package Worklist;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.model.ConvertAnchor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;

import common_Function.RW;
import jxl.biff.formula.ParseContext;

public class WorklistJobs extends RW {

	private static ExtentReports report;

	public synchronized static ExtentReports getReporter(String filePath) { // allow only one thread to access the shared resource,To prevent thread interference
																			
		if (report == null) {
			report = new ExtentReports(path.concat("Report\\Worklist_Job.html"));

			report.addSystemInfo("Host Name", "Priti") // Environment Setup For
														// Report
					.addSystemInfo("Environment", "QA");
		}

		return report;
	}

	public void AddNewJobs(WebDriver driver1) throws Exception { 

		// Get the list of controls used in the AddNewJobs screen
		ArrayList<Row> locator = GetElementrows(driver1);

		// Get Data for the Input Test datassss
		ArrayList<Row> InputTestData = GetInputData(driver1);
					
		// Loop for adding mumtiple jobs
		for (int jobID = 1; jobID < InputTestData.size(); jobID++) {
			//-- set input data to the locator 
		NavigateLocators( driver1,  locator,InputTestData, jobID);
		}
	}
			
	private ArrayList<Row> GetElementrows(WebDriver driver1) throws Exception {

		driver1.get("http://192.168.1.202/STG_VEKTOR/Technical/worklist/worklist.aspx");

		ArrayList<Row> OR_row = OR_tech.searchSheet("AddNewJobs", 0, 9);// Functn
																		// key,sheetNo.,Column
																		// no.//
																		// Xpath
		return (OR_row);

	}

	private ArrayList<Row> GetInputData(WebDriver driver1) {
		
        // defined TestData Excel in arraylist
    ArrayList<Row> Input_row = input_tech.searchSheet("AddNewJobs", 0, 0); 

		return (Input_row);

	}

	private void NavigateLocators(WebDriver driver1, ArrayList<Row> ElementRow, ArrayList<Row> Input_row, int jobID ) throws Exception
	{

		for (int i = 0; i < ElementRow.size(); i++) {
			//Get type of element (dropdown, text)
			String strControlTypeKey = ElementRow.get(i).getCell(10).toString();
			
			if (strControlTypeKey != null) {

				//Get property of element
				String LocatorName = ElementRow.get(i).getCell(0).getStringCellValue();

				//Get property of element
				String LocatorType = ElementRow.get(i).getCell(1).getStringCellValue();
				
				// Get client ID of the element 
				String strControl = ElementRow.get(i).getCell(2).getStringCellValue();
				
				//Get Sleep Time
				Long SleepTime =  (long) ElementRow.get(i).getCell(4).getNumericCellValue();
				
				String strValue =  Input_row.get(jobID).getCell(i+1).toString();
				
				//Button Click and navigate page
				if (strControlTypeKey.compareTo("WindowSwitch_Ctrl") == 0) {			
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);
					WindowSwitchto(driver1);
					Thread.sleep(SleepTime);
				}
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
					sendkeys(driver1, LocatorType, strControl, strValue);
					Thread.sleep(SleepTime);
				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					sendkeys(driver1, LocatorType, strControl, strValue);
					Thread.sleep(SleepTime);
				}
				if (strControlTypeKey.compareTo("Alert_WindowSwitch_Ctrl") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);
					Alert_accept(driver1);
					//Alert_WindowSwitch(driver1);
					Thread.sleep(SleepTime);
					WindowSwitchto(driver1);
				}
				
			}
		}
	
	}}
	

