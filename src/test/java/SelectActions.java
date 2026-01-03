import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.Driver", "D:\\Drivers\\chromedriver.exe");
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),' Drop-Down')] ")).click();
		Thread.sleep(3000); 
		WebElement drpDwn = driver.findElement(By.id("fruits"));
		Select select = new Select(drpDwn);
		select.selectByVisibleText("Apple");
		Thread.sleep(2000);
		WebElement drpDwn2 = driver.findElement(By.id("superheros"));
		Select select2 = new Select(drpDwn2);
		boolean b = select2.isMultiple();
		if(b) {
			System.out.println(" Is Multiple ");
			select2.selectByIndex(1);
			Thread.sleep(2000);
			select2.selectByValue("bt");
			Thread.sleep(2000);
			select2.selectByVisibleText("Aquaman");
			Thread.sleep(2000);
			select2.deSelectByContainsVisibleText("Black");
			Thread.sleep(2000);
		} else {
			System.out.println("Not multiple");
		}
		
		WebElement drpDwn3 = driver.findElement(By.xpath("//select[@id='lang']"));
		action.scrollToElement(drpDwn3).perform();
		Select select3 = new Select(drpDwn3);
		 List<WebElement> Elements = select3.getOptions();
//		 List<WebElement> selectedAll = select3.getAllSelectedOptions();
		 for(WebElement Element: Elements) {
			 System.out.println(Element.getText());
		 }
		 int size = Elements.size();
		 select3.selectByIndex(size-1);
		 
		 WebElement drpDwn4 = driver.findElement(By.id("country"));
		 Select select4 = new Select(drpDwn4);
		 select4.selectByVisibleText("India");
		 WebElement ele = select4.getFirstSelectedOption();
		 System.out.println(ele.getAttribute("Value"));
		 
		 
		driver.quit();
		
	}

}
