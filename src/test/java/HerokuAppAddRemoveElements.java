import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HerokuAppAddRemoveElements {

    public static final String URL = "http://the-internet.herokuapp.com/add_remove_elements/";

    public static final String DELETE_BUTTON_XPATH = "//*[text()='Delete']";
    @Test
    public void addRemovalElementsTest() {
        /**
         * 1. DONE Открыть сайт http://the-internet.herokuapp.com/add_remove_elements/
         * 2. DONE Найти кнопку Add Element
         * 3. DONE Кликнуть по кнопке
         * 4. DONE Найти элемент Delete
         * 5. DONE Убедиться что элемент 1
         * 6. DONE Найти кнопку Add Element
         * 7. DONE Кликнуть по кнопке
         * 8. DONE Найти элемент Delete
         * 9. DONE Убедиться что элемента 2
         * 10. найти элемент Delete ?????
         * 11. Кликнуть по элементу Delete
         * 12. Найти элемент Delete
         * 13. Убедиться что элемент 1
         * 14. Закрыть браузер - DONE
         **/
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get(URL);

        driver.manage().window().fullscreen();

        WebElement addElement = driver.findElement(By.xpath("//*[text()='Add Element']"));

        addElement.click();

        List<WebElement> deleteElements = driver.findElements(By.xpath(DELETE_BUTTON_XPATH));

        assertEquals(deleteElements.size(), 1);
        addElement.click();
        deleteElements = driver.findElements(By.xpath(DELETE_BUTTON_XPATH));

        assertEquals(deleteElements.size(), 2);

        deleteElements.get(1).click();

        deleteElements = driver.findElements(By.xpath(DELETE_BUTTON_XPATH));

        assertEquals(deleteElements.size(), 1);
        driver.quit();
    }
}
