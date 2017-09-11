package Worklist;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

import common_Function.RW;

public class Filter extends RW {

	private static ExtentReports report;

	public synchronized static ExtentReports getReporter(String filePath) {

		if (report == null) {
			report = new ExtentReports(path.concat("Report\\FilterWorklist_Job.html"));

			report.addSystemInfo("Host Name", "Priti") // Environment Setup For
														// Report
					.addSystemInfo("Environment", "QA");
		}

		return report;
	}

	public void JobStatus(WebDriver driver1) throws Exception {
		// Get WorklistPage URL
		driver1.get("http://192.168.1.202/STG_VEKTOR/Technical/worklist/worklist.aspx");
		
		// Get Fiter count
		FilterMatch(driver1);

		// Get Pending Jobs Status for Type of (ALL,NCR,Defect,Note)Jobs
		GetPendingJobs(driver1);

		// Get Completed Jobs Status for Type of (ALL,NCR,Defect,Note)Jobs
		GetCompletedJobs(driver1);

		// Get Reworked Jobs Status for Type of (ALL,NCR,Defect,Note)Jobs
		GetReworkesJobs(driver1);

		// Get Verified Jobs Status for Type of (ALL,NCR,Defect,Note)Jobs
		GetVerifiedJobs(driver1);

		// Get Overdue Jobs Status for Type of (ALL,NCR,Defect,Note)Jobs
		GetOverdueJobs(driver1);

		// Get All Jobs Status for Type of (ALL,NCR,Defect,Note)Jobs
		GetAllJobs(driver1);

		// Get Pending & Completed Jobs Status for Type of (ALL,NCR,Defect,Note)Jobs
		GetPendingCompletedJobs(driver1);

		// Get Pending & Reworked  Jobs Status for Type of (ALL,NCR,Defect,Note)Jobs
		GetPendingReworkedJobs(driver1);

		// Get Pending & Verified Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		GetPendingVerifiedJobs(driver1);
		
				
		// Get Completed & Reworked Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		GetCompletedReworkedJobs(driver1);
		
		// Get Completed & Verified  Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		GetCompletedVerifiedJobs(driver1);
		
		// Get Completed & Overdue  Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		GetCompletedOverdueJobs(driver1);
				
		// Get Reworked & Verified Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		GetReworkedVerifiedJobs(driver1);
		
		// Get Reworked & Overdue  Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		GetReworkedOverdueJobs(driver1);
		
		// Get Verified & Overdue  Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		 GetVerifiedOverdueJobs(driver1);
		 
		// Get Pending, Completed & Reworked Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		 GetPCRJobs(driver1);
				 
		// Get Pending ,Completed & Verified Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		  GetPCVJobs(driver1);
				 
		// Get Pending , Reworked & Verified  Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		  GetPRVJobs(driver1);
		  
		// Get Pending ,Reworked & Overdue  Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		  GetPROJobs(driver1);
		  
		// Get Pending ,Completed ,Reworked & Verified Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		  GetPCRVJobs(driver1);
		  
		// Get Pending , Completed, Reworked & Overdue Jobs Status for Type of(ALL,NCR,Defect,Note)Jobs
		  GetPCROJobs(driver1);
				
		

	}
	
