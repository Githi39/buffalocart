package com.buffalocart.pages;

import com.buffalocart.utilities.TableUtility;
import com.buffalocart.utilities.TestHelpUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersPage extends TestHelpUtility {
    WebDriver driver;
    /*** Class Constructor ***/
    public UsersPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    List<List<String>> datauser = excel.excelDataReader("userpage");
    private final String _searchBox = "//input[@class='form-control input-sm']";
    @FindBy(xpath = _searchBox)
    private WebElement searchBox;
    private final String _searchResult = "//table[@id='users_table']//tr/td[@class='sorting_1']";
    @FindBy(xpath = _searchResult)
    private WebElement searchResult;
    private final String _searchMessage = "//td[@class='dataTables_empty']";
    @FindBy(xpath = _searchMessage)
    private WebElement searchMessage;
    private final String _addUserButton = "//a[@class='btn btn-block btn-primary']";
    @FindBy(xpath = _addUserButton)
    private WebElement addUserButton;
    public String getActualUsersPageTitle() {
        return page.getPageTitle(driver);
    }
    private final String _rowElement = "//table[@id='users_table']//tbody//tr";
    @FindBy(xpath = _rowElement)
    private List<WebElement> rowElement;

    private final String _colElement = "//table[@id='users_table']//tbody//tr//td";
    @FindBy(xpath = _colElement)
    private List<WebElement> colElement;

    public void enterDataOnSearchBox(String dataToEnter) {
        page.EnterText(searchBox, dataToEnter);
    }
    public String getActualSearchData() {
        //wait.setExplicitWait(driver);
        wait.waitForTheElementToBeVisible(driver, WaitUtility.LocaterType.Xpath, _searchResult);
        List<WebElement> usersWebElementList = page.getWebElementList(driver, _searchResult);
        String actualUserValue = page.getElementText(usersWebElementList.get(0));
        System.out.println(actualUserValue);
        if (actualUserValue != " ") {
            System.out.println("True");
            return actualUserValue;
        } else {
            return " ";
        }
    }
    public String getInvalidSearchData() {
        return datauser.get(1).get(2);
    }

    public String getExpectedMessage() {
        return datauser.get(1).get(3);
    }

    public String getActualMessage() {
        wait.waitForTheElementToBeVisible(driver, WaitUtility.LocaterType.Xpath, _searchMessage);
        return page.getElementText(searchMessage);
    }
    public AddUserPage clickOnAddUsersButton() throws IOException {
        page.clickOnElement(addUserButton);
        return new AddUserPage(driver);
    }
    public List<ArrayList<String>> getTableData() {
        return TableUtility.getGridData(rowElement, colElement);

    }

    public boolean getTableContainsData(List<ArrayList<String>> tableData, String expectedUserName) {
        boolean status = false;
        for (int i = 0; i < tableData.size(); i++)
            if (tableData.get(i).contains(expectedUserName)) {
                status = true;
            }
        return status;
    }
    }

