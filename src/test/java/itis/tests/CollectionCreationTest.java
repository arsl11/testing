package itis.tests;

import itis.model.AccountData;
import itis.model.CollectionData;
import org.junit.Assert;
import org.junit.Test;

public class CollectionCreationTest extends AuthBase {

    CollectionData collection = new CollectionData("testing collection", "this is testing collection");

    @Test
    public void test() {
        app.getNavigation().OpenCollections();
        app.getCollection().createNewCollection(collection);
        CollectionData createdCollection = app.getCollection().getCreatedCollection();
        app.getAuth().exit();
        Assert.assertNotNull(createdCollection);
        Assert.assertEquals(collection.getName(), createdCollection.getName());
        Assert.assertEquals(collection.getDescription(), createdCollection.getDescription());
    }
}
