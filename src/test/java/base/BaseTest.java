package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	
	@BeforeMethod
	public void setUp() throws IOException {
		if (driver==null ) {
		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\java\\resources\\configfiles\\config.properties");
		FileReader fr1 = new FileReader(System.getProperty("user.dir") + "\\src\\java\\resources\\configfiles\\locators.properties");
		prop.load(fr);
		loc.load(fr1);
		
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(prop.getProperty("testUrl"));
			driver.manage().window().maximize();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testUrl"));
			driver.manage().window().maximize();
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
