package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver driver;
    JavascriptExecutor js;
    protected ApplicationManager app;

    public HelperBase(ApplicationManager app){
        this.driver = app.getDriver();
        this.app = app;
    }
}
