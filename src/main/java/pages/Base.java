package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;

public class Base {

    private WebDriver driver;
    private Properties prop;

    private LandingPage landingPage;
    private ProductList productList;
    private CheckoutPage checkoutPage;

    public void initializeDriver() throws Exception {
        // Load configuration
        prop = new Properties();
        FileInputStream fis = new FileInputStream("Globaldata.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } 
        else if(browserName.equalsIgnoreCase("firefox"))
		{
			
			WebDriver driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			
			WebDriver driver= new EdgeDriver();
		}
        else {
            throw new RuntimeException("Browser not supported: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
}

