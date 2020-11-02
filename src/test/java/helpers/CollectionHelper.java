package helpers;

import model.CollectionData;
import org.openqa.selenium.By;

public class CollectionHelper extends HelperBase {
    public void CreateNewCollection(CollectionData collectionData) {
        driver.findElement(By.id("new_collection_open")).click();
        //js.executeScript("window.scrollTo(0,608.7999877929688)");
        driver.findElement(By.id("collection_title")).click();
        driver.findElement(By.id("collection_title")).sendKeys(collectionData.getName());
        driver.findElement(By.cssSelector(".jsAjaxSubmitForm")).click();
        driver.findElement(By.id("collection_description")).click();
        driver.findElement(By.id("collection_description")).sendKeys(collectionData.getDescription());
        driver.findElement(By.cssSelector(".btn-block")).click();
    }

    public CollectionHelper(ApplicationManager app){super(app);}
}
