package itis.tests;

import itis.model.CommentData;
import org.junit.Assert;
import org.junit.Test;

public class CommentCreationTest extends TestBase {

    CommentData comment = new CommentData("testing comment");

    @Test
    public void testComment() {
//        AccountData user = new AccountData("ars11", "Arif2012");
//        app.getAuth().Login(user);
        app.getNavigation().OpenBlog();
        app.getComment().createComment(comment);
        CommentData createdComment = app.getComment().getCreatedCommentData();
        Assert.assertNotNull(createdComment);
        Assert.assertEquals(comment.getDescription(), createdComment.getDescription());
    }
}
