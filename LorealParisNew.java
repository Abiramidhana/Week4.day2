package week3.day2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LorealParisNew {
			public static void main(String[] args) throws InterruptedException {
				// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver= new ChromeDriver();
				driver.navigate().to("https://www.nykaa.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
				WebElement brands=driver.findElement(By.xpath("//a[text()='brands']"));
				Actions ac=new Actions(driver);
				ac.moveToElement(brands).perform();
				driver.findElement(By.linkText("L'Oreal Paris")).click();
				String Title=driver.getTitle();
				System.out.println(Title);
				if(Title.contains("L'Oreal Paris"))
				{
					System.out.println("It contains Loreal Paris");
				}
				driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		WebElement sp=driver.findElement(By.xpath("//span[@class='sort-name']"));
		boolean b=sp.isSelected();
		System.out.println(b);
		sp.click();
		Thread.sleep(3000);
		WebElement category = driver.findElement(By.xpath("//a[text()='categories']"));
		Actions cat=new Actions(driver);
		cat.moveToElement(category).perform();
		WebElement haircare=driver.findElement(By.xpath("(//li[@class='MegaDropdownHeadingbox']/a)[3]"));
		Actions ac1= new Actions(driver);
		ac1.moveToElement(haircare).perform();
		driver.findElement(By.linkText("Shampoo")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String newWindow : windowHandles) {
			driver.switchTo().window(newWindow);
			
		}

		WebDriverWait wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='filter-open css-nbw8dp']/span)[7]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='filter-open css-nbw8dp']/span)[7]"))).click();
		driver.findElement(By.xpath("//input[@type='text' and @placeholder='Search']")).sendKeys("color protection");
		WebElement find = driver.findElement(By.xpath("//div[@class='control-indicator checkbox ']"));
		find.click();
		driver.findElement(By.xpath("(//div[@class='lazy-load-wrap']/img)[9]")).click();//couln't locate this
	
		Set<String> window_Handles = driver.getWindowHandles();
		for (String windowHandles2 : window_Handles) {
			driver.switchTo().window(windowHandles2);
		}
		WebElement sel=driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select s=new Select(sel);
		s.selectByVisibleText("360ml");
		String mrp = driver.findElement(By.xpath("//span[@class='css-12x6n3h']")).getText();
		System.out.println(mrp);
			
			}
}
