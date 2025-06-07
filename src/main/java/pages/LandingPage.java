package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	
public LandingPage(	WebDriver driver)
	{
	//initialization
	//Assigning driver from standalone class to local var driver
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	//PageFActory
	@FindBy(id="login2")
	WebElement Loginpage;
	@FindBy(id="loginusername")
	WebElement Username;
	@FindBy(id="loginpassword")
	WebElement Password;
	@FindBy(xpath="//button[@type='button' and @onclick='logIn()' and contains(@class, 'btn-primary') and text()='Log in']")
	WebElement ClickLogin;
	
	public void Login(String User,String Pwd)
	
	{
		Loginpage.click();
		Username.sendKeys(User);
		Password.sendKeys(Pwd);
		ClickLogin.click();
	}
	
	public void Url()
	{
		driver.get("https://www.demoblaze.com/");
		System.out.println(driver.getTitle());
	}

//WebElement Loginpage= driver.findElement(By.id("login2")).click();
//WebElement Username= driver.findElement(By.id("loginusername")).sendKeys("charubirla");
// driver.findElement(By.id("loginpassword")).sendKeys("charu123");
//driver.findElement(By.xpath("//button[@type='button' and @onclick='logIn()' and contains(@class, 'btn-primary') and text()='Log in']")).click();
	
}
