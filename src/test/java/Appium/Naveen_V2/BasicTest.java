package Appium.Naveen_V2;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BasicTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws Throwable {
		
		File appiumJs = new File(
				"C:\\Users\\NKUMARG1\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		
		//e com app
		
		
		
		
		// Configure the Appium service using AppiumServiceBuilder
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder().withAppiumJS(appiumJs)
				.withIPAddress("127.0.0.1").usingPort(4723);

		// Build the AppiumDriverLocalService instance
		service = AppiumDriverLocalService.buildService(serviceBuilder);

		// Start the Appium server
		service.start();

		Thread.sleep(9000);

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("NaveenEmulator");
		
		//API demo app
		options.setApp("C:\\Users\\NKUMARG1\\eclipse-workspace\\Naveen_V2\\src\\test\\java\\resources\\ApiDemos-debug.apk");

		//General-strore
//		options.setApp("C:\\Naveen\\Naveen\\Appium learning files\\General-Store.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {
//		service.stop();

		// driver.quit();

	}

	public void scrollToEnd() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		} while (canScrollMore);
	}

	public void scrollToElemennt(String elementName) {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(" + elementName + "));"));

	}

	public void swipeLeft(WebElement element, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", direction, "percent", 0.9));
	}

	public void dragAndDrop(WebElement element, int endX, int endY) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", endX, "endY", endY));
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}
}
