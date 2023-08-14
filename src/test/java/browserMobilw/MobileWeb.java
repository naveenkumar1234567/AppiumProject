package browserMobilw;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileWeb extends BasicTest{
	@Test
	public void mobileWeb()
	{	
		driver.get("https://www.google.co.in/");
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class=\"navbar-toggler-icon\"]")).click();
		driver.findElement(By.xpath("//a[normalize-space(text())='Products']")).click();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,5000)", "");
		String devops = driver.findElement(By.xpath("//a[text()='Devops']")).getText();
	
		Assert.assertEquals("Devops", devops);
	
	}
	
}
