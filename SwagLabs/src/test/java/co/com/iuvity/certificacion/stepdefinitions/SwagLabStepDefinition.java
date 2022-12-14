package co.com.iuvity.certificacion.stepdefinitions;

import co.com.iuvity.certificacion.exceptions.ExceptionError;
import co.com.iuvity.certificacion.questions.ViewOrder;
import co.com.iuvity.certificacion.questions.ViewProduct;
import co.com.iuvity.certificacion.tasks.AddANewProduct;
import co.com.iuvity.certificacion.tasks.Login;
import co.com.iuvity.certificacion.utils.ReadFiles;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.iuvity.certificacion.utils.Constants.URL_SWAG_LABS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SwagLabStepDefinition {


    @Given("that {string} is on the web")
    public void thatIsOnTheWeb(String user) {
        theActorCalled(user).wasAbleTo(Open.url(URL_SWAG_LABS));
    }

    @When("{string} logs in with his")
    public void logsInWithHis(String count) {
        theActorInTheSpotlight().attemptsTo(
                Login.inSwagLab(ReadFiles.readUserCount(count))
        );
    }

    @When("adds a product in the cart and buys the product {string}")
    public void addsAProductInTheCartAndBuys(String personalInfo) {
        theActorInTheSpotlight().attemptsTo(
                AddANewProduct.inTheCartToBuy(ReadFiles.readPersonalInfo(personalInfo))
        );
    }

    @Then("should see a msg saying that product is paid")
    public void shouldSeeAMsgSayingThatProductIsPaid() {
        theActorInTheSpotlight().should(seeThat(ViewOrder.isSent()).orComplainWith(ExceptionError.class));
    }

    @Then("selects a product and should see a product on the page")
    public void shouldSeeAProductOnThePage() {
        theActorInTheSpotlight().should(seeThat(ViewProduct.inThePage()).orComplainWith(ExceptionError.class));
    }
}
