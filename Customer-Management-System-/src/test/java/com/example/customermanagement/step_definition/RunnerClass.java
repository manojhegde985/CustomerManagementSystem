package com.example.customermanagement.step_definition;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "cms/Customer-Management-System-/cucumber",
glue= {"com.example.customermanagement.step_definition"})

public class RunnerClass {

}
