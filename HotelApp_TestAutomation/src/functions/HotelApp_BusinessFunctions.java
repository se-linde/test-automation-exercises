package functions;

import java.util.Properties; 
import jxl.*; 
import jxl.read.biff.BiffException;
import java.io.File; 
import java.io.FileInputStream;
import java.util.List;
import java.util.Locale; 

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelApp_BusinessFunctions {
	
	public static Properties prop; 
	public static WebDriver driver; 
	public static String baseUrl;
	public boolean acceptNextAlert = true; 
	
	public void HA_BF_Login (WebDriver driver, String sUserName, String sPassword) {
		
	    driver.findElement(By.id(prop.getProperty("Txt_Login_Username"))).click();
	    driver.findElement(By.id(prop.getProperty("Txt_Login_Username"))).sendKeys("kashtin1");  
	    
	    driver.findElement(By.cssSelector("tr:nth-child(6) > td:nth-child(1)")).click();

	    
	    driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).click();
	    driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).sendKeys("kashtin1");
	    
	    driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(1)")).click();

	    
	    driver.findElement(By.id(prop.getProperty("Btn_Login_login"))).click();
		
	}
	
	
	// Function to read from the Excel .xls file: 
	
	public static String HA_GF_readXL (int row, String column, String strFilepath) {
		
		Cell c = null; 
		int reqCol = 0; 
		WorkbookSettings ws = null; 
		Workbook workbook = null; 
		Sheet sheet = null; 
		FileInputStream fs = null; 
		
		// Try-catch block 
	try {
		fs = new FileInputStream(new File(strFilepath)); 
		ws = new WorkbookSettings(); 
		ws.setLocale(new Locale("en", "EN"));
	
		// Opening the workbook and sheet for reading data. 
		workbook = Workbook.getWorkbook(fs, ws); 
		sheet = workbook.getSheet(0); 
		
		// Sanitize the given data
		String col = column.trim(); 
		
		// Loop for going through the given row 
		for (int j=0; j<sheet.getColumns(); j++) {
			Cell cell = sheet.getCell(j, 0); 
			if(cell.getContents().trim().equalsIgnoreCase(col)) 
			{
				
				reqCol = cell.getColumn(); 
				// System.out.println("Column No.: " + reqCol); 
				
				c = sheet.getCell(reqCol, row); 
				fs.close(); 
				return c.getContents(); 
			}
		}
			
			
	}
		
	catch(BiffException be) 
	{
		Log(be.getMessage().toString()); 
		System.out.println("The given file should have an .xls extention."); 
	}
		
	catch(Exception e) 
	{
		e.printStackTrace();
		Log(e.getMessage().toString());
	}
		

		Log("NO MATCH FOUND IN GIVEN FILE: PROBLEM IS COMING FROM INSIDE THE FILE."); 
	
		// Mandatory return statement. 
		return null; 
	}


	// To make Log happy. 
	private static void Log(String string) {
		// TODO Auto-generated method stub
		
	}

	// Function to read from multiple rows in an Excel spreadsheet. 
	
	public static int HA_GF_XLRowCount (String strFilePath, String sColumn) {
		
		int k; 
		
		for (k = 1; k < 999; k++) {
			
			String sParamVal = HA_GF_readXL(k, sColumn, strFilePath); 
			
				if (sParamVal.equals("ENDOFROW"))
			{
					break; 
			}
		}
		
		return k; 
	}
	
	//Function to dynamically wait for element presence
	
		public void HA_GF_WaitForElementPresent(WebDriver driver , By by, int iTimeOut) throws InterruptedException
		{
			int iTotal = 0;
			int iSleepTime = 5000;
			while(iTotal < iTimeOut)
			{
				List<WebElement> oWebElements = driver.findElements(by);
				if(oWebElements.size()>0)
					return;
				else
				{
					
						Thread.sleep(iSleepTime);
						iTotal = iTotal + iSleepTime;
						System.out.println(String.format("Waited for %d milliseconds.[%s]", iTotal, by));          
					
					
				}
			}
		}
	

}
