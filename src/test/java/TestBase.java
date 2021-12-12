import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    public static ThreadLocal<WebDriver> t1Driver = new ThreadLocal<>();
    public  WebDriver driver;
    public WebDriverWait wait;


    @BeforeEach
    public void start() {
        if (t1Driver.get() != null) {
            driver = t1Driver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }
        driver = new FirefoxDriver();
        t1Driver.set(driver);
        System.out.println(((HasCapabilities) driver).getCapabilities());
        wait = new WebDriverWait(driver, 10);
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    driver.quit();
                    driver = null;
                })
        );
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (InvalidSelectorException ex) {
            throw ex;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }

//    @AfterEach
//    public void stop(){
//        driver.quit();
//        driver = null;
//    }
}
