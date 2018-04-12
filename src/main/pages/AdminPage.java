package main.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AdminPage extends BasePage {

    //*********Constructor*********
    public AdminPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********
    String welcomeText = "/html/body/div[1]/div[2]/div/div/h1";

    //*********Page Methods*********
    
    //Verify Login Condition
    @Step("Verify verifyLoginAdmin: {0} step...")
    public void verifyLoginAdmin (String expectedText) throws Exception {
    	Thread.sleep(1000);
        Assert.assertEquals(readText(By.xpath(welcomeText)), expectedText);
    }

}
