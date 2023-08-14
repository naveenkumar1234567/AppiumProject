package eCommerce;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ECommerce_TC4 extends BasicTest {
	@Test
	public void fillFOrm() throws InterruptedException {

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Naveen Kumar G");

		driver.hideKeyboard();

		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));

		String xp = "//android.widget.TextView[@text='Australia']";

		driver.findElement(By.xpath(xp)).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println("The cart count is: " + productCount);
		for (int i = 0; i < 2; i++) {

			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
					.getText();
			System.out.println("The product name of" + i + " is " + productName);

			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top", 100,
				"width", 200, "height", 200, "direction", "down", "percent", 3.0));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top", 100,
				"width", 200, "height", 200, "direction", "down", "percent", 3.0));
		List<WebElement> priceProd = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = priceProd.size();
		System.out.println("The cart count is: " + count);
		double sum = 0;

		for (int i = 0; i < count; i++) {
			String amount = priceProd.get(i).getText();

			Double price = Double.parseDouble(amount.substring(1));

			sum = sum + price;
		}

		System.out.println("The total value of the products is: " + sum);
		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double totinSum = Double.parseDouble(total.substring(1));
		Assert.assertEquals(sum, totinSum);

		WebElement TandC = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(TandC);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);
		Set<String> contexts=	driver.getContextHandles();
		Iterator<String> iterator = contexts.iterator();
		String nativeAPP =iterator.next();
		String webView = iterator.next();
		
		for(String context:contexts)
		{
			System.out.println(context);
		}
	driver.context(webView);
	
	driver.findElement(By.xpath("//textarea[@name=\"q\"]")).sendKeys("Naveen Accademy");
	driver.findElement(By.xpath("//textarea[@name=\"q\"]")).sendKeys(Keys.ENTER);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.context(nativeAPP);
	
	

	}
}
