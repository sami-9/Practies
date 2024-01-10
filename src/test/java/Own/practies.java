package Own;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
public class practies {

	public static void main(String[] args) throws InterruptedException {
	     //Step 1: Lunch the browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2: Load the Application
		driver.get("http://localhost:8888/");
		
		//Step 3: Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("sami");
		driver.findElement(By.id("submitButton")).click();		//Step 4: Click on Contact link
		
		//Step 5: Click on create Leads look image
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		
		//Step 6: Create new Leads 
		driver.findElement(By.name("lastname")).sendKeys("sami");
		driver.findElement(By.name("company")).sendKeys("sami");
		
		//Step 7:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8:Validate
		String LeadsHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(LeadsHeader.contains("sami")) {
			System.out.println(LeadsHeader);
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		//Step 9:Logout of App
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Step 10: Close the browser
		driver.quit();

	}

}
