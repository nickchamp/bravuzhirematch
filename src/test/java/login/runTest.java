package login;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/login/",
        format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json", "junit:target/cucumber.xml"},
        snippets = SnippetType.CAMELCASE
)

public class runTest { }