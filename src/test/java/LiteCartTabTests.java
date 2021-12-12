import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class LiteCartTabTests {
    private WebDriver driver;
    private WebDriverWait wait;

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

    @BeforeEach
    public void start() {
        driver = new FirefoxDriver();
        driver.get("http://localhost/litecart/admin/");
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void checkTemplateTab() {
        driver.findElement(By.xpath("//span[contains(.,'Appearence')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Template')]")));
    }

    @Test
    public void checkCatalogTab() {
        driver.findElement(By.xpath("//span[contains(.,'Catalog')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Catalog')]")));
    }

    @Test
    public void checkCountriesTab() {
        driver.findElement(By.xpath("//span[contains(.,'Countries')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Countries')]")));
    }

    @Test
    public void checkCurrenciesTab() {
        driver.findElement(By.xpath("//span[contains(.,'Currencies')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Currencies')]")));
    }

    @Test
    public void checkCustomersTab() {
        driver.findElement(By.xpath("//span[contains(.,'Customers')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Customers')]")));
    }

    @Test
    public void checkGeoZonesTab() {
        driver.findElement(By.xpath("//span[contains(.,'Geo Zones')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Geo Zones')]")));
    }

    @Test
    public void checkLanguagesTab() {
        driver.findElement(By.xpath("//span[contains(.,'Languages')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Languages')]")));
    }

    @Test
    public void checkJobTab() {
        driver.findElement(By.xpath("//span[contains(.,'Modules')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Job Modules')]")));
    }

    @Test
    public void checkOrdersTab() {
        driver.findElement(By.xpath("//span[contains(.,'Orders')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Orders')]")));
    }

    @Test
    public void checkPagesTab() {
        driver.findElement(By.xpath("//span[contains(.,'Pages')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Pages')]")));
    }

    @Test
    public void checkReportsTab() {
        driver.findElement(By.xpath("//span[contains(.,'Reports')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Monthly Sales')]")));
    }

    @Test
    public void checkSettingsTab() {
        driver.findElement(By.xpath("//span[contains(.,'Settings')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Settings')]")));
    }

    @Test
    public void checkSlidesTab() {
        driver.findElement(By.xpath("//span[contains(.,'Slides')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Slides')]")));
    }

    @Test
    public void checkTaxTab() {
        driver.findElement(By.xpath("//span[contains(.,'Tax')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Tax Classes')]")));
    }

    @Test
    public void checkTranslationsTab() {
        driver.findElement(By.xpath("//span[contains(.,'Translations')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Search Translations')]")));
    }

    @Test
    public void checkUsersTab() {
        driver.findElement(By.xpath("//span[contains(.,'Users')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' Users')]")));
    }

    @Test
    public void checkTab() {
        driver.findElement(By.xpath("//span[contains(.,'vQmods')]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[contains(.,' vQmods')]")));
    }

    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }
}

