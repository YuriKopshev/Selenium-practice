import com.google.common.collect.Ordering;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCountryGeoZone {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void checkCountryTest() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector("#content > h1"));
        List<WebElement> links = driver.findElements(By.cssSelector(" .row"));
        List<String> countryList = new ArrayList<>();
        for (int i = 1; i < links.size(); i++) {
            int number = Integer.parseInt(driver.findElement(By.cssSelector(".row:nth-child(" + (i + 1) + ") > td:nth-child(6)")).getText());
            if (number != 0) {
                List<String> countryListInside = new ArrayList<>();
                driver.findElement(By.cssSelector(".row:nth-child(" + (i + 1) + ") > td:nth-child(5) > a")).click();
                List<WebElement> linksInside = driver.findElements(By.cssSelector("#table-zones > tbody > tr"));
                for (int j = 1; j < linksInside.size(); j++) {
                    String countryInside = driver.findElement(By.cssSelector("tr:nth-child(" + (j + 1) + ") > td:nth-child(3)")).getText();
                    countryListInside.add(countryInside);
                }
                if (!isSorted(countryListInside)) {
                    System.out.println("Countries are not listed alphabetically in list with size " + countryListInside.size());
                }
                driver.findElement(By.cssSelector("#box-apps-menu > li:nth-child(3)")).click();
                wait = new WebDriverWait(driver, 10);
            }
            String country = driver.findElement(By.cssSelector(".row:nth-child(" + (i + 1) + ") > td:nth-child(5) > a")).getText();
            countryList.add(country);
        }
        assertTrue(isSorted(countryList));
    }

    @Test
    public void checkGeoZonesTest() {
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait = new WebDriverWait(driver, 10);
        List<WebElement> rows = driver.findElements(By.cssSelector("tr.row"));
        List<String> links = new ArrayList<>();
        List<String> zones = new ArrayList<>();
        for (WebElement country : rows) {
            links.add(country.findElement(By.cssSelector("td:nth-child(3) a")).getAttribute("href"));
        }
        for (String link : links) {
            driver.get(link);
            WebElement table = driver.findElement(By.cssSelector("table.dataTable"));
            rows = table.findElements(By.cssSelector("tr td:nth-child(3)"));
            for (WebElement row : rows) {
                zones.add(row.findElement(By.cssSelector("[selected=selected]")).getAttribute("innerText"));
            }
        }
        assertTrue(isSorted(zones));
    }

    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }

    public boolean isSorted(List<String> listToCheck) {
        boolean isSorted;
        isSorted = Ordering.natural().isOrdered(listToCheck);
        return isSorted;
    }
}
