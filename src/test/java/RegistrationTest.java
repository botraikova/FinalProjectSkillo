import Object.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegistrationTest extends ScreenshotFailure {
    private WebDriver webDriver;

    ChromeDriver webDriverDriver;
   private boolean userReg = false;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.chromedriver().clearDriverCache().setup();
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        if (webDriver != null) {
            webDriver.close();
        }
        if (userReg == true) {
        }

    }

    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        return new Object[][]{
                {"usertofailthetest", "hellogoodbye@mail.com", "1234567", "1234567"},
        };
    }

    @Test (dataProvider = "getUser")
    public void registrationTest (String username, String email, String password, String confirmPassword){
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page isn't loaded");

        header.clickLoginButton();
        String loginURL = "http://training.skillo-bg.com:4200/users/login";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlToBe(loginURL));
        Assert.assertTrue(loginPage.isUrlLoaded(), "Login page isn't loaded");

        wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement registerLinkButton = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement
                (By.xpath("/html/body/app-root/div[2]/app-login/div/div/form/p[2]/a"))));
        registerLinkButton.click();

        registrationPage.typeUserName(username);
        registrationPage.typeEmail(email);
        registrationPage.typePassword(password);
        registrationPage.typeConfirmPassword(confirmPassword);

        registrationPage.clickSignIn();

        header.clickProfileButton();
        //profilePage.isUrlLoaded(userId);
        profilePage.isUrlLoaded();

        Assert.assertTrue(profilePage.isUrlLoaded(), "Profile page isn't loaded");


        //Assert.assertEquals(webDriver.getCurrentUrl(), "http://training.skillo-bg.com:4200/users/" + userId);
        //Assert.assertTrue(profilePage.isUrlLoaded(),"This is not Profile page for" + "username");
    }
}