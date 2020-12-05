package itis;

import itis.helpers.CollectionHelper;
import itis.helpers.CommentHelper;
import itis.helpers.LoginHelper;
import itis.helpers.NavigationHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    private WebDriver driver;
    JavascriptExecutor js;
    private Map<String, Object> vars;
    private String baseUrl;

    private NavigationHelper navigation;
    private CollectionHelper collection;
    private CommentHelper comment;
    private LoginHelper auth;

    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<ApplicationManager>();

    private ApplicationManager(){
        System.setProperty("webdriver.gecko.driver", "D:\\Projects\\Java\\SeleniumTesting\\src\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        baseUrl = "https://ficbook.net/";

        navigation = new NavigationHelper(this, baseUrl);
        auth = new LoginHelper(this);
        comment = new CommentHelper(this);
        collection = new CollectionHelper(this);
    }

    public static ApplicationManager getInstance(){
        if(app.get() == null){
            ApplicationManager newInstance = new ApplicationManager();
            newInstance.getNavigation().OpenHomePage();
            app.set(newInstance);
        }
            return app.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public CollectionHelper getCollection() {
        return collection;
    }

    public CommentHelper getComment() {
        return comment;
    }

    public LoginHelper getAuth() {
        return auth;
    }

    public void stop(){driver.quit();}


}
