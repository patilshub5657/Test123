import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		try {
			driver.navigate().to("https://letcode.in/test");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			
			WebElement btnToScroll = driver.findElement(By.xpath("//a[contains(text(),' Page Object Model ')]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", btnToScroll);
			
			WebElement btnFrame = driver.findElement(By.xpath("//a[contains(text(),' Inner HTML ')]"));
			btnFrame.click();
			
			WebElement pageFrame = driver.findElement(By.xpath("//h1[contains(text(),'Frame')]"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(pageFrame));
			
			driver.switchTo().frame("firstFr");
			WebElement txtFirstName = driver.findElement(By.xpath("//input[@placeholder='Enter name']"));
			WebElement txtLastName = driver.findElement(By.xpath("//label[contains(text(),'Last Name')]//parent::div//following-sibling::div//input[@placeholder='Enter email']"));
			
			txtFirstName.sendKeys("Kunal");
			txtLastName.sendKeys("K");
			
			WebElement innerEmail = driver.findElement(By.xpath("//label[contains(text(),'Last Name')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", innerEmail);
			
			WebElement innerFrame= driver.findElement(By.xpath("//iframe[@src='innerframe']"));
			driver.switchTo().frame(innerFrame);
			
			WebElement txtEmail = driver.findElement(By.xpath("//input[@name='email']"));
			txtEmail.sendKeys("Kunal@abc.com");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			driver.close();
		}
		
		
		

	}

}
