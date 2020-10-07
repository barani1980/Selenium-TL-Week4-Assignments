package Week4.Day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class w3school {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		Thread.sleep(1000);

		
		WebElement frame1 = driver.findElementById("iframeResult");
		driver.switchTo().frame(frame1);
		driver.findElementByXPath("//button[text()='Try it']").click();
		
		org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
		alert1.sendKeys("Barani");
		alert1.accept();
		
		String output = driver.findElementById("demo").getText();
		System.out.println(output);
		Thread.sleep(2000);
		
		boolean contains = output.contains("Barani");
		if (contains) {
			System.out.println("My name is successfully entered");
		}
		else {
			System.out.println("My name is not entered");
		}
	}

}
