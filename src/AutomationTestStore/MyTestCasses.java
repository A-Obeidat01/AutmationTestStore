package AutomationTestStore;

import java.awt.event.WindowEvent;
import java.util.Random;

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
Random rand=  new Random();

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
	WebElement firstNameInput =driver.findElement(By.name("firstname"));
	WebElement lastNameInput =driver.findElement(By.id("AccountFrm_lastname"));
	WebElement emailInput = driver.findElement(By.id("AccountFrm_email"));
	WebElement phoneNumInput = driver.findElement(By.name("telephone"));
	WebElement faxInput =driver.findElement(By.id("AccountFrm_fax"));
	
//Data - Your Personal Details
	int randNum = rand.nextInt(7000);
	String [] firstNames= {"abd","salam","noor"};
	int randInputFirstName = rand.nextInt(firstNames.length);
	String randFirstName=firstNames[randInputFirstName];
	String [] lastNames= {"abd","salam","noor"};
	int randIndexLastName = rand.nextInt(lastNames.length);
	String randLastName=lastNames[randIndexLastName];
	String  emails= randFirstName+randLastName+randNum+"@gmail.com";
	String phoneNum= "4646454564";
	String fax="hkal4";
	
//Action - Your Personal Details 
	firstNameInput.sendKeys(randFirstName);
	lastNameInput.sendKeys(randLastName);
	emailInput.sendKeys(emails);
	phoneNumInput.sendKeys(phoneNum);
	faxInput.sendKeys(fax);
	
	
//Elements - Your Address	
	WebElement companyInput =driver.findElement(By.id("AccountFrm_company"));
	WebElement address1Input = driver.findElement(By.id("AccountFrm_address_1"));
	WebElement address2Input = driver.findElement(By.id("AccountFrm_address_2"));
	WebElement cityInput =driver.findElement(By.id("AccountFrm_city"));
	WebElement countryInput = driver.findElement(By.id("AccountFrm_country_id"));
	

//Data - Your Address	
	String company= "me";
	String address1="Irbid";
	String address2= "Al-Rafed";
	String city="Irbid";
	String country= "Jordan";
	
	
	
//Action - Your Address	
	companyInput.sendKeys(company);
	address1Input.sendKeys(address1);
	address2Input.sendKeys(address2);
	cityInput.sendKeys(city);
	countryInput.sendKeys(country);
	
		
//Elements - Login Details
	WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));	
	WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));	
	WebElement PasswordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));	

	
//Data - Login Details
	String LoginName = randFirstName+randLastName;
	String Password = "abd7894562**";
	String PasswordConfirm = "abd7894562**";
 
//Action - Login Details
	LoginNameInput.sendKeys(LoginName);
	PasswordInput.sendKeys(Password);
	PasswordConfirmInput.sendKeys(PasswordConfirm);
	
	
//Action	
	WebElement PrivacyPolicyInput = driver.findElement(By.id("AccountFrm_agree"));	
	PrivacyPolicyInput.click();
}


}
