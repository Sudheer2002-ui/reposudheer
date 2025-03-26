package com.Tastynibbles.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resources\\com.Tastynibbles.Feature\\loginAndLogoutCredentials.feature",
glue= {"com.Tastynibbles.StepDefinition","com.Tastynibbles.Hooks"},plugin={"pretty","html:target/cucumberReport/report3.html"},monochrome=true)

public class TestyNibblesValidAndInvalidCredentials extends AbstractTestNGCucumberTests{
	
}
