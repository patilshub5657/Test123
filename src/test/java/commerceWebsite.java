import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class commerceWebsite {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//drivers/msedgedriver.exe");
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
			
	}

}
	