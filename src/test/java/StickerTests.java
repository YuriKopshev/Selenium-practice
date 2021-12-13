import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StickerTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void start() {
        driver = new FirefoxDriver();
    }

    @Test
    public void checkStickerTest() {
        driver.get("http://localhost/litecart/");
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector("#box-most-popular [title='Purple Duck'] [title='New']"));
        driver.findElement(By.cssSelector("#box-most-popular [title='Green Duck'] [title='New']"));
        driver.findElement(By.cssSelector("#box-most-popular [title='Blue Duck'] [title='New']"));
        driver.findElement(By.cssSelector("#box-most-popular [title='Yellow Duck'] [title='On Sale']"));
        driver.findElement(By.cssSelector("#box-campaigns [title='Yellow Duck'] [title='On Sale']"));
        driver.findElement(By.cssSelector("#box-latest-products [title='Yellow Duck'] [title='On Sale']"));
        driver.findElement(By.cssSelector("#box-latest-products [title='Green Duck'] [title='New']"));
        driver.findElement(By.cssSelector("#box-latest-products [title='Red Duck'] [title='New']"));
        driver.findElement(By.cssSelector("#box-latest-products [title='Blue Duck'] [title='New']"));
        driver.findElement(By.cssSelector("#box-latest-products [title='Purple Duck'] [title='New']"));
    }

    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }
}
