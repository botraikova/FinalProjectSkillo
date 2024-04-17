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
    private final WebDriverWait wait;

    //List<WebElement>visibleSearchResults;


    public Header(WebDriver driver) {

        this.webDriver = driver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(60));
    }

    public void clickLoginButton(){

        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-login")));
        //staro WebElement loginLink = this.webDriver.findElement(By.id("nav-link-login"));
        loginLink.click();
    }

    public void clickProfileButton(){
        //staro WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement profilePageLink = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("nav-link-profile"))));
        profilePageLink.click();
    }

    public void clickSearchIcon(){
        //staro WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(20));
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("search-bar"))));
        searchIcon.click();
    }

    public void typeInSearchBar(String textToType){
        //WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(120));
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("search-bar"))));
        searchInput.sendKeys(textToType);
    }
    //public void waitForResultsInSearchField(){
      //  WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(180));
       // wait.until(ExpectedConditions.visibilityOfAllElements(visibleSearchResults));
   // }
    public boolean hasSearchResultsGreaterThanValue(int minimumNumberOfResults){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dropdown-container app-small-user-profile"))); // Wait for visibility of search results
        List<WebElement> searchResults = this.webDriver.findElements(By.cssSelector(".dropdown-container app-small-user-profile"));
        int numberOfResultsFound = searchResults.size();
        System.out.println("Number of results found: " + numberOfResultsFound);
        return numberOfResultsFound >= minimumNumberOfResults;
    }
}