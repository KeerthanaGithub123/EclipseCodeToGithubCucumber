package runnerFiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/resources/FeatureFiles", 
glue="stepDefinitions",
monochrome = true
//plugin= {"html:reports/htmlReport", "json:reports/jsonReport.json" , "junit:reports/xmlReport.xml"},
//tags= ("@PhoneNumberInvalidScenario or @PhoneNumberValidScenario")
)

public class OldRunner {

}
