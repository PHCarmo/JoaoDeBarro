package br.com.fatecmc.joaodebarro.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
    static WebDriver driver;
    
    public static WebDriver startBrowser(String browser_name) {        
        switch(browser_name.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver(); break;
            case "chrome":
                driver = new ChromeDriver(); break;
            case "ie":
                driver = new InternetExplorerDriver(); break;
            default:
                driver = new ChromeDriver();
        }
        
        driver.manage().window().maximize();
        
        return driver;
    }
}
