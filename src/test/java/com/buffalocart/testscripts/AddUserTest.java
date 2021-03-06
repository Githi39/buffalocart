package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddUserTest extends Base {
    LoginPage login;
    UsersPage users;
    HomePage home;
    SoftAssert softAssert;
    SignOutPage signOut;
    UserManagementPage userManagement;
    AddUserPage addUser;
    ExcelUtility excel =new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 13,enabled = true,description = "TC_013_Verify the error message displayed without filling mandatory fields in add user form", groups = {"Regression"})
    public void verifyErrorMessageWithoutFillingMandatory() throws IOException {
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        userManagement = new UserManagementPage(driver);
        users = new UsersPage(driver);
        home = new HomePage(driver);
        signOut = new SignOutPage(driver);
        addUser = new AddUserPage(driver);
        softAssert = new SoftAssert();
        List<List<String>> data = excel.excelDataReader("login");
        String uname = data.get(1).get(1);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String psd = data.get(1).get(2);
        login.enterPassword(psd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "Successfully Logged in");
        home.clickOnEndTourButton();
        userManagement.clickOnUserManagementTab();
        users = userManagement.clickOnUserMenu();
        extentTest.get().log(Status.PASS, "Successfully clicked on users tab");
        addUser = users.clickOnAddUsersButton();
        extentTest.get().log(Status.PASS, "Successfully navigated to add users page");
        String expectedErrorMessage = addUser.getExpectedErrorMessage();
        extentTest.get().log(Status.PASS, "Expected error successfully captured");
        addUser.clickOnSaveButton();
        extentTest.get().log(Status.PASS, "Successfully clicked on save button without filling mandatory fields");
        String actualErrorMessage = addUser.getActualErrorMessage();
        extentTest.get().log(Status.PASS, "Actual error successfully captured");
        softAssert.assertEquals(actualErrorMessage,expectedErrorMessage,"ERROR : MISMATCH FOUND IN ERROR MESSAGE");
        home.clickOnUserName();
        login = signOut.clickOnSignout();
        extentTest.get().log(Status.PASS, "Successfully signed out and navigated to login page");
        softAssert.assertAll();
        extentTest.get().log(Status.PASS, "Verify the error message displayed without filling mandatory fields in add user form test case passed");
    }
    @Test(priority = 14,enabled = true,description = "TC_014_Verify user login with newly added user",groups = {"Regression"})
    public void verifyUserLoginWithNewlyAddedUser() throws IOException, InterruptedException {
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        userManagement = new UserManagementPage(driver);
        users = new UsersPage(driver);
        home = new HomePage(driver);
        signOut = new SignOutPage(driver);
        addUser = new AddUserPage(driver);
        softAssert = new SoftAssert();
        List<List<String>> data = excel.excelDataReader("login");
        String uname = data.get(1).get(1);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String psd = data.get(1).get(2);
        login.enterPassword(psd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "Successfully Logged in");
        extentTest.get().log(Status.PASS, "Successfully Logged in");
        home.clickOnEndTourButton();
        userManagement.clickOnUserManagementTab();
        users = userManagement.clickOnUserMenu();
        extentTest.get().log(Status.PASS, "Successfully clicked on users tab");
        addUser = users.clickOnAddUsersButton();
        extentTest.get().log(Status.PASS, "Successfully navigated to add users page");
        addUser.enterPrefix(addUser.getPrefix());
        addUser.enterFirstName(addUser.getFirstName());
        addUser.enterLastName(addUser.getLastName());
        addUser.enterEmail(addUser.getEmail());
        addUser.getRoles();
        addUser.enterUserName(addUser.getExpectedUserName());
        addUser.enterPassword(addUser.getPassword());
        addUser.enterConfirmPassWord(addUser.getConfirmPassword());
        extentTest.get().log(Status.PASS, "Successfully entered the user details");
        addUser.clickOnSaveButton();
        Thread.sleep(8000);
        extentTest.get().log(Status.PASS, "Successfully clicked on save button");
        home.clickOnUserName();
        login = signOut.clickOnSignout();
        login.enterUserName(addUser.getExpectedUserName());
        login.enterPassword(addUser.getPassword());
        login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "Successfully logged in using new user credentials");
        String actualUserName = home.getUserName();
        extentTest.get().log(Status.PASS, "Actual user name generated");
        String expectedUserName = addUser.getNewUserName();
        extentTest.get().log(Status.PASS, "expected user name generated");
        softAssert.assertEquals(actualUserName, expectedUserName, "ERROR : LOGIN FAILED");
        home.clickOnUserName();
        login = signOut.clickOnSignout();
        softAssert.assertAll();
        extentTest.get().log(Status.PASS, "Verify user login with newly added user test passed");
    }
    @Test(priority = 15,enabled = true,description = "TC_015_Verify Add Users page title",groups = {"Regression"})
    public void verifyAddUsersPageTitle() throws IOException {
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        userManagement = new UserManagementPage(driver);
        users = new UsersPage(driver);
        home = new HomePage(driver);
        signOut = new SignOutPage(driver);
        addUser = new AddUserPage(driver);
        softAssert = new SoftAssert();
        List<List<String>> data = excel.excelDataReader("login");
        String uname = data.get(1).get(1);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String psd = data.get(1).get(2);
        login.enterPassword(psd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "Successfully Logged in");
        home.clickOnEndTourButton();
        userManagement.clickOnUserManagementTab();
        users = userManagement.clickOnUserMenu();
        extentTest.get().log(Status.PASS, "Successfully clicked on users tab");
        addUser = users.clickOnAddUsersButton();
        extentTest.get().log(Status.PASS, "Successfully navigated to add users page");
        String expectedTitle = addUser.getExpectedAddUsersPageTitle();
        extentTest.get().log(Status.PASS, "Expected title successfully captured");
        String actualTitle = addUser.getActualAddUsersPageTitle();
        extentTest.get().log(Status.PASS, "Actual title successfully captured");
        softAssert.assertEquals(actualTitle,expectedTitle,"ERROR : INVALID ADD USERS PAGE TITLE FOUND");
        home.clickOnUserName();
        login = signOut.clickOnSignout();
        extentTest.get().log(Status.PASS, "Successfully signed out and navigated to login page");
        softAssert.assertAll();
        extentTest.get().log(Status.PASS, "Verify Add Users page title test case passed");
    }

}
