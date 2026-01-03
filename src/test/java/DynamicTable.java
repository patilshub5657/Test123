import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dynamic-table");
		driver.manage().window().maximize();
		WebElement scrollInto = driver.findElement(By.xpath("//h2[contains(text(),'Playground')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollInto);
		// to get col index of CPU and Name
		String colName;
		int cpuIndex=0;
		int nameIndex=0;
		List<WebElement> colNamesList = driver.findElements(By.xpath("//table[@class='table table-striped']/thead/tr/th"));
		for(int i=1;i<=colNamesList.size();i++) {
			colName=driver.findElement(By.xpath("//table[@class='table table-striped']/thead/tr/th["+i+"]")).getText();
			if(colName.equals("CPU")) {
				cpuIndex=i;
			}
			if(colName.equals("Name")) {
				nameIndex=i;
			}
		}
		String browserName;
		int chormeIndex=0;
		List<WebElement> nameList = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td["+nameIndex+"]"));
		for(int j=0;j<nameList.size();j++) {
			browserName=nameList.get(j).getText();
			if(browserName.equals("Chrome")) {
				chormeIndex=j+1;	
			}
			
		}
		String actualCPU = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+chormeIndex+"]/td["+cpuIndex+"]")).getText();
		System.out.println("Actual CPU : "+actualCPU);
		String exptCPUunExtracted = driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
		String exptCPU = exptCPUunExtracted.replaceAll("[^0-9.%]","");
		System.out.println("Expected CPU : " +exptCPU);
		if(actualCPU.equals(exptCPU)) {
			System.out.println("Matched");
		}
		driver.close();
	}

}
