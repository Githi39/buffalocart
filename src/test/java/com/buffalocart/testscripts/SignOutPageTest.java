package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SignOutPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SignOutPageTest extends Base {
    SignOutPage signOut;
    LoginPage login;
    HomePage home;
    ExcelUtility excel =new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 8,description = "TC_008_Verify whether user is navigating to login page by clicking on Sign out button")
    public void verifyTheNavigationOfSignOutButton() throws Exception
    {
        extentTest.get().assignCategory("Smoke");
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        signOut = new SignOutPage(driver);
        home = new HomePage(driver);
        List<List<String>> data = excel.excelDataReader("login");
        String uname = data.get(1).get(1);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String psd = data.get(1).get(2);
        login.enterPassword(psd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        home.clickOnEndTourButton();
        home.clickOnUserName();
        extentTest.get().log(Status.PASS, "Successfully clicked on username");
        login = signOut.clickOnSignout();
        String actualTitle = login.getLoginPageActualTitle();
        String expectedTitle = data.get(1).get(0);
        extentTest.get().log(Status.PASS, "Expected login page title generated");
        Assert.assertEquals(actualTitle,expectedTitle,"ERROR : NAVIGATION TO LOGIN PAGE FAILED");
        extentTest.get().log(Status.PASS, "Successfully navigated to login page");

    }
}
