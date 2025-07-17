package AutomationTestStore;

import java.awt.event.WindowEvent;
import java.net.URI;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCasses {
	
WebDriver driver = new ChromeDriver();
String theURL= "https://automationteststore.com/";
String Register="https://automationteststore.com/index.php?rt=account/create";
Random rand=  new Random();
String theUserName ;
String thePassword ="abd7894562*";
@BeforeTest
	public void MySetup() {
	driver.get(theURL);
	driver.manage().window().maximize();
	
}

@Test(priority = 1,enabled = true)
public void FirstTist() throws InterruptedException {
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
	String [] firstNames= {"salam","noor"};
	int randInputFirstName = rand.nextInt(firstNames.length);
	String randFirstName=firstNames[randInputFirstName];
	String [] lastNames= {"abd","salameh","mohammad"};
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
	WebElement RegionStateInput = driver.findElement(By.id("AccountFrm_zone_id"));
	WebElement 	ZIPCodeInput = driver.findElement(By.id("AccountFrm_postcode"));

//Data - Your Address	
	String company= "me";
	String address1="Irbid";
	String address2= "Al-Rafed";
	String city="Irbid";
	String ZIPCode="5589";

	
//Action - Your Address	
	companyInput.sendKeys(company);
	address1Input.sendKeys(address1);
	address2Input.sendKeys(address2);
	cityInput.sendKeys(city);
	ZIPCodeInput.sendKeys(ZIPCode);
	

	//country	
	/*
		Select countrySelect = new Select(countryInput);
		int optionsCountCountry = countrySelect.getOptions().size();
		int randomCountryIndex = rand.nextInt(1,optionsCountCountry);
		countrySelect.selectByIndex(randomCountryIndex);
		*/
	
	Select countrySelect = new Select(countryInput);
	int optionCountry = countryInput.findElements(By.tagName("option")).size();
	int randomCountry= rand.nextInt(1,optionCountry);
	countrySelect.selectByIndex(randomCountry);

	
	Thread.sleep(1000);
	
	//RegionState	
	
	Select RegionStateSelect = new Select(RegionStateInput);
	int optionRegionState = RegionStateInput.findElements(By.tagName("option")).size();
	int randomRegionState = rand.nextInt(1,optionRegionState);
	RegionStateSelect.selectByIndex(randomRegionState);
	/*
    Select RegionStateSelect = new Select(RegionStateInput);
	int optionsCountRegionState = RegionStateSelect.getOptions().size();
	int randomRegionStateIndex = rand.nextInt(1,optionsCountRegionState);
	RegionStateSelect.selectByIndex(randomRegionStateIndex);
	
	-------------------------------------------------------
	
	Select mySelectForTheState = new Select(StateSelect);
	int randomStateIndex = rand.nextInt(1, numberOfOptions);
	mySelectForTheState.selectByValue("1705");
	*/


//Elements - Login Details
	WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));	
	WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));	
	WebElement PasswordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));	

	
//Data - Login Details
	theUserName= randFirstName+randLastName+randNum;
	String LoginName = theUserName;
	String Password = thePassword;
	String PasswordConfirm = thePassword;
 
//Action - Login Details
	LoginNameInput.sendKeys(LoginName);
	PasswordInput.sendKeys(Password);
	PasswordConfirmInput.sendKeys(PasswordConfirm);
	
	
//Action	
	WebElement PrivacyPolicy = driver.findElement(By.id("AccountFrm_agree"));	
	PrivacyPolicy.click();
	WebElement Continue = driver.findElement(By.xpath("//button[@title='Continue']"));	
	Continue.click();
}
	@Test (priority = 2,enabled = true)
	public void logOut () throws InterruptedException {
		
		WebElement logoutButton = driver.findElement(By.linkText("Logoff"));
		logoutButton.click();
		Thread.sleep(1000);
		WebElement ContinueButton = driver.findElement(By.linkText("Continue"));
		ContinueButton.click();
		
	}
	@Test (priority = 3,enabled = true)
	public void logIn () {
		WebElement logInButton = driver.findElement(By.partialLinkText("Login or"));
		logInButton.click();
		WebElement userName =driver.findElement(By.id("loginFrm_loginname"));
		WebElement password = driver.findElement(By.id("loginFrm_password"));
		userName.sendKeys(theUserName);
		password.sendKeys(thePassword);
		WebElement login= driver.findElement(By.xpath("//button[@title='Login']"));
		login.click();
		
	}
	
	@Test (priority = 4,invocationCount = 1,enabled = true)
	public void cart () throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().to(theURL);
		Thread.sleep(2000);
		
		List<WebElement> listOfItem= driver.findElements(By.className("prdocutname"));
		int numOfItem = listOfItem.size();
		int randIndex = rand.nextInt(numOfItem);
		listOfItem.get(randIndex).click();
		
		//Elements
		WebElement price = driver.findElement(By.className("productfilneprice"));
		WebElement numberOfQuantity = driver.findElement(By.id("product_quantity"));
		WebElement addToCart=driver.findElement(By.xpath("//a[normalize-space()='Add to Cart']"));
		
		
		if (driver.getPageSource().contains("Out of Stock")) {
			driver.navigate().back();
			System.out.println("Sorry the item is Out of Stock");
		}
		else {
			
			System.out.println("The item is available");
			
			String priceText= price.getText().replace("$", "");
			double priceValue = Double.parseDouble(priceText);
			int randNumberOfQuantity = rand.nextInt(2,20);
		//Action	
			numberOfQuantity.clear();
			numberOfQuantity.sendKeys(randNumberOfQuantity+"");
		//Elements	
			double totalPriceValueNum = priceValue*randNumberOfQuantity;
			String totalPriceValueStr = "$" + String.format("%,.2f", totalPriceValueNum);
			
			System.out.println("The total price : "+totalPriceValueStr);
			addToCart.click();
			Thread.sleep(2000);
			
			if (driver.getPageSource().contains(totalPriceValueStr)) {
				
				WebElement checkout=driver.findElement(By.id("cart_checkout2"));
				checkout.click();
				
			Thread.sleep(2000);
			
				WebElement confirmOrderButton= driver.findElement(By.id("checkout_btn"));
				confirmOrderButton.click();
			Thread.sleep(3000);
			
				WebElement ContinueButton = driver.findElement(By.linkText("Continue"));
				ContinueButton.click();
			}
			
			else
			{
				System.out.println("sorry not found the total price equal this number :"+ totalPriceValueStr);
			}
			
			
			
			
			
			
			
		}
		
	}

}
