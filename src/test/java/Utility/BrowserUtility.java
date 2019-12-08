package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserUtility {

    public static WebDriver opeBrowser(WebDriver driver,String driverVersion,String browserName,String Url) throws Exception {

        switch (browserName.toString().toLowerCase()) {
            case "firefox":
                if (!driverVersion.equalsIgnoreCase("latest")) {
                    WebDriverManager.firefoxdriver().version(driverVersion).setup();
                } else {
                    WebDriverManager.firefoxdriver().setup();
                }
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(Url);
                return driver;
            case "chrome":
                if (!driverVersion.equalsIgnoreCase("latest")) {
                    WebDriverManager.chromedriver().version(driverVersion).setup();
                } else {
                    WebDriverManager.chromedriver().setup();
                }
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(Url);
                return driver;
            case "internetexplorer":
                if (!driverVersion.equalsIgnoreCase("latest")) {
                    WebDriverManager.iedriver().version(driverVersion).setup();
                } else {
                    WebDriverManager.iedriver().setup();
                }
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                driver.get(Url);
                return driver;
            case "edge":
                if (!driverVersion.equalsIgnoreCase("latest")) {
                    WebDriverManager.edgedriver().version(driverVersion).setup();
                } else {
                    WebDriverManager.edgedriver().setup();
                }
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.get(Url);
                return driver;
            default:
                throw new Exception("Unsupported browser: " + browserName.toLowerCase());
        }
    }

}
