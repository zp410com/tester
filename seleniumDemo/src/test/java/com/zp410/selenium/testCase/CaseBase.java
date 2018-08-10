package com.zp410.selenium.testCase;

import com.zp410.selenium.base.DriverBase;

public class CaseBase {

    public DriverBase InitDriver(String browser){
        return new DriverBase(browser);
    }
}
