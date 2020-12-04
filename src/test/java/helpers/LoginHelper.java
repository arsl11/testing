package helpers;

import manager.ApplicationManager;
import model.AccountData;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {
    public void Login(AccountData user) {
        driver.findElement(By.cssSelector(".dropdown-toggle > span:nth-child(2)")).click();
        driver.findElement(By.name("login")).sendKeys(user.getUsername());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("label")).click();
        driver.findElement(By.name("do_login")).click();
    }

    public LoginHelper(ApplicationManager app){super(app);}
}
