package Selenium_XeroApplication_ModularDrivenFramework_UsingTestNg;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AutomationScripts_A6 extends ReusableMethods_A6{
	//this is used for the testcase "Add another organization on trail version 1"
		
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browser) throws InterruptedException{
		if(browser.equalsIgnoreCase("firefox")) {
			 
			  driver = new FirefoxDriver();
		 
		  // If browser is IE, then do this	  
		 
		  }else if (browser.equalsIgnoreCase("ie")) { 
		 
			  // Here I am setting up the path for my IEDriver
		 
			  System.setProperty("webdriver.ie.driver", "C://Users//sudt//Downloads//IEDriverServer_x64_2.53.1//IEDriverServer (2).exe");
		 
			  driver = new InternetExplorerDriver();
		 
		  } 
		  else if (browser.equalsIgnoreCase("chrome")){
			  System.setProperty("webdriver.chrome.driver", "C://Users//sudt//Downloads//chromedriver_win32//chromedriver.exe");
			  driver = new ChromeDriver();
		  }
		  else {
              throw new IllegalArgumentException("The Browser Type is Undefined");
       }

		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
	
	
	}
	
	@AfterMethod
	public void closingBrowser(){
		driver.close();
	}
	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestDataProvider")
	public void loginTest(String url ,String usname,String password) throws InterruptedException, IOException{
		Module login = new Module();
		login.logintoXero(usname ,password);
		
	}
	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestIncorrecPasswordtDataProvider")
	public void inCorrectPasswordloginTest(String url ,String usname,String password) throws InterruptedException, IOException{
		Module incorrectPassword = new Module();
		incorrectPassword.logintoXero(usname ,password);
		incorrectPassword.loginErrorMessage();
		
	}
	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestIncorrectUsernameDataProvider")
	public void inCorrectEmailLoginTest(String url ,String usname,String password) throws InterruptedException, IOException{
		Module incorrectEmail = new Module();
		incorrectEmail.logintoXero(usname ,password);
		incorrectEmail.loginErrorMessage();
		
	} 
	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="ForgetPasswordDataProvider")
	public void forgetPasswordTest(String url ,String usname,String password) throws InterruptedException, IOException{
		//clicking on the Login link
		WebElement loginbutton = elementCssSelector("a[href='https://login.xero.com/']");
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , loginbutton);
		
		Thread.sleep(6000);
		//clicking on the forget password?  link
		WebElement forgetPasswordLink = elementCssSelector("a[href='/ForgottenPassword']");
		forgetPasswordLink.click();
				
		Thread.sleep(8000);
		WebElement email = elementXpath("//*[@id='UserName']");
		enterText(email,usname ,"email");
		
		Thread.sleep(5000);
		//clicking on the email button
		WebElement senLinkButton = elementXpath("//*[@id='submitButton']/a/span");
		clickBUtton(senLinkButton ,"sen link Button");
	} 
	
	@Test
	public void signUpTest() throws InterruptedException, IOException{
		Module signup = new Module();
		signup.signUpXero();
		signup.verifyTitlePage("Sign up for Xero & Trial Free | Xero | Xero");
		signup.verifyURL("https://www.xero.com/us/signup/success/"); 
		
	} 
	
	@Test
	public void signUp_TermsOfUse_PrivacyPolicy_PageTesting() throws IOException, InterruptedException{
		Module signup_tou_pp = new Module();
		Thread.sleep(6000);
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		
		//clicking on the FreeTrial link
		WebElement freeTrailLink = elementCssSelector("a[href='/us/signup']");
		jse.executeScript("arguments[0].click();" , freeTrailLink);	
		Thread.sleep(8000);
		
		//parent window
		String parentWindow = driver.getWindowHandle();
		System.out.println("Title of the parent  page  - switchingTo: " + driver.getTitle());
		
		Thread.sleep(8000);
		//clicking on the terms of use link
		WebElement termOfUseLink = linkXpath("terms of use");
		clickBUtton(termOfUseLink ,"term Of Use Link");
		signup_tou_pp.switchToWindow(parentWindow);
		
		
		Thread.sleep(8000);
		//clicking on the privacy and policy link
		WebElement privacyAndPolicyLink  = linkXpath("privacy policy");
		clickBUtton(privacyAndPolicyLink ,"privacyAndPolicy Link");
				
		Thread.sleep(8000);
		signup_tou_pp.switchToWindow(parentWindow);
	} 
	
	@Test
	public void signUp_offerDetails_PageTesting() throws InterruptedException, IOException{
		Module signup_od = new Module();
		Thread.sleep(6000);	
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		
		//clicking on the FreeTrial link
		WebElement freeTrailLink = elementCssSelector("a[href='/us/signup']");
		jse.executeScript("arguments[0].click();" , freeTrailLink);	
		
		Thread.sleep(6000);	
		//parent window
		String parentWindow = driver.getWindowHandle();
		System.out.println("Title of the parent  page  - switchingTo: " + driver.getTitle());
		
		Thread.sleep(6000);	
		//clicking on the offer details link
		WebElement offerDetailsLink = linkXpath("offer details");
		clickBUtton(offerDetailsLink ,"offer details");
		signup_od.switchToWindow(parentWindow);
	} 
	
	@Test
	public void signUp_accountant_PageTesting() throws InterruptedException, IOException{
		//Module signup_a = new Module();
		Thread.sleep(8000);	
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		
		//clicking on the FreeTrial link
		WebElement freeTrailLink = elementCssSelector("a[href='/us/signup']");
		jse.executeScript("arguments[0].click();" , freeTrailLink);	
		
		Thread.sleep(8000);	
		//parent window
		String parentWindow = driver.getWindowHandle();
		System.out.println("Title of the parent  page  - switchingTo: " + driver.getTitle());
		
		Thread.sleep(8000);	
		//clicking on the offer details link
		WebElement accountantLink = linkXpath("accountant or bookkeeper");
		clickBUtton(accountantLink ,"accountant or bookkeeper link");
		Thread.sleep(8000);	
		
		//switch to new window
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		 System.out.println("Title of the page after - switchingTo: " + driver.getTitle());
		//code to do something on new window
		 Thread.sleep(6000);
		driver.switchTo().window(parentWindow); // switch back to the original window
		System.out.println("Title of the parent window - switchingTo: " + driver.getTitle());

	}
	
	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestDataProvider")
	public void testAllTabsPage(String url ,String usname,String password) throws InterruptedException, IOException{
		Module tatp = new Module();
		tatp.logintoXero(usname, password);
		Thread.sleep(4000);
		//clicking on the dashboard link
		WebElement dashboardLink = elementXpath("//*[@id='Dashboard']");
		clickBUtton(dashboardLink ,"Dashboard Link");
		tatp.verifyTitlePage("Xero | Dashboard | enexus");
		tatp.verifyURL("https://go.xero.com/Dashboard/Default3.aspx");
		
		Thread.sleep(4000);
		//clicking on the Accounts link
		String[] accountExpectedtems ={"Bank Accounts","Sales","Purchases","Checks","Inventory","Expense Claims","Fixed Assets"};
		WebElement  accountsLink  = elementXpath("//*[@id='Accounts']");
		clickBUtton( accountsLink  ," Accounts  Link");
		tatp.verifyTitlePage("Xero | Dashboard | enexus");
		tatp.veriyingItems("//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[2]/ul/li[",1, 7 , accountExpectedtems);
		
		
		
		Thread.sleep(4000);
		//clicking on the reports link
		String[] reportsItems1 ={"All Reports","Budget Manager"};
		String[] reportsItems2= {"Aged Payables","Aged Receivables","Balance Sheet","Cash Summary","Income Statement","Sales Tax Report"};
		WebElement  reportsLink  = elementXpath("//*[@id='Reports']");
		clickBUtton( reportsLink  ," Reports  Link");
		tatp.verifyTitlePage("Xero | Dashboard | enexus");
		tatp.veriyingItems("//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[2]/ul/li[",1, 2 , reportsItems1);
		tatp.veriyingItems("//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[2]/ul/li[",3, 9 , reportsItems2);
		
		
		
		Thread.sleep(4000);
		//clicking on the contacts link
		String[] contactsExpectedItems ={"All Contacts","Customers","Suppliers"};
		WebElement  contactsLink  = elementXpath("//*[@id='Contacts']");
		clickBUtton( contactsLink  ," contacts  Link");
		tatp.verifyTitlePage("Xero | Dashboard | enexus");
		Thread.sleep(4000);
		tatp.veriyingItems("//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[5]/ul/li[",1, 3 , contactsExpectedItems);
	
	
		Thread.sleep(4000);
		//clicking on the settings link
		String[] settingsExpectedItems ={"General Settings","Favorites","Chart of Accounts","Payroll Settings"};
		WebElement  settingsLink  = elementXpath("//*[@id='Settings']");
		clickBUtton( settingsLink  ," settings  Link");
		tatp.verifyTitlePage("Xero | Dashboard | enexus");
		Thread.sleep(4000);
		tatp.veriyingItems("//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[6]/ul/li[",1, 4 , settingsExpectedItems);
		tatp.veriyingItems("//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[6]/ul/li[",3, 4 , settingsExpectedItems);

		
		
		
		Thread.sleep(4000);
		//clicking on the ' + '/new  link
		String[] newExpectedItems ={"Invoice","Bill","Quote","Purchase Order","Contact"};
		WebElement   newLink  = elementXpath("//*[@id='quicklaunchTab']");
		clickBUtton(  newLink  ,"  new Link");
		tatp.verifyTitlePage("Xero | Dashboard | enexus");
		Thread.sleep(4000);
		tatp.veriyingItems("//*[@id='quicklaunchPanel']/div/div/div[2]/div/ul/li[",1, 5 , newExpectedItems);
		
		
		
		Thread.sleep(4000);
		//clicking on the file link
		String[] fileExpectedItems ={"Invoice","Bill","Quote","Purchase Order","Contact"};
		Thread.sleep(4000);
		WebElement   fileLink  = elementXpath("//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a");
		clickBUtton(  fileLink  ,"  file Link");
		Thread.sleep(4000);
		tatp.verifyTitlePage(" Xero | Files | enexus");
		tatp.verifyURL("https://go.xero.com/Docs/Folders#139030f2-c276-48bc-a769-5289e9056309");
		
		
		
		Thread.sleep(4000);
		//clicking on the notifications link
		
		WebElement   notificationsLink  = elementXpath("//a[@class='notifications x-sandbox']");
		clickBUtton(  notificationsLink  ,"  notifications Link");
		
		//move on to the iframe notifications page
		WebElement   notificationsFrame  = elementXpath("//iframe[@id='post_office_frame']");
		driver.switchTo().frame(notificationsFrame);
		Thread.sleep(4000);
		//getting the title of the page 
		String expectedMessage ="Search";
		WebElement   headingOfNotification  = elementXpath("//*[@id='app']/div/div[2]/div[1]");
		tatp.veriyingMessageUsingGetText(expectedMessage,headingOfNotification);
			
		//switching back to normal page
		driver.switchTo().defaultContent();
		
		
		Thread.sleep(4000);
		//clicking on the search link
		
		WebElement   searchLink  = elementXpath("//a[@class='search']");
		clickBUtton(  searchLink  ," search Link");
		
		//move on to the iframe notifications page
		WebElement   searchFrame  = elementXpath("//iframe[@id='GlobalSearchApp']");
		driver.switchTo().frame(searchFrame);
		Thread.sleep(4000);
		//getting the title of the page 
		WebElement   searchDropdown = elementXpath("//*[@id='placeholder']");
		tatp.veriyingMessage("Notifications",searchDropdown, "value");

		
		//switching back to normal page
		driver.switchTo().defaultContent();
		
		
		Thread.sleep(4000);
		//clicking on the help link
		WebElement   helpLink  = elementXpath("//a[@class='help']");
		clickBUtton(  helpLink  ,"  help Link");

		Thread.sleep(4000);
		//getting the title of the page 
		WebElement   helpfieldArea = elementXpath("//*[@id='menu_help']");
		tatp.veriyingMessage("What do you need help with?",helpfieldArea, "placeholder");
	
	}
	
	
	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestDataProvider")
	public void testLogoutFunctionality(String url ,String usname,String password) throws InterruptedException, IOException{
		Module tlf = new Module();
		tlf.logintoXero(usname, password);
		Thread.sleep(4000);
		//clicking on the usermenu link
		WebElement   userMenuLink  = elementXpath("//a[@class='username']");
		clickBUtton(  userMenuLink  ,"  userMenu Link");

		Thread.sleep(4000);
		WebElement   logOutLink = linkXpath("Logout");
		clickBUtton(  logOutLink  ,"  logOut Link");
		Thread.sleep(4000);
		WebElement usernameAfterLogOut = elementXpath("//*[@id='email']");
		tlf.veriyingMessage("vanitha.gurram@gmail.com",usernameAfterLogOut ,"value");
		
	}
	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestDataProvider")
	public void testUploadProfileImage(String url ,String usname,String password)throws InterruptedException, IOException{
		Module tupi = new Module();
		tupi.logintoXero(usname, password);
		Thread.sleep(4000);
		//clicking on the usermenu link
		WebElement   userMenuLink  = elementXpath("//a[@class='username']");
		clickBUtton(  userMenuLink  ,"  userMenu Link");

		Thread.sleep(4000);
		//clicking on profile link
		WebElement   profileLink = linkXpath("Profile");
		clickBUtton(  profileLink  ,"  profile Link");
		Thread.sleep(4000);
		tupi.verifyTitlePage("My Xero | Profile Settings");
		tupi.verifyURL("https://my.xero.com/!xkcD/Settings/User");
		
		Thread.sleep(4000);
		//clicking on uploadImage link
		WebElement   uploadImageLink = elementXpath("//*[@id='button-1041-btnInnerEl']");
		clickBUtton(  uploadImageLink  ,"  uploadImage Link");
		
		//switch to other widow
		String parentHandle = driver.getWindowHandle();
		System.out.println("Title of the page before - switchingTo: " + driver.getTitle());
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		Thread.sleep(4000);
		//clicking on browse link
		WebElement   browseLink = elementXpath("//*[@id='filefield-1175-button']");
		clickBUtton(  browseLink  ,"  browse  Link");

		//clicking on browse link
		Thread.sleep(4000);
		WebElement   uploadLink = elementXpath("//*[@id='button-1179-btnInnerEl']");
		clickBUtton(  uploadLink  ,"  upload Link");
		System.out.println("Title of the page after - switchingTo: " + driver.getTitle());
				
		//to check whether image is present or not 
		WebElement ImageFile = elementXpath("//img[@class='your-logo']");
        
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        if (!ImagePresent)
        {
             System.out.println("Image not displayed.");
        }
        else
        {
            System.out.println("Image displayed.");
        }
	}
	
	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestDataProvider")
	public void testAddAnotherOrganizationTrailVersion1(String url ,String usname,String password)throws InterruptedException, IOException{
		Module taaotv1 = new Module();
		taaotv1.logintoXero(usname, password);
		Thread.sleep(4000);
//
		//clicking the enexus link on the to left menu
		WebElement enenxusLink = elementXpath("//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2");
		clickBUtton(enenxusLink ,"enenxus Link ");
		
		Thread.sleep(8000);
		//clicking the my xero link
		WebElement myXeroLink = linkXpath("My Xero");
		clickBUtton(myXeroLink ,"myXero Link");

		Thread.sleep(8000);
		//clicking the addMoreOrganizationsLink
		WebElement addMoreOrganizationsLink = elementXpath("//a[@href='/!xkcD/Organisation/Setup']");
		clickBUtton(addMoreOrganizationsLink ,"add more organizations Link");	
		
		Thread.sleep(8000);
		//enter the name of the organization
		WebElement nameOfOrganizationsText = elementXpath("//input[@name='OrganisationName']");
		enterText(nameOfOrganizationsText, "self", "name of organization");
		
		
		Thread.sleep(6000);
		//clicking on menu and enter the organization pay taxes
		WebElement organizationsPayTaxesMenu = elementXpath("//*[@id='ext-gen1087']");
		clickBUtton(organizationsPayTaxesMenu ,"organizationsPayTaxes Menu ");
		WebElement organizationsPayTaxesText = elementXpath("//*[@id='countryCmb-boundlist-listEl']/ul/li[229]");
		clickBUtton(organizationsPayTaxesText ,"organizationsPayTaxes Text ");
			
		
		Thread.sleep(6000);
		//clicking on menu and enter the time zone
		WebElement timeZoneMenu = elementXpath("//*[@id='ext-gen1091']");
		clickBUtton(timeZoneMenu ,"timeZone Text ");
		WebElement timeZoneText = elementXpath("//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[107]");
		clickBUtton(timeZoneText ,"timeZone Text ");
		
		
		Thread.sleep(6000);
		//clicking on menu andenter the organization do
		WebElement organizationsDoMenu = elementXpath("//*[@id='ext-gen1099']");
		clickBUtton(organizationsDoMenu ,"organizationsDo Text ");
		WebElement organizationsDoText = elementXpath("//*[@id='cmbIndustry-boundlist-listEl']/ul/li[1]");
		clickBUtton(organizationsDoText ,"organizationsDo Text ");
			
		
		Thread.sleep(6000);
		//clicking the startTrailButton
		WebElement startTrailButton = elementXpath("//*[@id='simplebutton-1029']");
		clickBUtton(startTrailButton ,"start trail ");
		
	}
	
	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestDataProvider")
	public void testAddAnotherOrganization_PaidVersion1(String url ,String usname,String password)throws InterruptedException, IOException{
		Module taaopv1 = new Module();
		taaopv1.addAnotherOrganization_PaidVersion1(usname,password);
		
	}
	
	
	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestDataProvider")
	public void testAddAnotherOrganization_starterPlan(String url ,String usname,String password)throws InterruptedException, IOException{
		Module taaosp = new Module();
		taaosp.addAnotherOrganization_PaidVersion1(usname,password);
		Thread.sleep(4000);
		
		//verifying 'purchase plan' title page  
		taaosp.verifyTitlePage("Xero | Pricing Plan");

		Thread.sleep(9000);
		//Choosing 'Starter Plan' on payment options page
		WebElement starterPlanButton = elementXpath("//*[@id='PRODUCTOPTION/ORG/SOLO']/h3");
		clickBUtton(starterPlanButton ,"Starter button ");
		
		Thread.sleep(6000);
		//verifying whether we are Should be able to see the chosen Starter Plan by hightliting with color
		String expectedColor = "rgba(219, 241, 224, 1)";
		WebElement starterPlanButton_BackgroundColor = elementXpath("//*[@id='PRODUCTOPTION/ORG/SOLO']");
		String actualColor = starterPlanButton_BackgroundColor.getCssValue("background-color");
		System.out.println("backgroung color highlighted: " + actualColor);
		if(expectedColor.equalsIgnoreCase(actualColor)){
			System.out.println(" backgorund is highlighted , so it is ready to choose options");
		}
		else{
			System.out.println(" backgorund is not highlighted , so it is  not ready to choose options");
		}
		
		Thread.sleep(6000);
		//clicking on the 'continue' button
		WebElement continueButton = elementXpath("//*[@id='ext-gen4']/span");
		clickBUtton(continueButton ,"Continue button ");
		
		//filling the billing conatct details
		taaosp.addAnotherOrganizationFillingBillingContactDetails();
		
		//Verifying the billing contact details 
		String[] expectedDetails ={"self","vanitha.gurram@gmail.com","6692419631","3450 granada ave","santa clara","California","95051","United States"}; 
		WebElement contactDetailsXpath = elementXpath("//*[@id='frmMain']/div/div/div[1]/fieldset");
		taaosp.verifyigContactDetails(expectedDetails,contactDetailsXpath ,"span" );
		
		//credit card details
		taaosp.addAnotherOrganizationCreditCardDetails();
			
	}	
	

	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestDataProvider")
	public void testAddAnotherOrganization_standaradPlan(String url ,String usname,String password)throws InterruptedException, IOException{
		Module taaostp = new Module();
		taaostp.addAnotherOrganization_PaidVersion1(usname,password);
		Thread.sleep(4000);
		
		//verifying 'purchase plan' title page  
		taaostp.verifyTitlePage("Xero | Pricing Plan");

		Thread.sleep(9000);
		//Choosing 'Standard Plan' on payment options page
		WebElement standardPlanButton = elementXpath("//*[@id='PRODUCTOPTION/ORG/STANDARD']/h3");
		clickBUtton(standardPlanButton ,"standard button ");
		
		Thread.sleep(6000);
		//verifying whether we are Should be able to see the chosen Starter Plan by hightliting with color
		String expectedColor = "rgba(219, 241, 224, 1)";
		WebElement starterPlanButton_BackgroundColor = elementXpath("//*[@id='PRODUCTOPTION/ORG/STANDARD']");
		String actualColor = starterPlanButton_BackgroundColor.getCssValue("background-color");
		System.out.println("backgroung color highlighted: " + actualColor);
		if(expectedColor.equalsIgnoreCase(actualColor)){
			System.out.println(" backgorund is highlighted , so it is ready to choose options");
		}
		else{
			System.out.println(" backgorund is not highlighted , so it is  not ready to choose options");
		}
		
		Thread.sleep(6000);
		//clicking on the 'continue' button
		WebElement continueButton = elementXpath("//*[@id='ext-gen4']/span");
		clickBUtton(continueButton ,"Continue button ");
		
		//filling the billing conatct details
		Thread.sleep(6000);
		taaostp.addAnotherOrganizationFillingBillingContactDetails();
		
		//Verifying the billing contact details 
		String[] expectedDetails ={"self","vanitha.gurram@gmail.com","6692419631","3450 granada ave","santa clara","California","95051","United States"}; 
		WebElement contactDetailsXpath = elementXpath("//*[@id='frmMain']/div/div/div[1]/fieldset");
		taaostp.verifyigContactDetails(expectedDetails,contactDetailsXpath ,"span" );
		
		//credit card details
		taaostp.addAnotherOrganizationCreditCardDetails();
			
	}	

	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestDataProvider")
	public void testAddAnotherOrganization_premiumPlan(String url ,String usname,String password)throws InterruptedException, IOException{
		Module taaopp = new Module();
		taaopp.addAnotherOrganization_PaidVersion1(usname,password);
		Thread.sleep(4000);
		
		//verifying 'purchase plan' title page  
		taaopp.verifyTitlePage("Xero | Pricing Plan");

		Thread.sleep(9000);
		//Choosing 'Premium Plan' on payment options page
		WebElement premiumPlanButton = elementXpath("//*[@id='PRODUCTOPTION/ORG/PRO']/h3");
		clickBUtton(premiumPlanButton ,"premium button ");
		
		Thread.sleep(6000);
		//verifying whether we are Should be able to see the chosen Starter Plan by hightliting with color
		String expectedColor = "rgba(219, 241, 224, 1)";
		WebElement starterPlanButton_BackgroundColor = elementXpath("//*[@id='PRODUCTOPTION/ORG/PRO']");
		String actualColor = starterPlanButton_BackgroundColor.getCssValue("background-color");
		System.out.println("backgroung color highlighted: " + actualColor);
		if(expectedColor.equalsIgnoreCase(actualColor)){
			System.out.println(" backgorund is highlighted , so it is ready to choose options");
		}
		else{
			System.out.println(" backgorund is not highlighted , so it is  not ready to choose options");
		}
		
		Thread.sleep(6000);
		//clicking on the 'continue' button
		WebElement continueButton = elementXpath("//*[@id='ext-gen4']/span");
		clickBUtton(continueButton ,"Continue button ");
		
		//filling the billing conatct details
		Thread.sleep(6000);
		taaopp.addAnotherOrganizationFillingBillingContactDetails();
		
		//Verifying the billing contact details 
		String[] expectedDetails ={"self","vanitha.gurram@gmail.com","6692419631","3450 granada ave","santa clara","California","95051","United States"}; 
		WebElement contactDetailsXpath = elementXpath("//*[@id='frmMain']/div/div/div[1]/fieldset");
		taaopp.verifyigContactDetails(expectedDetails,contactDetailsXpath ,"span" );
		
		//credit card details
		taaopp.addAnotherOrganizationCreditCardDetails();
			
	}	
	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestDataProvider")
	public void testAddAnotherOrganization_withCurrentQuickBooksUser(String url ,String usname,String password)throws InterruptedException, IOException{
		Module taao_wcqbu = new Module();
		taao_wcqbu.logintoXero(usname, password);
		Thread.sleep(8000);
		//clicking the enexus link on the to left menu
		WebElement enenxusLink = elementXpath("//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2");
		clickBUtton(enenxusLink ,"enenxus Link ");
		
		Thread.sleep(8000);
		//clicking the my xero link
		WebElement myXeroLink = linkXpath("My Xero");
		clickBUtton(myXeroLink ,"myXero Link");

		Thread.sleep(8000);
		//clicking the addMoreOrganizationsLink
		WebElement addMoreOrganizationsLink = elementXpath("//a[@href='/!xkcD/Organisation/Setup']");
		clickBUtton(addMoreOrganizationsLink ,"add more organizations Link");	
		
		Thread.sleep(8000);
		//enter the name of the organization
		WebElement nameOfOrganizationsText = elementXpath("//input[@name='OrganisationName']");
		enterText(nameOfOrganizationsText, "self", "name of organization");
		
		Thread.sleep(6000);
		//clicking on menu and enter the organization pay taxes
		WebElement organizationsPayTaxesMenu = elementXpath("//*[@id='ext-gen1087']");
		clickBUtton(organizationsPayTaxesMenu ,"organizationsPayTaxes Menu ");
		WebElement organizationsPayTaxesText = elementXpath("//*[@id='countryCmb-boundlist-listEl']/ul/li[229]");
		clickBUtton(organizationsPayTaxesText ,"organizationsPayTaxes Text ");
		
		
		Thread.sleep(6000);
		//clicking on menu and enter the time zone
		WebElement timeZoneMenu = elementXpath("//*[@id='ext-gen1091']");
		clickBUtton(timeZoneMenu ,"timeZone menu button");
		WebElement timeZoneText = elementXpath("//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[107]");
		clickBUtton(timeZoneText ,"timeZone Text ");
	
		
		Thread.sleep(6000);
		//clicking on menu and enter the organization do
		WebElement organizationsDoMenu = elementXpath("//*[@id='ext-gen1099']");
		clickBUtton(organizationsDoMenu ,"organizationsDo menu button ");
		WebElement organizationsDoText = elementXpath("//*[@id='cmbIndustry-boundlist-listEl']/ul/li[1]");
		clickBUtton(organizationsDoText ,"organizationsDo Text ");
		
		Thread.sleep(6000);
		//clicking on the 'convert your quick books file for free'
		WebElement quickBooksFileLink = elementXpath("//*[@id='conversionLink']");
		clickBUtton(quickBooksFileLink ,"convert your quick books file for free link ");
		
		Thread.sleep(6000);
		//checking the box on the 'currently using quickbooks'
		WebElement quickBooksCheckbox = elementXpath("//*[@id='conversionCheckbox-inputEl']");
		clickBUtton(quickBooksCheckbox ,"currently using quickbooks? checkbox is clicked ");			
		
		Thread.sleep(6000);
		//clicking on the 'continue' button 
		WebElement continueButton = elementXpath("//*[@id='simplebutton-1030']");
		clickBUtton(continueButton ,"continue Button is clicked ");	
		
		taao_wcqbu.verifyTitlePage("My Xero | New Organization");
		
		Thread.sleep(6000);
		//verifying the message  
		String expectedMessage="QuickBooks file conversion";
		WebElement element = elementXpath("//*[@id='tbtext-1045']");
		taao_wcqbu.veriyingMessageUsingGetText(expectedMessage, element);
			
			
	}	
	

	
	@Test(dataProviderClass = Data_Provider_A6.class ,dataProvider="LoginTestDataProvider")
	public void testAddAnotherOrganization_checkIfUserCanllokOutSubScriptionAndbillin(String url ,String usname,String password)throws InterruptedException, IOException{
		Module taao_sb = new Module();
		taao_sb.logintoXero(usname, password);
		
		Thread.sleep(4000);
		//clicking on the Accounts link
		WebElement  accountsLink  = elementXpath("//*[@id='Accounts']");
		clickBUtton( accountsLink  ," Accounts  Link");
		
		//clicking on the Purchases link in the Accounts menu
		WebElement  purchasesLink  = elementXpath("//a[@href='/Accounts/Payable/Dashboard/']");
		clickBUtton( purchasesLink  ," purchases  Link from Accounts Menu");
		
		taao_sb.verifyURL("https://go.xero.com/Accounts/Payable/Dashboard/");
	}	
}
