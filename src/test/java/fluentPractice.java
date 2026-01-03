import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.function.Function;


public class fluentPractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.Driver", "D:\\Drivers\\chromedriver.exe");
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("RedTape shoes for men");
		Wait<WebDriver> wait = new FluentWait <WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
			
/*		 WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	            	
	            	WebElement ele2 =driver.findElement(By.id("nav-search-submit-button"));
	            	System.out.println(ele2.isDisplayed());
	            	return ele2;
			
		}
		 }
		 
		 );
		 */
		
		//using lambda expression
		WebElement element = wait.until(lambdaDriver -> driver.findElement(By.id("nav-search-submit-button")));
		 	element.click();
		 	Thread.sleep(5000);
		 	driver.quit();
	}

}
