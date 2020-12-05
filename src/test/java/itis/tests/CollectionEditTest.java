package itis.tests;

import itis.model.CollectionData;
import org.junit.Assert;
import org.junit.Test;

public class CollectionEditTest extends TestBase {

    CollectionData collection = new CollectionData("edited collection", "This collection was edited");

    @Test
    public void test(){
//        AccountData user = new AccountData("ars11", "Arif2012");
//        app.getAuth().Login(user);
//        app.getNavigation().OpenCollections();
        app.getCollection().editCollection(collection);
        CollectionData editedCollection = app.getCollection().getEditedCollection();
        Assert.assertNotNull(editedCollection);
        Assert.assertEquals(collection.getName(), editedCollection.getName());
    }
}
