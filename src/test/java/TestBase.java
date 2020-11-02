import helpers.ApplicationManager;
import org.junit.After;
import org.junit.Before;


public class TestBase {
    protected ApplicationManager app;

    @Before
    public void setUpTest() {
        app = new ApplicationManager();
    }
    @After
    public void tearDownTest() {
        app.stop();
    }









}
