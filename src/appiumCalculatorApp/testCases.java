package appiumCalculatorApp;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
public class testCases {

	// step 1
	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;

	@BeforeTest
	public void myBeforeTest() {
		// step2
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "dima");

		// to open the browser
//			caps.setCapability("chromedriverExecutable",
//					"C:\\Users\\user\\OneDrive\\Desktop\\chromewebdriver\\chromedriver.exe");
//			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

		// to open the calculator app
		File calculatorApp = new File("src/myApplications/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP, calculatorApp.getAbsolutePath());// el3nwan elf3li llcalculator

	}

//		@Test(priority=1)
//		public void openTheApp() throws MalformedURLException {
	//
//		}

//		@Test()
//		public void openTheBrowser() throws MalformedURLException {
//			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	//
//			 
//			driver.get("https://www.google.com");
//		}

	@Test()
	public void clickOnAllDigits() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);// el port elli btsht3'l 3leh es
																					// service tb3t el appium
		List<WebElement> myButtons = driver.findElements(By.className("android.widget.ImageButton"));
		// System.out.println(myButtons.size()+"*****************");
		// to print all digits
//			for (int i = 0; i < myButtons.size(); i++) {
//				// System.out.println(myButtons.get(i).getAttribute("resource-id"));
//				if (myButtons.get(i).getAttribute("resource-id").contains("digit")) {
//					myButtons.get(i).click();
		//
//				}
//			}
//			Assertion myAssert = new Assertion();
//			String expectedValue = "7894561230";
//			String actualValue = driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
//			myAssert.assertEquals(actualValue,expectedValue);

		// to print all even digit
		for (int i = 0; i < myButtons.size(); i++) {
			if (myButtons.get(i).getAttribute("resource-id").contains("2")
					|| myButtons.get(i).getAttribute("resource-id").contains("4")
					|| myButtons.get(i).getAttribute("resource-id").contains("6")
					|| myButtons.get(i).getAttribute("resource-id").contains("8")) {
				myButtons.get(i).click();
			}
		}
		// Hard Assert
		Assertion myAssert = new Assertion();

		String ExpectedValue = "8462";
		String Actual = driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
		myAssert.assertEquals(Actual, ExpectedValue);
		System.out.println(Actual);
	}

	@AfterTest
	public void afterMyTest() {

	}

}
