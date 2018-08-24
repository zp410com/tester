package com.zp410.selenium.testCase;

import com.zp410.selenium.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class testCourseList extends CaseBase{
    public DriverBase driver;

    public testCourseList(){
        this.driver = InitDriver("chrome");
    }

    @Test
    public void CourseList(){
        driver.get("https://coding.imooc.com/");
        List<String> listString = this.listElement();

        for (int i = 0; i < listString.size(); i++) {
            driver.findeElement(By.xpath("/html/body/a/i")).click();
            driver.findeElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")).click();
            driver.back();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取所有课程的List
     */

    public List<String> listElement(){
        List<String> listString = new ArrayList<String>();
        WebElement element = driver.findeElement(By.className("shizhan-course-list"));
        List<WebElement> listElement = element.findElements(By.className("shizhan-course-box"));
        for (WebElement el: listElement) {
            listString.add(el.findElement(By.className("shizan-desc")).getText());
        }
        return listString;
    }

}
