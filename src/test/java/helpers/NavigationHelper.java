package helpers;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class NavigationHelper extends HelperBase {
    private String baseURL;

    public void OpenHomePage() {
        driver.get(baseURL);
        driver.manage().window().setSize(new Dimension(1550, 838));
    }
    public void OpenBlog() {
        driver.findElement(By.linkText("Блог")).click();
        driver.findElement(By.cssSelector(".blog-article-preview:nth-child(1) > .article-image")).click();
    }
    public void OpenCollections() {
        driver.findElement(By.cssSelector(".header-b")).click();
        driver.findElement(By.id("dLabel")).click();
        driver.findElement(By.linkText("Понравившееся")).click();
        driver.findElement(By.linkText("Сборники")).click();
    }

    public NavigationHelper(ApplicationManager manager, String baseURL){
        super(manager);
        this.baseURL = baseURL;
    }
}
