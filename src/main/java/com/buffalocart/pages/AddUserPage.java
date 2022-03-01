package com.buffalocart.pages;

import com.buffalocart.utilities.RandomDataUtility;
import com.buffalocart.utilities.TestHelpUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class AddUserPage extends TestHelpUtility {
    WebDriver driver;
    /*** Class Constructor ***/
    public AddUserPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    List<List<String>> dataadduser = excel.excelDataReader("adduserpage");
    RandomDataUtility randomData=new RandomDataUtility();

    /*** Web Elements ***/
    private final String _addUserErrorMessage = "first_name-error";
    @FindBy(id=_addUserErrorMessage)
    private WebElement addUserErrorMessage;

    private final String _saveButton = "//button[@id='submit_user_button']";
    @FindBy(xpath=_saveButton)
    private WebElement saveButton;

    private final String _prefix = "surname";
    @FindBy(id=_prefix)
    private WebElement prefix;

    private final String _firstName = "first_name";
    @FindBy(id=_firstName)
    private WebElement firstName;

    private final String _lastName = "last_name";
    @FindBy(id=_lastName)
    private WebElement lastName;

    private final String _email = "email";
    @FindBy(id=_email)
    private WebElement email;

    private final String _role = "role";
    @FindBy(id=_role)
    private WebElement role;

    private final String _userName = "username";
    @FindBy(id=_userName)
    private WebElement userName;

    private final String _password = "password";
    @FindBy(id=_password)
    private WebElement password;

    private final String _confirmPassword = "confirm_password";
    @FindBy(id=_confirmPassword)
    private WebElement confirmPassword;

    private final String _toastMessage = "//div[@id='toast-container']";
    @FindBy(xpath = _toastMessage)
    private WebElement toastMessage;
    /*** User Action Methods ***/
    public String getExpectedAddUsersPageTitle() {
        return dataadduser.get(1).get(0);
    }
    public String getActualAddUsersPageTitle() {
        return page.getPageTitle(driver);
    }
    public UsersPage clickOnSaveButton() throws IOException {
        page.clickOnElement(saveButton);
        return new UsersPage(driver);
    }
    public String getActualErrorMessage() {
        return page.getElementText(addUserErrorMessage);
    }
    public String getExpectedErrorMessage() {
        return dataadduser.get(1).get(10);
    }
    public String getPrefix()
    {
        return dataadduser.get(1).get(1);
    }
    public String getFirstName()
    {
        return dataadduser.get(1).get(2);
    }
    public String getLastName()
    {
        return dataadduser.get(1).get(3);
    }
    public String getExpectedUserName()
    {
        return dataadduser.get(1).get(4);
    }
    public String getPassword()
    {
        return dataadduser.get(1).get(5);
    }
    public String getConfirmPassword()
    {
       return dataadduser.get(1).get(6);
    }
    public String getEmail()
    {

        return randomData.getRandomEmail();
    }
    public void getRoles()
    {
        wait.waitForTheElementToBeVisible(driver, WaitUtility.LocaterType.Id, _role);
        page.selectDropDownByIndex(role,Integer.parseInt(dataadduser.get(1).get(7)));
    }
    public void enterPrefix(String prefixToEnter)
    {
        page.EnterText(prefix,prefixToEnter);
    }
    public void enterFirstName(String firstNameToEnter)
    {
        page.EnterText(firstName,firstNameToEnter);
    }
    public void enterLastName(String lastNameToEnter)
    {
        page.EnterText(lastName,lastNameToEnter);
    }
    public void enterEmail(String emailToEnter) {
        page.EnterText(email,emailToEnter);
    }
    public void enterPassword(String passwordToEnter) {
        page.EnterText(password,passwordToEnter);
    }
    public void enterConfirmPassWord(String confirmPasswordToEnter) {
        page.EnterText(confirmPassword, confirmPasswordToEnter);
    }
    public void enterUserName(String userNameToEnter)
    {
        page.EnterText(userName,userNameToEnter);
    }
    public void clickOnToastMessage() throws InterruptedException {
        page.clickOnElement(toastMessage);
    }
    public String getNewUserName() {
        return dataadduser.get(1).get(8);

    }

    public String getUserName() {
        return dataadduser.get(1).get(11);
    }
}
