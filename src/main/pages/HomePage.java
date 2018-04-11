package main.pages;

import io.qameta.allure.Step;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.GetProperties;

public class HomePage extends BasePage {

	GetProperties prop = new GetProperties();
    
	//*********Constructor*********
    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********
    String loginButton = "/html/body/header/nav/div/ul/li/a";
    String usernameBox = "//*[@id=\"username\"]";
    String passwordBox = "//*[@id=\"password\"]";
    String loginButtonPanel = "//*[@id=\"btn-login\"]";
    String errorLoginMessage = "//*[@id=\"err-ms\"]";

    //*********Page Methods*********

    //Go to Homepage
    @Step("Open Homepage...")
    public void goToHomePage () throws IOException {
    	String baseURL = prop.getPropValues("homepage");
    	driver.get(baseURL);
        //driver.navigate().to(baseURL)
    }

    //Go to LoginPanel
    @Step("Login Step with username: {0}, password: {1}, for method: {method} step...")
    public void goToLoginPanel (String username, String password) throws Exception {  	
    	click(By.xpath(loginButton));
    	Thread.sleep(500);
        writeText(By.xpath(usernameBox),username);
        Thread.sleep(500);
        writeText(By.xpath(passwordBox), password);
        Thread.sleep(500);
        click(By.xpath(loginButtonPanel));
        Thread.sleep(500);
    }

    //Verify Login Condition
    @Step("Verify verifyLogin: {0} step...")
    public void verifyLogin (String expectedText) {
        Assert.assertEquals(readText(By.xpath(errorLoginMessage)), expectedText);
    }

}
