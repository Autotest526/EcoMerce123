package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

     public  WebDriver driver;
     public Logger logger; //Log4j Logging
     public ResourceBundle rb; //to read config.properties
     
	
	@BeforeClass(groups= {"master", "sanity", "regression"})
	@Parameters({"browser"})
	public void setUp(String br)
	{
		//Load config.properties
		rb=ResourceBundle.getBundle("config");
		
		//Log4j Logging
		logger=LogManager.getLogger(this.getClass());
	
		
		//Drivers
		if(br.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		logger.info("Launched Chrome browser");
		}
		else if(br.equals("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		logger.info("Launched Edge browser");
		}
		
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			logger.info("Launched Firefox browser");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass(groups= {"master", "sanity", "regression"})
	public void tearDown()
	{
		driver.close();
	}
	
	public String randomestring()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
		
	}
	
	public int radomeNumber()
	{
		String generatedString2=RandomStringUtils.randomAlphanumeric(5);
		return(Integer.parseInt(generatedString2));
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		
	}
	
}
