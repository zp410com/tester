package com.zp410.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Login {

    WebDriver driver;

    public void init() {
        driver = new ChromeDriver();
//		String url1 = "https://www.imooc.com/user/newlogin/from_url";
        String url2 = "https://www.imooc.com/";
        driver.get(url2);
    }

    public void loginScript() throws Exception{
        driver.findElement(By.id("js-signin-btn")).click();
        Thread.sleep(2000);

        WebElement user = driver.findElement(By.name("email"));
        user.isDisplayed();

        WebElement password = driver.findElement(By.name("password"));
        password.isDisplayed();

        WebElement loginButton = driver.findElement(By.className("xa-login"));
        loginButton.isDisplayed();

        user.sendKeys("18844996590");
        password.sendKeys("19951108ZXZzxz");
        //点击登陆
        loginButton.click();
        Thread.sleep(3000);

        WebElement header = driver.findElement(By.id("header-avator"));
        header.isDisplayed();

        Actions actions = new Actions(driver);
        actions.moveToElement(header).perform();

        String userInfo = driver.findElement(By.className("name")).getText();
        System.out.println(userInfo);
    }


    public static void main (String[] args) throws Exception{

        Login sele = new Login();
        sele.init();
        sele.loginScript();


    }


}
