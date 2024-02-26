package Klaar.pageobjects;

import Klaar.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class UserListPage extends AbstractComponents {
    WebDriver driver;

    public UserListPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@data-cy=\"submenu-button\"][text()='User List']")
    private WebElement userListSection;

    @FindBy(xpath = "//*[@data-cy=\"page-heading-field\"][text()='User List']")
    private WebElement userListPageConfirmation;
    @FindBy(xpath = "//*[@aria-selected='true']")
    private WebElement allUserPageConfirmation;
    @FindBy(xpath = "//*[@data-cy='settings-user-list-add-user-button']")
    private WebElement addUserDropdown;
    @FindBy(xpath = "//*[text()='Add User']")
    private WebElement addUserButton;
    @FindBy(xpath = "//*[text()='Send invite mail to new user.']")
    private WebElement addUserPopupConfirmation;
    @FindBy(xpath = "//*[@formcontrolname='full_name']")
    private WebElement userNameTextFld;
    @FindBy(xpath = "//*[@formcontrolname='email']")
    private WebElement emailTextFld;
    @FindBy(xpath = "//*[text()=' Enter department here ']")
    private WebElement departmentNameDropdown;
    @FindBy(xpath = "//*[@class='ant-select-item-option-content']")
    private List<WebElement> departmentNames;
    @FindBy(xpath = "//*[text()=' Enter title here ']")
    private WebElement titleNameDropdown;

    @FindBy(xpath = "//*[@class='ant-select-item-option-content']")
    private List<WebElement> titleNames;
    @FindBy(xpath = "(//nz-select-placeholder[@class='ant-select-selection-placeholder ng-star-inserted'])[1]")
    private WebElement managerDropdown;
    @FindBy(xpath = "//*[@class='ant-select-item-option-content']")
    private List<WebElement> managerNames;
    @FindBy(xpath = "//nz-select-placeholder[@class='ant-select-selection-placeholder ng-star-inserted']")
    private WebElement HRBPDropdown;
    @FindBy(xpath = "//*[@class='ant-select-item-option-content']")
    private List<WebElement> HRMails;
    @FindBy(xpath = "//*[@placeholder='Enter employee id here']")
    private WebElement userIdTextFld;
    @FindBy(xpath = "//*[@placeholder='Enter Phone Number here']")
    private WebElement userPhoneNumFld;
    @FindBy(xpath = "//*[@placeholder='Enter location here']")
    private WebElement locationTextFld;
    @FindBy(xpath = "//*[text()=' Add Now']")
    private WebElement addNowButton;
    @FindBy(xpath = "//*[text()='Edit User']")
    private WebElement editUserPageConfirmation;
    @FindBy(xpath = "//*[@data-cy='user-list-search-text-field']")
    private WebElement validateUserSearchFld;
    @FindBy(xpath = "//*[@data-cy='user-list-user-id-field']")
    private List<WebElement> emailConfirmation;

//    private String email;
//    private String userName;
//    private String employeID;
//    private String userNumber;
      Properties properties = AbstractComponents.getProperties();

    public void addingNewUserInTheList() throws InterruptedException, IOException {

        mouseOverOnElement(addUserDropdown);
        waitAndCheckElementIsPresent(addUserButton);
        moveToTheElementAndClick(addUserButton);
        waitAndCheckElementIsPresent(addUserPopupConfirmation);
        //userNameTextFld.sendKeys(properties.getProperty("userName"));
        //moveToTheElementAndClickAndSendKeys(userNameTextFld,properties.getProperty("userName"));
        try {
            userNameTextFld.sendKeys(properties.getProperty("userName"));
        } catch (Exception e) {

            e.printStackTrace();
        }
//        try {
//            moveToTheElementAndClickAndSendKeys(userNameTextFld, properties.getProperty("userName"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        emailTextFld.sendKeys(properties.getProperty("email"));
        moveToTheElementAndClickAndSendKeys(departmentNameDropdown, "quality");
        Thread.sleep(2000);
        waitAndCheckElementIsPresent(departmentNames.get(0));
        moveToTheElementAndClick(departmentNames.get(0));
        moveToTheElementAndClickAndSendKeys(titleNameDropdown, "software tester");
        Thread.sleep(2000);
        waitAndCheckElementIsPresent(titleNames.get(0));
        moveToTheElementAndClick(titleNames.get(0));
        moveToTheElementAndClickAndSendKeys(managerDropdown, "akas");
        Thread.sleep(2000);
        waitAndCheckElementIsPresent(managerNames.get(0));
        moveToTheElementAndClick(managerNames.get(0));
        moveToTheElementAndClickAndSendKeys(HRBPDropdown, "akshay");
        Thread.sleep(2000);
        waitAndCheckElementIsPresent(HRMails.get(0));
        moveToTheElementAndClick(HRMails.get(0));
        userIdTextFld.sendKeys(properties.getProperty("employeID"));
        userPhoneNumFld.sendKeys(properties.getProperty("userNumber"));
        scrollToElement(addNowButton);
        locationTextFld.sendKeys("India");
        moveToTheElementAndClick(addNowButton);
    }

    public void validateUserLandingOnAllUsersSec() {
        waitAndCheckElementIsPresent(userListSection);
        userListSection.click();
        waitAndCheckElementIsPresent(allUserPageConfirmation);
    }

    public boolean validateUserLandingOnAllUsersPage() {
        return checkIsElementIsPresent(allUserPageConfirmation);
    }

    public boolean confirmingTheAddedUser() throws InterruptedException {
        waitAndCheckElementIsPresent(userListSection);
        userListSection.click();
        waitAndCheckElementIsPresent(userListPageConfirmation);
        moveToTheElementAndClickAndSendKeys(validateUserSearchFld, properties.getProperty("userName"));
        Thread.sleep(2000);
        for (WebElement emailId : emailConfirmation) {
            if (emailId.getText().equalsIgnoreCase(properties.getProperty("email"))) {
                System.out.println("User is added to the userList");
                return true;
            }
        }
        return false;
    }

    public void navigateToEditUserPage() throws InterruptedException {
        Thread.sleep(2000);
        waitAndCheckElementIsPresent(editUserPageConfirmation);
    }

    public boolean validatingLandingOnTheEditUserPage() {
     return checkIsElementIsPresent(editUserPageConfirmation);
    }















}
