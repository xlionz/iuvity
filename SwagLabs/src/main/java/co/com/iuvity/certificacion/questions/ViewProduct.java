package co.com.iuvity.certificacion.questions;

import co.com.iuvity.certificacion.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.iuvity.certificacion.userinterfaces.ProductsPage.LBL_TITLE_PRODUCT;

public class ViewProduct implements Question<Boolean> {

    public static ViewProduct inThePage() {
        return new ViewProduct();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String product = new Excel().leerDatoExcel("Productos",
                "src/main/resources/Data.xlsx", 1, 0);

        actor.attemptsTo(
                Click.on(LBL_TITLE_PRODUCT.of(product))
        );

        return LBL_TITLE_PRODUCT.of(product).resolveFor(actor).getText().equals(product);

    }

}
