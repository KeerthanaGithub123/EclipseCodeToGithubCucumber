package runnerFiles;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="@target/rerun.txt", 
glue={"parallel"},
monochrome = true
)

public class ReRunner_Failed {
//this class is used to run only the scenarios listed in rerun.txt
	//only runs the failed scenarios in rerun.txt
	
}
