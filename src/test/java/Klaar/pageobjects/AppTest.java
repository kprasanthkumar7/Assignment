package Klaar.pageobjects;

import Testcomponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;


public class AppTest extends BaseTest {
    public  SettingsPage settingsPage;
    public  LoginPage loginPage;
    public  UserListPage userListPage;
    public  CustomFieldsPage customFieldsPage;

    @BeforeTest
    public void loginToAccount() throws IOException {
        loginPage = new LoginPage(driver);
        settingsPage = new SettingsPage(driver);
        userListPage = new UserListPage(driver);
        customFieldsPage = new CustomFieldsPage(driver);
    }


    @Test(priority = 0,description = "Test1: Workspace Settings")
    public void workspaceSettingsTest() throws InterruptedException, AWTException {
        loginPage.loginToAccount();
        Assert.assertTrue(loginPage.validateUserAbleToLoginToAccount(),"Unable to login to the account");
        settingsPage.navigateToSettingPage();
        Assert.assertTrue(settingsPage.validateLandingOnWorkSpaceSettingPage(),"User unable to land on workspace settings page");
        settingsPage.validatingFunctionalityOfWorkSpaceSettings();
        Assert.assertTrue(settingsPage.validationOnSelectingOrgHead(),"Unable to add organisation Head");
        settingsPage.addingWorkspaceLogo();
        Assert.assertTrue(settingsPage.validateWorkspaceLogo(),"Unable to change the workspace logo");
        settingsPage.editingWorkSpaceLogo();
        Assert.assertTrue(settingsPage.validatingTheLogoChange(),"Unable to find the change for the latest workspace logo ");
        settingsPage.removingTheWorkSpaceLogo();
        Assert.assertTrue(settingsPage.validationOnDeletingTheLogo(),"Unable to delete the workspace logo");

    }

    @Test(priority = 1,description = " Test 2: Add a new user")
    public void addANewUserTest() throws InterruptedException, IOException {
        settingsPage.navigateToSettingPage();
        Assert.assertTrue(settingsPage.validateLandingOnWorkSpaceSettingPage(),"User unable to land on workspace settings page");
        userListPage.validateUserLandingOnAllUsersSec();
        Assert.assertTrue(userListPage.validateUserLandingOnAllUsersPage(),"User unable to navigate to All Users page");
        userListPage.addingNewUserInTheList();
        userListPage.navigateToEditUserPage();
        Assert.assertTrue(userListPage.validatingLandingOnTheEditUserPage(),"Usable to navigate to edit user details page");
        Assert.assertTrue(userListPage.confirmingTheAddedUser(),"User is not added");

    }


    @Test(priority = 2,description = "Test 3: User Custom Fields")
    public void userCustomFieldsFunctionality() throws InterruptedException, AWTException {
        settingsPage.navigateToSettingPage();
        Assert.assertTrue(settingsPage.validateLandingOnWorkSpaceSettingPage(),"User unable to land on workspace settings page");
        customFieldsPage.functionalityOfCustomFieldsSec();
        Assert.assertTrue(customFieldsPage.confirmingAddedDateInUserDetailSpace(),"Custom field of date type is not added");
        customFieldsPage.selectingFutureDate();
        customFieldsPage.addingCustomFldList();
        Assert.assertTrue(customFieldsPage.confirmAddedCustomFldOfTypeList(),"Custom field of List type is not added");
        customFieldsPage.selectingOneOfTheOptionInTheList();
        customFieldsPage.checkToggleFunctionality();
        Assert.assertTrue(customFieldsPage.confirmingTheChangesOfToggle(),"Toggle changes are not reflecting on company details page");
        customFieldsPage.deletingTheAddedToggle();
        Assert.assertTrue(customFieldsPage.confirmingDeletionOfAddedToggleInCustomFldSec(),"Toggle is not deleted and its reflecting in the custom fields page");
        Assert.assertTrue(customFieldsPage.confirmingDeletionOfAddedToggleInCompanyDetailsPage(),"Toggle is not deleted and its reflecting in company details page");
    }




    }








