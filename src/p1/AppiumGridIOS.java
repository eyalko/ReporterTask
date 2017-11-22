package p1;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.net.MalformedURLException;

public class AppiumGridIOS implements Runnable {

	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "EriBank iOS reporter";
	protected IOSDriver<IOSElement> driver = null;

	private String deviceQuery = "@os='ios'";
	
	DesiredCapabilities dc = new DesiredCapabilities();
	
	@Before
	public void setUp() throws MalformedURLException {
		dc.setCapability("reportDirectory", reportDirectory);
		dc.setCapability("reportFormat", reportFormat);
		dc.setCapability("testName", testName);
		dc.setCapability("user", "eyal");
		dc.setCapability("password", "Admin1234");
		
		
		dc.setCapability("deviceQuery", deviceQuery);
		dc.setCapability("stream", "Eyal Reporter");
		dc.setCapability("build", 1);
		
		
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "cloud:com.experitest.ExperiBank");
		dc.setCapability("instrumentApp", true);

		driver = new IOSDriver<>(new URL("https://stage.experitest.com:443/wd/hub"), dc);
		driver.setLogLevel(Level.INFO);
	}

	@Test
	public void testIOS() throws InterruptedException {

//		int i = 0;
//		while (i < 10) {
//			i++;
			driver.findElement(By.xpath("//*[@accessibilityLabel='Username']")).sendKeys("company");
			driver.findElement(By.xpath("//*[@accessibilityLabel='Password']")).sendKeys("company");
			driver.findElement(By.xpath("xpath=//*[@text='Login']")).click();
			driver.findElement(By.xpath("xpath=//*[@text='Make Payment']")).click();
			driver.findElement(By.xpath("xpath=//*[@text='Select']")).click();
//			int j = 0;
//			while (j < 5) {
//				driver.swipe(100, 1000, 100, 50, 10);
//				j++;
//			}
			driver.findElement(By.xpath("//*[@accessibilityLabel='USA']")).click();
			driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='Cancel']")).click();
			driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='Logout']")).click();
			
			double random = Math.random();
			if (random>0.9)
				driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='notfoundanything']"));
//		}
		driver.get("http://www.wikipedia.org");
//		driver.findElement(By.id("searchInput")).sendKeys("experitest");
		//driver.findElement(By.xpath("xpath=//*[@nodeName='BUTTON' and ./parent::*[@nodeName='FIELDSET']]")).click();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			setUp();
			testIOS();
		} catch (Exception e) {
			System.out.println("Test Failed");
			e.printStackTrace();
		}
		finally {
			tearDown();
		}
	}
}
