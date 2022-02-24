package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UserPageTest extends Base {
    LoginPage login;
    UsersPage users;
    HomePage home;
    SignOutPage signOut;
    UserManagementPage userManagement;
    ExcelUtility excel =new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 10,enabled = true,description = "TC_010_Verify users page title")
    public void verifyUsersPageTitle()
    {
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        userManagement = new UserManagementPage(driver);
        users = new UsersPage(driver);
        home = new HomePage(driver);
        signOut = new SignOutPage(driver);
        List<List<String>> data = excel.excelDataReader("login");
        List<List<String>> udata = excel.excelDataReader("userpage");
        String uname = data.get(1).get(1);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String psd = data.get(1).get(2);
        login.enterPassword(psd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        home.clickOnEndTourButton();
        userManagement.clickOnUserManagementTab();
        extentTest.get().log(Status.PASS, "Successfully clicked on user management tab");
        users = userManagement.clickOnUserMenu();
        extentTest.get().log(Status.PASS, "Successfully clicked on users tab");
        String actualTitle = users.getActualUsersPageTitle();
        extentTest.get().log(Status.PASS, "Actual users page title successfully captured");
        String expectedTitle=udata.get(1).get(0);
        extentTest.get().log(Status.PASS, "Expected users page title successfully captured");
        Assert.assertEquals(actualTitle,expectedTitle,"ERROR : INVALID USERS PAGE TITLE FOUND");
        extentTest.get().log(Status.PASS, "Verify users page title test case passed");
    }
}
