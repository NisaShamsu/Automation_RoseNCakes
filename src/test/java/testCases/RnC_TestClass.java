package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import PageObjects.RnC_AddCartPage;
import PageObjects.RnC_CheckoutPage;
import PageObjects.RnC_FacebookPage;
import PageObjects.RnC_LoginPage;
import PageObjects.RnC_RegisterPage;
import testBase.BaseRoseNCaken;
import utility.RnC_Excel;

public class RnC_TestClass extends BaseRoseNCaken
{
	
	@Test(priority = 1)
	public void testRegister() 
	{
		RnC_RegisterPage register=new RnC_RegisterPage(driver);
		register.clickRegisterLink();
		register.setName("Nisa");
		register.setEmail("nisa@gmail.com");
		register.setTelephone("1234567891");
		register.setPassword("Nisa123#");
		register.setConfirmPassword("Nisa123#");
		register.setAddress("Arakkal house");
		register.setCity("Ernakulam");
		register.setPincode("684251");
		register.setState("Kerala");
		register.countrytDropClick();
		register.countryDropdownSelect();
		register.setPolicy();
		register.clickBtnRegister();
	}

	@Test(priority = 2)	
	public void static_ValidLogin() throws IOException, InterruptedException
	{
		//Valid Login Static test		
		RnC_LoginPage login=new RnC_LoginPage(driver);
		login.clickLoginLink();
		login.setEmail("nisa@gmail.com");
		login.setPassword("Nisa123#");		
		login.clickLoginButton();
	}
	
	@Test(priority = 3)
	public void addToCart() throws InterruptedException, IOException 
	{				
		//AddCart()		
		RnC_AddCartPage cart = new RnC_AddCartPage(driver);
		cart.searchCake();
		Thread.sleep(1000);
		cart.Capture_Screenshot();
		cart.logo_Check();
		cart.available_Option();
		cart.size_Quantity();
		cart.selectdate();
		cart.deliverytime();
		cart.message();
		cart.Addtocart();
	}
	
	@Test(priority = 4)
	public void checkOut()
	{
		//Checkout()		
		RnC_CheckoutPage checkout = new RnC_CheckoutPage(driver);      
		checkout.applyCoupen();
		checkout.warning();
		checkout.placeOrder();  
		checkout.receiverdetails();
		checkout.OrderPlaced();
		checkout.Logout();	
	}
	
	@Test(priority = 5)
	public void fbWindowHandle() throws InterruptedException
	{

		//FB_WindowHandle()		
		RnC_FacebookPage fb = new RnC_FacebookPage(driver);
        fb.Facebook();	
	}

		
	@Test(priority = 6)
	public void verifyLoginWithValidCredentials () throws Exception
	{
	        //Data driven of Login
		     RnC_LoginPage login=new RnC_LoginPage(driver);
		
	          // Reading the data from excel file by the specified path

	            String xl = "C:\\Users\\user\\Desktop\\Book.xlsx";
	            String Sheet = "Sheet1";
	            int rowCount = RnC_Excel.getRowCount(xl, Sheet);

	            for (int i=0;i<=rowCount;i++)

	            {
	            	        login.clickLoginLink();
	            	        
	                        String UserName=RnC_Excel.getCellValue(xl, Sheet, i, 0);
                            System.out.println("username---"+UserName);
	                        String Pwd=RnC_Excel.getCellValue(xl, Sheet, i, 1);
                            System.out.println("password---"+Pwd);
                            
                            
	                        //Passing Email and password as parameters
                            login.clearFields();
	                        login.setEmail(UserName);
	                        login.setPassword(Pwd);
	                        
                            //Submitting the data by clicking on login button                   
                             login.clickLoginButton();     
	                        
	                        String expectedurl="https://www.rosencakes.com/dashboard.php";
	          			    String actualurl= driver.getCurrentUrl();
	          			  
	          			     if(actualurl.equals(expectedurl))
	          			     {
	          			    	System.out.println("pass");
	          			    	login.clickLogoutLink();
	          			    		          			    	
	          			     }else
	          			     {
	          			    	System.out.println("fail");
	          			     }
	                        
	            }	            
	}
}




