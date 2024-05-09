package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(xpath="//*[@name='username']")
	private WebElement enterusername;
	
	@FindBy(xpath="//*[@name='password']")
	private WebElement enterpassword;
	
	@FindBy(xpath="//*[text()='Login']")
	private WebElement loginbutton;
	
	
	
	public void enterusername() {
		enterusername.sendKeys("prexo.mis@dealsdray.com");;
	}
	
	public void enterpassword() {
		enterpassword.sendKeys("prexo.mis@dealsdray.com");
	}
	
	public void loginbutton() {
		loginbutton.click();
	}
	

}
