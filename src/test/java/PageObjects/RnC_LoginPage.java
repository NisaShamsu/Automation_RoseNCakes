package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.BaseRoseNCaken;

public class RnC_LoginPage extends BaseRoseNCaken
{
    WebDriver driver;
    
    public RnC_LoginPage( WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement lnk_Login;
    
    @FindBy(xpath="//input[@id='usemail']")
    WebElement txtEmail;
    
    @FindBy(xpath = "//input[@id='usrpass']")
    WebElement txtPaswd;
    
    @FindBy(xpath="//*[@id=\"btwnreg\"]")
    WebElement btnLogin;
    
   @FindBy(xpath = "//a[normalize-space()='Logout']")
   WebElement lnk_Logout;
    
    public void clearFields()
	{
		txtEmail.clear();
		txtPaswd.clear();
	}	
    
    public void clickLoginLink()
    {
    	lnk_Login.click();
    }
    
    public void setEmail(String email)
    {
    	
    	txtEmail.sendKeys(email);
    }
    
    public void setPassword(String pswd)
    {
    	
    	txtPaswd.sendKeys(pswd);
    }
	
    public void clickLoginButton()
    {
    	btnLogin.click();
    }
    
    public void clickLogoutLink()
    {
    	lnk_Logout.click();
    }
    
}
