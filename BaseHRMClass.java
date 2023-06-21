package basepackage;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Time;
public class BaseHRMClass {
	public static Properties prop ;
	public static WebDriver driver;
	
	public BaseHRMClass() {
		
		try {
			prop=new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\alber\\eclipse-workspace\\HRMANAGEMENT\\src\\test\\java\\environmentvariables\\config.Properties");
		prop.load(file);
	}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
		public static void initiation() {
			String browsername =prop.getProperty("browser");
			
	if (browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe" );
		driver=new ChromeDriver();
		
	}
		else if(browsername.equals("Firefox")){
			
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			driver=new FirefoxDriver();
	}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time.implicitwait));
	driver.get(prop.getProperty("url"));
		}
	public static void screenshots(String Filename) {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
	FileUtils.copyFile(file,new File("C:\\Users\\alber\\eclipse-workspace\\HRMANAGEMENT\\src\\test\\java\\screenshots\\Screenshots" + Filename +".png"));
	
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		
}
		
	
}