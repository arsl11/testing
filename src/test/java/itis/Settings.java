package itis;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Settings {

    public static String file = "C:\\Users\\1\\IdeaProjects\\testing\\src\\test\\java\\itis\\settings.json";
    public static String baseUrl;
    public static String password;
    public static String username;


    static {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(file));

            JSONObject jsonObject = (JSONObject) obj;

            baseUrl = (String) jsonObject.get("baseUrl");
            password = (String) jsonObject.get("password");
            username = (String) jsonObject.get("username");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    public static String getFile() {
        return file;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }
}
