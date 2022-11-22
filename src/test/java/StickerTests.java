import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StickerTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void start() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
    }

    @Test
    public void checkStickerTest() {
        driver.get("http://localhost/litecart/");
        wait = new WebDriverWait(driver, 10);
        List<WebElement> productList = driver.findElements(By.cssSelector("ul.listing-wrapper >li"));
        for (WebElement element : productList) {
            List<WebElement> sticker = element.findElements(By.cssSelector("div.sticker"));
            if (sticker.size() != 1) {
                System.out.println("Error: More one sticker!");
                driver.close();
            }
        }
    }

    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }
}
