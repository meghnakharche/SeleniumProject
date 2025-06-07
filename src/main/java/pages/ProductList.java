package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductList {
	
	WebDriver driver;
	WebDriverWait wait;

	public ProductList(	WebDriver driver)
	{
	//initialization
	//Assigning driver from standalone class to local var driver
	this.driver=driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize explicit wait
    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='itemc' and contains(@class, 'list-group-item') and text()='Phones']")
	WebElement phonesCategory;
	
	@FindBy(css = "img.card-img-top.img-fluid")
    List<WebElement> Listofproducts;
	
	public void clickPhonesCategory() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(phonesCategory)).click();
    }
	
	public int getProductCount() 
	{
        return Listofproducts.size();
    }
	
	public void printProductImages() 
	{
        for (WebElement product : Listofproducts) {
            System.out.println("Phone: Product Image URL: " + product.getAttribute("src"));
        }
	}
	
}
