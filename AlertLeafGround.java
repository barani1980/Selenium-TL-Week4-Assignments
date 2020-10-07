package Week4.Day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertLeafGround {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Alert.html");
		Thread.sleep(1000);
		
		driver.findElementByXPath("//button[text()='Alert Box']").click();			Thread.sleep(2000);
		Alert alert1 = driver.switchTo().alert();
		String text1 = alert1.getText();
		System.out.println("Message of the simple alert box = " + text1);			Thread.sleep(2000);
		alert1.accept();															Thread.sleep(2000);
		
		
		driver.findElementByXPath("//button[text()='Confirm Box']").click(); 		Thread.sleep(2000);
		Alert alert2 = driver.switchTo().alert();
		String text2 = alert2.getText();
		System.out.println("Message of the confirm alert box = " + text2);
		alert1.dismiss();															Thread.sleep(2000);
		
		
		driver.findElementByXPath("//button[text()='Prompt Box']").click();			Thread.sleep(2000);
		Alert alert3 = driver.switchTo().alert();
		String text3 = alert3.getText();
		System.out.println("Message of the prompt alert box = " + text3);
		alert3.sendKeys("Online Webex"); 											Thread.sleep(2000);
		alert3.accept();															Thread.sleep(2000);
		
		driver.findElementByXPath("//button[text()='Line Breaks?']").click();		Thread.sleep(2000);
		Alert alert4 = driver.switchTo().alert();
		String text4 = alert4.getText();
		System.out.println("Line break messages");
		System.out.println("*******************");
		System.out.println(text4);
		alert4.accept();
		
		driver.findElementByXPath("//button[text()='Sweet Alert']").click();		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='OK']").click();					Thread.sleep(2000);
		
		driver.close();
	}

}
