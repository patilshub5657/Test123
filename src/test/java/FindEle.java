import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class FindEle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stubWebDriver driver = new ChromeDriver();
		
		WebDriver driver = new ChromeDriver();System.setProperty("WebDriver.Chrome.Driver", "D:\\Drivers\\chromedriver.exe");
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		WebElement header =driver.findElement(By.cssSelector("header"));
		int headerSize = header.getSize().getHeight();
		
		WebElement ele1 = driver.findElement(By.cssSelector("a.card-footer-item[href='/window']"));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0].getBoundingClientRect().top - arguments[1]);",
			    ele1, headerSize);
		Thread.sleep(3000); 
		driver.findElement(By.xpath(" //a[contains(text(),'Find Elements ')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("Shubham");
		Thread.sleep(2000);
		driver.findElement(By.id("search")).click();
		Thread.sleep(4000);
		String name = driver.findElement(By.xpath("//p[@class='title is-4']")).getText();
		Assert.assertEquals("Shubham Mishra", name, "Checking");
		WebElement pic = driver.findElement(By.cssSelector(".is-rounded"));
		Thread.sleep(2000);
		Assert.assertTrue(pic.isDisplayed());
		Thread.sleep(2000);
		System.out.println("User Name - "+name);
		String bio = driver.findElement(By.xpath("//p[@class='subtitle is-6 has-text-grey']//following-sibling::p")).getText();
		System.out.println("Bio - "+bio);
		String repoCount = driver.findElement(By.xpath("//p[contains(text(),'Public Repos')]//following-sibling::p")).getText();
		System.out.println("Number of public repos : "+repoCount);
		
		boolean b ; 
		String Shref ;
		Set<String> urls = new HashSet<>();
		do  {
			WebElement checkNext = driver.findElement(By.xpath("//button[@class='pagination-next']"));
			b= checkNext.isEnabled();
			System.out.println(b);
			List<WebElement> links = driver.findElements(By.xpath("//app-repos//a"));
			String number= driver.findElement(By.xpath("//span[@class='pagination-link is-current']")).getText();
			System.out.println("Page -" + number);
			for(WebElement link : links) {
				Shref = link.getAttribute("href");
						urls.add(Shref);
					
					}
			if(b) {
					checkNext.click();
			}
			System.out.println("59");
		} while(b);
		for(String item:urls) {
			System.out.println(item);
			
		}
		driver.quit();
	}

}
