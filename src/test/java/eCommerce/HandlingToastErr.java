package eCommerce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandlingToastErr extends BasicTest{
	@Test
	public void toastMsg()
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		
		String errMsg=driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		System.out.println(errMsg);
		
		
		
		
		
	}
	
}
