import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.Driver", "D:\\Drivers\\chromedriver.exe");
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		WebElement header =driver.findElement(By.cssSelector("header"));
		int headerSize = header.getSize().getHeight();
		
		WebElement ele1 = driver.findElement(By.cssSelector("a.card-footer-item[href='/window']"));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0].getBoundingClientRect().top - arguments[1]);",
			    ele1, headerSize);
		Thread.sleep(3000);
		ele1.click();
		Thread.sleep(2000); 
		driver.findElement(By.id("home")).click();
		
	}

}
