import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/table");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
/*		
 * First table
		List<WebElement> shopList = driver.findElements(By.xpath("//table[@id='shopping']/tbody/tr"));
		int shopListSize=shopList.size();
		int expectedTotal =0;
		int actualTotal =0;
		String priceExpt;
		
		
		for(int i=1;i<=shopListSize;i++) {
			priceExpt = driver.findElement(By.xpath("//table[@id='shopping']/tbody/tr["+i+"]/td[2]")).getText();
			expectedTotal+=Integer.parseInt(priceExpt);
		//	System.out.println("Expected amount is " +expectedTotal);
		}
		
		actualTotal=Integer.parseInt(driver.findElement(By.xpath("//table[@id='shopping']//td[normalize-space()='Total']/following-sibling::td/b")).getText());
		if(actualTotal==expectedTotal) {
			System.out.println("Amount is same");
			System.out.println("Actual amount is " +actualTotal);
			System.out.println("Expected amount is " +expectedTotal);
		}
	*/	
		WebElement scrollTo = driver.findElement(By.xpath("//table[@id='shopping']//td[normalize-space()='Total']/following-sibling::td/b"));
		JavascriptExecutor  js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollTo);
		
		//to avoid hardcoding we wil get the Last Name column's index and use that to find last name in xpath
		String colName;
		int colIndex=0;
		int presentIndex=0;
		List<WebElement> attendanceListColName = driver.findElements(By.xpath("//table[@id='simpletable']/thead/tr/th"));
		for(int k=1;k<=attendanceListColName.size();k++) {
			colName=driver.findElement(By.xpath("//table[@id='simpletable']/thead/tr/th["+k+"]")).getText();
			if(colName.equals("Last name")) {
				colIndex=k;
			}
			if(colName.equals("Present/Absent")) {
				presentIndex=k;
			}
			
		}
		System.out.println("Last Name ColIndex " +colIndex);
		System.out.println("Present/Absent ColIndex " +colIndex);
		List<WebElement> presentList = driver.findElements(By.xpath("//table[@id='simpletable']/tbody/tr"));
		String name;
		for(int j=1;j<presentList.size();j++) {
			name=driver.findElement(By.xpath("//table[@id='simpletable']/tbody/tr["+j+"]/td["+colIndex+"]")).getText().trim();  
			if(name.equals("Raj")) {
				driver.findElement(By.xpath("//table[@id='simpletable']/tbody/tr/td["+presentIndex+"]")).click();
			}
		}
		driver.close();
	} 

}
