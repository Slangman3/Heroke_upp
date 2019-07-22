import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestCheckInputs {
    public static final String URL = "http://the-internet.herokuapp.com/inputs";

    @Test
    public void checkInputs() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().fullscreen();
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("4");
        String text = input.getAttribute("value");
        assertEquals(text,"4");
        input.sendKeys(Keys.ARROW_UP);
        text = input.getAttribute("value");
        assertEquals(text, "5");
        driver.quit();

    }
}



