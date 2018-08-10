package com.zp410.selenium.util;

import com.zp410.selenium.ProUtil;
import org.openqa.selenium.By;

public class getByLocator {

    public static By getByLocator(String key) {

        ProUtil properties = new ProUtil("element.properties");
        String locator = properties.getPro(key);
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
}
