package com.adidastest.runnerFile;

import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.*;
import io.cucumber.*;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/main/resources/features",  glue="com.adidastest.stepdefinitions",tags =  "@ui" ,plugin= { "pretty","json:target/cucumber.json","rerun:target/FailedScenarios.text","html:target/cucumber-htmlreport","html:target/cucumber-report/" }) //

//plugin = { "pretty","json:target/cucumber.json","rerun:target/FailedScenarios.text","html:target/cucumber-htmlreport","html:target/cucumber-report/","junit:target/cucumber-results.xml","json:target/cucumber-report.json" }
//features = "@target/FailedScenarios.text" //to run failed scenarios and remove tags
public class TestRunner {


}