	private void NavigateLocators(WebDriver driver1, ArrayList<Row> GetCompletedJobs)
			throws Exception {

		for (int i = 0; i < GetCompletedJobs.size(); i++) {

			Thread.sleep(k);
			// Get type of element (dropdown, text)
			String strControlTypeKey = GetCompletedJobs.get(i).getCell(10).toString();

			if (strControlTypeKey != null) {

				// Get property of element
				String LocatorName = GetCompletedJobs.get(i).getCell(0).getStringCellValue();

				// Get property of element
				String LocatorType = GetCompletedJobs.get(i).getCell(1).getStringCellValue();

				// Get client ID of the element
				String strControl = GetCompletedJobs.get(i).getCell(2).getStringCellValue();

				// Get Sleep Time
				Long SleepTime = (long) GetCompletedJobs.get(i).getCell(4).getNumericCellValue();

				// Button Click and navigate page

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);
				}

				if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {

					getAttribute(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);

				}
				 
				if (strControlTypeKey.compareTo("Compare_Ctrl1") == 0) {

					A =driver1.findElement(By.xpath(strControl)).getText();
					Thread.sleep(SleepTime);
					System.out.println(A);
				}
				if (strControlTypeKey.compareTo("Compare_Ctrl2") == 0) {

					B = driver1.findElement(By.xpath(strControl)).getText();
					Thread.sleep(SleepTime);
					System.out.println(B);

				}

			}
		}
		if (A.equals(B)) {
			System.out.println("Jobs matches");

		} else {
			System.out.println("Jobs does not matches");
		}
	}
	
	private void FilterMatch(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("1stFilterMatch", 2, 9);
		System.out.println("=========================================================");
		
		// -- set the Element locator
		NavigateLocators(driver1, OR_row);

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row1 = (ArrayList<Row>) OR_tech.searchSheet("2ndFilterMatch", 2, 9);
		System.out.println("=========================================================");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row1);

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row2 = (ArrayList<Row>) OR_tech.searchSheet("3rdFilterMatch", 2, 9);
		System.out.println("=========================================================");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row2);

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row3 = (ArrayList<Row>) OR_tech.searchSheet("4thFilterMatch", 2, 9);
		System.out.println("=========================================================");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row3);

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row4 = (ArrayList<Row>) OR_tech.searchSheet("5thFilterMatch", 2, 9);
		System.out.println("=========================================================");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row4);

	}
		
	private void GetPendingJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("PendingJobs", 2, 9);
		System.out.println("========================================================= \nPending Type:-");
		// -- set the Element locator
		NavigateLocators(driver1, OR_row);

	}

	private void GetCompletedJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("CompletedJobs", 2, 9);

		System.out.println("========================================================= \nCompleted Type:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);

		

	}

	private void GetReworkesJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("ReworkesJobs", 2, 9);

		System.out.println("========================================================= \nReworked Type:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);
		
	}

	private void GetVerifiedJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("VerifiedJobs", 2, 9);

		System.out.println("========================================================= \nVerified Type:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);

	}

	private void GetOverdueJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("OverdueJobs", 2, 9);

		System.out.println("========================================================= \nOverdue Type:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);

	}

	private void GetAllJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("AllJobs", 2, 9);

		System.out.println("========================================================= \nStatus All Type:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);

	}

	private void GetPendingCompletedJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("PendingCompletedJobs", 2, 9);

		System.out.println("========================================================= \nPending & Completed Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);
	}

	private void GetPendingReworkedJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("PendingReworkedJobs", 2, 9);

		System.out.println("========================================================= \nPending & Reworked Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);


	}

	private void GetPendingVerifiedJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("PendingVerifiedJobs", 2, 9);

		System.out.println("========================================================= \nPending & Verified Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);

	}
	
	private void GetCompletedReworkedJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("CompletedReworkedJobs", 2, 9);

		System.out.println("========================================================= \nCompleted & Reworked Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);

	}
	
	private void GetCompletedVerifiedJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("CompletedVerifiedJobs", 2, 9);

		System.out.println("========================================================= \nCompleted & Verified Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);

	}
	
	private void GetCompletedOverdueJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("CompletedOverdueJobs", 2, 9);

		System.out.println("========================================================= \nCompleted & Overdue Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);

	}

	private void GetReworkedVerifiedJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("ReworkedVerifiedJobs", 2, 9);

		System.out.println("========================================================= \nReworked & Verified Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);

	}
	
	private void GetReworkedOverdueJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("ReworkedOverdueJobs", 2, 9);

		System.out.println("========================================================= \nReworked & Overdue Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);
	}
	
	private void GetVerifiedOverdueJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("VerifiedOverdueJobs", 2, 9);

		System.out.println("========================================================= \nVerified & Overdue Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);
	}

	private void GetPCRJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("PCRJobs", 2, 9);

		System.out.println("========================================================= \nPending, Completed, Reworked Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);
	}
	
	private void GetPCVJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("PCVJobs", 2, 9);

		System.out.println("========================================================= \nPending, Completed, Verified Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);
	}
	
	private void GetPRVJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("PRVJobs", 2, 9);

		System.out.println("========================================================= \nPending , Reworked ,Verified Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);
	}
	
	private void GetPROJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("PROJobs", 2, 9);

		System.out.println("========================================================= \nPending , Reworked ,Overdue Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);
	}
	
	private void GetPCRVJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("PCRVJobs", 2, 9);

		System.out.println("========================================================= \nPending, Complete, Reworked, Verified Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);
	}
	
	private void GetPCROJobs(WebDriver driver1) throws Exception {

		// defined TestData Excel in arraylist
		ArrayList<Row> OR_row = (ArrayList<Row>) OR_tech.searchSheet("PCROJobs", 2, 9);

		System.out.println("========================================================= \nPending, Complete, Rework, Overdue Jobs:-");

		// -- set the Element locator
		NavigateLocators(driver1, OR_row);
	}
	
}
