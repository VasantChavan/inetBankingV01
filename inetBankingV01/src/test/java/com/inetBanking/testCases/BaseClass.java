package com.inetBanking.testCases;

import java.io.File;

import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public String baseUrl = readConfig.getAppUrl();
	public String user = readConfig.getUserName();
	public String pass = readConfig.getUserPass();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(@Optional("chrome") String br) {
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");

		// System.setProperty("webdriver.chrome.driver",
		// System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
		}

		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();

		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static void captureScreen(WebDriver driver, String tname) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			File target = new File(System.getProperty("user.dir") + "//Screenshots//" + tname + ".png");

			FileUtils.copyFile(source, target);
			
			System.out.println("screenshot captured....");
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
