package itis.generator;

import itis.model.CommentData;
import itis.tests.TestBase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class jsonGenerator {

    public static void main(String[] args) throws IOException {
        String type = "comments";
        int count = 3;
        String filename = "C:\\Users\\1\\IdeaProjects\\testing\\src\\test\\java\\itis\\generator\\comments.json";

        if(type.equals("comments")) {
            generateForComments(count, filename);
        } else System.out.println("Unrecognized type of data" + type);
    }

    static void generateForComments(int count, String filename) throws IOException {
        List<CommentData> comments = new ArrayList<CommentData>() ;
        for(int i = 0; i < count; i++){
            comments.add(new CommentData(TestBase.generateRandomString(10)));
        }

        FileWriter file = new FileWriter(filename);

        JSONObject obj1 = new JSONObject();
        JSONArray list = new JSONArray();

        for(int i = 0; i < count; i++){
            JSONObject obj = new JSONObject();
            obj.put("text", comments.get(i).description);
            list.add(obj);
        }
        obj1.put("comments", list);
        file.write(obj1.toJSONString());
        file.flush();
    }
}
