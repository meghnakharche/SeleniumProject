package testcomponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	public WebDriver driver;
	
	@BeforeEach
	public void initializeDriver() throws Exception {
		
		//properties class
		Properties pro= new Properties();
		FileInputStream Fi= new FileInputStream("src/main/java/utils/Globaldata.properties");
		pro.load(Fi);
		String browserName=pro.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			
			 driver= new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			
			 driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			
			 driver= new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
		
		@AfterEach
		public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
		
	
}
}