import Object.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LikeButtonTest extends DriverMaintenanceAndScreenshots {


    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        return new Object[][]{
                {"testbo", "1234567"} // "5493"},
        };
    }

    @Test(dataProvider = "getUser")
    public void loginTest(String username, String password) { //String userId

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

        WebElement likePostButton = webDriver.findElement(By.xpath("/html/body/app-root/div[2]/app-all-posts/div/div/div[1]/app-post-detail/div/div[2]/div/div[1]/i[1]"));

        boolean isPostLikedAlready = likedPost(likePostButton);
        Assert.assertTrue(isPostLikedAlready, "The post is not liked");
    }

    public boolean likedPost(WebElement likePostButton) {
        String firstClassName = likePostButton.getAttribute("class");
        likePostButton.click();
        String secondClassName = likePostButton.getAttribute("class");
        return secondClassName.contains("liked");
    }
}