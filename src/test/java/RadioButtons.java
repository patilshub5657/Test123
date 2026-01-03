import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RadioButtons {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.Driver", "D:\\Drivers\\chromedriver.exe");
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		WebElement header =driver.findElement(By.cssSelector("header"));
		int headerSize = header.getSize().getHeight();
		
		WebElement ele1 = driver.findElement(By.cssSelector("a.card-footer-item[href='/radio']"));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0].getBoundingClientRect().top - arguments[1]);",
			    ele1, headerSize);
		Thread.sleep(3000);
		ele1.click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//label[@class='radio']//input[@id='yes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='radio']//input[@id='two']")).click();
		Thread.sleep(2000);
		boolean b1 = driver.findElement(By.xpath("//label[@class='radio']//input[@id='one']")).isSelected();
		if(b1) {
			System.out.println("Selected");
		} else {
			System.out.println("Not selected");
		}
		driver.findElement(By.xpath("//label[@class='radio']//input[@id='nobug']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='radio']//input[@id='bug']")).click();
		Thread.sleep(2000);
		boolean b2 = driver.findElement(By.xpath("//label[@class='radio']//input[@id='nobug']")).isSelected();
		boolean b3 = driver.findElement(By.xpath("//label[@class='radio']//input[@id='bug']")).isSelected();
		if(b2 && b3) {
			System.out.println(" Error -- User is able to select both the radio buttons ");
		} else {
			System.out.println("Working fine");
		}
		boolean b4 = driver.findElement(By.xpath("//label[@class='radio']//input[@id='maybe']")).isEnabled();
		if(b4) {
			System.out.println(" May be button is enabled");
		} else {
			System.out.println(" May be button is disabled");
		}
		
		boolean b5 = driver.findElement(By.xpath("//label[@class='checkbox' and contains(text(),' Remember me ')]//input")).isSelected();
		if(b5) {
			System.out.println(" Remember me  button is selected");
		} else {
			System.out.println("Remember me  button is  NOT selected");
		}
		WebElement ele = driver.findElement(By.xpath("//label[@class='checkbox' and contains(text(),' I agree to the ')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele);
		ele.click();
		Thread.sleep(2000);
		driver.quit();

	}

}
