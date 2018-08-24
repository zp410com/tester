package com.zp410.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * driverBase基类
 */
public class DriverBase {

    private WebDriver driver;

    public DriverBase(String browser) {
        SelectDriver selectDriver = new SelectDriver();
        this.driver = selectDriver.driverName(browser);
    }


    /**
     * 关闭浏览器
     */
    public void stop() {
        System.out.println("close WebDriver");
        driver.close();
    }

    /**
     * 封装Element方法
     */
    public WebElement findeElement(By by){
        WebElement element = driver.findElement(by);
        return element;
    }

    /**
     * 封装get
     */

    public void get(String url){
        driver.get(url);
    }

    /**
     * 返回上一步
     */

    public void back(){
        driver.navigate().back();
    }
}
