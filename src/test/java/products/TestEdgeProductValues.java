package products;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.Arrays;

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
        assertTrue(isGrey(titleRegularPriceColor));
    }

    @Test
    public void productPromotionalPriceColorTest() {
        driver.get("http://localhost/litecart/en/");
        String titlePromotionalPriceColor = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color");
        assertTrue(isRed(titlePromotionalPriceColor));
    }

    @Test
    public void productRegularPriceColorInsideTest() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        String insideRegularPriceColor = driver.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        assertTrue(isGrey(insideRegularPriceColor));
    }

    @Test
    public void productPromotionalPriceColorInsideTest() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        String insidePromotionalPriceColor = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        assertTrue(isRed(insidePromotionalPriceColor));
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

    public boolean isGrey(String rgba) {
        String resultString = rgba.replaceAll(" ", "");
        String[] resultRgba;
        resultRgba = resultString.substring(5, 18).trim().split(",");
        System.out.println(Arrays.toString(resultRgba));
        return Integer.parseInt(resultRgba[0]) == Integer.parseInt(resultRgba[1]) &&
                Integer.parseInt(resultRgba[1]) == Integer.parseInt(resultRgba[2]);
    }

    public boolean isRed(String rgba) {
        String resultString = rgba.replaceAll(" ", "");
        String[] resultRgba;
        resultRgba = resultString.substring(5, 14).trim().split(",");
        System.out.println(Arrays.toString(resultRgba));
        return Integer.parseInt(resultRgba[1]) == Integer.parseInt(resultRgba[2]);
    }
}
