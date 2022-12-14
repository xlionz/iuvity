package co.com.iuvity.certificacion.tasks;

import co.com.iuvity.certificacion.models.PersonalInfo;
import co.com.iuvity.certificacion.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.iuvity.certificacion.userinterfaces.ProductsPage.*;
public class AddANewProduct implements Task {

    private PersonalInfo personalInfo;

    public AddANewProduct(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public static AddANewProduct inTheCartToBuy(PersonalInfo personalInfo){
        return Tasks.instrumented(AddANewProduct.class, personalInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String product = new Excel().leerDatoExcel("Productos",
                "src/main/resources/Data.xlsx", 1, 0);

        actor.attemptsTo(
                Click.on(BTN_ADD_CART.of(product)),
                Click.on(BTN_CART)
        );

        actor.attemptsTo(
                Ensure.that(LBL_TITLE_PRODUCT.of(product).resolveFor(actor).getText())
                        .isEqualTo(product),
                Click.on(BTN_CHECKOUT),
                Enter.theValue(personalInfo.getFirstName()).into(INPUT_FIRST_NAME),
                Enter.theValue(personalInfo.getLastName()).into(INPUT_LAST_NAME),
                Enter.theValue(personalInfo.getZip()).into(INPUT_ZIP),
                Click.on(BTN_CONTINUE)
        );

        actor.attemptsTo(
                Ensure.that(LBL_TITLE_PRODUCT.of(product).resolveFor(actor).getText())
                        .isEqualTo(product),
                Click.on(BTN_FINISH)
        );
    }
}
