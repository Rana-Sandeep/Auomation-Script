package Script;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class New_Emp_Registration {

	public static void main(String[] args) {
		
		//Script to check New Registered Employee is displayed in Employee List Table or not?
		
        System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
				
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://orangehrm.qedgetech.com");	
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		driver.findElement(By.id("firstName")).sendKeys("Saneep");
		driver.findElement(By.id("lastName")).sendKeys("Rana");
		
			String empno = driver.findElement(By.id("employeeId")).getAttribute("value");
			driver.findElement(By.id("btnSave")).click();
		
			driver.findElement(By.linkText("Employee List")).click();
			driver.findElement(By.id("empsearch_id")).sendKeys(empno);
			driver.findElement(By.id("searchBtn")).click();
			
			WebElement emptable = driver.findElement(By.id("resultTable"));

			List<WebElement> rows,cols;
			
			rows = emptable.findElements(By.tagName("tr"));
			
			boolean isempexist = false;
			for(int i=1;i<rows.size();i++)
			{
				cols = rows.get(i).findElements(By.tagName("td"));
				if(cols.get(1).getText().equals(empno))
				{
					isempexist = true;
					break;
				}
			}
		
		if(isempexist)
		{
			System.out.println("New Registered Employee is displayed in Employee List, Test Pass");
		}else
		{
			System.out.println("New Registered Employee is not displayed in Employee List, Test Fail");
		}
		driver.close();
}

		
	}


