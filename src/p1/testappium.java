package p1;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.util.logging.Level;
import java.net.MalformedURLException;

public class testappium implements Runnable {
	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Reporter Login EriBank";
	protected AndroidDriver<AndroidElement> driver = null;

	private String deviceQuery = "@os='android'";

	DesiredCapabilities dc = new DesiredCapabilities();

	@Before
	public void setUp() throws MalformedURLException {
		dc.setCapability("reportDirectory", reportDirectory);
		dc.setCapability("reportFormat", reportFormat);
		dc.setCapability("testName", testName);
		dc.setCapability("user", "eyal");
		dc.setCapability("password", "Admin1234");
		
		
		dc.setCapability("deviceQuery", deviceQuery);
		dc.setCapability("stream", "Eyal Jenkins task");
		dc.setCapability("build", 1);
		
		//  dc.setCapability("projectName", "Default");
		//  dc.setCapability(MobileCapabilityType.UDID, "bb5f832e3ee56f952af3f8ae1983b4de9e4b0951");
		
//		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
		dc.setCapability("instrumentApp", true);
		driver = new AndroidDriver<AndroidElement>(new URL("http://stage.experitest.com:80/wd/hub"), dc);
		driver.setLogLevel(Level.INFO);
	}

	@Test
	public void testAppium() {
		driver.context("NATIVE_APP");
		driver.findElement(By.id("usernameTextField")).sendKeys("company");
		driver.findElement(By.id("passwordTextField")).sendKeys("company");
		driver.findElement(By.id("loginButton")).click();


	}

	@After
	public void tearDown() {
		driver.quit();
	}

//	@Override
	public void run() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			setUp();
			testAppium();
		} catch (Exception e) {
			System.out.println("Test Failed");
			e.printStackTrace();
		}
		finally {
			tearDown();
		}
	}
}