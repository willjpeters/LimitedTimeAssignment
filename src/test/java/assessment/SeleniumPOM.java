package assessment;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("unused")
public class SeleniumPOM
{

	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	private WebElement OwnersBTN;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a/span[2]")
	private WebElement AddNewBTN;
	
	public void moveAndClickOwners(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(OwnersBTN).click().perform();
	}
	
	public void moveAndClickAddUsers(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(AddNewBTN).click().perform();
	}
}
