package helpers;

import model.CommentData;
import org.openqa.selenium.By;

public class CommentHelper extends HelperBase {

    public void CreateComment(CommentData commentData) {
//        js.executeScript("window.scrollTo(0,1169.5999755859375)");
        driver.findElement(By.id("comment_form")).click();
        driver.findElement(By.id("comment_form")).sendKeys(commentData.getDescription());
        driver.findElement(By.cssSelector(".js-open-notification-modal")).click();
    }

    public CommentHelper(ApplicationManager app){super(app);}
}
