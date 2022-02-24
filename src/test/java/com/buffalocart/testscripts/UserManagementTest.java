package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SignOutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UserManagementTest extends Base {
    LoginPage login;
    UserManagementPage userManagement;
    HomePage home;
    ExcelUtility excel =new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 9,description = "TC_009_Verify the Usermangement sub tabs")
    public void verifyUserManagementSubTabs()
    {
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        home = new HomePage(driver);
        userManagement = new UserManagementPage(driver);
        SignOutPage signOut = new SignOutPage(driver);
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
        userManagement.clickOnUserManagementTab();
        extentTest.get().log(Status.PASS, "Successfully clicked on user management tab");
        List<String> actualTabValues = userManagement.getActualUserManagementListValues();
        System.out.println("act"+actualTabValues);
        extentTest.get().log(Status.PASS, "Actual user Management Tab values successfully captured");
        List<List<String>>expectedTabValues = excel.excelDataReader("usermanagement");
        System.out.println(expectedTabValues.size());
        System.out.println("exp"+expectedTabValues);
        Assert.assertEquals(actualTabValues,expectedTabValues,"ERROR:MOSMATCH FOUND");



    }
}
