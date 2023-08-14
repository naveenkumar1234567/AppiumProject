package eCommerce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ECommerce_TC1 extends BasicTest {
	@Test
	public void fillFOrm() {

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Naveen Kumar G");
	
		driver.hideKeyboard();
		
		
	
	driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']"));
	driver.findElement(By.id("android:id/text1")).click();
	
	driver.findElement(AppiumBy
			.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Congo\"));"));
	
String xp =	"//android.widget.TextView[@text='Congo']";
	
	driver.findElement(By.xpath(xp)).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	
	
	}

}
