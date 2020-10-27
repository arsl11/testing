import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;


public class TestBase {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\Projects\\Java\\SeleniumTesting\\src\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    public void CreateNewCollection(CollectionData collectionData) {
        driver.findElement(By.id("new_collection_open")).click();
        js.executeScript("window.scrollTo(0,608.7999877929688)");
        driver.findElement(By.id("collection_title")).click();
        driver.findElement(By.id("collection_title")).sendKeys(collectionData.getName());
        driver.findElement(By.cssSelector(".jsAjaxSubmitForm")).click();
        driver.findElement(By.id("collection_description")).click();
        driver.findElement(By.id("collection_description")).sendKeys(collectionData.getDescription());
        driver.findElement(By.cssSelector(".btn-block")).click();
    }

    public void OpenCollections() {
        driver.findElement(By.cssSelector(".header-b")).click();
        driver.findElement(By.id("dLabel")).click();
        driver.findElement(By.linkText("Понравившееся")).click();
        driver.findElement(By.linkText("Сборники")).click();
    }

    public void Login(AccountData user) {
        driver.findElement(By.cssSelector(".dropdown-toggle > span:nth-child(2)")).click();
        driver.findElement(By.name("login")).sendKeys(user.getUsername());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("label")).click();
        driver.findElement(By.name("do_login")).click();
    }

    public void OpenHomePage() {
        driver.get("https://ficbook.net/");
        driver.manage().window().setSize(new Dimension(1550, 838));
    }

    public void CreateComment(CommentData commentData) {
        js.executeScript("window.scrollTo(0,1169.5999755859375)");
        driver.findElement(By.id("comment_form")).click();
        driver.findElement(By.id("comment_form")).sendKeys(commentData.getDescription());
        driver.findElement(By.cssSelector(".js-open-notification-modal")).click();
    }

    public void OpenBlog() {
        driver.findElement(By.linkText("Блог")).click();
        driver.findElement(By.cssSelector(".blog-article-preview:nth-child(1) > .article-image")).click();
    }
}
