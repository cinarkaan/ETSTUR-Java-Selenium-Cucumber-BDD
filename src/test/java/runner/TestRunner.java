package runner;

import base.BaseFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import util.Base;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\features", glue = {"stepdefinations"})
public class TestRunner {


}
