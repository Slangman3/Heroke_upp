import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class HeroDropdowns {
    public static final String URL = "http://the-internet.herokuapp.com/dropdown";

    @Test
    public void selectByText() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().fullscreen();
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        String text = select.getFirstSelectedOption().getText();
        assertEquals(text, "Option 1");
        select.selectByVisibleText("Option 2");
        text = select.getFirstSelectedOption().getText();
        assertEquals(text, "Option 2");
        driver.quit();

    }
}
