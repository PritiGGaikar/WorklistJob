package Worklist;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

import common_Function.RW;

public class EditJob extends RW {

	private static ExtentReports report;

	public synchronized static ExtentReports getReporter(String filePath) {

		if (report == null) {
			report = new ExtentReports(path.concat("Report\\Edit_Worklist_Job.html"));

			report.addSystemInfo("Host Name", "Priti") // Environment Setup For
														// Report
					.addSystemInfo("Environment", "QA");
		}

		return report;
	}

	public void EditJobs(WebDriver driver1) throws Exception {

		// Get the list of controls used in the EditJobs
		ArrayList<Row> locator = GetElementrows(driver1);

		// Get Data for the Input Test datassss
		ArrayList<Row> InputTestData = GetInputData(driver1);

		// Loop for adding mumtiple jobs
		for (int jobID = 1; jobID < InputTestData.size(); jobID++) {
			// -- set input data to the locator
			NavigateLocators(driver1, locator, InputTestData, jobID);
		}
	}

	private ArrayList<Row> GetElementrows(WebDriver driver1) throws Exception {

		driver1.get("http://192.168.1.202/STG_VEKTOR/Technical/worklist/worklist.aspx");

		ArrayList<Row> OR_row = OR_tech.searchSheet("EditWorklistJob", 1, 9);// Functn
		// key,sheetNo.,Column
		// no.//
		// Xpath
		return (OR_row);

	}

	private ArrayList<Row> GetInputData(WebDriver driver1) {

		// defined TestData Excel in arraylist
		ArrayList<Row> Input_row = input_tech.searchSheet("EditWorklistJob", 1, 0);

		return (Input_row);

	}

	private void NavigateLocators(WebDriver driver1, ArrayList<Row> ElementRow, ArrayList<Row> Input_row, int jobID)
			throws Exception {

		for (int i = 0; i < ElementRow.size(); i++) {
			// Get type of element (dropdown, text)
			String strControlTypeKey = ElementRow.get(i).getCell(10).toString();

			if (strControlTypeKey != null) {

				// Get property of element
				String LocatorName = ElementRow.get(i).getCell(0).getStringCellValue();

				// Get property of element
				String LocatorType = ElementRow.get(i).getCell(1).getStringCellValue();

				// Get client ID of the element
				String strControl = ElementRow.get(i).getCell(2).getStringCellValue();

				// Get Sleep Time
				// Long SleepTime = (long)
				// ElementRow.get(i).getCell(4).getNumericCellValue();

				String strValue = Input_row.get(jobID).getCell(i + 1).toString();

				// Button Click and navigate page
				if (strControlTypeKey.compareTo("WindowSwitch_Ctrl") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(k);
					WindowSwitchto(driver1);
					Thread.sleep(k);
				}
				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(k);
				}
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
					sendkeys(driver1, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					sendkeys(driver1, LocatorType, strControl, strValue);
					Thread.sleep(k);
				}
				if (strControlTypeKey.compareTo("Alert_accept") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(k);
					Alert_accept(driver1);
					Thread.sleep(k);

				}

				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {
					clear_element(driver1, LocatorType, strControl);
					Thread.sleep(k);
				}
				if (strControlTypeKey.compareTo("Alert_WindowSwitch_Ctrl") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(k);
					Alert_accept(driver1);
					Thread.sleep(k);
					// SwitchtoParent(driver1);
					WindowSwitchto(driver1);
				}

			}
		}
	}

}
