package com.zp410.selenium.page;

import com.zp410.selenium.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 页面基类封装
 */
public class BasePage {

    private DriverBase driver;

    public BasePage(DriverBase driver) {
        this.driver = driver;
    }

    /**
     * 定位元素
     */
    public WebElement element(By by) {
        WebElement element = driver.findeElement(by);
        return element;
    }

    /**
     * 封装点击
     */

    public void clink(WebElement element) {
        if (element != null) {
            element.click();
        } else {
            System.out.println(element + "元素没有定位到");
        }

    }

    /**
     * 封装输入
     */

    public void sendkeys(WebElement element, String value) {
        if (element != null) {
            element.sendKeys(value);
        } else {
            System.out.println(element + "元素没有定位到,输入失败" + value);
        }
    }

    /**
     * 判断元素是否显示
     */
    public boolean assertElementIs(WebElement element) {
        return element.isDisplayed();
    }



}
