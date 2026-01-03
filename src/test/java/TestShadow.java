import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestShadow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/shadow");
		driver.manage().window().maximize();
		WebElement host = driver.findElement(By.id("open-shadow"));
		SearchContext shadowRoot = host.getShadowRoot();
		WebElement txtName = shadowRoot.findElement(By.cssSelector("#fname"));
		txtName.sendKeys("Kunal");
		WebElement txtLastName = driver.findElement(By.cssSelector("#lname"));
		WebElement txtEmail = driver.findElement(By.cssSelector("#email"));
		
		txtLastName.sendKeys("K");
		txtEmail.sendKeys("kunal@abc.com");
		driver.close();
		
	}

}
