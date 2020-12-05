package itis.tests;

import itis.model.CollectionData;
import org.junit.Assert;
import org.junit.Test;

public class CollectionEditTest extends AuthBase {

    CollectionData collection = new CollectionData("edited collection", "This collection was edited");

    @Test
    public void test(){
        app.getNavigation().OpenCollections();
        app.getCollection().editCollection(collection);
        CollectionData editedCollection = app.getCollection().getEditedCollection();
        app.getAuth().exit();
        Assert.assertNotNull(editedCollection);
        Assert.assertEquals(collection.getName(), editedCollection.getName());
    }
}
