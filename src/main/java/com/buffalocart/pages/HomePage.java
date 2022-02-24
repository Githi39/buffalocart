package com.buffalocart.pages;

import com.buffalocart.constants.Constants;
import com.buffalocart.utilities.TestHelpUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HomePage extends TestHelpUtility {
    WebDriver driver;
    /*** Class Constructor ***/
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    /*** page Web Elements ***/
    private final String _userName = "//a[@class='dropdown-toggle']";
    @FindBy(xpath=_userName)
    private WebElement userName;

    private final String _endTourButton = "//button[@class='btn btn-default btn-sm']";
    @FindBy(xpath=_endTourButton)
    private WebElement endTourButton;

    private final String _logoutButton = "//div[@class='pull-right']//a";
    @FindBy(xpath=_logoutButton)
    private WebElement logoutButton;

    private final String _dateDisplayed="//div[@class='m-8 pull-left mt-15 hidden-xs']/strong";
    @FindBy(xpath = _dateDisplayed) private WebElement dateDisplayed;

    /*** User Action Methods ***/
    public String getUserName() {return page.getElementText(userName);}
    public void clickOnEndTourButton()
    {
        page.clickOnElement(endTourButton);
    }
    public void clickOnUserName()
    {
        page.clickOnElement(userName);
    }
    public String getHomePageTitle() {return page.getPageTitle(driver);}
    public String getActualDateInHomePage() {return page.getElementText(dateDisplayed);}
    public String getDateDisplayedOnHomePage(){return page.getElementText(dateDisplayed);}
    public String getSystemDate(){return dates.getDateOfSystem();}
}
