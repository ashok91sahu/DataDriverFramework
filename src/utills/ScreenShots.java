package utills;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	WebDriver driver;
	
	Date date=new Date();
	DateFormat df= new SimpleDateFormat("mm-yyyy-dd hh-mm-ss");
	String datef=df.format(date);
	
File sc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//FileHandler.copy(sc,newfile("C:\\Users\\Ak\\eclipse-workspace\\DataDrivenFrameWork\\ScreenShots.jh.png"));
}
