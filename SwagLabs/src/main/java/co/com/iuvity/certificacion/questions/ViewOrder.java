package co.com.iuvity.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.iuvity.certificacion.userinterfaces.ProductsPage.LBL_ORDER_SENT;
import static co.com.iuvity.certificacion.utils.Constants.ORDER_SENT;

public class ViewOrder implements Question<Boolean> {

    public static ViewOrder isSent(){
        return new ViewOrder();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_ORDER_SENT.resolveFor(actor).getText().equals(ORDER_SENT);
    }
}
