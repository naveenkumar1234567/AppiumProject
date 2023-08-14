package Appium.Naveen_V2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
@Test
public class DranAndDrop_5 extends BasicTest {
	public void dragAndDrop() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
dragAndDrop(source, 869, 727);
		
		
//		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) source).getId(),
//			    "endX", 869,
//			    "endY", 727
//			));
//		
		
		
		
}

}
