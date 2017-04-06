
package sistema;

import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Edilva
 */
public class FilmeSeleniumWebDriverTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Before
    public void setUp() {
        driver.get("http://localhost:8084/atividade-praticas/index.html");
    }

    @AfterClass
    public static void tearDownTest(){
        driver.quit();
    }

    @Test
    public void testaTituloDaPagina(){
        assertEquals("Emprestimo de Livros", driver.getTitle());
    }

    @Test
    public void testaCadastro() throws InterruptedException {
        WebElement element = driver.findElement(By.id("filme"));
        element.click();
        Thread.sleep(2000L);
        assertEquals("http://localhost:8084/atividade-praticas/filmes.jsp", driver.getCurrentUrl());

        Thread.sleep(2000L);
        element = driver.findElement(By.id("titulo"));
        element.sendKeys("A Bela e a Fera");
        element = driver.findElement(By.id("genero"));
        element.sendKeys("Fantasia");
        element = driver.findElement(By.id("duracao"));
        element.sendKeys("110");
        Thread.sleep(1000L);
        element = driver.findElement(By.id("btnCadastrar"));
        Thread.sleep(2000L);
        element.click();
    }

}
