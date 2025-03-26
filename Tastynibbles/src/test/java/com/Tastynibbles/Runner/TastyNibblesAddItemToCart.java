package com.Tastynibbles.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resources\\com.Tastynibbles.Feature\\loginAndProductSearchAndToCart.feature",
glue= {"com.Tastynibbles.StepDefinition","com.Tastynibbles.Hooks"},plugin={"pretty","html:target/cucumberReport/report1.html"},monochrome=true)

public class TastyNibblesAddItemToCart extends AbstractTestNGCucumberTests{
	
}
