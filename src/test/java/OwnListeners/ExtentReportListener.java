package OwnListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.core.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.createDirectory;

public class ExtentReportListener {

    public static ExtentHtmlReporter report = null;
    public static ExtentReports extent = null;
    public static ExtentTest test = null;
    public Scenario scenario;

    public void testStartSetup(){
        test = extent.createTest(Feature.class, scenario.getName());
        test = test.createNode(com.aventstack.extentreports.gherkin.model.Scenario.class,scenario.getName());
    }

    public static ExtentReports setUp() {
        String reportLocation = "./Reports/Extent_Report.html";
        report = new ExtentHtmlReporter(reportLocation);
        report.config().setDocumentTitle("Automation Test Report");
        report.config().setReportName("Automation Test Report");
        report.config().setTheme(Theme.STANDARD);
        System.out.println("Extent Report location initialized . . .");
        report.start();

        extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Application", "ComputerApp");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        System.out.println("System Info. set in Extent Report");

        return extent;
    }

    public void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable) {
        switch (teststatus) {
            case "FAIL":
                extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));
                extenttest.error(throwable.fillInStackTrace());

                try {
                    extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "PASS":
                extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
                break;

            default:
                break;
        }
        if (driver != null) {
            driver.quit();
        }
    }

    private String captureScreenShot(WebDriver driver) throws IOException {
        // Take screenshot and store as a file format
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destination = "./ScreenShot/" + System.currentTimeMillis() + ".jpeg";

        // now copy the screenshot to desired location using copyFile method
        FileUtils.copyFile(src, new File(destination));
        return destination;

    }

    public void flushReport(){
            extent.flush();
    }

}
