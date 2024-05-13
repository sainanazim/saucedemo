package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sauceloginpg {
	WebDriver driver;
	
	@FindBy(id ="user-name")
	WebElement usernme;
	
	@FindBy(id = "password")
	WebElement pswd;
	
	@FindBy(name = "login-button")
	WebElement loginbtn;
	
   public Sauceloginpg(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements( driver,this);

}	
	
	
	public void setvalues(String username,String password)
	{
	  usernme.clear();
	   usernme.sendKeys(username);
	   pswd.clear();
	   pswd.sendKeys(password);
	}
	
	public void loginclick()
	{
		loginbtn.click();
	}
	
	

}
