package week3.day2;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleDroppable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='draggable']/p"));
		WebElement from = driver.findElement(By.xpath("//div[@id='draggable']"));

		//WebElement to which the above object is dropped
		WebElement to = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions builder=new Actions(driver);
		builder.dragAndDrop(from, to).perform();
				

				
	}

}
