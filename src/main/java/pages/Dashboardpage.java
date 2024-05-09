package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboardpage {

	WebDriver driver;
	Actions action;

	public Dashboardpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//strong[text()='PREXO-MIS-ADMIN']")
	private WebElement verifylogintext;

	@FindBy(xpath = "//div[@class='css-sukebr']/button")
	private WebElement orderdropdown;

	

	public WebElement verifylogintext() {
		return verifylogintext;
	}

	public void orderdropdown() {
		orderdropdown.click();
	}

	
	
}
