package AutomationTestStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCasses {
	
WebDriver driver = new ChromeDriver();
String theURL= "https://automationteststore.com/";
String Register="https://automationteststore.com/index.php?rt=account/create";

@BeforeTest
	public void MySetup() {
	driver.get(theURL);
	driver.manage().window().maximize();
	
}

@Test(priority = 1,enabled = true)
public void FirstTist() {
	driver.navigate().to(Register);
	
	
//Elements 
	
	WebElement firstName =driver.findElement(By.xpath("//*[@id=\"AccountFrm_firstname\"]"));
	//WebElement firstName =driver.findElement(By.name("firstname"));
	
	
	
	
//Action
	firstName.sendKeys("abdalrahman");
	
}


}
