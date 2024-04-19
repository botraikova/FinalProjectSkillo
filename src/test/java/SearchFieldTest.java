import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.SECONDS;

import Object.*;

public class SearchFieldTest extends DriverMaintenanceAndScreenshots {

    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        return new Object[][]{
                //To pass the first data object the userId needs to be changed to 5508/5493-bo
                {"testbo", "1234567", "5493"},
        };
    }

    @Test(dataProvider = "getUser")
    public void searchUser(String username, String password, String userId) {
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);


        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page isn't loaded");

        header.clickLoginButton();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Login page isn't loaded");


        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.checkRememberMeBox();

        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember Me checkbox isn't checked");

        loginPage.clickSignInButton();

        header.clickSearchIcon();
        header.typeInSearchBar("user");
        Assert.assertTrue(header.hasSearchResultsGreaterThanValue(50), "Users are not shown");


    }
}
