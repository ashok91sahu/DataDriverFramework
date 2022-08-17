package utills;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CrossBroweser {
	public static  WebDriver driver;
	public static  Properties pro;
	@BeforeTest
	public void setUp() throws Throwable, IOException {
		pro=new Properties();
		FileInputStream fi= new FileInputStream("C:\\Users\\Ak\\eclipse-workspace\\DataDrivenFrameWork\\properties\\broweser.properties");
		pro.load(fi);	
	if(pro.getProperty("Broweser").equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pro.getProperty("url"));
		Reporter.log("Broweser Found::"+"chrome"+ true);
	}
	else if(pro.getProperty("Broweser").equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("url"));
		Reporter.log("Broweser Found::"+"chrome"+ true);
	}
	else if(pro.getProperty("Broweser").equalsIgnoreCase("Edge"))
	{
		System.setProperty("webdriver.edge.driver","C:\\Users\\Ak\\eclipse-workspace\\DataDrivenFrameWork\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(pro.getProperty("Url"));
	}
	else {
		Reporter.log("Broweser not Found::", true);
	}
}
	@AfterTest
	public void clouser() {
		driver.close();
	}
}
