package com.zp410.selenium.testCase;

import com.zp410.selenium.base.DriverBase;
import com.zp410.selenium.business.LoginPro;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * 登陆
 */
public class login extends CaseBase {

    public DriverBase driver;
    public LoginPro loginPro;
    static Logger logger = Logger.getLogger(login.class);

    public login() {
        this.driver = InitDriver("chrome");
        loginPro = new LoginPro(driver);
    }

    @Test
    public void getLoginHome() {
        driver.get("http://www.imooc.com");
        driver.findeElement(By.id("js-signin-btn")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test(dependsOnMethods = {"getLoginHome"})
    public void testLogin() {
        logger.debug("debug");
        BasicConfigurator.configure();
        loginPro.login("18844996590", "19951108ZXZzxz");
    }


}
