import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Object.*;

public class SearchFieldTest extends DriverMaintenanceAndScreenshots {

    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        return new Object[][]{
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