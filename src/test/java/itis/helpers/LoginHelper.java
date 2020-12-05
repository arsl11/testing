package itis.helpers;

import itis.ApplicationManager;
import itis.model.AccountData;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {
    public void login(AccountData user) {
            driver.findElement(By.cssSelector(".dropdown-toggle > span:nth-child(2)")).click();
            driver.findElement(By.name("login")).sendKeys(user.getUsername());
            driver.findElement(By.name("password")).click();
            driver.findElement(By.name("password")).sendKeys(user.getPassword());
            driver.findElement(By.cssSelector("label")).click();
            driver.findElement(By.name("do_login")).click();
        }

    public void exit(){
        driver.findElement(By.xpath("//*[@id=\"dLabel\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div/div/div[1]/div[5]/noindex/div/div[2]/div/ul/li[13]/a")).click();
    }



    public LoginHelper(ApplicationManager app){super(app);}
}
