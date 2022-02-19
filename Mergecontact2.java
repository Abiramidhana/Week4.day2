package week3.day2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mergecontact2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); // Open a new chrome browser
        driver.manage().window().maximize(); // 
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();	
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		String old=driver.getWindowHandle();
		driver.findElement(By.xpath("(//span[text()='From Contact']//following::img)[1]")).click();
		Set<String>windows=driver.getWindowHandles();
		for (String newwindow : windows) {
			driver.switchTo().window(newwindow);
	      }
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
        driver.switchTo().window(old);
	    driver.findElement(By.xpath("(//span[text()='To Contact']//following::img)[1]")).click();
		 Set<String> windowHandles = driver.getWindowHandles();
		 for (String openWindow : windowHandles) {
				driver.switchTo().window(openWindow);
		      }
		    Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
			driver.switchTo().window(old);
			driver.findElement(By.linkText("Merge")).click();
			Alert alert=driver.switchTo().alert();
			alert.accept();
			

	}

	}


