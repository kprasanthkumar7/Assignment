package Klaar.pageobjects;

import Klaar.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.awt.*;
import java.util.List;

public class CustomFieldsPage extends AbstractComponents {

    WebDriver driver;

    public CustomFieldsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[text()='Custom Fields']")
    private WebElement customFieldSection;
    @FindBy(xpath = "//*[@aria-selected='true']")
    private WebElement customFieldConfirmation;
    @FindBy(xpath = "//*[text()='Add Field']")
    private WebElement addFieldButton;
    @FindBy(xpath = "//*[@class='modal footer-available']")
    private WebElement addFieldPopupConfirm;
    @FindBy(xpath = "//*[@placeholder='Enter field name...']")
    private WebElement nameFldOnPopup;
    @FindBy(xpath = "//*[text()=' Select field Type ']")
    private WebElement fieldTypeDropdown;
    @FindBy(xpath = "//*[@class='ant-select-item-option-content'][text()='Date']")
    private WebElement fieldTypeDate;
    @FindBy(xpath = "//*[text()=' Submit']")
    private WebElement submitButtonOfPopup;
    @FindBy(xpath = "//*[text()='All Users']")
    private WebElement allUserSec;
    @FindBy(xpath = "//*[@class='tw-flex ng-star-inserted']/*[1]")
    private List<WebElement> usersList;
    @FindBy(xpath = "//*[text()='Edit User']")
    private WebElement userDetailsPage;
    @FindBy(xpath = "//*[text()='Company']")
    private WebElement userCompanyDetailsSec;
    @FindBy(xpath = "//*[@aria-selected='true']")
    private WebElement userCompanyPageConfirm;
    @FindBy(xpath = "//*[@data-cy='settings-edit-user-company-info-custom-field-label']/*")
    private List<WebElement> addedCustomFlds;
    private String nameFLdText = "Dumy";
    @FindBy(xpath = "//*[@class='ant-select-item-option-content'][text()='List']")
    private WebElement fieldTypeList;
    @FindBy(xpath = "//*[text()=' Add another Item ']")
    private WebElement addAnotherButtonInList;
    private String listName = "LISt";
    @FindBy(xpath = "//*[@class='ant-select-item-option-content']")
    private List<WebElement> listOptions;
    @FindBy(xpath = "//*[text()='Save']")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@class='toast-message']")
    private WebElement toastMessageConfirm;
    @FindBy(xpath = "//*[text()='User List']")
    private WebElement userListPage;
    @FindBy(xpath = "//*[@class='row ng-star-inserted']/*[2]")
    private List<WebElement> listOfToggles;
    @FindBy(xpath = "//*[@placeholder=\"Option List\"]")
    private List<WebElement> optionsInTheList;
    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButtonInCompanySec;


    public void functionalityOfCustomFieldsSec() throws InterruptedException {
        waitAndCheckElementIsPresent(userListPage);
        moveToTheElementAndClick(userListPage);
        customFieldSection.click();
        waitAndCheckElementIsPresent(customFieldConfirmation);
        addFieldButton.click();
        waitAndCheckElementIsPresent(addFieldPopupConfirm);
        moveToTheElementAndClickAndSendKeys(nameFldOnPopup, nameFLdText);
        moveToTheElementAndClick(fieldTypeDropdown);
        waitAndCheckElementIsPresent(fieldTypeDate);
        moveToTheElementAndClick(fieldTypeDate);
        submitButtonOfPopup.click();
        Thread.sleep(1000);
        waitAndCheckElementIsPresent(allUserSec);
        mouseOverOnElement(allUserSec);
        allUserSec.click();

    }
    public boolean confirmingAddedDateInUserDetailSpace(){
        waitAndCheckElementIsPresent(usersList.get(0));
        moveToTheElementAndClick(usersList.get(0));
        waitAndCheckElementIsPresent(userDetailsPage);
        moveToTheElementAndClick(userCompanyDetailsSec);
        waitAndCheckElementIsPresent(userCompanyPageConfirm);
        for (WebElement createdDateFld : addedCustomFlds) {
            if (createdDateFld.getText().equalsIgnoreCase(nameFLdText)) {
                scrollToElement(createdDateFld);
                System.out.println("Custom Field of date type is created with name " + nameFLdText + "");
                return true;
            }
        }
        return false;
    }
    public void selectingFutureDate() throws InterruptedException, AWTException {
        for (WebElement createdDateFld : addedCustomFlds) {
            if (createdDateFld.getText().equalsIgnoreCase(nameFLdText)) {

                waitAndCheckElementIsPresent(createdDateFld);
                WebElement element = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(createdDateFld));
                moveToTheElementAndClick(element);
                Thread.sleep(2000);
                element.sendKeys("2028-04-21");
                enterButton_VK();
                scrollToElement(saveButtonInCompanySec);
                saveButtonInCompanySec.click();
                waitAndCheckElementIsPresent(toastMessageConfirm);

            }
        }

    }


        public void addingCustomFldList () throws InterruptedException {

            waitAndCheckElementIsPresent(userListPage);
            moveToTheElementAndClick(userListPage);
            waitAndCheckElementIsPresent(customFieldSection);
            moveToTheElementAndClick(customFieldSection);
            waitAndCheckElementIsPresent(addFieldButton);
            addFieldButton.click();
            waitAndCheckElementIsPresent(addFieldPopupConfirm);
            //moveToTheElementAndClickAndSendKeys(nameFldOnPopup, listName);
            Thread.sleep(1000);
            waitAndCheckElementIsPresent(nameFldOnPopup);
            nameFldOnPopup.sendKeys(listName);
            moveToTheElementAndClick(fieldTypeDropdown);
            moveToTheElementAndClick(fieldTypeList);
            waitAndCheckElementIsPresent(addAnotherButtonInList);
            moveToTheElementAndClick(addAnotherButtonInList);
            Thread.sleep(1000);
            moveToTheElementAndClick(addAnotherButtonInList);
            for (WebElement option : optionsInTheList) {
                moveToTheElementAndClick(option);
                option.sendKeys("list1");
            }
            submitButtonOfPopup.click();
            Thread.sleep(1000);


        }
        public boolean confirmAddedCustomFldOfTypeList() throws InterruptedException {
            waitAndCheckElementIsPresent(allUserSec);
            mouseOverOnElement(allUserSec);
            allUserSec.click();
            waitAndCheckElementIsPresent(usersList.get(0));
            moveToTheElementAndClick(usersList.get(0));
            waitAndCheckElementIsPresent(userDetailsPage);
            moveToTheElementAndClick(userCompanyDetailsSec);
            waitAndCheckElementIsPresent(userCompanyPageConfirm);
            for (WebElement createdList : addedCustomFlds) {
                if (createdList.getText().equalsIgnoreCase(listName)) {
                    System.out.println("Added custom field of type List");
                    return true;
                }
            }
            Thread.sleep(2000);
            return false;
        }
    public void selectingOneOfTheOptionInTheList() throws InterruptedException {


            for (WebElement createdList : addedCustomFlds) {
                if (createdList.getText().equalsIgnoreCase(listName)) {
                    scrollToElement(createdList);
                    Thread.sleep(1000);
                    WebElement element = driver.findElement(RelativeLocator.with(By.tagName("nz-select-top-control")).toRightOf(createdList));
                    moveToTheElementAndClick(element);
                    Thread.sleep(1000);
                    waitAndCheckElementIsPresent(listOptions.get(0));
                    moveToTheElementAndClick(listOptions.get(0));
                    scrollToElement(saveButton);
                    saveButton.click();
                    waitAndCheckElementIsPresent(toastMessageConfirm);
                }
            }


        }

        public void checkToggleFunctionality() {
            waitAndCheckElementIsPresent(userListPage);
            moveToTheElementAndClick(userListPage);
            waitAndCheckElementIsPresent(customFieldSection);
            moveToTheElementAndClick(customFieldSection);
            waitAndCheckElementIsPresent(customFieldConfirmation);
            for (WebElement toggle : listOfToggles) {
                if (toggle.getText().equalsIgnoreCase(listName)) {
                    scrollToElement(toggle);
                    WebElement element = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(toggle));
                    moveToTheElementAndClick(element);
                    //waitAndCheckElementIsPresent(toastMessageConfirm);
                }
            }
        }
            public boolean confirmingTheChangesOfToggle(){
            waitAndCheckElementIsPresent(allUserSec);
            moveToTheElementAndClick(allUserSec);
            waitAndCheckElementIsPresent(usersList.get(0));
            moveToTheElementAndClick(usersList.get(0));
            waitAndCheckElementIsPresent(userDetailsPage);
            moveToTheElementAndClick(userCompanyDetailsSec);
            waitAndCheckElementIsPresent(userCompanyPageConfirm);
            for (WebElement toggle : addedCustomFlds) {
                if (toggle.getText().equalsIgnoreCase(listName)) {
                    System.out.println(listName + "  is still visible");
                    return false;
                }break;
            }
            return true;
        }


        public void deletingTheAddedToggle () {
            waitAndCheckElementIsPresent(userListPage);
            moveToTheElementAndClick(userListPage);
            waitAndCheckElementIsPresent(customFieldSection);
            moveToTheElementAndClick(customFieldSection);
            waitAndCheckElementIsPresent(customFieldConfirmation);
            for (WebElement toggle : listOfToggles) {
                if (toggle.getText().contains(listName)) {
                    String dynamicValue = listName;
                    String locator = String.format("//*[@class='row ng-star-inserted']/*[2][contains(text(),'%s')]//following::*/following::*/*/*[@nztooltiptitle='Delete Field']/*", dynamicValue);
//                    WebElement element = toggle.findElement(By.xpath("//following::*/following::*/*/*[@nztooltiptitle='Delete Field']/*"));
//                    moveToTheElementAndClick(element);
                      WebElement ele = driver.findElement(By.xpath(locator));
                      ele.click();
                      waitAndCheckElementIsPresent(toastMessageConfirm);
                }
            }
        }
    public boolean confirmingDeletionOfAddedToggleInCustomFldSec() throws InterruptedException {
        Thread.sleep(1000);
        for (WebElement toggle : listOfToggles) {

            if (toggle.getText().equalsIgnoreCase(listName)) {
                System.out.println(listName + "is still visible and it's not deleted and it is present in the custom fields");
                return false;
            }
        }
        return true;
    }
    public boolean confirmingDeletionOfAddedToggleInCompanyDetailsPage() {
            waitAndCheckElementIsPresent(allUserSec);
            moveToTheElementAndClick(allUserSec);
            waitAndCheckElementIsPresent(usersList.get(0));
            moveToTheElementAndClick(usersList.get(0));
            waitAndCheckElementIsPresent(userDetailsPage);
            moveToTheElementAndClick(userCompanyDetailsSec);
            waitAndCheckElementIsPresent(userCompanyPageConfirm);
            for (WebElement toggle : addedCustomFlds) {
                if (toggle.getText().equalsIgnoreCase(listName)) {
                    System.out.println(listName + "is still visible");
                    return false;
                }
            }
            return true;
        }

    }






















