package co.com.iuvity.certificacion.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import static co.com.iuvity.certificacion.utils.Constants.CHROME;
import static co.com.iuvity.certificacion.utils.ReadFiles.readBrowser;

public class WebDriverFactory {

    private WebDriverFactory(){}

    public static WebDriver goToWeb() {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver getDriver() {
        return (readBrowser().equals(CHROME)) ? getChromeDriver() : getEdgeDriver();
    }
    private static WebDriver getChromeDriver() {

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments(
                "--incognito",
                "--disable-infobars",
                "enable-automation",
                "--disable-browser-side-navigation",
                "--lang=es",
                "--disable-download-notification",
                "--start-maximized",
                "--test-type",
                "--ignore-certificate-errors",
                "--allow-running-insecure-content",
                "--disable-translate",
                "--always-authorize-plugins", "--disable-extensions",
                 "--allow-geolocation");



        return WebDriverManager.chromedriver().capabilities(chromeOptions).create();
    }

    private static WebDriver getEdgeDriver() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("inprivate", true);

        return WebDriverManager.edgedriver().capabilities(edgeOptions).create();
    }
}