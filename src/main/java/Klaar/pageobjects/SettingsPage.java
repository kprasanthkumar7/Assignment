package Klaar.pageobjects;

import Klaar.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class SettingsPage extends AbstractComponents {

    WebDriver driver;

    public SettingsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//p[text()='Settings']")
    WebElement settingsSec;
    @FindBy(xpath = "//span[text()='Settings']")
    WebElement settingsPageConfirmation;
    @FindBy(xpath = "//*[text()='Workspace Settings']")
    WebElement workingSpaceSettingsConfirmation;
    @FindBy(xpath = "//*[@placeholder='Organization name']")
    WebElement workSpaceNameField;
    @FindBy(xpath = "//*[text()=' Save changes ']")
    WebElement saveWorkspaceChangesButton;
    @FindBy(xpath = "//*[@class='ant-select-selector ng-tns-c142-3']")
    WebElement selectOrgHeadDrop;
    @FindBy(xpath = "//*[@class='ant-select-item-option-content']")
    List<WebElement> selectOrgHeadFromSuggestions;
    @FindBy(xpath = "//*[text()='Save']")
    WebElement orgHeadSaveButton;
    @FindBy(id = "cdk-overlay-0")
    WebElement orgHeadOptions;
    @FindBy(xpath = "//*[@class='toast-message']")
    WebElement orgHeadConfirmToastMsg;
    @FindBy(xpath = "//*[@class='ant-select-selection-item-remove ng-star-inserted']")
    WebElement removeOrgHeadIcon;
    @FindBy(xpath = "//*[text()=' Choose File ']")
    WebElement chooseFileButton;
    @FindBy(xpath = "//*[@viewBox=\"0 0 24 16\"]")
    WebElement saveLogoButton;
    @FindBy(xpath="//*[@class='orgShortLogo']")
    WebElement logoConfirmation;
    @FindBy(xpath = "//button[@data-cy=\"settings-workspace-logo-edit-button\"]/*[@class='anticon']")
    WebElement logoEditButton;
    @FindBy(xpath = "//*[@data-cy=\"settings-workspace-logo-delete-button\"]/*[@class='anticon']")
    WebElement logoDeleteIcon;
    @FindBy(xpath = "//*[text()='Delete']")
    WebElement deleteButton;
    @FindBy(xpath ="//*[text()='Workspace Logo ']")
    WebElement workspaceLogoSection;
    @FindBy(xpath = "//*[@class='ant-select-selection-item ng-star-inserted']")
    private List<WebElement> headConfirm;

    private String firstLogoColor,secondLogoColor;

    public void  navigateToSettingPage(){
        settingsSec.click();
        waitAndCheckElementIsPresent(settingsPageConfirmation);
        waitAndCheckElementIsPresent(workingSpaceSettingsConfirmation);
        String workSpaceSettings=workingSpaceSettingsConfirmation.getText();
        workSpaceSettings.equalsIgnoreCase("Workspace Settings");
    }
    public void
    validatingFunctionalityOfWorkSpaceSettings() throws InterruptedException, AWTException {
        workSpaceNameField.clear();
        workSpaceNameField.sendKeys("New Workspace");
        saveWorkspaceChangesButton.click();
        Thread.sleep(2000);
        waitAndCheckElementIsPresent(workingSpaceSettingsConfirmation);
        waitAndCheckElementIsPresent(selectOrgHeadDrop);
        moveToTheElementAndClick(selectOrgHeadDrop);
        Thread.sleep(1000);
        backspaceButton_VK();
        waitAndCheckElementIsPresent(orgHeadOptions);
        if(selectOrgHeadFromSuggestions.isEmpty())
        {
            System.out.println("There is no data about the Organisation Head");
            orgHeadSaveButton.click();
        }else{
            moveToTheElementAndClick(selectOrgHeadFromSuggestions.get(0));
            waitForElementToBeClickable(orgHeadSaveButton);
            orgHeadSaveButton.click();
            waitAndCheckElementIsPresent(orgHeadConfirmToastMsg);
        }



    }
    public void addingWorkspaceLogo() throws InterruptedException, AWTException {
        waitAndClickWhenElementIsPresent(workingSpaceSettingsConfirmation);
        scrollToElement(chooseFileButton);
        moveToTheElementAndClick(chooseFileButton);
        Thread.sleep(2000);
        String filePath="C:\\Users\\Pavan\\Downloads\\sampleFile.jpeg";
        StringSelection path = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path,null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        scrollToElement(saveLogoButton);
        waitAndCheckElementIsPresent(saveLogoButton);
        mouseOverOnElement(saveLogoButton);
        saveLogoButton.click();
        waitAndCheckElementIsPresent(logoConfirmation);
        firstLogoColor= logoConfirmation.getCssValue("color");

    }
    public void editingWorkSpaceLogo() throws InterruptedException, AWTException {

        moveToTheElementAndClick(logoEditButton);
        Thread.sleep(2000);
        String filePath="C:\\Users\\Pavan\\Downloads\\SystemD.png";
        StringSelection path = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path,null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        waitAndCheckElementIsPresent(saveLogoButton);
        mouseOverOnElement(saveLogoButton);
        saveLogoButton.click();
        waitAndCheckElementIsPresent(logoConfirmation);
        secondLogoColor= logoConfirmation.getCssValue("color");
    }
    public void removingTheWorkSpaceLogo(){

        waitAndCheckElementIsPresent(logoDeleteIcon);
        moveToTheElementAndClick(logoDeleteIcon);
        waitAndCheckElementIsPresent(deleteButton);
        deleteButton.click();
        waitAndCheckElementIsPresent(chooseFileButton);
        scrollToElement(chooseFileButton);
    }
    public boolean validateLandingOnWorkSpaceSettingPage(){
        return checkIsElementIsPresent(workingSpaceSettingsConfirmation);
    }
    public boolean validationOnSelectingOrgHead(){
        return checkIsElementIsPresent(headConfirm.get(0));
    }
    public boolean validateWorkspaceLogo(){
        return checkIsElementIsPresent(logoConfirmation);
    }
    public boolean validatingTheLogoChange(){

      boolean result =firstLogoColor.equals(secondLogoColor);
      return result;
    }
    public boolean validationOnDeletingTheLogo(){
        return checkIsElementIsPresent(chooseFileButton);
    }
}
