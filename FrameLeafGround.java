package Week4.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameLeafGround {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");	Thread.sleep(1000);
		
		WebElement frame1 = driver.findElementByXPath("//iframe[@src='default.html']");
		driver.switchTo().frame(frame1);
		driver.findElementById("Click").click();	Thread.sleep(1000);
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElementByXPath("//iframe[@src='page.html']");
		driver.switchTo().frame(frame2);
		WebElement frame3 = driver.findElementByXPath("//iframe[@src='nested.html']");
		driver.switchTo().frame(frame3);
		driver.findElementById("Click1").click();
		driver.switchTo().defaultContent();			Thread.sleep(1000);
		
		
		List<WebElement> allOuterFrames = driver.findElementsByXPath("//iframe");
		int count = allOuterFrames.size();
		System.out.println("Total outer frames in the webpage = " + count);
		// The above prints only 3 frames, but the page has 5 frames in total
	
		/*
		 * int inCount = 0; for (int i = 0; i < count; i++) { WebElement frameId =
		 * allOuterFrames.get(i); driver.switchTo().frame(frameId); boolean displayed =
		 * driver.findElementByXPath("//iframe").isDisplayed(); if (displayed) {inCount
		 * = inCount + 1; } driver.switchTo().defaultContent(); } count = count +
		 * inCount; System.out.println(count);
		 */
		
		driver.close(); 
	}
}

