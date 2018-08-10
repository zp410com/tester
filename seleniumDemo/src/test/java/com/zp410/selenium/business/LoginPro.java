package com.zp410.selenium.business;

import com.zp410.selenium.base.DriverBase;
import com.zp410.selenium.handle.loginPageHandle;

public class LoginPro {

    public loginPageHandle lph;

    public LoginPro(DriverBase driver) {
        lph = new loginPageHandle(driver);
    }

    public void login(String username, String password) {
        if (lph.assertLoginPage()){
            lph.sendKeysUser(username);
            lph.sendKeysPassword(password);
            lph.clickAutoSignin();
            lph.clickLoginButton();
        }else{
            System.out.println("页面不存在或者状态不正确");
        }
    }
}
