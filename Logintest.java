package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseHRMClass;
import pompackage.Pomlogin;
import testdata.Excelsheet;

public class Logintest extends BaseHRMClass {
	Pomlogin Log;
	
	public Logintest() {
		
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		screenshots("Login");
		
		Log=new Pomlogin();
		
	}
	@Test(priority=1)
	public void Title() {
		String actual=Log.Verify();
		
		Assert.assertEquals(actual, "OrangeHRM");
	}
	@DataProvider
	public Object[][]Details() throws InterruptedException{
		
		Object result[][]=Excelsheet.readdata("Sheet1");
		
		return result;
		
	}
	@Test(priority=2,dataProvider="Details")
	public void Login(String name,String password) throws InterruptedException {
		Log.typeusername(name);
		Thread.sleep(1000);
		Log.typepassword(password);
		Thread.sleep(1000);
		//Log.clickbutton();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}

}
