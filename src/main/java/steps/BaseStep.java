package steps;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.AfterClass;
import org.junit.Before;
import other.Stash;

public class BaseStep {

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Stash.put("driver", driver);
        driver.get("https://www.yandex.ru/");
    }

    @AfterClass
    public static void shutDown(){
        Stash.getDriver().quit();
    }
    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) Stash.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
