package testClases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass

{
	
	@Test(groups= {"regression", "master"})
	public void test_account_registration()
	{
		logger.info("Starting TC_001_AccountRegistration");
		try
		{
		driver.get(rb.getString("appURL"));
		//driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
		
		Homepage hp=new Homepage(driver);
		logger.info("Clicked on Register");
		hp.clickRegister();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstname("Anil");
		logger.info("Provided Firstname");
		
		regpage.setLastname("Ganta");
		logger.info("Provided Lastname");
		
		regpage.setAddress("Rudravaram do:123");
		logger.info("Provided Address");
		
		regpage.setCity("Hyderbad");
		logger.info("Provided City");
		
		regpage.setState("krishna");
		logger.info("Provided distic");
		
		regpage.setZipcode("12535");
		logger.info("Provided pincode");
		
		regpage.setMobileNumber("6466456564");
		logger.info("Provided Mobile Number");
		
		regpage.setssnnumber("SNN123564");
		logger.info("Provided SSN Number");
		
		regpage.setusername(randomestring()+"@yopmail.com");
		logger.info("Provided Email");
		
		regpage.setPassword("Password@123");
		logger.info("Provided Password");
		
		regpage.setconfPassword("Password@123");
		logger.info("Provided Confpassword");
		
		regpage.Register();
		logger.info("Click on Register button");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String confmg=regpage.getConfirmationMsg();
		if(confmg.equals("Your account was created successfully. You are now logged in."))
		{
			logger.info("Account register successfully");
			captureScreen(driver, "test_accout_Registration"); //Capturing screenshot
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Account Registration Failed only ");
			captureScreen(driver, "test_accout_Registration"); //Capturing screenshot
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			logger.fatal("Account Registration Failed");
			Assert.fail();
		}
		
		logger.info(" Finished TC_001_AccountRegistration ");
			
	}
}
