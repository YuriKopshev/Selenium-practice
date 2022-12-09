import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegistrationUserTest {
    private WebDriver driver;
    private static String login;
    private static String phoneNumber;

    @BeforeAll
    static void determineLoginAndPhoneNumber() {
        login = generateEmail();
        phoneNumber = generatePhoneNumber();
    }

    @BeforeEach
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void newCustomerRegistrationAndLogoutTest() {
        driver.get("http://localhost/litecart/");
        driver.findElement(By.cssSelector(" tr:nth-child(5) > td > a")).click();
        driver.findElement(By.cssSelector("input[name=firstname]")).click();
        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Ivan");
        driver.findElement(By.cssSelector("input[name=lastname]")).click();
        driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys("Ivanov");
        driver.findElement(By.cssSelector("input[name=address1]")).click();
        driver.findElement(By.cssSelector("input[name=address1]")).sendKeys("4 Pennsylvania Plaza, New York, NY 10001");
        driver.findElement(By.cssSelector("input[name=postcode]")).click();
        driver.findElement(By.cssSelector("input[name=postcode]")).sendKeys("53216");
        driver.findElement(By.cssSelector("input[name=city]")).click();
        driver.findElement(By.cssSelector("input[name=city]")).sendKeys("New York");
        driver.findElement(By.cssSelector(".select2-selection__arrow")).click();
        driver.findElement(By.cssSelector("input[class=select2-search__field]")).click();
        driver.findElement(By.cssSelector("input[class=select2-search__field]")).sendKeys("United States" + Keys.ENTER);
        driver.findElement(By.cssSelector("input[name=email]")).click();
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(login);
        driver.findElement(By.cssSelector("input[name=phone]")).click();
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys(phoneNumber);
        driver.findElement(By.cssSelector("input[name=password]")).click();
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("11111");
        driver.findElement(By.cssSelector("input[name=confirmed_password]")).click();
        driver.findElement(By.cssSelector("input[name=confirmed_password]")).sendKeys("11111");
        driver.findElement(By.cssSelector("button[name=create_account]")).click();
        new WebDriverWait(driver, 5);
        driver.findElement(By.cssSelector(".content .list-vertical > li:nth-child(4) > a")).click();
        String actual = driver.findElement(By.cssSelector("#box-account-login > h3")).getText();
        assertEquals("Login", actual);
    }

    @Test
    public void loginAndLogoutTest() {
        driver.get("http://localhost/litecart/");
        driver.findElement(By.cssSelector("input[name=email]")).click();
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(login);
        driver.findElement(By.cssSelector("input[name=password]")).click();
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("11111");
        driver.findElement(By.cssSelector("button[name=login]")).click();
        new WebDriverWait(driver, 5);
        driver.findElement(By.cssSelector(".content .list-vertical > li:nth-child(4) > a")).click();
        String actual = driver.findElement(By.cssSelector("#box-account-login > h3")).getText();
        assertEquals("Login", actual);
    }

    public static String generateEmail() {
        return "mail" + RandomStringUtils.randomNumeric(5) + "@gmail.com";
    }

    public static String generatePhoneNumber() {
        return "+1" + RandomStringUtils.randomNumeric(10);
    }

    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }
}
