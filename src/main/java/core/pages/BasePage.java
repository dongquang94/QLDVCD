package main.java.core.pages;

import io.qameta.allure.Attachment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    
    

    //Constructor
    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //Click Method
    public void click (By elementLocation) {
    	WebElement element = driver.findElement(elementLocation);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Actions action = new Actions(driver);
    	action.moveToElement(element).build().perform();
    	element.click();
    }

    //Write Text
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
}
