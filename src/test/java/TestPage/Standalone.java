package TestPage;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import testcomponent.BaseTest;
import utils.ConfigReader;
import utils.Reportclass;

import java.time.Duration;


import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CheckoutPage;
import pages.LandingPage;
import pages.ProductList;

public class Standalone extends BaseTest {

	ExtentReports extent = Reportclass.getReportInstance(); 
    ExtentTest test;  

		@Test
		public void Executetest()
		{
		
		try {
			test = extent.createTest("Standalone E2E Test");  // Start test log
		
		//LandingPage
		Properties prop = ConfigReader.readprop();
		String username = prop.getProperty("user");
		String password = prop.getProperty("pass");
		LandingPage Landingobj=new LandingPage(driver);
		Landingobj.Url();
		Landingobj.Login(username, password);
		
		//ProductList
		driver.navigate().refresh();
		ProductList ProductListobj = new ProductList(driver);
		ProductListobj.clickPhonesCategory();
		System.out.println("Total Products Found: " + ProductListobj.getProductCount());
		ProductListobj.printProductImages();
		
		//Addto cartand Checkoutpage
		String name = prop.getProperty("name");
		String country = prop.getProperty("country");
		String city = prop.getProperty("city");
		String card = prop.getProperty("card");
		String month = prop.getProperty("month");
		String year = prop.getProperty("year");
		
		CheckoutPage checkout = new CheckoutPage(driver);
        checkout.addToCart();
        checkout.goToCart();
        checkout.placeOrder();
        checkout.fillCheckoutForm(name,country,city,card,month,year);
        checkout.purchaseOrder();
        System.out.println("Text on Page: " + checkout.getPurchaseButtonText()); 
        test.pass("Order placed successfully");
        test.info("Purchase button text: " + checkout.getPurchaseButtonText());
        
		}catch(Exception e) {
			test.fail("Test failed due to exception: " + e.getMessage());
			
		}finally {
            extent.flush(); // ✅ Save the report
        }
		
	}
	

}
