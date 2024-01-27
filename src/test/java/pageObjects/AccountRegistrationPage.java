package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage {

	 WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='customer.firstName']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='customer.lastName']") WebElement txtLastname;
	
	
	@FindBy(xpath="//input[@id='customer.address.street']") WebElement txtAddress;
	
	@FindBy(xpath="//input[@id='customer.address.city']") WebElement txtCity;
	
	@FindBy(xpath="//input[@id='customer.address.state']") WebElement txtState;
	
	@FindBy(xpath="//input[@id='customer.address.zipCode']") WebElement txtZipCode;
	
	@FindBy(xpath="//input[@id='customer.phoneNumber']") WebElement txtMobileNumber;
	
	@FindBy(xpath="//input[@id='customer.ssn']") WebElement txtssnNumber;
	
	@FindBy(xpath="//input[@id='customer.username']") WebElement txtusername;
	
	@FindBy(xpath="//input[@id='customer.password']") WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='repeatedPassword']") WebElement txtconfpassword;
	
	@FindBy(xpath="//input[@value='Register']") WebElement btnRegister;
	
	@FindBy(xpath="//p[normalize-space()='Your account was created successfully. You are now logged in.']") WebElement  msgconfirm;
	
	
	public void setFirstname(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setAddress(String address)
	{
		txtAddress.sendKeys(address);
	}
	
	public void setCity(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void setState(String state)
	{
		txtState.sendKeys(state);
	}
	
	public void setZipcode(String zipcode)
	{
		txtZipCode.sendKeys(zipcode);
	}
	
	public void setMobileNumber(String mNumber)
	{
		txtMobileNumber.sendKeys(mNumber);
	}
	
	public void setssnnumber(String ssnnumber)
	{
		txtssnNumber.sendKeys(ssnnumber);
	}
	
	public void setusername(String usname)
	{
		txtusername.sendKeys(usname);
	}
	
	public void setPassword(String Password)
	{
		txtPassword.sendKeys(Password);
	}
	
	public void setconfPassword(String confPassword)
	{
		txtconfpassword.sendKeys(confPassword);
	}
	
	public void Register()
	{
		btnRegister.click();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			return(msgconfirm.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
}
