package itis.tests;

import itis.ApplicationManager;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;

import java.util.Random;


public class TestBase {
    protected ApplicationManager app;

    @Before
    public void setUpTest() {
        app = ApplicationManager.getInstance();
    }
    @AfterAll
    public void tearDownTest() {
        app.stop();
    }

    public static String generateRandomString(int length) {
        Random r = new Random();
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = ((char) (r.nextInt(24) + 65));
        }
        return String.valueOf(result);
    }









}
