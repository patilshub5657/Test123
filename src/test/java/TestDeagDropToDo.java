import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDeagDropToDo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://letcode.in/test");
		driver.manage().window().maximize();
		WebElement scrollTab = driver.findElement(By.xpath("//a[contains(text(),' Tabs ')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollTab);
		WebElement btnDragDropToDo = driver.findElement(By.xpath("//a[contains(text(),' AUI - 3 ')]"));
		btnDragDropToDo.click();
		WebElement checkSortPage = driver.findElement(By.xpath("//h1[contains(text(),'Sort')]"));
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(checkSortPage));
		
		
		
		
		

	}

}
