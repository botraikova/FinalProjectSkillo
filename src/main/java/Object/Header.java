package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Header {
    private final WebDriver webDriver;

    List<WebElement>visibleSearchResults;


    public Header(WebDriver driver) {
        this.webDriver = driver;
    }

    public void clickLoginButton(){
        WebElement loginLink = this.webDriver.findElement(By.id("nav-link-login"));
        loginLink.click();
    }

    public void clickProfileButton(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement profilePageLink = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("nav-link-profile"))));
        profilePageLink.click();
    }

    public void clickSearchIcon(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(20));
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("search-bar"))));
        searchIcon.click();
    }

    public void typeInSearchBar(String textToType){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(120));
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("search-bar"))));
        searchIcon.sendKeys(textToType);
    }
    public void waitForResultsInSearchField(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.visibilityOfAllElements(visibleSearchResults));
    }
}