package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
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
    public void verifyUsersPageTitle()throws Exception
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
        home.clickOnUserName();
        login = signOut.clickOnSignout();
        extentTest.get().log(Status.PASS, "Successfully signed out and navigated to login page");
        extentTest.get().log(Status.PASS, "Verify users page title test case passed");
    }
    @Test(priority = 11,description = "TC_011_Verify user search with valid data",groups = {"Smoke","Sanity","Regression"})
    public void verifyUserSearchWithValidData() throws Exception {
        extentTest.get().assignCategory("Smoke");
        extentTest.get().assignCategory("Sanity");
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        userManagement = new UserManagementPage(driver);
        users = new UsersPage(driver);
        home = new HomePage(driver);
        signOut = new SignOutPage(driver);
        List<List<String>> data = excel.excelDataReader("login");
        String uname = data.get(1).get(1);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String psd = data.get(1).get(2);
        login.enterPassword(psd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        extentTest.get().log(Status.PASS, "Successfully Logged in");
        home.clickOnEndTourButton();
        userManagement.clickOnUserManagementTab();
        users = userManagement.clickOnUserMenu();
        extentTest.get().log(Status.PASS, "Successfully clicked on users tab");
        List<List<String>> datauser = excel.excelDataReader("userpage");
        String expectedSearchResult = datauser.get(1).get(1);
        extentTest.get().log(Status.PASS, "Expected user search data successfully captured");
        users.enterDataOnSearchBox(expectedSearchResult);
        extentTest.get().log(Status.PASS, "Successfully data entered on search box");
        String actualSearchResult = users.getActualSearchData();
        extentTest.get().log(Status.PASS, "Actual user search data successfully captured");
        Assert.assertEquals(actualSearchResult,expectedSearchResult,"ERROR : INVALID SEARCH RESULT FOUND");
        home.clickOnUserName();
        login = signOut.clickOnSignout();
        extentTest.get().log(Status.PASS, "Successfully signed out and navigated to login page");
        extentTest.get().log(Status.PASS, "Verify user search with valid data test case passed");
    }
    @Test(priority = 12,enabled = true,description = "TC_012_Verify message displayed by user search with invalid data",groups = {"Smoke","Regression"})
    public void verifyMessageInUserSearchWithInvalidData() throws IOException {
        extentTest.get().assignCategory("Smoke");
        extentTest.get().assignCategory("Sanity");
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        userManagement = new UserManagementPage(driver);
        users = new UsersPage(driver);
        home = new HomePage(driver);
        signOut = new SignOutPage(driver);
        List<List<String>> data = excel.excelDataReader("login");
        String uname = data.get(1).get(1);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String psd = data.get(1).get(2);
        login.enterPassword(psd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        extentTest.get().log(Status.PASS, "Successfully Logged in");
        home.clickOnEndTourButton();
        userManagement.clickOnUserManagementTab();
        users = userManagement.clickOnUserMenu();
        extentTest.get().log(Status.PASS, "Successfully clicked on users tab");
        String searchdata = users.getInvalidSearchData();
        users.enterDataOnSearchBox(searchdata);
        extentTest.get().log(Status.PASS, "Invalid data entered on search box");
        String expectedMessage = users.getExpectedMessage();
        extentTest.get().log(Status.PASS, "Expected Message successfully captured");
        String actualMessage = users.getActualMessage();
        extentTest.get().log(Status.PASS, "Actual Message successfully captured");
        Assert.assertEquals(actualMessage,expectedMessage,"ERROR : INVALID SEARCH RESULT FOUND WHILE SEARCHING WITH INVALID USER DATA");
        home.clickOnUserName();
        login = signOut.clickOnSignout();
        extentTest.get().log(Status.PASS, "Successfully signed out and navigated to login page");
        extentTest.get().log(Status.PASS, "Verify message displayed by user search with invalid data test case passed");

    }
}

