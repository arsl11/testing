package itis.tests;


import itis.Settings;
import itis.model.AccountData;
import org.junit.Before;


public class AuthBase extends TestBase{

    static TestBase testBase = new TestBase();

    @Before
    public void setUp(){
        testBase.setUpTest();
        app.getAuth().login(new AccountData(Settings.getUsername(), Settings.getPassword()));
    }
}
