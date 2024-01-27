package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='username']") WebElement txtEmailAddresss;
	
	@FindBy(xpath="//input[@name='password']") WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Log In']") WebElement btnLogin;
	
	@FindBy(xpath="//a[normalize-space()='Accounts Overview']") WebElement msgHeading;
	
	
	public void setEmail(String email)
	{
		txtEmailAddresss.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public boolean isAccountOverviewExist()
	{
		try
		{
			return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}

}
