package browserMobilw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class BrowserTesting extends BasicTest{
@Test
	public void browser() throws InterruptedException
	{	Thread.sleep(3000);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@name=\"q\"]")).sendKeys("Naveen Accademy");
		driver.findElement(By.xpath("//textarea[@name=\"q\"]")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
}
