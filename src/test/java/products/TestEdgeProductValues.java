package products;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEdgeProductValues {
    private WebDriver driver;

    @BeforeEach
    public void start() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.ignoreZoomSettings();
        driver = new InternetExplorerDriver(options);
    }

    @Test
    public void productNameTest() {
        driver.get("http://localhost/litecart/en/");
        String titleProductName = driver.findElement(By.cssSelector("#box-campaigns .name")).getText();
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        String insideProductName = driver.findElement(By.cssSelector("h1.title")).getText();
        assertEquals(titleProductName, insideProductName);
    }

    @Test
    public void productPromotionalPriceTest() {
        driver.get("http://localhost/litecart/en/");
        String titlePrice = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getText();
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        String insidePrice = driver.findElement(By.cssSelector(".campaign-price")).getText();
        assertEquals(titlePrice, insidePrice);
    }

    @Test
    public void productRegularPriceTest() {
        driver.get("http://localhost/litecart/en/");
        String titleRegularPrice = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getText();
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        String insideRegularPrice = driver.findElement(By.cssSelector(".regular-price")).getText();
        assertEquals(titleRegularPrice, insideRegularPrice);
    }

    @Test
    public void productRegularPriceColorTest() {
        driver.get("http://localhost/litecart/en/");
        String titleRegularPriceColor = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("color");
        String grayRGBa = "119, 119, 119, 1";
        assertEquals(grayRGBa, titleRegularPriceColor.substring(5, 21).trim());
    }

    @Test
    public void productPromotionalPriceColorTest() {
        driver.get("http://localhost/litecart/en/");
        String titlePromotionalPriceColor = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color");
        String redRGBa = "204, 0, 0, 1";
        assertEquals(redRGBa, titlePromotionalPriceColor.substring(5, 17).trim());
    }

    @Test
    public void productRegularPriceColorInsideTest() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        String insideRegularPriceColor = driver.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        String grayRGBa = "102, 102, 102, 1";
        assertEquals(grayRGBa, insideRegularPriceColor.substring(5, 21).trim());
    }

    @Test
    public void productPromotionalPriceColorInsideTest() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        String insidePromotionalPriceColor = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        String redRGBa = "204, 0, 0, 1";
        assertEquals(redRGBa, insidePromotionalPriceColor.substring(5, 17).trim());
    }

    @Test
    public void productPricesSizeTest() {
        driver.get("http://localhost/litecart/en/");
        Rectangle promoSize = (driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getRect());
        Rectangle regSize = (driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getRect());
        assertTrue((promoSize.height > regSize.height && promoSize.width > regSize.width));
    }

    @Test
    public void productInsidePricesSizeTest() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        Rectangle promoSize = (driver.findElement(By.cssSelector(".campaign-price")).getRect());
        Rectangle regSize = (driver.findElement(By.cssSelector(".regular-price")).getRect());
        assertTrue((promoSize.height > regSize.height && promoSize.width > regSize.width));
    }

    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }
}
