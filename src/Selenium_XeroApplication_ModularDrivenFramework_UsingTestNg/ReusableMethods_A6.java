package Selenium_XeroApplication_ModularDrivenFramework_UsingTestNg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class ReusableMethods_A6 {

	public static WebDriver driver;
	
	/*Name of the Method : launchBrowser
	 * Brief Description : launching the browser 
	 * Arguments : URL --> String url
	 * Creation of Date : Oct 19 ,2016
	 * last Modified :  Oct 19,2016
	 * Created by: Enexus Automation team
	 * */
	
/*	public static void launchBrowser(String URL) throws InterruptedException{
		//System.setProperty("webdriver.ie.driver", "C://Users//sudt//Downloads//IEDriverServer_x64_2.53.1//IEDriverServer (2).exe");
		driver = new FirefoxDriver(); 
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	
	}*/
	
	/*Name of the Method : elementXpath
	 * Brief Description : xpath of the element
	 * Arguments : xpathExp --> String xpathExp
	 * Creation of Date :  Oct 19 ,2016
	 * last Modified :  Oct 19,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static WebElement elementXpath(String xpathExp){
		
		WebElement element =driver.findElement(By.xpath(xpathExp));
		return element; 
		
	}
	
	/*Name of the Method : elementCssSelector
	 * Brief Description : xpath of the element
	 * Arguments : xpathExp --> String xpathExp
	 * Creation of Date :  Oct 19 ,2016
	 * last Modified :  Oct 19,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static WebElement elementCssSelector(String CssSelectorExp){
		
		WebElement element =driver.findElement(By.cssSelector(CssSelectorExp));
		return element; 
		
	}
	
	/*Name of the Method : idPath
	 * Brief Description : id path of the element
	 * Arguments : xpathExp --> String idExp
	 * return parameters : element Webelement
	 * Creation of Date :  Oct 19 ,2016
	 * last Modified :  Oct 19,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static WebElement idPath(String idExp){
		
		WebElement element =driver.findElement(By.id(idExp));
		return element; 
		
	}
	
	
	/*Name of the Method : linkXpath
	 * Brief Description : xpath of the element
	 * Arguments : xpathExp --> String xpathExp
	 * return parameters : element Webelement
	 * Creation of Date : Sep 30 ,2016
	 * last Modified : Sep 30,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static WebElement linkXpath(String xpathExp){
		
		WebElement element =driver.findElement(By.linkText(xpathExp));
		return element; 
		
	}
	
	/* Name of the Method : Enter Text
	 * Brief Description :Enter text to the text feild
	 * Arguments: Obj --> Object webelement , textnmae--> text value to be entered,onjNmae --> Object Name
	 * Creation of Date : Sep 30 ,2016
	 * last Modified : Sep 30,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static void enterText(WebElement obj , String textName , String ObjName) throws IOException{
		if(obj.isDisplayed()){
			obj.sendKeys(textName);
			//Update_Report("Pass","enterText",  textName + " is entered in the "+ ObjName+ " feild");
			System.out.println("Pass: "+ textName + " is entered in the "+ ObjName+ " feild");
		}
		else{
			//Update_Report("Fail","enterText", textName +" feild is not avalibale please check it.");
			System.out.println("Fail: "+ textName +" feild is not avalibale please check it.");
		}
		
	}
	
	/* Name of the Method : click button 
	 * Brief Description :clicking the button 
	 * Arguments: Obj --> Object webelement ,,objName --> Object Name
	 * Creation of Date : Sep 30 ,2016
	 * last Modified : Sep 30,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static void clickBUtton(WebElement obj,String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.click();
			//Update_Report("Pass","clickBUtton", objName + " is clicked");
			System.out.println("Pass: "+ objName + " is clicked");
		}
		else{
			//Update_Report("Fail","clickBUtton", objName +" is not able to click ");
			System.out.println("Fail: "+ objName +" is not able to click ");
		}
		
	}
	

	
	/* Name of the Method : readXl
	 * Brief Description :reading the xls file
	 * Arguments: String testData --filepath
	 * 			 String sheetName----> name of the sheet 
	 * Creation of Date : oct 6 ,2016
	 * last Modified : oct 6,2016
	 * Created by: Enexus Automation team
	 * */
	
	public static String[][] readXl(String testData ,String sheetName) throws IOException{
		
		
		//get the file path
		File xlfile = new File(testData);
		
		//Access the file
		FileInputStream xldoc = new FileInputStream(xlfile);
		
		//access the work book POI jar file
		HSSFWorkbook wb = new HSSFWorkbook(xldoc);
		
		//access the sheet
		HSSFSheet sheet = wb.getSheet(sheetName);
		
		
		int rowCount = sheet.getLastRowNum() + 1 ;
		int colCount =sheet.getRow(0).getLastCellNum();
		String[][]  xlData =new String[rowCount][colCount];
		
		for(int i =0;i< rowCount;i++){
			for(int j=0 ;j<colCount ;j++){
				xlData[i][j]=sheet.getRow(i).getCell(j).getStringCellValue(); 
				 
			}
		}
		return xlData;
	}
	
	


}
