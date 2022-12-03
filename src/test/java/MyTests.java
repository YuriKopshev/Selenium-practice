import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.factory.WebDriverPool;

public class MyTests {
//    private WebDriver driver;
//
//    private WebDriverWait wait;


//    @BeforeEach
//    public void start() {
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver, 10);
//
//    }

    @Test
    public void myFirstTestChrome() {
        WebDriver driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
        driver.get(" https://www.google.com");
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Test
    public void myFirstTestFireFox() {
        WebDriver driver = WebDriverPool.DEFAULT.getDriver(new FirefoxOptions());
        driver.get(" https://www.google.com");
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Test
    public void myFirstTestIE() {
        WebDriver driver = WebDriverPool.DEFAULT.getDriver(new InternetExplorerOptions());
        driver.get(" https://www.google.com");
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

//    @AfterEach
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }

    @AfterAll
    static void stopAllDrivers() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}
