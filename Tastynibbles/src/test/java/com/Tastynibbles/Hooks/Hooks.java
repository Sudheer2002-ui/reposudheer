package com.Tastynibbles.Hooks;

import com.Tastynibbles.Browser.Browser;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends Browser {

    @BeforeAll
    public static void initializingExtentReport() {
        Browser.init("ExtentReport"); 
    }

    @Before
    public void creatingExtentTest(Scenario scenario) { 
        if (extent == null) {  
            Browser.init("ExtentReport");
        }
        Browser.logger1 = Browser.extent.createTest(scenario.getName());  
    }

    @After
    public void flushExtentReport() {
        extent.flush(); 
    }
}
