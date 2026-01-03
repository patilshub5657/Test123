import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		try {
			driver.navigate().to("https://letcode.in/test");
			driver.manage().window().maximize();
			WebElement scrollElement = driver.findElement(By.xpath("//a[contains(text(),' Drop-Down ')]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", scrollElement);
			
			WebElement btnTabs = driver.findElement(By.xpath("//a[contains(text(),' Tabs ')]"));
			btnTabs.click();
			WebElement btnOpenHomePage = driver.findElement(By.id("home"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(btnOpenHomePage));
			btnOpenHomePage.click();
			String parentWindow = driver.getWindowHandle();
			Set<String> firstWindowHandles = driver.getWindowHandles();
			List<String> ListfirstWindowHandles = new ArrayList<> (firstWindowHandles);
			for(String handle : ListfirstWindowHandles)
				if(!(handle.equals(parentWindow))) {
					driver.switchTo().window(handle);
					String childWindowTitle = driver.getTitle();
					System.out.println("Child window title - " +childWindowTitle);
					driver.close();
					
				}
			driver.switchTo().window(parentWindow); 
			try {	
			WebElement btnCloseAdd=driver.findElement(By.id("//div[@id='dismiss-button']"));
			wait.until(ExpectedConditions.elementToBeClickable(btnCloseAdd));
			btnCloseAdd.click();
			}
			catch (NoSuchElementException e){
				System.out.println("Add did not appear");
				
			}
			WebElement btnMultipleWindow = driver.findElement(By.id("multi"));
			btnMultipleWindow.click();
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> ListallWindowHandles = new ArrayList<> (allWindowHandles);
			String title=driver.getTitle();
			System.out.println(title);
			for(String handle1 : ListallWindowHandles) {
				if((!handle1.equals(parentWindow))) {
					driver.switchTo().window(handle1);
					title=driver.getTitle();
					System.out.println(title);
					driver.close();
				}
			}
				
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
		driver.quit();
		}
	
	}

}
