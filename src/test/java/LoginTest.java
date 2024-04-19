import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import Object.*;
//import Factory.*;

public class LoginTest extends DriverMaintenanceAndScreenshots {

    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        return new Object[][]{
                {"testbo", "1234567", "5493"},
        };
    }

    @Test(dataProvider = "getUser")
    public void loginTest(String username, String password, String userId) {

        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        homePage.navigateTo();

        Assert.assertTrue(homePage.isUrlLoaded(), "Home page isn't loaded");

        header.clickLoginButton();
        String loginURL = "http://training.skillo-bg.com:4200/users/login";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlToBe(loginURL));

        Assert.assertTrue(loginPage.isUrlLoaded(), "Login page isn't loaded");

        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.checkRememberMeBox();

        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember Me checkbox isn't checked");


        loginPage.clickSignInButton();
        header.clickProfileButton();
        profilePage.isUrlLoaded(userId);


        Assert.assertTrue(profilePage.isUrlLoaded(), "Profile page isn't loaded");

        Assert.assertEquals(webDriver.getCurrentUrl(), "http://training.skillo-bg.com:4200/users/" + userId);
    }
}