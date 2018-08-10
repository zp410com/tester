package com.zp410.selenium.handle;

import com.zp410.selenium.base.DriverBase;
import com.zp410.selenium.page.loginPage;

public class loginPageHandle {

    private DriverBase driver;
    private loginPage lp;

    public loginPageHandle(DriverBase driver) {
        this.driver = driver;
        lp = new loginPage(driver);
    }

    /**
     * 输入用户名
     */

    public void sendKeysUser(String username) {
        lp.sendkeys(lp.getUserElement(), username);
    }

    /**
     * 输入密码
     */

    public void sendKeysPassword(String password) {
        lp.sendkeys(lp.getPasswordElement(), password);
    }

    /**
     * 点击登陆
     */

    public void clickLoginButton() {
        lp.clink(lp.getLoginButtonElement());
    }

    /**
     * 点击自动登陆
     */

    public void clickAutoSignin() {
        lp.clink(lp.getAutosigninElement());
    }

    /**
     * 判断是否是登陆页面
     */

    public boolean assertLoginPage() {
        return lp.assertElementIs(lp.getUserElement());
    }
}
