package Appium.Naveen_V2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPress_2 extends BasicTest {
	@Test
	public void longPress() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();

		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		String xPath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ExpandableListView/android.widget.TextView[1]";

		WebElement ele = driver.findElement(By.xpath(xPath));

		longPressAction(ele);

		
String sampleMenu =		driver.findElement(By.id("android:id/title")).getText();

Assert.assertEquals(sampleMenu, "Sample menu");
		
	}

}
