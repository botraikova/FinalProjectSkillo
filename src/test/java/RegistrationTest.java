import Object.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationTest extends TestObjectAndDriver {


    @Test
    public void registrationTest (){
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page isn't loaded");

        header.clickLoginButton();

        Assert.assertTrue(loginPage.isUrlLoaded(), "Login page isn't loaded");


        registrationPage.registerLinkButton();
        registrationPage.typeUserName();
        registrationPage.typeEmail();
        registrationPage.typePassword();
        registrationPage.typeConfirmPassword();

        registrationPage.clickSignIn();

        header.clickProfileButton();

        profilePage.isUrlLoaded();

        Assert.assertTrue(profilePage.isUrlLoaded(), "Profile page isn't loaded");

    }
}