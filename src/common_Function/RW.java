
package common_Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RW {
	public String A="";
	public String B="";
	protected int k = 3000;

	public static String path = "C:\\Users\\Priti\\workspace\\Worklist_Jobs\\";

	public ExcelRead jibe_config = new ExcelRead(path.concat("Excel\\Jibe_Config.xlsx"));

	public ExcelRead OR_tech = new ExcelRead(path.concat("Excel\\OR_WorklistJob.xlsx"));

	public ExcelRead input_tech = new ExcelRead(path.concat("Excel\\WorklistJob_Input.xlsx"));

	public WriteExcel write_data = new WriteExcel(path.concat("Excel\\WorklistJob_Input.xlsx"));

	public String url = jibe_config.getData(0, 1, 1);

	// All Kyeword

	public static String click_element(WebDriver driver, String locatorType, String locatorvalue) throws Exception

	{
		Boolean locatorvalue_enabled = driver.findElement(By.id(locatorvalue)).isEnabled();
		if (locatorvalue_enabled == true) {

			switch (locatorType) {

			case "id":
				driver.findElement(By.id(locatorvalue)).click();
				break;

			case "name":
				driver.findElement(By.name(locatorvalue)).click();
				break;

			case "xpath":
				driver.findElement(By.xpath(locatorvalue)).click();
				break;

			case "linkText":
				driver.findElement(By.linkText(locatorvalue)).click();
				break;

			}
		}
		return null;

	}

	public static String sendkeys(WebDriver driver, String locatorType, String locatorvalue, String pamarValue)
			throws Exception

	{
		Boolean locatorvalue_enabled = driver.findElement(By.id(locatorvalue)).isEnabled();
		if (locatorvalue_enabled == true) {
			switch (locatorType) {

			case "id":
				driver.findElement(By.id(locatorvalue)).sendKeys(pamarValue);
				break;

			case "name":
				driver.findElement(By.name(locatorvalue)).sendKeys(pamarValue);
				break;

			case "xpath":
				driver.findElement(By.xpath(locatorvalue)).sendKeys(pamarValue);
				break;

			case "linkText":
				driver.findElement(By.linkText(locatorvalue)).sendKeys(pamarValue);
				break;

			}
		}
		return null;

	}

	public static String clear_element(WebDriver driver, String locatorType, String locatorvalue) throws Exception

	{
		Boolean locatorvalue_enabled = driver.findElement(By.id(locatorvalue)).isEnabled();
		if (locatorvalue_enabled == true) {
			switch (locatorType) {

			case "id":
				driver.findElement(By.id(locatorvalue)).clear();
				break;

			case "name":
				driver.findElement(By.name(locatorvalue)).clear();
				break;

			case "xpath":
				driver.findElement(By.xpath(locatorvalue)).clear();
				break;

			case "linkText":
				driver.findElement(By.linkText(locatorvalue)).clear();
				break;

			}
		}
		return null;

	}

	public static String frameSwitchto(WebDriver driver, String locatorType, String locatorvalue) throws Exception

	{
		WebElement iframe = driver.findElement(By.id(locatorvalue));
		switch (locatorType) {

		case "id":

			driver.switchTo().frame(iframe);

			break;

		case "name":

			driver.switchTo().frame(iframe);
			break;

		case "xpath":
			driver.switchTo().frame(iframe);
			break;

		case "linkText":
			driver.switchTo().frame(iframe);
			break;

		case "cssSelector":
			driver.switchTo().frame(iframe);
			break;

		}

		return null;

	}

	public static String getAttribute(WebDriver driver, String locatorType, String locatorvalue) throws Exception

	{
		String Value="" ;
		switch (locatorType) {

		case "id":

			Value = driver.findElement(By.id(locatorvalue)).getText();
			System.out.println(Value);
			break;

		case "name":

			Value = driver.findElement(By.name(locatorvalue)).getText();
			System.out.println(Value);
			break;

		case "xpath":

			Value = driver.findElement(By.xpath(locatorvalue)).getText();
			System.out.println(Value);
			break;

		case "linkText":

			Value = driver.findElement(By.linkText(locatorvalue)).getText();
			System.out.println(Value);

			break;

		}

		return null;

	}

	public static String dropdownIndex(WebDriver driver, String locatorType, String locatorvalue, String pamarValue)
			throws Exception

	{
		

		switch (locatorType) {

		case "id":
			Select dropdown = new Select(driver.findElement(By.id(locatorvalue)));
			dropdown.selectByValue(pamarValue);

		case "name":
			Select dropdown1 = new Select(driver.findElement(By.id(locatorvalue)));
			dropdown1.selectByValue(pamarValue);
			break;

		case "xpath":
			Select dropdown2 = new Select(driver.findElement(By.id(locatorvalue)));
			dropdown2.selectByValue(pamarValue);
			break;

		case "linkText":
			Select dropdown3 = new Select(driver.findElement(By.id(locatorvalue)));
			dropdown3.selectByValue(pamarValue);
			break;
		}

		return null;

	}

	public static String frameSwitchBack(WebDriver driver) throws Exception

	{

		driver.switchTo().defaultContent();

		return null;

	}
	
	public static String WindowSwitchto(WebDriver driver) throws Exception

	{
		for (String handle : driver.getWindowHandles()) { // Switch to new
															// window
			driver.switchTo().window(handle);
		}
		return null;
	}

	public static String SwitchtoParent(WebDriver driver) throws Exception

	{
		String HandleBefore = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) { // Switch to new
															// window
			driver.switchTo().window(handle);
		}
		driver.switchTo().window(HandleBefore);
		return null;
	}

	public static String Alert_accept(WebDriver driver) throws Exception

	{ // Alert of "Alert"
		Alert alert = driver.switchTo().alert();
		// To read the text from alert
		String Alert = alert.getText();
		System.out.println(" alert :" + Alert);
		alert.accept();
		return null;
	}

	public static String Alert_Dismiss(WebDriver driver) throws Exception

	{// Alert of "Alert"
		Alert alert = driver.switchTo().alert();
		// To read the text from alert
		String Alert = alert.getText();
		System.out.println(" alert :" + Alert);
		alert.dismiss();
		return null;
	}

	public static String refresh(WebDriver driver) throws Exception {

		driver.navigate().refresh();
		return null;

	}

	public static void close_driver(WebDriver driver)

	{
		driver.close();

	}
	public static String gettext(WebDriver driver, String locatorType, String locatorvalue,  String pamarValue) throws Exception
	 
	 {
	 
	  switch(locatorType)
	   {

	   case "id":  	        
	         driver.findElement(By.id(locatorvalue)).getText(); 	        
	          break;

	   case "name":
		   
		     driver.findElement(By.name(locatorvalue)).getText();
	         break;

	   case "xpath":
		    
		    driver.findElement(By.xpath(locatorvalue)).getText();    		 
	         break;
	         
	   case "linkText":
		   
		   driver.findElement(By.linkText(locatorvalue)).getText();
	         break;

	   }	    
	   return null;

	

	  
	 }
	

}