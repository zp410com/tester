package com.zp410.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


public class loginTest extends baseDriver {


    public void init() {
        driver = new ChromeDriver();
//		String url1 = "https://www.imooc.com/user/newlogin/from_url";
        String url2 = "https://www.imooc.com/";
        driver.get(url2);
        driver.findElement(By.id("js-signin-btn")).click();
    }

    public void loginScript(String username, String pwd) throws Exception {


        Thread.sleep(2000);
        WebElement user = this.element(this.byStr("username"));
        user.isDisplayed();


        WebElement password = this.element(this.byStr("userpwd"));
        password.isDisplayed();

        WebElement loginButton = this.element(this.byStr("loginButton"));
        loginButton.isDisplayed();

        user.sendKeys(username);
        password.sendKeys(pwd);

        //点击登陆
        loginButton.click();
        Thread.sleep(3000);

        WebElement header = this.element(this.byStr("header"));
        header.isDisplayed();

        Actions actions = new Actions(driver);
        actions.moveToElement(header).perform();

        String userInfo = this.element(this.byStr("userInfo")).getText();
        System.out.println(userInfo);
        if (userInfo.equals("慕仙2111511")) {
            this.takeScreenShot();
        }
    }

    /**
     * 封装By
     */

    public By byStr(String elementName) {

        ProUtil properties = new ProUtil("element.properties");
        String locator = properties.getPro(elementName);
        //定位方式
        String locatorType = locator.split(">")[0];
        //定位值
        String localtorValue = locator.split(">")[1];

        if (locatorType.equals("id")) {
            return By.id(localtorValue);

        } else if (locatorType.equals("name")) {
            return By.name(localtorValue);

        } else if (locatorType.equals("className")) {
            return By.className(localtorValue);

        } else {
            return By.xpath(localtorValue);
        }

    }

    /**
     * 封装登陆信息
     */
    public List<String> loginInfo() {
        List<String> infos = new ArrayList();
        ProUtil info = new ProUtil("element.properties");
        String userN = info.getPro("user");
        String pwd = info.getPro("pwd");
        infos.add(userN);
        infos.add(pwd);
        return infos;
    }


    /**
     * 封装Element
     */

    public WebElement element(By by) {
        WebElement ele = driver.findElement(by);
        return ele;
    }


    @Test
    public void logininpage() throws Exception {

        this.init();
        List<String> strings = this.loginInfo();
        this.loginScript(strings.get(0), strings.get(1));

    }

}
