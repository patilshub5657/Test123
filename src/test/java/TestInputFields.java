import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestInputFields {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		try {
		driver.navigate().to("https://letcode.in/test");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement btnInput = driver.findElement(By.xpath("//a[contains(text(),' Edit ')]"));
		btnInput.click();
		WebElement txtFullName = driver.findElement(By.id("fullName"));
		WebElement txtJoin = driver.findElement(By.id("join")); 
		WebElement readTxt = driver.findElement(By.id("getMe"));
		WebElement clrText = driver.findElement(By.id("clearMe"));
		WebElement fieldDisabled = driver.findElement(By.id("noEdit"));
		WebElement fieldReadOnly = driver.findElement(By.id("dontwrite"));
		
		txtFullName.sendKeys("Shubham Mojo");
		txtJoin.sendKeys("Joining with a TAB", Keys.TAB);
		String readTextBox=readTxt.getText();
		System.out.println(readTextBox);
		clrText.clear();
		boolean checkDisabled = fieldDisabled.isDisplayed();
		System.out.println(checkDisabled);
		boolean checkIsEnabled = fieldReadOnly.isEnabled();
		System.out.println(checkIsEnabled);
		
		//page 2 buttons
		driver.navigate().back();
		WebElement btnButton = driver.findElement(By.xpath("//a[contains(text(),'Click')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(btnButton));
		btnButton.click();
		
		WebElement btnGoToHome = driver.findElement(By.id("home"));
		btnGoToHome.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),' LetCode with Koushik')] ")));
		
		driver.navigate().back();
		btnGoToHome=driver.findElement(By.id("home"));
		wait.until(ExpectedConditions.visibilityOf((btnGoToHome)));
		
		WebElement btnFindLocation = driver.findElement(By.id("position"));
		WebElement btnColor = driver.findElement(By.id("color"));
		WebElement btnProperty = driver.findElement(By.id("property"));
		WebElement btnIsDisabled = driver.findElement(By.xpath("//button[@id='isDisabled' and contains(text(),'Disabled')]"));
		WebElement btnHold = driver.findElement(By.xpath("//button[@id='isDisabled']//div//h2[contains(text(),' Button Hold!')]"));
		
		Point position = btnFindLocation.getLocation();
		System.out.println(position);

		String color = btnColor.getCssValue("color");
		System.out.println(position);
		
		Dimension size = btnProperty.getSize();
		System.out.println(size);
		
		boolean chkDisability = btnIsDisabled.isDisplayed();
		System.out.println(chkDisability);
		
		boolean chkHold = btnHold.isEnabled();
		System.out.println(chkHold);
		}
		
		catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		finally {
			driver.close();
		}
		
		
		
	}

}
