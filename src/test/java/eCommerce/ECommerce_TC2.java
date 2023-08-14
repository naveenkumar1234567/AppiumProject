package eCommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ECommerce_TC2 extends BasicTest {
	@Test
	public void fillFOrm() {

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Naveen Kumar G");

		driver.hideKeyboard();

		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));

		String xp = "//android.widget.TextView[@text='Australia']";

		driver.findElement(By.xpath(xp)).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
	int productCount=	driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	for(int i=0;i<productCount;i++)
	{

		String productName=	driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		System.out.println(productName);
		if(productName.equalsIgnoreCase("Jordan 6 Rings"))
		{
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		}
	
	}
	
	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
	String selectedProduct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
	Assert.assertEquals(selectedProduct, "Jordan 6 Rings");
	}

}
