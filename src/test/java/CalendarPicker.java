import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarPicker {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.Driver", "D:\\Drivers\\chromedriver.exe");
		driver.get("https://jqueryui.com/resources/demos/datepicker/other-months.html");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		driver.findElement(By.id("datepicker")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ui-datepicker-div']")));
		String  month ="June";
		int day = 22 , year = 2025, currYearTwo;
		WebElement previous = driver.findElement(By.xpath("//span[contains(text(),'Prev')]"));
		WebElement next = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();
		int currYearOne = Integer.parseInt(currentYear); 
		String currentYearTwo;
		while(!(currentMonth==month && currYearOne==year)) {
			currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();
			currentYearTwo = driver.findElement(By.className("ui-datepicker-year")).getText();
			if(Integer.parseInt(currentYearTwo)>year) {
				
				
				
			}
		}
		driver.quit();

	}

}
