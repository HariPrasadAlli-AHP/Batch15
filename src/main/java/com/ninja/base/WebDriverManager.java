package com.ninja.base;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    private static ThreadLocal<WebDriver> threadLocaDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocaDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        threadLocaDriver.set(driver);
    }

}
