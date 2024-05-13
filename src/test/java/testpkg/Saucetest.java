package testpkg;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basepkg.Baseclass;
import pagepkg.Sauceloginpg;
import utilities.Excelutils;

public class Saucetest extends Baseclass {
	
	@Test
	public void verifytest() throws IOException, InterruptedException
	{
		Sauceloginpg ob = new Sauceloginpg(driver);
		
		String xl = "G:\\Booksecret.xlsx";
		String Sheet = "Sheet1";
		int rowcount =    Excelutils.getRowCount(xl,Sheet);
		for(int i = 1;i<= rowcount;i++)
		{
			String username = Excelutils.getCellValue(xl,Sheet,i,0);
			System.out.println("username = " +username);
			String passwd = Excelutils.getCellValue(xl, Sheet, i,1);
			System.out.println("password = "+passwd);
			ob.setvalues(username, passwd);
			ob.loginclick();
		}
		
        List<WebElement> li =   driver.findElements(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/button"));
        for(WebElement ele: li)
        {
        	String text = ele.getText();
        	if(text.equals("Add to cart")) 
        	{
        		ele.click();
        	}
        }
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		driver.findElement(By.id("first-name")).sendKeys("saina");
		driver.findElement(By.id("last-name")).sendKeys("nazim");
		driver.findElement(By.id("postal-code")).sendKeys("691007");
		Thread.sleep(5000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logout_sidebar_link\"]")));
		
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
		
		
	}

}
