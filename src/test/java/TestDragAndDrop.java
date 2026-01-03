import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDragAndDrop {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		try {
			driver.navigate().to("https://letcode.in/test");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			WebElement scrollBtn = driver.findElement(By.xpath("//a[contains(text(),' Toggle ')]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", scrollBtn);
			WebElement btnDragDrop = driver.findElement(By.xpath("//a[contains(text(),' AUI - 2 ')]"));
			btnDragDrop.click();
			WebElement DropPage = driver.findElement(By.xpath("//h1[contains(text(),'Drop')]"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(DropPage));
			WebElement source = driver.findElement(By.id("draggable"));
			WebElement destination = driver.findElement(By.id("droppable"));
			Actions actions = new Actions(driver);
		//	actions.dragAndDrop(source, destination).release().perform();
			actions.clickAndHold(source)
			       .moveToElement(destination)
			       .release()
			       .build()
			       .perform();
			Thread.sleep(3000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			driver.close();
		}
		
		
		

	}

}
