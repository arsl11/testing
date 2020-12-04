package helpers;

import manager.ApplicationManager;
import model.CollectionData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CollectionHelper extends HelperBase {
    public void createNewCollection(CollectionData collectionData) {
        driver.findElement(By.id("new_collection_open")).click();
        driver.findElement(By.id("collection_title")).click();
        driver.findElement(By.id("collection_title")).sendKeys(collectionData.getName());
        driver.findElement(By.cssSelector(".jsAjaxSubmitForm")).click();
        driver.findElement(By.id("collection_description")).click();
        driver.findElement(By.id("collection_description")).sendKeys(collectionData.getDescription());
        driver.findElement(By.cssSelector(".btn-block")).click();
    }

    public void editCollection(CollectionData collectionData){
        driver.findElement(By.linkText("testing collection")).click();
        driver.findElement(By.cssSelector(".main-holder")).click();
        driver.findElement(By.cssSelector(".btn:nth-child(3) > .hidden-xs")).click();
        driver.findElement(By.id("collection_title")).click();
        driver.findElement(By.id("collection_title")).clear();
        driver.findElement(By.id("collection_title")).sendKeys(collectionData.getName());
        {
            WebDriver driver = app.getDriver();
            WebElement description = driver.findElement(By.xpath("//*[@id=\"collection_description\"]"));
            description.click();
            description.clear();
            description.sendKeys(collectionData.getDescription());
        }
//        driver.findElement(By.id("collection_description")).click();
//        driver.findElement(By.id("сollection_description")).clear();
//        driver.findElement(By.id("collection_description")).sendKeys(collectionData.getDescription());
        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
    }


    public CollectionHelper(ApplicationManager app){super(app);}

    public CollectionData getCreatedCollection(){
        String name = driver.findElement(By.id("collection_title")).getAttribute("value");
        String description = driver.findElement(By.id("collection_description")).getAttribute("value");
        return new CollectionData(name, description);
    }

    public CollectionData getEditedCollection(){
        String name = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/section/div[1]/h1")).getText();
        String description = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/section/div[1]/p")).getText();
        return new CollectionData(name, description);
    }




}
