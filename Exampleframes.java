package week3.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exampleframes {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new  ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Not a friendly Topic");
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(0);
		driver.switchTo().frame(2);
		boolean b=driver.findElement(By.id("a")).isSelected();
		System.out.println(b);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		WebElement animals=driver.findElement(By.id("animals"));
			Select s=new Select(animals);
			s.selectByVisibleText("big baby cat");
System.out.println(s.getOptions());
	}

}
