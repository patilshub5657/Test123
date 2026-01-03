import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.Driver", "D:\\Drivers\\chromedriver.exe");
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),' Click ')]")).click();
		Thread.sleep(3000); 
		driver.findElement(By.id("home")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(3000);
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println("Location : "+ location);
		Thread.sleep(3000);
		String clr = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("Colour : " + clr);
		Dimension size = driver.findElement(By.xpath("//button[@id='property']/parent::div")).getSize();
		System.out.println("Size : "+size);
		WebElement disabled = driver.findElement(By.xpath("//button[@id='isDisabled' and contains(text(),'Disabled')]"));
		action.scrollToElement(disabled).perform();
		boolean b = disabled.isEnabled();
		if(b==true) {
			System.out.println(" Is Enabled");
		} else {
			System.out.println(" Is Disabled ");
		}
		WebElement hold = driver.findElement(By.xpath("//h2[contains(text(),' Button Hold!')]"));
		action.scrollToElement(hold).perform();
		action.clickAndHold(hold).perform();
		Thread.sleep(3000);
		String txt = hold.getText();
		System.out.println("Text : "+txt);
		driver.quit();
	}

}
