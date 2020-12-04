package tests;

import manager.ApplicationManager;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;


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









}
