package Appium.Naveen_V2;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscelaniousAppium_6 extends BasicTest {
	@Test
	public void miscDemo() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();

		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation rotate = new DeviceRotation(0, 0, 90);
		driver.rotate(rotate);

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

		String text = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(text, "WiFi settings");

		// Set clipboardTest

		driver.setClipboardText("Naveen Kumar");

		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		//Keys
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
}
