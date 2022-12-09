package products;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.stqa.selenium.factory.WebDriverPool;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProductValues {


    @Test
    public void testFirefox() {
        productNameTest(WebDriverPool.DEFAULT.getDriver(new FirefoxOptions()));
        productPromotionalPriceTest(WebDriverPool.DEFAULT.getDriver(new FirefoxOptions()));
        productRegularPriceTest(WebDriverPool.DEFAULT.getDriver(new FirefoxOptions()));
        productRegularPriceColorTest(WebDriverPool.DEFAULT.getDriver(new FirefoxOptions()));
        productPromotionalPriceColorTest(WebDriverPool.DEFAULT.getDriver(new FirefoxOptions()));
        productRegularPriceColorInsideTest(WebDriverPool.DEFAULT.getDriver(new FirefoxOptions()));
        productPromotionalPriceColorInsideTest(WebDriverPool.DEFAULT.getDriver(new FirefoxOptions()));
        productPricesSizeTest(WebDriverPool.DEFAULT.getDriver(new FirefoxOptions()));
        productInsidePricesSizeTest(WebDriverPool.DEFAULT.getDriver(new FirefoxOptions()));
    }


    @Test
    public void testChrome() {
        productNameTest(WebDriverPool.DEFAULT.getDriver(new ChromeOptions()));
        productPromotionalPriceTest(WebDriverPool.DEFAULT.getDriver(new ChromeOptions()));
        productRegularPriceTest(WebDriverPool.DEFAULT.getDriver(new ChromeOptions()));
        productRegularPriceColorTest(WebDriverPool.DEFAULT.getDriver(new ChromeOptions()));
        productPromotionalPriceColorTest(WebDriverPool.DEFAULT.getDriver(new ChromeOptions()));
        productRegularPriceColorInsideTest(WebDriverPool.DEFAULT.getDriver(new ChromeOptions()));
        productPromotionalPriceColorInsideTest(WebDriverPool.DEFAULT.getDriver(new ChromeOptions()));
        productPricesSizeTest(WebDriverPool.DEFAULT.getDriver(new ChromeOptions()));
        productInsidePricesSizeTest(WebDriverPool.DEFAULT.getDriver(new ChromeOptions()));

    }


    private void productNameTest(WebDriver driver) {
        driver.get("http://localhost/litecart/en/");
        String titleProductName = driver.findElement(By.cssSelector("#box-campaigns .name")).getText();
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        String insideProductName = driver.findElement(By.cssSelector("h1.title")).getText();
        assertEquals(titleProductName, insideProductName);
    }

    private void productPromotionalPriceTest(WebDriver driver) {
        driver.get("http://localhost/litecart/en/");
        String titlePrice = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getText();
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        String insidePrice = driver.findElement(By.cssSelector(".campaign-price")).getText();
        assertEquals(titlePrice, insidePrice);
    }

    private void productRegularPriceTest(WebDriver driver) {
        driver.get("http://localhost/litecart/en/");
        String titleRegularPrice = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getText();
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        String insideRegularPrice = driver.findElement(By.cssSelector(".regular-price")).getText();
        assertEquals(titleRegularPrice, insideRegularPrice);
    }


    private void productRegularPriceColorTest(WebDriver driver) {
        driver.get("http://localhost/litecart/en/");
        String titleRegularPriceColor = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("color");
        System.out.println(titleRegularPriceColor);
        assertTrue(isGrey(titleRegularPriceColor));
    }

    private void productPromotionalPriceColorTest(WebDriver driver) {
        driver.get("http://localhost/litecart/en/");
        String titlePromotionalPriceColor = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color");
        assertTrue(isRed(titlePromotionalPriceColor));
    }

    private void productRegularPriceColorInsideTest(WebDriver driver) {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        String insideRegularPriceColor = driver.findElement(By.cssSelector(".regular-price")).getCssValue("color");
       assertTrue(isGrey(insideRegularPriceColor));
    }

    private void productPromotionalPriceColorInsideTest(WebDriver driver) {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        String insidePromotionalPriceColor = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        assertTrue(isRed(insidePromotionalPriceColor));
    }

    private void productPricesSizeTest(WebDriver driver) {
        driver.get("http://localhost/litecart/en/");
        Rectangle promoSize = (driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getRect());
        Rectangle regSize = (driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getRect());
        assertTrue((promoSize.height > regSize.height && promoSize.width > regSize.width));
    }

    private void productInsidePricesSizeTest(WebDriver driver) {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-campaigns .name ")).click();
        Rectangle promoSize = (driver.findElement(By.cssSelector(".campaign-price")).getRect());
        Rectangle regSize = (driver.findElement(By.cssSelector(".regular-price")).getRect());
        assertTrue((promoSize.height > regSize.height && promoSize.width > regSize.width));
    }

    @AfterAll
    static void stopAllDrivers() {
        WebDriverPool.DEFAULT.dismissAll();
    }

    public boolean isGrey(String rgba){
        String resultString = rgba.replaceAll(" ","");
        String[]resultRgba;
        resultRgba = resultString.substring(5, 16).trim().split(",");
        System.out.println(Arrays.toString(resultRgba));
        return Integer.parseInt(resultRgba[0])==Integer.parseInt(resultRgba[1]) &&
                Integer.parseInt(resultRgba[1])==Integer.parseInt(resultRgba[2]);
    }

    public boolean isRed(String rgba){
        String resultString = rgba.replaceAll(" ","");
        String[]resultRgba;
        resultRgba = resultString.substring(5, 14).trim().split(",");
        System.out.println(Arrays.toString(resultRgba));
        return Integer.parseInt(resultRgba[1])==Integer.parseInt(resultRgba[2]);
    }

}
