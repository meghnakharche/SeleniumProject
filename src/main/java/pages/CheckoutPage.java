package pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize explicit wait
        PageFactory.initElements(driver, this);
    }
	
	// Click on product 
	 @FindBy(xpath="//img[@src='imgs/Lumia_1520.jpg']")
	 WebElement Producttoaddcart;

	 // "Add to Cart" button
    @FindBy(css = "a[onclick*='addToCart']")
     WebElement addToCartButton;

    // "Cart" link
    @FindBy(xpath = "//a[text()='Cart']")
     WebElement cartLink;

    // "Place Order" button
    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement placeOrderButton;

    // input fields
    @FindBy(id = "name")  WebElement nameField;
    @FindBy(id = "country")  WebElement countryField;
    @FindBy(id = "city")  WebElement cityField;
    @FindBy(id = "card")  WebElement cardField;
    @FindBy(id = "month")  WebElement monthField;
    @FindBy(id = "year")  WebElement yearField;

    // "Purchase" button
    @FindBy(xpath = "//button[@type='button' and contains(@class, 'btn-primary') and contains(@onclick, 'purchaseOrder()')]")
     WebElement purchaseButton;


    // Click "Add to Cart" and Navigate Back
    public void addToCart() {
    	
    	Producttoaddcart.click();
    	System.out.println(Producttoaddcart);
    
    	/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();*/
    	addToCartButton.click();
        driver.navigate().back();
        System.out.println("Added to Cart");
    }

    // Click "Cart"
    public void goToCart() {
        cartLink.click();
    }

    // Click "Place Order"
    public void placeOrder() {
        placeOrderButton.click();
    }

    // Fill Checkout Form
    public void fillCheckoutForm(String name, String country, String city, String card, String month, String year) {
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        cardField.sendKeys(card);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }

    // Click "Purchase"
    public void purchaseOrder() {
        purchaseButton.click();
        System.out.println("Order placed successfully");
    }

    // Get Button Text (e.g., Purchase button text)
    public String getPurchaseButtonText() {
        return purchaseButton.getText();
    }
}

