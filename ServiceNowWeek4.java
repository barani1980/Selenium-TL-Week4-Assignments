package Week4.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowWeek4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://dev68594.service-now.com/");
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		
		driver.findElementByXPath("//input[@id='filter']").sendKeys("incident"); Thread.sleep(2000);//Type Incident
		driver.findElementByXPath("//ul[@aria-label='Modules for Application: Incident']/li[6]//a").click();//All
		Thread.sleep(3000);
		
		driver.switchTo().frame("gsft_main");
		driver.findElementById("sysverb_new").click(); //click new button
		
		driver.findElementById("lookup.incident.caller_id").click(); //lookup caller from magnifier
		
		Set<String> setCallers = driver.getWindowHandles();
		List<String> listCallers = new ArrayList<String> (setCallers);
		String wind1 = listCallers.get(0);
		String wind2 = listCallers.get(1);
		driver.switchTo().window(wind2); // switch to caller popup window
		
		driver.findElementByXPath("//table[@id='sys_user_table']/tbody/tr[3]//a").click(); //choose 1st caller
		Thread.sleep(2000);
		
		driver.switchTo().window(wind1);
		driver.switchTo().frame("gsft_main");
		
		driver.findElementById("incident.short_description").sendKeys("Selenium test");
		String incidentNo = driver.findElementById("incident.number").getAttribute("value");
		System.out.println("New incident created = " + incidentNo);
		
		driver.findElementById("sysverb_insert").click();			Thread.sleep(4000);
		
		driver.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following::input").sendKeys(incidentNo, Keys.RETURN);
		String incValue = driver.findElementByXPath("//table[@id='incident_table']//following::tr[3]/td[3]/a").getText();
		
		if (incidentNo.contentEquals(incValue)) {
			System.out.println("Incident created successfully");
		}
		else { System.out.println("Incident not created"); }
	}

}
