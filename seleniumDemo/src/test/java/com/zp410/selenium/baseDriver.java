package com.zp410.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class baseDriver {
    WebDriver driver;

    public baseDriver(){
        driver = new ChromeDriver();
    }

    /**
     * 截图
     */
    public void takeScreenShot(){
        //获取时间戳
        long date = System.currentTimeMillis();
        //转型
        String path = String.valueOf(date);
//        String curPath = System.getProperty("user.dir");  //获取当前路径
        path = path +".png";
//        String screenPath = curPath+"/"+ path;  //存储在当前路径
        //图片存储路径
        String screenPath = "/Users/zhangxianzhao/Documents/screenShot"+"/"+ path;
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screen,new File(screenPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
