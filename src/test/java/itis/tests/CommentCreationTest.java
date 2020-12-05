package itis.tests;

import itis.model.AccountData;
import itis.model.CommentData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommentCreationTest extends AuthBase {


    public List<CommentData> getDataFromJson() throws IOException, ParseException {
        List<CommentData> commentData = new ArrayList<CommentData>();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("C:\\Users\\1\\IdeaProjects\\testing\\src\\test\\java\\itis\\generator\\comments.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray comments = (JSONArray) jsonObject.get("comments");
        Iterator<JSONObject> iterator = comments.iterator();
        while (iterator.hasNext()) {
            CommentData comment = new CommentData((String)iterator.next().get("text"));
            commentData.add(comment);
        }
        return commentData;
    }

    @Test
    public void testComment() throws IOException, ParseException {
        List<CommentData> comments = getDataFromJson();
        app.getNavigation().OpenBlog();
        app.getComment().createComment(comments.get(0));
        CommentData createdComment = app.getComment().getCreatedCommentData();
        Assert.assertNotNull(createdComment);
        Assert.assertEquals(comments.get(0).getDescription(), createdComment.getDescription());
    }
}
