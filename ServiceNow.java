package week4day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://dev61637.service-now.com");
		String title = driver.getTitle();
		System.out.println("Title" + title);

		WebElement frame1 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Nithinjisha@97");
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();

		driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		driver.findElement(By.xpath("//ul[@aria-label='Modules for Application: Incident']/li[6]//div//a/div/div")).click();
		
		WebElement frame2 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("sysverb_new")).click();
		driver.switchTo().defaultContent();
		
		WebElement frame3 = driver.findElement(By.id("gsft_main"));
	driver.switchTo().frame(frame3);
	driver.findElement(By.id("lookup.incident.caller_id")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> winList=new ArrayList<String>(windowHandles);
	driver.switchTo().window(winList.get(1));
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
	driver.switchTo().window(winList.get(0));
	driver.switchTo().defaultContent();
	
	WebElement frameThree = driver.findElement(By.id("gsft_main"));
	driver.switchTo().frame(frameThree);
	
	driver.findElement(By.id("incident.short_description")).sendKeys("Service now testCase");
	
	String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
	System.out.println("The Incident number is : " +incidentNum);
	
	driver.findElement(By.id("sysverb_insert_bottom")).click();
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNum,Keys.ENTER);
	System.out.println("The testcase has been created successfully");
	
	//taking a screenshot of the page
	File src= driver.getScreenshotAs(OutputType.FILE);
	File dst=new File("./ServiceNow Screenshot/incident.png");
	FileUtils.copyFile(src, dst);
	
	
	}

}
