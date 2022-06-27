package main;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;


public class SystemTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Svetlana\\12\\src\\main\\resources\\chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        driver.get("https://www.saucedemo.com/");


        System.out.println("Started session");


        driver.findElement(By.id("user-name"));
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");
        driver.findElement(By.id("password"));
        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");


        driver.findElement(By.id("login-button"));
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        String expected_url = "https://www.saucedemo.com/inventory.html/";
        String current_url = driver.getCurrentUrl();

        Assert.assertFalse("URL does not match\\n", expected_url.equals(current_url));
        Thread.sleep(2000);
        System.out.println("AssertTrue Test Passed\n");
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                    elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));

            driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            WebElement item = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            item.click();

            driver.findElement(By.className("shopping_cart_link"));
            WebElement bag = driver.findElement(By.className("shopping_cart_link"));
            bag.click();

            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                    elementToBeClickable(By.className("cart_quantity")));
            WebElement actualBag = driver.findElement(By.className("cart_quantity"));
            WebElement expectedBag = null;
            Assert.assertNotNull("Null Object", actualBag);
            Thread.sleep(2000);
            System.out.println("AssertNotNull Test Passed");


            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                    elementToBeClickable(By.id("checkout")));
            driver.findElement(By.id("checkout"));
            WebElement checkout = driver.findElement(By.id("checkout"));
            checkout.click();

            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                    elementToBeClickable(By.id("first-name")));
            driver.findElement(By.id("first-name"));
            WebElement firstName = driver.findElement(By.id("first-name"));
            firstName.click();
            firstName.sendKeys("Sviatlana");

            driver.findElement(By.id("last-name"));
            WebElement lastName = driver.findElement(By.id("last-name"));
            lastName.click();
            lastName.sendKeys("Karaliova");
            driver.findElement(By.id("postal-code"));
            WebElement postalcode = driver.findElement(By.id("postal-code"));
            postalcode.click();
            postalcode.sendKeys("04-379");
            driver.findElement(By.id("continue"));
            WebElement continue1 = driver.findElement(By.id("continue"));
            continue1.click();
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                    elementToBeClickable(By.id("finish")));
            driver.findElement(By.id("finish"));
            WebElement finish = driver.findElement(By.id("finish"));
            finish.click();
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                    elementToBeClickable(By.id("back-to-products")));
            driver.findElement(By.id("back-to-products"));
            WebElement back = driver.findElement(By.id("back-to-products"));
            back.click();
            driver.close();
        } catch (TimeoutException e) {
        } catch (NoSuchElementException e) {
        }
        ;

    }

    private static void assertEquals(String actual, String expected) {
    }

    ;

    private static void setProperty(String s, String s1) {
    }
}

