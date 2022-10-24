package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/features" },
		glue = "steps",
		tags = {"@movie"},
		plugin = "pretty",
		snippets = SnippetType.CAMELCASE
		)

public class RunTest {
}
