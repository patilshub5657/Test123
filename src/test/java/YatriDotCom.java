import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YatriDotCom {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.Driver","D:\\Drivers\\chromedriver.exe" );
		driver.get("https://www.yatra.com/react-home?utm_source=google&utm_medium=search&utm_campaign=brand&_gcl&utm_source=google&utm_medium=cpc&utm_campaign=&gad_source=1&gad_campaignid=21579793373&gbraid=0AAAAAD4ZB-NxNjULS2M8tHadgHYYOlH9Q&gclid=CjwKCAjw6ZTCBhBOEiwAqfwJd3hQC2tM6L9INUu2wdEtM2bG-UsOP9-tjynD4Z3ryMAgjuGt9Ea2lBoCxcUQAvD_BwE");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@aria-label='Departure Date inputbox']")).click();
		Thread.sleep(5000);
		// //span[@class='react-datepicker__aria-live']//following-sibling::div[1]//div[@class='react-datepicker__month']
		WebElement firstMonth = driver.findElement(By.xpath(("//div[@aria-label='month  2025-06']//span[@class='custom-day-content lowestPrice'][1]")));
		String date = driver.findElement(By.xpath("//div[@aria-label='month  2025-06']//span[@class='custom-day-content lowestPrice'][1]/parent::span/parent::div")).getAttribute("aria-label");
		String currentPrice = firstMonth.getText();
		date = date.replace("Choose","");
		System.out.println("First Month Date : "+date +"- price : " +currentPrice );
		firstMonth.click();
		Thread.sleep(5000);
		//2nd month
		driver.findElement(By.xpath("//div[@aria-label='Departure Date inputbox']")).click();
		Thread.sleep(5000);
		WebElement secondMonth = driver.findElement(By.xpath("//div[@aria-label='month  2025-07']//span[@class='custom-day-content lowestPrice'][1]"));
		String date2 = driver.findElement(By.xpath("//div[@aria-label='month  2025-07']//span[@class='custom-day-content lowestPrice'][1]/parent::span/parent::div")).getAttribute("aria-label");
		String nextPrice = secondMonth.getText();
		date2 = date2.replace("Choose","");
		System.out.println("Second Month Date : "+date2 +"- price : " +nextPrice );
		Thread.sleep(2000);
		secondMonth.click();
		Thread.sleep(3000);
		//lowest of two
		currentPrice= currentPrice.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(currentPrice);
		nextPrice= nextPrice.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(nextPrice);
		driver.findElement(By.xpath("//div[@aria-label='Departure Date inputbox']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'July')]//preceding-sibling::button")).click();
		if(Integer.parseInt(currentPrice)>Integer.parseInt(nextPrice)) {
			driver.findElement(By.xpath("//div[@aria-label='month  2025-07']//span[@class='custom-day-content lowestPrice'][1]")).click();
		}else {
			driver.findElement(By.xpath("//div[@aria-label='month  2025-06']//span[@class='custom-day-content lowestPrice'][1]")).click();
		}
		Thread.sleep(3000);
		driver.quit();
	}

}
