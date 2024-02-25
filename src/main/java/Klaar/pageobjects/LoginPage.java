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

public class LoginPage extends AbstractComponents {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[text()='Log in with klaar']")
    WebElement loginWithKlaarAccount;

    @FindBy(xpath = "//p[text()='Log in']")
    WebElement loginPageConfirmation;
    @FindBy(id = "email-field")
    WebElement emailTextField;
    @FindBy(id = "password-field")
    WebElement passwordTextField;
    @FindBy(id = "login-btn")
    WebElement loginButton;
    @FindBy(xpath = "//*[@class='user-name'][text()='Deepa Nayak']")
    WebElement profileConfirmation;

    public void loginToAccount() {
        loginWithKlaarAccount.click();
        waitAndCheckElementIsPresent(loginPageConfirmation);
        emailTextField.sendKeys("deepa.nayak@gamma.klaar.team");
        passwordTextField.sendKeys("Klaar2021");
        waitForElementToBeClickable(loginButton);
        loginButton.click();
        waitAndCheckElementIsPresent(profileConfirmation);
    }




    public boolean validateUserAbleToLoginToAccount(){
        return checkIsElementIsPresent(profileConfirmation);
    }

}
