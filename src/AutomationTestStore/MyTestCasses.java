package AutomationTestStore;

import java.awt.event.WindowEvent;

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
	
	
//Elements - Your Personal Details 
	
	//WebElement firstName =driver.findElement(By.xpath("//*[@id=\"AccountFrm_firstname\"]"));
	WebElement firstName =driver.findElement(By.name("firstname"));
	WebElement lastName =driver.findElement(By.id("AccountFrm_lastname"));
	WebElement email = driver.findElement(By.id("AccountFrm_email"));
	WebElement phoneNum = driver.findElement(By.name("telephone"));
	WebElement fax =driver.findElement(By.id("AccountFrm_fax"));
	
	
	
//Action - Your Personal Details 
	firstName.sendKeys("abdalrahman");
	lastName.sendKeys("obeidat");
	email.sendKeys("abdalrahman.obe@gmail.com");
	phoneNum.sendKeys("45345434354");
	fax.sendKeys("hkal4");
	
	
//Elements - Your Address	
	WebElement company =driver.findElement(By.id("AccountFrm_company"));
	WebElement address1 = driver.findElement(By.id("AccountFrm_address_1"));
	WebElement address2 = driver.findElement(By.id("AccountFrm_address_2"));
	WebElement city =driver.findElement(By.id("AccountFrm_city"));
	WebElement country = driver.findElement(By.id("AccountFrm_country_id"));
	

	
	
//Action - Your Address	
	company.sendKeys("me");
	address1.sendKeys("Irbid");
	address2.sendKeys("Al-Rafed");
	city.sendKeys("Irbid");
	country.sendKeys("Jordan");
	
	
	
}


}
