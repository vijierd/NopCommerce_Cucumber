package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features = {".//Features"},//All the feature file
					//features = {".//Features//NOP_Login.feature",".//Features//NOP_Customers.feature"},//For Specific feature file
					//features= {".//Features//NOP_LoginDDT.feature"},//Only one feature file
					//features = {".//Features//NOP_Customers.feature"},
					glue="stepDefinitions",
					plugin= {"pretty", "html:reports/myreport.html"},
					//tags = "@Regression",//"@Sanity" --> To define single tags
					//tags="@Sanity and @Regression" ,//Scenarios tagged with both @sanity and @regression
					//tags="@Sanity and not @Regression", //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@Sanity or @Regression" ,//Scenarios tagged with either @sanity or @regression
					dryRun=false
				)
public class TestRunner {

}
