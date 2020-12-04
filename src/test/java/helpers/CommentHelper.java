package helpers;

import manager.ApplicationManager;
import model.CommentData;
import org.openqa.selenium.By;

public class CommentHelper extends HelperBase {

    public void createComment(CommentData commentData) {
        driver.findElement(By.id("comment_form")).click();
        driver.findElement(By.id("comment_form")).sendKeys(commentData.getDescription());
        driver.findElement(By.cssSelector(".js-open-notification-modal")).click();
    }

    public CommentData getCreatedCommentData(){
        String description = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/section/div/article[64]/div[2]/div[1]/div[1]/div")).getText();
        return new CommentData(description);
    }

    public CommentHelper(ApplicationManager app){super(app);}
}

