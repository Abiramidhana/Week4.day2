package week3.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleResizable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
ChromeDriver driver= new ChromeDriver();
driver.navigate().to("https://jqueryui.com/resizable/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
driver.switchTo().frame(0);
WebElement resizeElement = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
Actions actionsResize = new Actions(driver);
actionsResize.dragAndDropBy(resizeElement, 100, 50).perform();
	}

}
