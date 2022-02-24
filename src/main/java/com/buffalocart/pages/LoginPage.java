package com.buffalocart.pages;

import com.buffalocart.constants.Constants;
import com.buffalocart.utilities.TestHelpUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class LoginPage extends TestHelpUtility {
WebDriver driver;
    /*** Page Constructor ***/
public LoginPage(WebDriver driver)
{
    this.driver=driver;
    PageFactory.initElements(driver,this);
}
    /*** page Web Elements ***/
    private final String _loginName = "username";
    @FindBy(id=_loginName)
    private WebElement loginName;

    private final String _loginPassword = "password";
    @FindBy(id=_loginPassword)
    private WebElement loginPassword;
    private final String _loginButton = "//button[@class='btn btn-primary']";
    @FindBy(xpath=_loginButton)
    private WebElement loginButton;
    private final String _errorMessage = "//span[@class='help-block']//strong";
    @FindBy(xpath=_errorMessage)
    private WebElement errorMessage;

    private final String _rememberMeCheckbox = "//div[@class='checkbox']//input";
    @FindBy(xpath=_rememberMeCheckbox)
    private WebElement rememberMeCheckbox;

    private final String _forgotPassword = "//a[@class='btn btn-link']";
    @FindBy(xpath=_forgotPassword)
    private WebElement forgotPassword;
    /*** User action methods ***/

    public String getLoginPageActualTitle()
    {
        return page.getPageTitle(driver);
    }
    public void enterUserName(String uname){page.EnterText(loginName,uname);}
    public void enterPassword(String pswd){
        page.EnterText(loginPassword,pswd);
    }
    public void clickOnRememberMeCheckBox(){
        page.clickOnElement(rememberMeCheckbox);
    }
    public boolean rememberMeCheckBoxIsSelected(){return page.getSelectedValue(rememberMeCheckbox);}
    public HomePage clickOnLoginButton(){page.clickOnElement(loginButton);return new HomePage(driver);}
    public ResetPasswordPage clickOnForgotPassword() {page.clickOnElement(forgotPassword);return new ResetPasswordPage(driver);}
    public String getErrorMessage(){
        return page.getElementText(errorMessage);
    }

}
