import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		
		try{
			driver.navigate().to("https://letcode.in/test");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			WebElement btnDropDown= driver.findElement(By.xpath("//a[contains(text(),' Drop-Down ')]"));
			btnDropDown.click();
			WebElement drpdwn=driver.findElement(By.id("fruits"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(drpdwn)).click();
		
			Select select = new Select(drpdwn);
			String selectApple = "Apple";
			select.selectByVisibleText(selectApple);
		
			WebElement drpdwnSuperHero = driver.findElement(By.id("superheros"));
			Select selectHero = new Select(drpdwnSuperHero);
			selectHero.selectByValue("th");
		
			WebElement msgSuperHero = driver.findElement(By.xpath("//label[contains(text(),\"super hero's\")]//parent::div//following-sibling::div//div//div//p"));
			String actualSuccessMsg = msgSuperHero.getText();
			String expectedSuccessMsg = "You have selected Thor";
			Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
			
			WebElement drpdwnLang = driver.findElement(By.id("lang"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",drpdwnLang );
			
			drpdwnLang.click();
			
			Select selectLang = new Select(drpdwnLang);
			selectLang.selectByVisibleText("Java");
			List<WebElement> allOptions =selectLang.getOptions();
			for(WebElement option : allOptions) {
				System.out.println(option.getText());
			}
			
			WebElement drpdwnCountry = driver.findElement(By.id("country"));
			js.executeScript("arguments[0].scrollIntoView(true);", drpdwnCountry );
			Select selectCountry = new Select(drpdwnCountry);
			selectCountry.selectByValue("India");
			WebElement firstSelectCountry = selectCountry.getFirstSelectedOption();
			System.out.println(firstSelectCountry.getText());
			
			
			
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		finally {
			driver.close();
		}
		
		

	}

}
