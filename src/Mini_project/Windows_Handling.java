package Mini_project;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Windows_Handling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\2317696\\eclipse-workspace\\Selenium_Basic\\Browser\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		
		//Open the web application, http://cookbook.seleniumacademy.com/Config.html 
			
		driver.get("http://cookbook.seleniumacademy.com/Config.html ");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Current window title." + driver.getTitle());
		
		
		//Configure your car: White BMW Diesel car with “Parking Sensor”

		WebElement make = driver.findElement(By.name("make"));
		/* Thread.sleep(3000); */
		make.click();
		Thread.sleep(3000);
		Select selMake = new Select(make);
		selMake.selectByIndex(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Diesel']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("parksensor")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[@value='wt']")).click();
		
		Thread.sleep(3000);
		
		
		//Click on Help button. 
		
		driver.findElement(By.id("helpbutton")).click();
		Thread.sleep(3000);
		
		//Click on Online Chat Support button. 
		
		driver.findElement(By.id("chatbutton")).click();
		Thread.sleep(3000);
		
		//Click on Visit Us button. 
		

		driver.findElement(By.id("visitbutton")).click();
		
		//Find and print the number of browser windows opened. 
		//Get the collection of all opened windows. 
		
		
		String currWindow = driver.getWindowHandle();
		Set<String> setAllwindows = driver.getWindowHandles();
		System.out.println("number of browser windows opened  " + setAllwindows.size());
		int count=1;
		for (String wind : setAllwindows) {
			System.out.println("Window (" + count + " ) is " +wind);
			count++;
			
			//Find a browser window whose title equals to "Visit Us" 
			
		//If the browser window with the title "Visit Us" found, print it is found and close the browser window.
			String title = driver.switchTo().window(wind).getTitle();

			if (driver.getTitle().equals("Visit Us")) {
				System.out.println("Browser window with title 'Visit Us' is found.");
				Thread.sleep(5000);
				driver.close();
			}
			
			//Navigate back to main browser window. 
			//Close all the browser windows. 
			Thread.sleep(3000);
			driver.switchTo().window(currWindow);
			System.out.println("After switch back, previous window title is " + driver.getTitle());
		}

		Thread.sleep(3000);
		driver.quit();
	}
}
