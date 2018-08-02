package com.zp410.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Login {

    WebDriver driver;

    public void init() {
        driver = new ChromeDriver();
//		String url1 = "https://www.imooc.com/user/newlogin/from_url";
        String url2 = "https://www.imooc.com/";
        driver.get(url2);
        driver.findElement(By.id("js-signin-btn")).click();
    }

    public void loginScript(String username,String pwd) throws Exception {


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
    public List<String> loginInfo(){
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


    public static void main(String[] args) throws Exception {

        Login login = new Login();
        login.init();
        List<String> strings = login.loginInfo();
        login.loginScript(strings.get(0),strings.get(1));


    }


}
