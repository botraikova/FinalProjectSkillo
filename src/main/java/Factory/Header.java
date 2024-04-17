package Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver webDriver;
    @FindBy(id = "nav-link-login")
    private WebElement loginLinkFactory;

    @FindBy(id = "nav-link-profile")
    private WebElement profilePageLinkFactory;

    public Header(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickLoginButton() {
        loginLinkFactory.click();
    }


    public void clickProfileButton() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        profilePageLinkFactory.click();
    }
}
