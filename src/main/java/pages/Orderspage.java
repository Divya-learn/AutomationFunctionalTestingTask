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

public class Orderspage {

	WebDriver driver;
	Actions action;

	public Orderspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//span[text()='Orders']")
	private WebElement orderbutton;

	@FindBy(xpath = "//*[@class='MuiBox-root css-0']/button")
	private WebElement addbulkorderbutton;

	@FindBy(xpath = "//*[contains(@class,'css-i44wyl')]")
	private WebElement chooseFilebutton;

	@FindBy(xpath = "//*[@class='MuiBox-root css-1xi4464']//button")
	private WebElement Importbutton;

	@FindBy(xpath = "//*[text()='Validate Data']")
	private WebElement validatedata;
	
	@FindBy(xpath = "//*[text()='Submit']")
	private WebElement submitbutton;
	
	
	public void orderbutton() {
		orderbutton.click();
	}

	public void addbulkorderbutton() {
		addbulkorderbutton.click();
	}

	public void chooseFilebutton() {
		action = new Actions(driver);

		action.moveToElement(chooseFilebutton).click().perform();

		try {

			ProcessBuilder processBuilder = new ProcessBuilder("C:\\autoitfiles\\fileupload.exe",
					"C:\\Users\\ADMIN\\Downloads\\demo-data.xlsx");
			Process process = processBuilder.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebElement getImportbutton() {

		return Importbutton;
	}

	public void validatedata() {
		validatedata.click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public WebElement submitbutton() {
		return submitbutton;
	}
}
