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

    public Header(WebDriver driver) {

        this.webDriver = driver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(60));
    }

    public void clickLoginButton(){

        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-login")));
        loginLink.click();
    }

    public void clickProfileButton(){

        WebElement profilePageLink = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("nav-link-profile"))));
        profilePageLink.click();
    }

    public void clickSearchIcon(){

        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("search-bar"))));
        searchIcon.click();
    }

    public void typeInSearchBar(String textToType){

        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("search-bar"))));
        searchInput.sendKeys(textToType);
    }

    public boolean hasSearchResultsGreaterThanValue(int minimumNumberOfResults){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dropdown-container app-small-user-profile"))); // Wait for visibility of search results
        List<WebElement> searchResults = this.webDriver.findElements(By.cssSelector(".dropdown-container app-small-user-profile"));
        int numberOfResultsFound = searchResults.size();
        System.out.println("Number of results found: " + numberOfResultsFound);
        return numberOfResultsFound >= minimumNumberOfResults;
    }
}