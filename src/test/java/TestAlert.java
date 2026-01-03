import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAlert {

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
			
			
			WebElement btnAction = driver.findElement(By.xpath("//a[contains(text(),' Dialog ')]"));
			btnAction.click();
			WebElement btnAlertSimple = driver.findElement(By.id("accept"));
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(btnAlertSimple));
			btnAlertSimple.click();
			
			Alert alertSimple = driver.switchTo().alert();
			String msgSimpleAlert = alertSimple.getText();
			System.out.println(msgSimpleAlert);
			alertSimple.accept();
			
			WebElement btnAlertConfirm = driver.findElement(By.id("confirm"));
			btnAlertConfirm.click();
			Alert alertConfirm = driver.switchTo().alert();
			String txtAlertConfirm= alertConfirm.getText();
			System.out.println(txtAlertConfirm);
			alertConfirm.dismiss();
			
			WebElement btnAlertText = driver.findElement(By.id("prompt"));
			btnAlertText.click();
			Alert enterTextAlert = driver.switchTo().alert();
			enterTextAlert.sendKeys("Hi My name is Mojo");
			enterTextAlert.accept();
			
			WebElement btnAlertSweet = driver.findElement(By.id("modern"));
			btnAlertSweet.click();
			String txtSweetAlert = btnAlertSweet.getText();
			System.out.println(txtSweetAlert);
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		finally {
			driver.close();
		}
		
		
		
		
		
		

	}

}
