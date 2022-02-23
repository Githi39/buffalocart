package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginTest extends Base {
    LoginPage login;
    HomePage home;
    ExcelUtility excel =new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority=1,description = "TC_001_Verification of login page title")
    public void verifyLoginPageTitle()throws IOException
    {
        extentTest.get().assignCategory("Smoke");
        login=new LoginPage(driver);
        //home=new HomePage(driver);
        List<List<String>> data = excel.excelDataReader("login");
        String actualTitle= login.getLoginPageActualTitle();
        extentTest.get().log(Status.PASS, "Actual login page title generated");
        String expectedTitle = data.get(1).get(0);
        extentTest.get().log(Status.PASS, "Expected login page title generated");
        Assert.assertEquals(actualTitle,expectedTitle,"ERROR : INVALID LOGIN PAGE TITLE PAGE FOUND");
        extentTest.get().log(Status.PASS, "verify login page title test case passed");
    }
    @Test(priority =2,description = "TC_002_Verify user login with valid user credentials")
    public void verifyUserLoginWithValidUserCredentials() throws Exception
    {
        login = new LoginPage(driver);
        List<List<String>> data=excel.excelDataReader("Login");
        String uname=data.get(1).get(1);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String psd=data.get(1).get(2);
        login.enterPassword(psd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        home=login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String actualUserAccountName=home.getUserName();
        String expectedUserAccountName=data.get(1).get(3);
        Assert.assertEquals(actualUserAccountName,expectedUserAccountName,"ERROR ::Invalid user");
        extentTest.get().log(Status.PASS, "user logged in successfully");
    }
    @Test(priority = 3,description = "TC_003_Verify the error message displayed for user login with invalid credentials")
    public void verifyUserLoginWithInValidUserCredentials(){
        login = new LoginPage(driver);
        List<List<String>> data=excel.excelDataReader("Login");
        String uName=data.get(2).get(1);
        login.enterUserName(uName);
        System.out.println(uName);
        extentTest.get().log(Status.PASS, "invalid User name entered successfully");
        String pswd=data.get(2).get(2);
        login.enterPassword(pswd);
        extentTest.get().log(Status.PASS, "invalid Password entered successfully");
        home=login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String actualErrorMessage=login.getErrorMessage();
        String expectedUserAccountName=data.get(1).get(4);
        Assert.assertEquals(actualErrorMessage,expectedUserAccountName,"ERROR ::Invalid user");
        extentTest.get().log(Status.PASS, "Expected error message matched with actual error message ");
    }
    @Test(priority = 4,description = "TC_004_Verify whetehr the user is able to click on 'Remember me' checkbox")
    public void verifyWhetherUserAbleToClickOnRemememberMeCheckBox(){
        login = new LoginPage(driver);
        login.clickOnRememberMeCheckBox();
        extentTest.get().log(Status.PASS, "user successfully clicked on CheckBox");
        login.rememberMeCheckBoxIsSelected();
        extentTest.get().log(Status.PASS, "successfully selected CheckBox");
        Assert.assertTrue(login.rememberMeCheckBoxIsSelected());
        extentTest.get().log(Status.PASS, "Assertion True for checkbox selected ");
    }
}
