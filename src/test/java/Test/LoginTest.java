package Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Dashboardpage;
import pages.Loginpage;
import pages.Orderspage;
import resources.BaseTest;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class LoginTest extends BaseTest{
	
	public WebDriver driver;
	public Loginpage loginpage;
	public Dashboardpage dashboardpage;

	@BeforeTest
	public void openbrowser() {
		driver = initializedriver();
		driver.get("https://demo.dealsdray.com/");
	}
	
	
	@Test(priority=1)
	public void login() {
		
		loginpage = new Loginpage(driver);
		loginpage.enterusername();
		loginpage.enterpassword();
		loginpage.loginbutton();
		
		dashboardpage = new Dashboardpage(driver);
		String text = dashboardpage.verifylogintext().getText();
		Assert.assertEquals("PREXO-MIS-ADMIN",text);
		 
	}
	
	@Test(priority=2)
	public void validatedata() {
	
		dashboardpage.orderdropdown();
		Orderspage Opage = new Orderspage(driver);
		Opage.orderbutton();
		Opage.addbulkorderbutton();
		Opage.chooseFilebutton();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   try {
	        wait.until(ExpectedConditions.invisibilityOf(Opage.getImportbutton()));
	        
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    Opage.getImportbutton().click();
	    Opage.validatedata();
	   
	    wait.until(ExpectedConditions.elementToBeClickable(Opage.submitbutton()));
	
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		    try {
		       
		        FileUtils.copyFile(screenshot, new File("Screenshot.png"));
		        System.out.println("Full page screenshot saved successfully.");
		    } catch (Exception e) {
		        System.out.println("Error while saving full page screenshot: " + e.getMessage());
		    }
	    
	    
	}
	
	
	@AfterTest
	public void closebrowser() {
		driver.quit();
	}
	
	
}


