package Week4.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//button[@class='btn btn-primary']").click(); // alert
		
		driver.findElementByXPath("//i[@class='fa fa-align-justify']").click(); //topbutton
		
		driver.findElementByXPath("//div[@id='slide-menu']//label[text()='FLIGHTS']").click(); //flights
		
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowIDs = new ArrayList<String> (windowHandles);
		
		String firstWindow = windowIDs.get(0);
		String secondWindow = windowIDs.get(1);
		
		driver.switchTo().window(secondWindow);
		String titleOfSecond = driver.getTitle();
		System.out.println("title of 2nd window = " + titleOfSecond);
		
		driver.switchTo().window(firstWindow);
		driver.close();
		
	}

}
