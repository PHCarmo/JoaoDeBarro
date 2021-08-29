package br.com.fatecmc.joaodebarro.util;

import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {

    private static WebDriverSingleton instance;
    private final WebDriver driver;

    private WebDriverSingleton() {
        driver = WebDriverFactory.startBrowser("Chrome");
    }

    public static WebDriverSingleton getInstance() {
        if (instance == null) {
            instance = new WebDriverSingleton();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
