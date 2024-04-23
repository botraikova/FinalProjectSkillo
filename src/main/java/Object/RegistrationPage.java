package Object;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage {
    public static final String REG_PAGE_URL = "http://training.skillo-bg.com:4200/users/register";
    private final WebDriver webDriver;

    public RegistrationPage(WebDriver driver){
        this.webDriver = driver;
    }

    public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(REG_PAGE_URL));
    }

    public void registerLinkButton() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(
                webDriver.findElement(By.xpath("//form//p//a[text()='Register']"))));
        registrationLink.click();
    }

    public void typeUserName(){
        String username = generateRandomUsername(10,15);
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement usernameTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.
                findElement(By.xpath("//*[@name='username']"))));
        usernameTextField.sendKeys(username);
    }

    public void typeEmail(){
        String email = generateRandomEmailAddress(10,15);
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement emailTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.
                findElement(By.xpath("//*[@type='email']"))));
        emailTextField.sendKeys(email);
    }

    String password = generateRandomAlphabeticString(10,15);

    public void typePassword(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement passwordTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.
                findElement(By.xpath("//*[@id='defaultRegisterFormPassword']"))));
        passwordTextField.sendKeys(password);
    }

    public void typeConfirmPassword(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement passwordAgainTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.
                findElement(By.xpath("//*[@id='defaultRegisterPhonePassword']"))));
        passwordAgainTextField.sendKeys(password);
    }

    public void clickSignIn(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement
                (By.xpath("//*[@id='sign-in-button']"))));
        signInButton.click();
    }

    private String generateRandomUsername(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }

    private String generateRandomEmailAddress(int minLengthInclusive, int maxLengthInclusive) {
        return generateRandomAlphabeticString(minLengthInclusive, maxLengthInclusive) + "@gmail.com";
    }

    private String generateRandomAlphabeticString(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }

}