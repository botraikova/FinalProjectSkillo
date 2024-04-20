package Object;
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

    public void typeUserName(String username){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement usernameTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.
                findElement(By.xpath("/html/body/app-root/div[2]/app-register/div/div/form/div[1]/input"))));
        usernameTextField.sendKeys(username);
    }

    public void typeEmail(String email){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement emailTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.
                findElement(By.xpath("/html/body/app-root/div[2]/app-register/div/div/form/div[2]/input"))));
        emailTextField.sendKeys(email);
    }

    public void typePassword(String password){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement passwordTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.
                findElement(By.xpath("//*[@id='defaultRegisterFormPassword']"))));
        passwordTextField.sendKeys(password);
    }

    public void typeConfirmPassword(String confirmPassword){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement passwordAgainTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.
                findElement(By.xpath("//*[@id='defaultRegisterPhonePassword']"))));
        passwordAgainTextField.sendKeys(confirmPassword);
    }

    public void clickSignIn(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement
                (By.xpath("//*[@id='sign-in-button']"))));
        signInButton.click();
    }
}