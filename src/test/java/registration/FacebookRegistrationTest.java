package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FacebookRegistrationTest {

    public WebDriver driver = null;

    @BeforeMethod
    public void setUp() {
        // Launch google chrome
        System.setProperty("webdriver.chrome.driver",
                "/Users/fahim/Documents/FB/facebook/src/main/java/driver/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().window().fullscreen();
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser.
        this.driver.close();
    }

    @Test
    public void testUserCannotRegisterIfEmailIsNotProvided() throws Exception {
        // 2. Navigate to facebook.com
        String facebookUrl = "https://facebook.com";
        driver.get(facebookUrl);
        Assert.assertEquals(driver.getTitle(), "Facebook - Log In or Sign Up");

        // 3. Provide in first name.
        driver.findElement(By.name("firstname")).sendKeys("John");

        // 4. Provide in last name.
        driver.findElement(By.name("lastname")).sendKeys("Doe");

        // 5. Provide in password.
        driver.findElement(By.name("reg_passwd__")).sendKeys("Test123!");

        // 6. Provide in date of birth.
        // July 21, 1994
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        Select dayDropdown = new Select(driver.findElement(By.name("birthday_day")));
        Select yearDropdown = new Select(driver.findElement(By.id("year")));

        monthDropdown.selectByValue("7");
        dayDropdown.selectByValue("21");
        yearDropdown.selectByValue("1994");

        // 7. Provide in gender (male).
        driver.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();

        // 8. Click on the submit button.
        driver.findElement(By.name("websubmit")).click();

        // 9. Assert that the popup is shown.
        // WebElement popup = driver.findElement(By.name(""));
        // boolean popUpIsDisplayed = popup.isDisplayed();
        // Assert.assertEquals(popUpIsDisplayed, true);
    }

    @Test
    public void anotherTest() {
        System.out.println("Another test");
    }


}
