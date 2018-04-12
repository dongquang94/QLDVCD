package test.java.tests;

import io.qameta.allure.*;
import main.java.core.pages.AdminPage;
import main.java.core.pages.HomePage;
import main.java.core.utils.GetProperties;
import main.java.core.utils.ExtendReports.ExtendTestManager;
import main.java.core.utils.Listeners.TestListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTests extends BaseTest {
	
	GetProperties prop = new GetProperties();

    @Test (priority = 0, description="Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Invalid username and password login test")
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws Exception {
    	ExtendTestManager.getTest().setDescription("Invalid Login Scenario with wrong username and password.");
        HomePage homePage = new HomePage(driver,wait);
        homePage.goToHomePage();
        homePage.goToLoginPanel(prop.getPropValues("wrongUsername"),prop.getPropValues("wrongPassword"));
        homePage.verifyLogin("");
    }

    @Test (priority = 1, description="Invalid Login Scenario with empty username and password.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login test with empty username and empty password.")
    @Story("Empty username and password login test")
    public void invalidLoginTest_EmptyUserEmptyPassword () throws Exception {
    	ExtendTestManager.getTest().setDescription("Invalid Login Scenario with empty username and password.");
        HomePage homePage = new HomePage(driver,wait);
        homePage.goToHomePage();
        homePage.goToLoginPanel("","");
        homePage.verifyLogin("");
    }
    
    @Test (priority = 2, description="Valid Login Scenario.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Login test with correct username and empty password.")
    @Story("Correct username and password login test")
    public void validLoginTest () throws Exception {
    	ExtendTestManager.getTest().setDescription("Valid Login Scenario.");
        HomePage homePage = new HomePage(driver,wait);
        AdminPage adminPage = new AdminPage(driver,wait);
        homePage.goToHomePage();
        homePage.goToLoginPanel(prop.getPropValues("username"),prop.getPropValues("password"));
        adminPage.verifyLoginAdmin("Chào mừng bạn đến với trang chủ website Quản Lý Công đoàn");
    }

}
