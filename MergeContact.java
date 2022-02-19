package week3.day2;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

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
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		
		Set<String>windows=driver.getWindowHandles();
		for (String newwindow : windows) {
			driver.switchTo().window(newwindow);
	}
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")));
			{
	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
			
		}	
		driver.switchTo().window(old);
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			Set<String>windows1=driver.getWindowHandles();
			for (String newwindows1 : windows1) {
				driver.switchTo().window(newwindows1);
		}
			WebDriverWait wait2=new WebDriverWait(driver, 30);
			wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")));
			{
				driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
			
			}
			driver.switchTo().window(old);
			driver.findElement(By.linkText("Merge")).click();
			Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());	
			alert.accept();
	}
	}


