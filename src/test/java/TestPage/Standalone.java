package TestPage;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import testcomponent.BaseTest;

import java.time.Duration;


import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CheckoutPage;
import pages.LandingPage;
import pages.ProductList;

public class Standalone {
WebDriver Driver;
WebDriver driver= new ChromeDriver();


	
		@Test
		
		public void Executetest()
		{
		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		//LandingPage
		LandingPage Landingobj=new LandingPage(driver);
		Landingobj.Url();
		Landingobj.Login("charubirla", "charu123");
		
		//ProductList
		driver.navigate().refresh();
		ProductList ProductListobj = new ProductList(driver);
		ProductListobj.clickPhonesCategory();
		System.out.println("Total Products Found: " + ProductListobj.getProductCount());
		ProductListobj.printProductImages();
		
		//Addto cartand Checkoutpage
		
		CheckoutPage checkout = new CheckoutPage(driver);
        checkout.addToCart();
        checkout.goToCart();
        checkout.placeOrder();
        checkout.fillCheckoutForm("Charu Birla", "India", "Udaipur-67572", "908723456", "05", "2028");
        checkout.purchaseOrder();
        System.out.println("Text on Page: " + checkout.getPurchaseButtonText()); 
		}    
	

}
