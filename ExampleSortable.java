package week3.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleSortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.navigate().to("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		List<WebElement> list=driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		WebElement from=list.get(0);
		WebElement to= list.get(5);
//		WebElement from=driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle']/span)[1]"));
//		WebElement to=driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle']/span)[5]"));
		Actions ac=new Actions(driver);
		ac.clickAndHold(from);
		ac.moveToElement(to);
		ac.release(to);
		ac.build().perform();

	}

}
