package week4day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://leafground.com/pages/frame.html");
		List<WebElement> winList = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of Frames are : " + winList.size());

		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='default.html']"));
		driver.switchTo().frame(frame1);

		WebElement ss = driver.findElement(By.id("Click"));
		File src = ss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/button.png");
		FileUtils.copyFile(src, dst);

		driver.switchTo().defaultContent();

	}

}
