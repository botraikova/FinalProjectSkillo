import Object.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LikeButtonTest extends TestObjectAndDriver {


    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        return new Object[][]{
                {"testbo", "1234567"}
        };
    }

    @Test(dataProvider = "getUser")
    public void likeButtonTest(String username, String password) {

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

        loginPage.clickSignInButton();

        boolean isPostLikedAlready = homePage.likedPost();
        Assert.assertTrue(isPostLikedAlready, "The post is not liked");
    }
}