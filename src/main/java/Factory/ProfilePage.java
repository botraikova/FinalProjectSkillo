package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public static final String PROFILE_PAGE_URL = "http://training.skillo-bg.com:4200/users/";
    private final WebDriver webDriver;
    public ProfilePage(WebDriver driver){
        this.webDriver = driver;
    }

    public boolean isUrlLoaded (){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlContains(PROFILE_PAGE_URL));
    }

    public boolean isUrlLoaded (String userId){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(PROFILE_PAGE_URL + userId));
    }
}
