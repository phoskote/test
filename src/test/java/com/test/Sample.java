package com.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Sample {

	@Test
	public void testApp() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setBrowserName(BrowserType.CHROME);
		cap.setPlatform(Platform.LINUX);
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.220.128:4545/wd/hub"), cap);
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Learn Automation");
		//Thread.sleep(60000);
		driver.quit();
	}
}
