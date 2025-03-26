package com.Tastynibbles.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resources\\com.Tastynibbles.Feature\\AddTwoProductsAndVerifyCartSummary.feature",
glue= {"com.Tastynibbles.StepDefinition","com.Tastynibbles.Hooks"},plugin={"pretty","html:target/cucumberReport/report4.html"},monochrome=true)

public class TastyNibblesAddingMultipleProductsAndVerfyCart extends AbstractTestNGCucumberTests{
	
}
