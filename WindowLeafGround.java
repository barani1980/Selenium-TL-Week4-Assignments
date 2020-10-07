package Week4.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowLeafGround {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Window.html");	Thread.sleep(2000);
		String win1 = driver.getWindowHandle();
				
		driver.findElementById("home").click();	Thread.sleep(2000);
		
		driver.findElementByXPath("//button[text()='Open Multiple Windows']").click();
		Set<String> winSetHandles1 = driver.getWindowHandles();
		List<String> winListHandles1 = new ArrayList<String> (winSetHandles1);
		int winCount1 = winListHandles1.size();
		System.out.println("Number of windows opened = " + winCount1);	Thread.sleep(2000);
		
		driver.findElementById("color").click();						Thread.sleep(2000);
		Set<String> winSetHandles2 = driver.getWindowHandles();
		List<String> winListHandles2 = new ArrayList<String> (winSetHandles2);
		int size = winListHandles2.size();
		
		for (int i = 1; i < size; i++) {
			String tempWindow = winListHandles2.get(i);
			driver.switchTo().window(tempWindow);
			driver.close();
			driver.switchTo().window(win1);
		}		
		
		
		driver.findElementByXPath("//button[text()='Wait for 5 seconds']").click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		Set<String> winSetHandles3 = driver.getWindowHandles();
		System.out.println(winSetHandles3);
		driver.quit();
	}

}
