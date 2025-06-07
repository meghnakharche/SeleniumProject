package FrameworkProject.CustomizedFramework.Testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	public WebDriver driver;
	
	public void initializeDriver() throws Exception {
		
		//properties class
		Properties pro= new Properties();
		FileInputStream Fi= new FileInputStream("C:\\Users\\user\\eclipse-workspace\\CustomizedFramework\\src\\main\\java\\FrameworkProject\\CustomizedFramework\\resources\\Globaldata.properties");
		pro.load(Fi);
		String browserName=pro.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			
			WebDriver driver= new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			
			WebDriver driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			
			WebDriver driver= new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	
}
}