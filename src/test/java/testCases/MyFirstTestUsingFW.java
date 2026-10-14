package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadExcelData;

public class MyFirstTestUsingFW extends BaseTest {

	@Test(dataProviderClass = ReadExcelData.class ,dataProvider="logindata")
	public static void Login(String username, String password) throws InterruptedException {

		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("email_field")))).sendKeys(username);
		
		driver.findElement(By.id(loc.getProperty("next_btn"))).click();
		driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath(loc.getProperty("login_next_btn"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(loc.getProperty("CRM_link"))).click(); 
		
		Thread.sleep(5000);
		
		String CRMHomeExpected = "Welcome guddetivikram";
		WebElement CRMHome = driver.findElement(By.xpath(loc.getProperty("CRM_home_text")));
		String CRMHomeActual = CRMHome.getText();
		
		Assert.assertEquals(CRMHomeActual, CRMHomeExpected);
		
		
	}
//	@DataProvider(name="test1")
//	public Object[][] testdata(){
//		return new Object[][] {
//			{"vikramguddetii@gmail.com", "Vicky@060"},
//			{"guddetivikram@gmail.com", "Vicky@060"}
//		};
//	}

}
