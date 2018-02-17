import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class main {


    public static void main (String [] args) throws MalformedURLException {
        DesiredCapabilities caps  = new DesiredCapabilities();
        caps.setCapability("deviceName","LGH990edeee2f");
        caps.setCapability("platformName","Android");
        caps.setCapability("udid", "LGH990edeee2f"); //Give Device ID of your mobile phone
        caps.setCapability("platformVersion", "7.0");
        caps.setCapability("appPackage", "com.golan.app");
        caps.setCapability("appActivity", "com.golan.app.GolanMain");
        caps.setCapability("noReset", "true");
        AndroidDriver driver = new AndroidDriver(new  URL("http://0.0.0.0:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        ExtentReports extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

        extent.attachReporter(htmlReporter);

        driver.findElementById("settingsBtn").click();
        ExtentTest test = extent.createTest("TestName");
        test.log(Status.PASS, "pass");
        extent.setSystemInfo("os", "win7");

        extent.flush();





    }





}
