package week4day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContacts {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif'][1]")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWin = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listWin.get(1));
		driver.manage().window().maximize();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]/a"))
				.click();
		driver.switchTo().window(listWin.get(0));

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		
				System.out.println(" title1" +driver.getTitle());
		
				Set<String> windowHandles2 = driver.getWindowHandles();
				List<String> listWin2 = new ArrayList<String>(windowHandles2);
				driver.switchTo().window(listWin2.get(1));
				driver.manage().window().maximize();
				System.out.println(" title2" +driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("(//tbody/tr[1]/td[1]/div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]/a)[1]")).click();

		driver.switchTo().window(listWin.get(0));
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	System.out.println(	driver.getTitle());
		
	}
}
