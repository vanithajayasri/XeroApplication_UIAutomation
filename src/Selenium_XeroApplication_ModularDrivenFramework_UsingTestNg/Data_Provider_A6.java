package Selenium_XeroApplication_ModularDrivenFramework_UsingTestNg;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Data_Provider_A6 extends ReusableMethods_A6{
	@DataProvider(name="LoginTestDataProvider")
	public static Object[][] getData() throws IOException{
		Object [][] data = new Object[1][3];
		String [][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData_Xerox_A6.xls" ,"Sheet1");
		
		data[0][0] = recData[1][0];
		data[0][1] = recData[1][1];
		data[0][2] = recData[1][2];
		
		
		return data;
	}
	
	@DataProvider(name="LoginTestIncorrecPasswordtDataProvider")
	public static Object[][] getDataIncorrectPassword() throws IOException{
		Object [][] data = new Object[1][3];
		String [][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData_Xerox_A6.xls" ,"Sheet1");
		
		data[0][0]  = recData[2][0];
		data[0][1] = recData[2][1];
		data[0][2]= recData[2][2];
		
		
		return data;
	}
	@DataProvider(name="LoginTestIncorrectUsernameDataProvider")
	public static Object[][] getDataIncorrectUsername() throws IOException{
		Object [][] data = new Object[1][3];
		String [][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData_Xerox_A6.xls" ,"Sheet1");
		
		data[0][0]  = recData[3][0];
		data[0][1] = recData[3][1];
		data[0][2]= recData[3][2];
		
		
		return data;
	}
	
	@DataProvider(name="ForgetPasswordDataProvider")
	public static Object[][] getDataForgetPassword() throws IOException{
		Object [][] data = new Object[1][3];
		String [][] recData = readXl("C:/Users/sudt/Desktop/vanitha/enexus/framework/TestData/TestData_Xerox_A6.xls" ,"Sheet1");
		
		data[0][0]  = recData[4][0];
		data[0][1] = recData[4][1];
		data[0][2]= recData[4][2];
		
		
		return data;
	}
}
