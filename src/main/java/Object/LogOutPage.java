package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOutPage {

    private final WebDriver webDriver;

    public LogOutPage(WebDriver driver) {
        this.webDriver = driver;
    }
        public void clickLogoutButton () {
            WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement
                    (By.xpath("//*[@class='nav-link']//*[@class='fas fa-sign-out-alt fa-lg']"))));
            logoutButton.click();
        }
    }