import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class innerOuterHTML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.Driver", "D:\\Drivers\\chromedriver.exe");
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		String str = driver.findElement(By.xpath("//*[@data-name='Layer 1']")).getAttribute("innerHTML");
		System.out.println(str);
		driver.quit();

	}

}
