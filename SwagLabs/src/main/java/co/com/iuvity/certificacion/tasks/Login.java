package co.com.iuvity.certificacion.tasks;

import co.com.iuvity.certificacion.models.UserCount;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.iuvity.certificacion.userinterfaces.HomePage.*;

public class Login implements Task {

    private UserCount userCount;

    public Login(UserCount userCount) {
        this.userCount = userCount;
    }

    public static Login inSwagLab(UserCount userCount){
        return Tasks.instrumented(Login.class, userCount);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userCount.getName()).into(INPUT_USERNAME),
                Enter.theValue(userCount.getPassword()).into(INPUT_PASS),
                Click.on(BTN_LOGIN)
        );
    }
}
