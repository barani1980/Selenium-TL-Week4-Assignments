package Week4.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeadLeafTaps {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");				Thread.sleep(1000);
		driver.findElementByClassName("decorativeSubmit").click(); 			Thread.sleep(1000);
		
		driver.findElementByLinkText("CRM/SFA").click();					Thread.sleep(1000);
		driver.findElementByLinkText("Leads").click();						Thread.sleep(1000);
		driver.findElementByLinkText("Merge Leads").click();				Thread.sleep(1000);
		
		driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdFrom']/following::img").click();
		Set<String> setFromPopUp = driver.getWindowHandles();
		List<String> listFromPopUp = new ArrayList<String> (setFromPopUp);
		String wind1 = listFromPopUp.get(0);
		String wind2 = listFromPopUp.get(1);
		driver.switchTo().window(wind2);
		
		driver.findElementByName("id").sendKeys("10039");
		driver.findElementByXPath("//button[text()='Find Leads']").click(); Thread.sleep(4000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		Thread.sleep(2000);
		
		driver.switchTo().window(wind1);
		driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdTo']/following::img").click();
		Set<String> setToPopUp = driver.getWindowHandles();
		List<String> listToPopUp = new ArrayList<String> (setToPopUp);
		String windTo2 = listToPopUp.get(1);
		driver.switchTo().window(windTo2);
		
		driver.findElementByName("id").sendKeys("10040");
		driver.findElementByXPath("//button[text()='Find Leads']").click(); Thread.sleep(4000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		
		driver.switchTo().window(wind1);
		driver.findElementByClassName("buttonDangerous").click();
		
		Alert alert1 = driver.switchTo().alert();
		String text1 = alert1.getText();
		System.out.println("Message of the confirm alert box after merging leads = " + text1);			Thread.sleep(2000);
		alert1.accept();							
		
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByName("id").sendKeys("10039");
		driver.findElementByXPath("//button[text()='Find Leads']").click(); Thread.sleep(4000);
		String result = driver.findElementByClassName("x-paging-info").getText();
		
		if (result.contains("No records to display")) {
			System.out.println("The leads are merged successfully");
		}
		else {
			System.out.println("The leads are not merged successfully");
		}
		driver.close();
	}

}
