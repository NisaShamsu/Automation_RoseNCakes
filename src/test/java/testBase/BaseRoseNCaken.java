package testBase;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseRoseNCaken
{
public WebDriver driver;
	
	@BeforeClass	
    public void setUP() 
    {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		driver.get("https://www.rosencakes.com");
		driver.manage().window().maximize();  		

    }		
  @AfterClass
    public void tearDown()
    {
		 driver.quit();	  
    }

}
