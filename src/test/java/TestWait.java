import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();
		WebElement scrollElement = driver.findElement(By.xpath("//a[contains(text(),' AUI - 2 ')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scrollElement);
		WebElement btnWait = driver.findElement(By.xpath("//a[contains(text(),' Timeout ')]"));
		btnWait.click();
		WebElement btnSimpleAlert = driver.findElement(By.id("accept"));
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(btnSimpleAlert));
		btnSimpleAlert.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Alert accepted");
		driver.close();
		
		
		
		
		
		
	}

}
