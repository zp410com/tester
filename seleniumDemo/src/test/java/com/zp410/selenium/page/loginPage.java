package com.zp410.selenium.page;

import com.zp410.selenium.base.DriverBase;
import org.openqa.selenium.WebElement;
import com.zp410.selenium.util.getByLocator;


public class loginPage extends BasePage {

    public loginPage(DriverBase driver) {
        super(driver);
    }

    /**
     * 获取用户名输入框
     */

    public WebElement getUserElement() {
        return element(getByLocator.getByLocator("username"));
    }


    /**
     * 获取密码输入框
     */

    public WebElement getPasswordElement() {
        return element(getByLocator.getByLocator("userpwd"));
    }

    /**
     * 获取登陆密码输入框
     */

    public WebElement getLoginButtonElement() {
        return element(getByLocator.getByLocator("loginButton"));
    }

    /**
     * 或取自动登陆按钮
     */

    public WebElement getAutosigninElement(){
        return element(getByLocator.getByLocator("autosignin"));
    }

}
