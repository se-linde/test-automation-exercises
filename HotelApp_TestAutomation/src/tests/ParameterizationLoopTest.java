package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

// import org.apache.bcel.generic.Select;

import org.openqa.selenium.support.ui.Select;
import org.junit.After;
import org.junit.Before;
// Generated by Selenium IDE
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import functions.HotelApp_BusinessFunctions;



// extend the existing test case, to inherit functions from our function library file HotelApp...
public class ParameterizationLoopTest extends HotelApp_BusinessFunctions {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  private boolean acceptNextAlert = true; 
  public static String sAppURL; 
  public static String sSharedUIMapPath; 
  public static String sBones; 
  
  
  @Before
  public void setUp() {
  
	// New code, for a shared UI map. 
	prop = new Properties(); 
	
	// New code for the ConfigFileTest. 

	
	
	try {
		prop.load(new FileInputStream("./Configuration/HA_Configuration.properties"));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	try {
		prop.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	
	
	
	sAppURL = prop.getProperty("AppURL"); 
	sSharedUIMapPath = prop.getProperty("SharedUIMap"); 
	sBones = prop.getProperty("Bones");
	
	System.out.print("Hello sAppURL: " + sAppURL); // returning NULL. 
	System.out.print(" Hello sSharedUIMapPath: " + sSharedUIMapPath); // returning a value  
	System.out.print("Hello sBones: " + sBones); // returning NULL. 
	
	
	try {
		prop.load(new FileInputStream(sSharedUIMapPath));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	System.out.print("Hello sAppURL: " + sAppURL); // returning NULL. 
	System.out.print(" Hello sSharedUIMapPath: " + sSharedUIMapPath); // returning a value  
	
	// End of the shared UI map code 
	  
	  
	  
	driver = new FirefoxDriver();
	baseUrl = "http://www.adactin.com/";  
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  
  // Here, we replace all the variables with mapping from haredUIMap.properties. 
  
  public void chap6test1() {
    // Test name: chap6test1
    // Step # | name | target | value | comment
    // 1 | open | /HotelApp/ |  | 
    // driver.get(baseUrl + "/HotelApp/");
    
	System.out.print("Hello sAppURL: " + sAppURL); // returning NULL. 
	System.out.print(" Hello sSharedUIMapPath: " + sSharedUIMapPath); // returning a value  
	
    driver.get(sAppURL);
    
    // For the loop. 
    
    int Xlcount = HA_GF_XLRowCount("./DataPool/HA_HotelSearch.xls", "Location");
     
    driver.manage().window().setSize(new Dimension(1088, 788));

    // Now, looping the function call. 
    
    for (int i=1; i<Xlcount; i++)
    {
    // START LOOP 
    
    
    // The Function Call: 
    
    HA_BF_Login(driver, "kashtin1", "kashtin1"); 
    
    // End of Function Editing and Function Call. 

    // Reading from the Excel .xls file. 

    String strFile = "./DataPool/HA_HotelSearch.xls"; 
    String strLocation = HA_GF_readXL(1, "Location", strFile);

    // For the looping through the Excel document. 
    String sLocation = HA_GF_readXL(i, "Location", "./DataPool/HA_HotelSearch.xls");
    
    // End of reading from Excel .xls file. 
    
    // 10 | click | id=username_show |  | 
    driver.findElement(By.id(prop.getProperty("Txt_Login_Username_Show"))).click();
    // 11 | mouseDownAt | css=#location > option:nth-child(2) | -158,-251.5833282470703 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#location > option:nth-child(2)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    // 12 | mouseMoveAt | css=#location > option:nth-child(2) | -158,-251.5833282470703 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#location > option:nth-child(2)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 13 | mouseUpAt | css=#location > option:nth-child(2) | -158,-251.5833282470703 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#location > option:nth-child(2)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    // 14 | select | id=location | label=Sydney | 
    {
      //WebElement dropdown = driver.findElement(By.id("location"));
      //new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Location")))).selectByVisibleText(strLocation);

      // This is where we try to loop through all of the entries in the spreadsheet. 
      
      new Select(driver.findElement(By.id("location"))).selectByVisibleText(sLocation);
      
    }
    // 15 | click | css=#location > option:nth-child(2) |  | 
    driver.findElement(By.cssSelector("#location > option:nth-child(2)")).click();
    // 16 | mouseDownAt | css=#room_nos > option:nth-child(3) | -158,-338.58331298828125 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#room_nos > option:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    // 17 | mouseMoveAt | css=#room_nos > option:nth-child(3) | -158,-338.58331298828125 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#room_nos > option:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 18 | mouseUpAt | css=#room_nos > option:nth-child(3) | -158,-338.58331298828125 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#room_nos > option:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    // 19 | select | id=room_nos | label=2 - Two | 
    {
      WebElement dropdown = driver.findElement(By.id("room_nos"));
      dropdown.findElement(By.xpath("//option[. = '2 - Two']")).click();
      
      // dropdown.findElement(By.xpath("//option[. = '2 - Two']")).click();
      
    }
    // 20 | click | css=#room_nos > option:nth-child(3) |  | 
    driver.findElement(By.cssSelector("#room_nos > option:nth-child(3)")).click();
    // 21 | mouseDownAt | css=#adult_room > option:nth-child(3) | -158,-441.58331298828125 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#adult_room > option:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    // 22 | mouseMoveAt | css=#adult_room > option:nth-child(3) | -158,-441.58331298828125 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#adult_room > option:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 23 | mouseUpAt | css=#adult_room > option:nth-child(3) | -158,-441.58331298828125 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#adult_room > option:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    // 24 | select | id=adult_room | label=2 - Two | 
    {
      WebElement dropdown = driver.findElement(By.id("adult_room"));
      dropdown.findElement(By.xpath("//option[. = '2 - Two']")).click();
    }
    // 25 | click | css=#adult_room > option:nth-child(3) |  | 
    driver.findElement(By.cssSelector("#adult_room > option:nth-child(3)")).click();
    // 26 | click | id=Submit |  | 
    driver.findElement(By.id("Submit")).click();
    //driver.findElement(By.id(prop.getProperty("Btn_SearchHotel_Search"))).click();
    
  //driver.findElement(By.id(prop.getProperty("Btn_SearchHotel_Search"))).click();
    
    
    // 27 | click | id=radiobutton_2 |  | 
    driver.findElement(By.id(prop.getProperty("Rad_SelectHotel_RadioButton_1"))).click(); // Rad_SelectHotel_RadioButton_1
    // 28 | click | id=continue |  | 
    driver.findElement(By.id(prop.getProperty("Btn_SelectHotel_continue"))).click(); // Btn_SelectHotel_continue
    // 29 | click | id=first_name |  | 
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_FirstName"))).click(); // Txt_BookingHotel_FirstName
    // 30 | type | id=first_name | test | 
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_FirstName"))).sendKeys("test"); // Txt_BookingHotel_FirstName
    // 31 | type | id=last_name | test | 
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_LastName"))).sendKeys("test"); // Txt_BookingHotel_LastName
    // 32 | type | id=address | 1 test ave. \nTestville Queensland | 
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_Address"))).sendKeys("1 test ave. \nTestville Queensland"); // Txt_BookingHotel_Address=address

    // 33 | click | id=cc_num |  | 
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCNumber"))).click(); // Txt_BookingHotel_CCNumber
    // 34 | type | id=cc_num | 1111111111111111 | 
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCNumber"))).sendKeys("1111111111111111");
    
    
    // Continue filling out/changing the form here.  
    
    // 35 | mouseDownAt | css=#cc_type > option:nth-child(1) | -158,-507.5 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#cc_type > option:nth-child(1)"));
      Actions builder = new Actions(driver);
      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
      
      builder.moveToElement(element).clickAndHold().perform();
      
    }
    // 36 | mouseMoveAt | css=#cc_type > option:nth-child(1) | -158,-507.5 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#cc_type > option:nth-child(1)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 37 | mouseUpAt | css=#cc_type > option:nth-child(1) | -158,-507.5 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#cc_type > option:nth-child(1)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    // 38 | click | css=#cc_type > option:nth-child(1) |  | 
    driver.findElement(By.cssSelector("#cc_type > option:nth-child(1)")).click();
    // 39 | mouseDownAt | css=#cc_type > option:nth-child(2) | -158,-507.5 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#cc_type > option:nth-child(2)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    // 40 | mouseMoveAt | css=#cc_type > option:nth-child(2) | -158,-507.5 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#cc_type > option:nth-child(2)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 41 | mouseUpAt | css=#cc_type > option:nth-child(2) | -158,-507.5 | 
    {
      WebElement element = driver.findElement(By.cssSelector("#cc_type > option:nth-child(2)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    // 42 | select | id=cc_type | label=American Express | 
    {
      // WebElement dropdown = driver.findElement(By.id("cc_type"));

      WebElement dropdown = driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCType"))); // Txt_BookingHotel_CCType

      dropdown.findElement(By.xpath("//option[. = 'American Express']")).click();
    }
    // 43 | click | css=#cc_type > option:nth-child(2) |  | 
    driver.findElement(By.cssSelector("#cc_type > option:nth-child(2)")).click();
    // 44 | click | css=tr:nth-child(18) > td:nth-child(2) |  | 
    driver.findElement(By.cssSelector("tr:nth-child(18) > td:nth-child(2)")).click();
    // 45 | click | id=cc_exp_month |  | 
    
    // driver.findElement(By.id("cc_exp_month")).click();  
    
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCExpMonth"))).click();  // Txt_BookingHotel_CCExpMonth

    // 46 | select | id=cc_exp_month | label=December | 
    {
      WebElement dropdown = driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCType"))); // Txt_BookingHotel_CCType
      dropdown.findElement(By.xpath("//option[. = 'December']")).click();
    }
    // 47 | click | css=#cc_exp_month > option:nth-child(13) |  | 
    driver.findElement(By.cssSelector("#cc_exp_month > option:nth-child(13)")).click();
    // 48 | click | id=cc_exp_year |  | 
    
    // driver.findElement(By.id("cc_exp_year")).click();

    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCExpYear"))).click(); //Txt_BookingHotel_CCExpYear

    
    // 49 | select | id=cc_exp_year | label=2022 | 
    {
      // WebElement dropdown = driver.findElement(By.id("cc_exp_year"));

      WebElement dropdown = driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCExpYear"))); //Txt_BookingHotel_CCExpYear

      
      dropdown.findElement(By.xpath("//option[. = '2022']")).click();
    }
    // 50 | click | css=#cc_exp_year > option:nth-child(13) |  | 
    driver.findElement(By.cssSelector("#cc_exp_year > option:nth-child(13)")).click();
    // 51 | click | id=cc_cvv |  | 
    
    // driver.findElement(By.id("cc_cvv")).click();
    
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCCvvNumber"))).click(); // Txt_BookingHotel_CCCvvNumber

    
    // 52 | type | id=cc_cvv | 111 | 
    
    // driver.findElement(By.id("cc_cvv")).sendKeys("111");
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCCvvNumber"))).sendKeys("111"); //Txt_BookingHotel_CCCvvNumber

    
    // 53 | click | id=book_now |  | 
    
    // driver.findElement(By.id("book_now")).click();
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_BookNow"))).click(); // Txt_BookingHotel_BookNow

    
    
    // 54 | click | linkText=Logout |  | 
    
    // driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.linkText(prop.getProperty("Txt_BookingHotel_Logout"))).click(); // Txt_BookingHotel_Logout

    // 55 | click | linkText=Log back in again |  | 
    
    driver.findElement(By.linkText("Click here to login again")).click();
    
    // Sleep so that the test can 'catch up' with itself. 
    
    try {
    	// In milliseconds
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  // END LOOP
  
}
  
/* private Actions withAction() {
	// TODO Auto-generated method stub
	return null;
} */ 
}
