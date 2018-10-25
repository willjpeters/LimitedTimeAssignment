package assessment;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import org.junit.After;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@SuppressWarnings("unused")
public class SeleniumUserTest
{
	
	public WebDriver driver = null;
//	static ExtentReports extent;
//	ExtentTest test;
	
	@Before
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
	driver = new ChromeDriver();
//	extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Assessment - MASTER FILES\\Selenium_Report.html", true);
	}
	
	@Test
	public void AccessSite()
	{
//	test = extent.startTest("Access test (1) initialised");
	driver.get("http://10.0.10.10:4200/petclinic");
	assertEquals(driver.getCurrentUrl(),"http://10.0.10.10:4200/petclinic");
//	test.log(LogStatus.INFO, "Pet clinic web-site accessed successfully");
	}
	
	@Test
	public void navigateToUsers()
	{
	driver.get("http://10.0.10.10:4200/petclinic");
	driver.findElement(By.linkText("Owners")).click();
//	SeleniumPOM POM1 = PageFactory.initElements(driver, SeleniumPOM.class);
//	POM1.moveAndClickOwners(driver);
//	WebElement myDynamicElement = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a")));
//	POM1.moveAndClickAddUsers(driver);
		    
//	String URL = driver.getCurrentUrl();
	//report the test as a pass
//  if(URL.equals("http://www.practiceselenium.com/menu.html"))
//	{
//	test.log(LogStatus.PASS, "Successfully taken to menu page");
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Unsuccessful: navigation to menu page");
//	}
//	extent.endTest(test);
	}
	
	@Test
	public void enterDetails()
	{
	driver.get("http://10.0.10.10:4200/petclinic/owners/add");
	}
	
	
	@After
	public void teardown()
	{
		driver.quit();
	}
}
