import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.Driver", "D:\\Drivers\\chromedriver.exe");
/*		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//Input
		driver.findElement(By.xpath("//a[contains(text(),' Edit ')]")).click();
		Thread.sleep(3000); 
		driver.findElement(By.id("fullName")).sendKeys("Rahul Gandhi");
		Thread.sleep(3000); 
		//textbox
		driver.findElement(By.id("join")).sendKeys(" Person");
		Thread.sleep(2000);
		String text = driver.findElement(By.id("getMe")).getAttribute("value");
		System.out.println(text);
		Thread.sleep(2000);
		driver.findElement(By.id("clearMe")).clear();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.id("noEdit"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(ele).perform();
		boolean b = ele.isEnabled();
		if(b==true) {
			System.out.println("Is eneabled");
		} else {
			System.out.println("Is Disabled");
		}
*/	
		driver.get("https://int.zigzag.lk/collections/dresses");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='XS']//following-sibling::span[contains(text(),'XS')]")).click();
		Thread.sleep(3000);
		driver.quit(); 
	}

}
