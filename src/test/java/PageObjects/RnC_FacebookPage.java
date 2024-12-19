package PageObjects;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RnC_FacebookPage 
{	
	WebDriver driver;
	public RnC_FacebookPage (WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"footer\"]/div[2]/div/div[1]/ul/li[1]/a")
	WebElement FB_icon;
			
	public void Facebook() throws InterruptedException {
		String parentwindow=driver.getWindowHandle();//current window
    	System.out.println("Parent Window Title: "+driver.getTitle());
    	FB_icon.click();
		
		Set<String> allwindow=driver.getWindowHandles();
    	for(String handle: allwindow) {
    		if(!handle.equalsIgnoreCase(parentwindow)) {
    			driver.switchTo().window(handle);
    			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
                WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/i[1]")));           
                closeButton.click();
                Thread.sleep(3000);
                driver.close();
    		}
    		driver.switchTo().window(parentwindow);
    		Thread.sleep(3000);
    	}
	}
}
