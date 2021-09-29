package week4day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarWale {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.carwale.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String title = driver.getTitle();
		System.out.println("Title : " + title);

		driver.findElement(By.xpath("//span[text()='Used']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Chennai");

		driver.findElement(By.xpath("//div[text()='Choose your Budget']")).click();
		WebElement slider1 = driver.findElement(By.xpath("(//button[@type='button'])[1]"));

		int left = slider1.getSize().getWidth();

		System.out.println(left);

		Actions builder = new Actions(driver);
		builder.dragAndDropBy(slider1,60, 0).perform();
		String text = driver.findElement(By.xpath("//input[@placeholder='Min']")).getAttribute("value");
		System.out.println("Slider 1 value is: "+text +"lakhs");

		WebElement slider2 = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		int right = slider2.getSize().getWidth();
		System.out.println(right);
		Actions builder2 = new Actions(driver);
		builder2.dragAndDropBy(slider2, -130, 0).perform();
		
		String text2= driver.findElement(By.xpath("//input[@placeholder='Max']")).getAttribute("value");
		System.out.println("Slider 2 value is: "+text2+"lakhs");
	}

}
