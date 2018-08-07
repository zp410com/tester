package com.zp410.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {

    public WebDriver driverName(String browser){

        if (browser.equalsIgnoreCase("fireFox")){
            return new FirefoxDriver();
        }else {
            return new ChromeDriver();
        }

    }
}
