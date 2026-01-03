import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.Driver", "D:\\Drivers\\chromedriver.exe");
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		WebElement header =driver.findElement(By.cssSelector("header"));
		int headerSize = header.getSize().getHeight();
		
		WebElement ele1 = driver.findElement(By.cssSelector("a.card-footer-item[href='/alert']"));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0].getBoundingClientRect().top - arguments[1]);",
			    ele1, headerSize);
		Thread.sleep(3000);
		ele1.click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')] ")).click();
		Thread.sleep(2000); 
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		Thread.sleep(2000);
		driver.findElement(By.id("confirm")).click();
		Alert alert2 = driver.switchTo().alert();
		String txt = alert2.getText();
		//System.out.println("Text : "+txt);
		alert2.dismiss();
		Thread.sleep(2000);
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(2000); 
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Hello");
		Thread.sleep(2000); 
		alert3.accept();
		Thread.sleep(2000);
		System.out.println("Line 49");
		WebElement ele2 = driver.findElement(By.cssSelector("#modern"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele2);
		Thread.sleep(2000);
		driver.findElement(By.id("modern")).click();
		Thread.sleep(2000);
		String sweetText = driver.findElement(By.xpath("//p[@class='title']")).getText();
		System.out.println(" Sweet Text : "+sweetText);
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
