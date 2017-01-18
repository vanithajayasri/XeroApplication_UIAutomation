package Selenium_XeroApplication_ModularDrivenFramework_UsingTestNg;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Module extends ReusableMethods_A6{
	static int i =2;
	public  void logintoXero(String usname ,String password) throws IOException, InterruptedException{
	
		WebElement loginLink = elementCssSelector("a[href='https://login.xero.com/']");
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , loginLink);

		//WebElement login = driver.findElement(By.xpath("html/body/div[7]/header/nav/div[3]/div[1]/div/div/div/ul/li[5]/a"));
		
		Thread.sleep(4000);
		WebElement username = elementXpath("//*[@id='email']");
		enterText(username, usname, "username");
		
		WebElement pwd = elementXpath("//*[@id='password']");
		enterText(pwd, password, "password");
		
		WebElement loginButton = elementXpath("//button[text()='Login']");
		clickBUtton(loginButton ,"Login Button");
		
	}
	
	public void loginErrorMessage() throws InterruptedException{
		String expectedError = "Your email or password is incorrect";
		Thread.sleep(4000);
		String actualError =driver.findElement(By.tagName("p")).getText();
		System.out.println(actualError);
		try{
			Assert.assertEquals(actualError, expectedError);
			System.out.println("test Passed");
		}
		catch(Throwable e){
			System.out.println("test failed");
		}
	}
	
	public void signUpXero() throws InterruptedException, IOException{
		Thread.sleep(6000);
		
		//clicking on the FreeTrial link
		WebElement freeTrailLink = elementCssSelector("a[href='/us/signup']");
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , freeTrailLink);
		
		Thread.sleep(6000);
		//entering the first name
		WebElement fname = elementXpath("//input[@name='FirstName']");
		enterText(fname,"sudhakar"," first name");
		
		Thread.sleep(3000);
		//entering the last name
		WebElement lname = elementXpath("//input[@name='LastName']");
		enterText(lname,"tiruveedhula"," last name");
		
		Thread.sleep(3000);
		//entering the email address
		WebElement email = elementXpath("//input[@name='EmailAddress']");
		enterText(email,"89085.gurram@students.itu.edu"," email address");
		
		Thread.sleep(3000);
		//entering the PhoneNumber 
		WebElement phoneNumber = elementXpath("//input[@name='PhoneNumber']");
		enterText(phoneNumber,"6692419631"," PhoneNumber");
		
		Thread.sleep(4000);
		//selecting the country
		Select country = new Select(driver.findElement(By.xpath("//select[@name='LocationCode']")));
		country.selectByVisibleText("Armenia");
		
		Thread.sleep(5000);
	/*	//clicking the captcha
		WebElement captcha = elementXpath("//div[@id='recaptcha-anchor']/div[5]");
		clickBUtton(captcha, "captcha checkbox");*/
		
		Thread.sleep(3000);
		//clicking the termsAgree
		WebElement termsAgree = elementXpath("//input[@name='TermsAccepted']");
		clickBUtton(termsAgree, "termsAgree checkbox");
		
		Thread.sleep(3000);
		//clicking the Get Started
		WebElement getStarted = elementXpath("//button[text()='Get started']");
		clickBUtton(getStarted, "getStarted button");

	}
	
	public void addAnotherOrganization_PaidVersion1(String usname,String password)throws InterruptedException, IOException{
		Module taaopv1 = new Module();
		taaopv1.logintoXero(usname, password);
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
		enterText(nameOfOrganizationsText, "self"+i, "name of organization");
		i++;
		
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
		//clicking the buyNowButton
		WebElement buyNowButton = elementXpath("//a[@id='simplebutton-1030']");
		clickBUtton(buyNowButton ,"Buy Now button ");
		
		//verifying title 
		taaopv1.verifyTitlePage("Xero | Pricing Plan");
		//taaopv1.verifyURL("https://my.xero.com/MyXero/PricingPlan.aspx?");
	}
	
	
	public void addAnotherOrganizationCreditCardDetails() throws InterruptedException, IOException{
		Module aaccd = new Module();
		//credit card details
				Thread.sleep(6000);
				driver.switchTo().frame(idPath("dpsIframe"));
				//enter the valid credit cardnumber
				WebElement creditCardNumberText = elementXpath("//input[@name='CardNumber']");
				enterText(creditCardNumberText, "1234567890123456", "creditCardNumber Text");
				
				Thread.sleep(6000);
				//enter the valid name of the card
				WebElement nameofCardText = elementXpath("//input[@name='CardHolderName']");
				enterText(nameofCardText, "vanitha", "nameof card Text");
				
				//selecting the expire date of card 
				Select expireDateSelection1 = new Select(elementXpath("//*[@id='DateExpiry_1']"));
				expireDateSelection1.selectByVisibleText("05");
				
				Thread.sleep(6000);
				Select expireDateSelection2 = new Select(elementXpath("//*[@id='DateExpiry_2']"));
				expireDateSelection2.selectByVisibleText("19");
				
				Thread.sleep(6000);
				//enter the valid  security code of the card
				WebElement securityCodeText = elementXpath("//input[@name='Cvc2']");
				enterText(securityCodeText, "1234567890123456", "security code Text");
				
				Thread.sleep(6000);
				//clicking on the 'confirm' button
				WebElement confirmButton1 = elementXpath("//*[@id='17773']");
				clickBUtton(confirmButton1 ,"confirm button ");
				
				aaccd.verifyTitlePage("");	
	}
	
	public void addAnotherOrganizationFillingBillingContactDetails() throws InterruptedException, IOException{
		Module aabcd = new Module();
		Thread.sleep(6000);
		//enter the valid street address
		WebElement streetAddressText = elementXpath("//*[@id='POAddress']");
		enterText(streetAddressText, "3450 granada ave", "Street Address");
		
		Thread.sleep(6000);
		//enter the valid city
		WebElement cityText = elementXpath("//*[@id='POCity']");
		enterText(cityText, "santa clara", "city");

		Thread.sleep(6000);
		//clicking the menu and entering  the valid state
		WebElement stateMenu = elementXpath("//*[@id='PORegionDropdown_toggle']");
		clickBUtton(stateMenu ,"state Menu  button");
		WebElement stateText = elementXpath("//*[@id='PORegionDropdown_suggestions']/div/div[5]");
		clickBUtton(stateText ,"stateText California i");
		
		Thread.sleep(6000);
		//enter the valid zipcode
		WebElement zipcodeText = elementXpath("//*[@id='POPostalCode']");
		enterText(zipcodeText, "95051", "zipcode");		
		
		Thread.sleep(6000);
		//clicking on the 'continue' button
		WebElement continueButton1 = elementXpath("//*[@id='ext-gen4']/span");
		clickBUtton(continueButton1 ,"Continue button ");	
		
		//verifying the tile 
		aabcd.verifyTitlePage("Xero | Confirm");
	}
	
	public static void switchToWindow(String parentWindow) throws InterruptedException{
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		 System.out.println("Title of the page after - switchingTo: " + driver.getTitle());
		//code to do something on new window
		 Thread.sleep(6000);
		driver.close(); // close newly opened window when done with it
		Thread.sleep(6000);
		driver.switchTo().window(parentWindow); // switch back to the original window
		System.out.println("Title of the parent window - switchingTo: " + driver.getTitle());
	}
	
	public   void verifyTitlePage(String title) throws InterruptedException{
		String expectedTitle = title;
		Thread.sleep(4000);
		String actualTitle =driver.getTitle();
		System.out.println(actualTitle);
		try{
			Assert.assertEquals(actualTitle, expectedTitle);
			System.out.println("test Passed");
		}
		catch(Throwable e){
			System.out.println("test failed");
		}
	}
	
	public  void verifyURL(String url) throws InterruptedException{
		String expectedURL = url;
		Thread.sleep(4000);
		String actualURL =driver.getCurrentUrl();
		System.out.println(actualURL);
		try{
			Assert.assertEquals(actualURL, expectedURL);
			System.out.println("test Passed");
		}
		catch(Throwable e){
			System.out.println("test failed");
		}
	}
	
	/*Name of the Method : nemu list 
	 * Brief Description : getting the list of the menu 
	 * Arguments : xpathExp --> String xpathExp
	 * Creation of Date :  Oct 21 ,2016
	 * last Modified :  Oct 21,2016
	 * Created by: Enexus Automation team
	 * */
	public  void menuList(String xpathExpression ,String[] exp){
		int count =0;
		WebElement  reportsMenu  = elementXpath(xpathExpression);
		List<WebElement> dropDown = reportsMenu.findElements(By.tagName("li"));
		for(WebElement item : dropDown){
			for (int i = 0; i < exp.length; i++) {
	            if (item.getText().equals(exp[i])) {
	                count++;
	            }
	        }
			System.out.println( item.getText());
	    }
	    if (count == exp.length) {
	        System.out.println("menu drop down matched");
	    } else {
	        System.out.println("Houston, we have a problem in matchin the drop down menu.");
	    }
	
	}
	
	/*Name of the Method : verifying items 
	 * Brief Description : getting the list of the items 
	 * Arguments : xpathExp --> String xpathExp_one , start number , length , string array of expected items 
	 * Creation of Date :  Oct 28 ,2016
	 * last Modified :  Oct 28,2016
	 * Created by: Enexus Automation team
	 * */
	
	public  void veriyingItems(String xpathExpression_one, int start , int length , String[] expectedItems){
		//verifying the list
		int count =0 ;
		try{
				for(int i = start ;i<=length ;i++){
					String one =xpathExpression_one;
					int two = i ;
					String three ="]/a";
					WebElement  items  = elementXpath(one+ two +three);
					String actualContactsItems = items.getText();
					if(expectedItems[i-1].equalsIgnoreCase(actualContactsItems)){
						count ++ ;
					}
				}
		}	
		catch(Exception e){
			System.out.println(" exception occurs");
		}
		
		if(count==expectedItems.length){
			System.out.println(" menu matched");
		}
		else{
			System.out.println("menu not matched");
		}
	}
	
	
	/*Name of the Method : verifying Message 
	 * Brief Description : getting the list of the items 
	 * Arguments : xpathExp --> String xpathExp_one , start number , length , string array of expected items 
	 * Creation of Date :  Oct 28 ,2016
	 * last Modified :  Oct 28,2016
	 * Created by: Enexus Automation team
	 * */
	
	public  void veriyingMessage(String expectedMessage,WebElement element,String attribute){
		//verifying the message 
		String actualMessage = element.getAttribute(attribute);
		
		
		if(actualMessage.equalsIgnoreCase(expectedMessage)){
			System.out.println(expectedMessage +  " :    message  matched");
		}
		else{
			System.out.println(expectedMessage +  " :    message not  matched");
		}
	}
	
	/*Name of the Method : verifying Message  using getText method 
	 * Brief Description : getting the list of the items 
	 * Arguments : xpathExp --> String xpathExp_one , start number , length , string array of expected items 
	 * Creation of Date :  Oct 28 ,2016
	 * last Modified :  Oct 28,2016
	 * Created by: Enexus Automation team
	 * */
	
	public  void veriyingMessageUsingGetText(String expectedMessage,WebElement element){
		//verifying the message 
		String actualMessage = element.getText();
		
		
		if(actualMessage.equalsIgnoreCase(expectedMessage)){
			System.out.println(expectedMessage +  " :    message  matched");
		}
		else{
			System.out.println(expectedMessage +  " :    message not  matched");
		}
	}
	
	/*Name of the Method : vverifyigContactDetails method  
	 * Brief Description : getting the list of the entered contact
	 * Arguments : xpathExp --> array of  with String expected details  , contact details xpath, tagname  
	 * Creation of Date :  Oct 31 ,2016
	 * last Modified :  Oct 31,2016
	 * Created by: Enexus Automation team
	 * */
	public static void verifyigContactDetails(String[] expectedDetails, WebElement contactDetailsXpath , String tagname1 ){
		List<WebElement> detailsList = contactDetailsXpath.findElements(By.tagName(tagname1));
		String[] actualDetails = new String[expectedDetails.length];
		int j=0;
		for(WebElement eachDetail: detailsList ){
			String item = eachDetail.getText();
			System.out.println(item);
			actualDetails[j] = item;
			j++;
		}
		for(int k=0; k<actualDetails.length ;k++){
			if(expectedDetails[k].equalsIgnoreCase(actualDetails[k])){
				System.out.println(actualDetails[k] + ":  is matched");
			}
			else{
				System.out.println(actualDetails[k] + ":  is not matched");
			}
		}
		
	}
	
}
