package co.com.iuvity.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/swag_labs.feature",
        glue = {"co.com.iuvity.certificacion.stepdefinitions",
                "co.com.iuvity.certificacion.hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SwagLabs {
}
